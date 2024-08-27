package com.akashit.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.akashit.service.MyUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer {
    
    @Autowired
    private MyUserDetailsService userDetailsService;
    
    public void configureUsers(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(NoOpPasswordEncoder.getInstance());
    }

    @Bean
    public SecurityFilterChain securityConfig(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests((req) ->
                    req.requestMatchers("/contact").permitAll()
                       .anyRequest().authenticated()
                )
                .formLogin(form -> form
                    .loginPage("/login")  // Specify custom login page if you have one
                    .permitAll()           // Allow access to the login page
                )
                .logout(logout -> logout.permitAll());  // Ensure logout is permitted
            
        return http.build();
    }

}
