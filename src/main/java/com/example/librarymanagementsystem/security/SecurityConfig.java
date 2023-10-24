package com.example.librarymanagementsystem.security;

import jakarta.servlet.FilterChain;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {
    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource){
        return new JdbcUserDetailsManager(dataSource);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception{

        httpSecurity.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/book/**").hasAnyRole("LIBRARIAN", "ADMIN")
                                .requestMatchers("/librarian/**").hasRole("ADMIN")
                                .anyRequest()
                                .authenticated())
                .exceptionHandling(configurer -> configurer
                        .accessDeniedPage("/accessDenied"))
                .formLogin(form -> form
                        .loginPage("/loginPage")
                        .loginProcessingUrl("/authenticateUser")
                        .permitAll())
                .logout(logout -> logout.permitAll());

        return httpSecurity.build();
    }
}
