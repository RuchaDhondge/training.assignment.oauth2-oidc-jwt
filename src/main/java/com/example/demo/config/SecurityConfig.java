package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Central place for the HTTP security rules of the application.
 *
 * <p>This class is intentionally skeletal: it only denies anonymous access so that the
 * application starts. Candidates are expected to turn it into a working OAuth 2.0 / OIDC
 * configuration.
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig {

    /**
     * Defines the security filter chain applied to every request.
     *
     * @param http the {@link HttpSecurity} to customize
     * @return the configured {@link SecurityFilterChain}
     * @throws Exception if the configuration is invalid
     */
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(authorize -> authorize
                // TODO: Candidate to implement... allow expected public endpoints (for example
                //  "/", "/error") and secure the API. Keep `/api/profile` restricted to callers
                //  with authority "SCOPE_profile:read".
                .anyRequest().authenticated()
            );

        // TODO: Candidate to implement... enable browser-based OIDC login using
        //  `http.oauth2Login(...)` and the client registration in application.yml.

        // TODO: Candidate to implement... enable JWT bearer-token support with
        //  `http.oauth2ResourceServer(oauth2 -> oauth2.jwt(...))` using issuer/JWKS config from
        //  application.yml.

        // TODO: Candidate to implement... use standard scope mapping for JWT authorities.
        //  Spring Security maps scope `profile:read` to authority `SCOPE_profile:read`.
        //  Use `hasAuthority("SCOPE_profile:read")` for `/api/profile`.

        // Keep the authentication models clear:
        // - OIDC login uses a browser session.
        // - JWT bearer authentication is used for API requests.
        // Use Spring Security's standard mechanisms; do not implement
        // custom session or token handling.

        return http.build();
    }
}
