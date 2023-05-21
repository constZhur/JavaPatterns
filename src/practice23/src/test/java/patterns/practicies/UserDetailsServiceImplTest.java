package patterns.practicies;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import patterns.practicies.model.User;
import patterns.practicies.repositories.UserRepository;
import patterns.practicies.service.UserDetailsServiceImpl;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserDetailsServiceImplTest {

    private UserRepository userRepository = mock(UserRepository.class);
    private UserDetailsServiceImpl userDetailsService = new UserDetailsServiceImpl(userRepository);

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testLoadUserByUsername() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setRole("ROLE_USER");

        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.of(user));

        UserDetails userDetails = userDetailsService.loadUserByUsername("test@example.com");

        assertEquals(user.getEmail(), userDetails.getUsername());
        assertEquals(user.getPassword(), userDetails.getPassword());
        assertTrue(userDetails.getAuthorities().contains(new SimpleGrantedAuthority(user.getRole())));
    }

    @Test(expected = UsernameNotFoundException.class)
    public void testLoadUserByUsernameNotFound() {
        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.empty());

        userDetailsService.loadUserByUsername("test@example.com");
    }

    @Test
    public void testIsAdminTrue() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setRole("ROLE_ADMIN");

        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.of(user));

        boolean result = userDetailsService.isAdmin("test@example.com");

        assertTrue(result);
    }


    @Test
    public void testIsAdminFalse() {
        User user = new User();
        user.setEmail("test@example.com");
        user.setPassword("password");
        user.setRole("ROLE_USER");

        when(userRepository.findUserByEmail("test@example.com")).thenReturn(Optional.of(user));

        Optional<User> optionalUser = userRepository.findUserByEmail("test@example.com");
        assertFalse(optionalUser.isEmpty());

        boolean result = userDetailsService.isAdmin("test@example.com");

        assertFalse(result);
    }
}
