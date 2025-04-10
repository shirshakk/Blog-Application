package com.blogapplication.blogapplication.Config;

import java.security.AuthProvider;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.blogapplication.blogapplication.Service.UserDetailService;
import com.blogapplication.blogapplication.Service.UserService;

@Configuration
@EnableWebSecurity
public class security {
    @Autowired
    private UserDetailService userDetailsService;

    @Bean
    public AuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
        provider.setUserDetailsService(userDetailsService);
        provider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        return provider;
    }
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
        http.csrf(csrf->csrf.disable())
        .authorizeHttpRequests(authorize -> 
            authorize.requestMatchers("/login", "/register").permitAll()
            .anyRequest().authenticated());
            http.httpBasic(Customizer.withDefaults())
                .sessionManagement(session -> session.maximumSessions(12));
            return http.build();
    }
}
