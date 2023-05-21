package patterns.practicies.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import patterns.practicies.model.User;
import patterns.practicies.repositories.UserRepository;
import patterns.practicies.security.UserDetailsImpl;

import java.util.Objects;
import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    @Autowired
    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findUserByEmail(username);

        if (user.isEmpty()) throw new UsernameNotFoundException("Пользователь с данным никнеймом не существует!");
        return new UserDetailsImpl(user.get());
    }

    public boolean isAdmin(String name){
        User user = userRepository.findUserByEmail(name).get();
        return Objects.equals(user.getRole(), "ROLE_ADMIN");
    }

}
