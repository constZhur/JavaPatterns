package patterns.practicies.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import patterns.practicies.service.UserDetailsServiceImpl;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class SecurityConfig {

    private final UserDetailsServiceImpl userDetailsService;

    @Autowired
    public SecurityConfig(UserDetailsServiceImpl userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();

        authProvider.setUserDetailsService(userDetailsService);
        authProvider.setPasswordEncoder(passwordEncoder());

        return authProvider;
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.
                authorizeHttpRequests().
                requestMatchers("/auth/**", "/home", "/static/**").permitAll().
                requestMatchers("/admin/**").hasRole("ADMIN").
                anyRequest().authenticated().
                and().formLogin().
                loginPage("/auth/login").
                loginProcessingUrl("/process_login").
                successHandler((request, response, authentication) -> {
                    if (userDetailsService.isAdmin(authentication.getName())) {
                        response.sendRedirect("/admin/index");
                    } else {
                        response.sendRedirect("/index");
                    }
                }).
                failureUrl("/auth/login?error").
                and().
                logout().
                logoutUrl("/logout").
                logoutSuccessUrl("/home");
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
