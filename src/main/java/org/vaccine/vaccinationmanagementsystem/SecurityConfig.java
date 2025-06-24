package org.vaccine.vaccinationmanagementsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .cors(withDefaults())
                .csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(auth -> auth
                        // Allow authentication endpoints
                        .requestMatchers("/api/auth/**").permitAll()

                        // ADD THESE - Allow all API endpoints
                        .requestMatchers("/api/centers/**").permitAll()
                        .requestMatchers("/api/appointments/**").permitAll()
                        .requestMatchers("/api/vaccine-stocks/**").permitAll()

                        // Allow development tools
                        .requestMatchers("/h2-console/**", "/swagger-ui.html", "/swagger-ui/**", "/v3/api-docs/**").permitAll()

                        // All other requests need authentication
                        .anyRequest().authenticated()
                );

        return http.build();
    }
}
