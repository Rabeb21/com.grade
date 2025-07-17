package com.grade.config;

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
                .csrf().disable() // Désactive CSRF pour les API REST (facultatif, à activer en production)
                .authorizeHttpRequests()
                .anyRequest().authenticated() // Toute requête nécessite une authentification
                .and()
                .httpBasic(); // Utilise l'authentification basique (nom user/ mdp)

        return http.build();
    }
}