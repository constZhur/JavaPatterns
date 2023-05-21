package patterns.practicies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import patterns.practicies.model.User;
import patterns.practicies.repositories.UserRepository;
import patterns.practicies.service.UserService;

import java.util.Objects;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UserServiceTest {

    @Mock
    private UserRepository userRepository;

    @Mock
    private PasswordEncoder passwordEncoder;

    @InjectMocks
    private UserService userService;

    private User user1;
    private int id;

    @Before
    public void setUp() {
        user1 = new User("user1@test.com", "password123");
        id = user1.getId();
    }

    @Test
    public void testFindUserByEmailWithExistingUser() {
        when(userRepository.findUserByEmail("user1@test.com")).thenReturn(Optional.of(user1));

        User foundUser = userService.findUserByEmail("user1@test.com");

        verify(userRepository, times(1)).findUserByEmail("user1@test.com");
        assertNotNull(foundUser);
        assertEquals(user1, foundUser);
    }

    @Test
    public void testFindUserByEmailWithNonExistingUser() {
        when(userRepository.findUserByEmail("user2@test.com")).thenReturn(Optional.empty());

        User foundUser = userService.findUserByEmail("user2@test.com");

        verify(userRepository, times(1)).findUserByEmail("user2@test.com");
        assertNull(foundUser);
    }

    @Test
    public void testSave() {
        when(passwordEncoder.encode("password456")).thenReturn("encodedPassword456");

        User newUser = new User("user2@test.com", "password456");
        userService.save(newUser);

        verify(passwordEncoder, times(1)).encode("password456");
        verify(userRepository, times(1)).save(argThat(user -> {
            User expectedUser = new User("user2@test.com", "encodedPassword456");
            expectedUser.setId(user.getId());
            expectedUser.setRole(user.getRole());
            return userEquals(user, expectedUser);
        }));
    }

    private boolean userEquals(User actualUser, User expectedUser) {
        if (actualUser == null || expectedUser == null) {
            return false;
        }
        return Objects.equals(actualUser.getId(), expectedUser.getId()) &&
                Objects.equals(actualUser.getEmail(), expectedUser.getEmail()) &&
                Objects.equals(actualUser.getPassword(), expectedUser.getPassword()) &&
                Objects.equals(actualUser.getRole(), expectedUser.getRole());
    }
    @Test
    public void testGetCurrentUser() {
        Authentication auth = mock(Authentication.class);
        SecurityContextHolder.getContext().setAuthentication(auth);

        when(auth.getName()).thenReturn("user1@test.com");
        when(userRepository.findUserByEmail("user1@test.com")).thenReturn(Optional.of(user1));

        User currentUser = userService.getCurrentUser();

        verify(userRepository, times(1)).findUserByEmail("user1@test.com");
        assertEquals(user1, currentUser);
    }
}
