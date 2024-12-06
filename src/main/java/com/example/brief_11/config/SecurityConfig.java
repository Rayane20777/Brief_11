package com.example.brief_11.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers("/api/auth/register").permitAll() // Allow unauthenticated access to register
                        .anyRequest().authenticated() // Require authentication for other requests
                )
                .httpBasic(httpBasic -> httpBasic.disable()) // Disable HTTP Basic (if not needed)
                .formLogin(form -> form.disable()) // Disable form login for REST API
                .csrf(csrf -> csrf.disable()); // Disable CSRF for development (not recommended for production)

        return http.build();
    }
}
