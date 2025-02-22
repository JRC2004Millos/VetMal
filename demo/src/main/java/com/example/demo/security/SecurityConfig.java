package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    private JwtAuthEntryPoint jwtAuthEntryPoint;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.csrf(AbstractHttpConfigurer::disable)
                .headers(headers -> headers.frameOptions(frame -> frame.disable()))
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/h2/**").permitAll()
                        .requestMatchers("/clientes/login").permitAll()
                        .requestMatchers("/admin/login").permitAll()
                        .requestMatchers("/admin/**").hasAuthority("ADMIN")
                        .requestMatchers("/veterinarios").hasAuthority("ADMIN")
                        .requestMatchers("/veterinario/login").permitAll()
                        .requestMatchers("/veterinario/modificar/**").hasAuthority("ADMIN")
                        .requestMatchers("/veterinario/agregar/**").hasAuthority("ADMIN")
                        .requestMatchers("/veterinario/eliminar/**").hasAuthority("ADMIN")
                        .requestMatchers("/admin/negocio").hasAuthority("ADMIN")
                        .requestMatchers("/clientes/ver").hasAuthority("VETERINARIO")
                        .requestMatchers("/clientes/ver/**").hasAuthority("CLIENTE")
                        .requestMatchers("/clientes/agregar").hasAuthority("VETERINARIO")
                        .requestMatchers("/clientes/modificar/**").hasAuthority("VETERINARIO")
                        .requestMatchers("/clientes/eliminar/**").hasAuthority("VETERINARIO")
                        .requestMatchers("/veterinarios/**").authenticated()
                        .requestMatchers("/clientes/details").hasAuthority("CLIENTE")
                        .requestMatchers("/veterinario/details").hasAuthority("VETERINARIO")
                        .anyRequest().permitAll())
                .exceptionHandling(exception -> exception.authenticationEntryPoint(jwtAuthEntryPoint));

        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public JWTAuthenticationFilter jwtAuthenticationFilter() {
        return new JWTAuthenticationFilter();
    }
}
