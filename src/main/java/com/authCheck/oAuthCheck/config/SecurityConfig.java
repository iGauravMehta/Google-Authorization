package com.authCheck.oAuthCheck.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .authorizeHttpRequests(auth -> {
                auth.requestMatchers("/", "/login").permitAll()
                    .anyRequest().authenticated();
            })
            .oauth2Login(oauth2 -> {
                oauth2.loginPage("/login")
                    .defaultSuccessUrl("/success", true);
            })
            .logout(logout -> {
                logout.logoutSuccessUrl("/")
                    .permitAll();
            });
        
        return http.build();
    }
} 