package com.vasiliskardaras.SpringSocialOauth2Demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(
                        rep -> rep
                                .anyRequest().authenticated()
                )
                .formLogin(Customizer.withDefaults())
            .oauth2Login(Customizer.withDefaults());

        return http.build();
    }
}
