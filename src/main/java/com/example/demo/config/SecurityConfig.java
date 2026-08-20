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
                // TODO: Candidate to implement... permit public endpoints (e.g. "/", "/error",
                //  actuator health) and require authentication for everything under "/api/**".
                .anyRequest().authenticated()
            );

        // TODO: Candidate to implement... enable the OIDC login flow (Authorization Code + PKCE)
        //  by configuring `http.oauth2Login(...)` against the mock OIDC provider. The client
        //  registration lives in `application.yml` under `spring.security.oauth2.client`.

        // TODO: Candidate to implement... enable JWT bearer token validation by configuring
        //  `http.oauth2ResourceServer(oauth2 -> oauth2.jwt(...))`. The issuer / JWK set URI
        //  lives in `application.yml` under `spring.security.oauth2.resourceserver.jwt`.

        // TODO: Candidate to implement... map JWT/OIDC claims to Spring Security authorities.
        //  By default, Spring Security's JWT resource server converts a space-delimited
        //  "scope" claim directly into "SCOPE_<scopename>" granted authorities (e.g. a token
        //  with scope "profile:read" yields the authority "SCOPE_profile:read"). Use this to
        //  secure `/api/profile` with `.requestMatchers("/api/profile").hasAuthority("SCOPE_profile:read")`,
        //  or supply a custom JwtAuthenticationConverter / GrantedAuthoritiesMapper if a
        //  different claim (e.g. "roles") should also be mapped to authorities.

        // TODO: Candidate to implement... decide on the CSRF and session strategy. Stateless
        //  bearer-token APIs usually disable CSRF, while browser based OIDC login does not.

        return http.build();
    }
}
