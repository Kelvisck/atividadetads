package com.kelvisck.primeiroexemplo.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;

import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig{
 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        /*http
            .authorizeRequests(authorize ->
                authorize
                    .requestMatchers("/public/**").permitAll()
                    .anyRequest().authenticated()
            )
            .formLogin()
            .and()
            .logout();*/
        http.csrf(csrf -> csrf.disable()).oauth2ResourceServer(oauth2 -> oauth2.
        jwt(jwt -> jwt.jwtAuthenticationConverter(new JWTconverter())));

        return http.build();
    }

    
}
