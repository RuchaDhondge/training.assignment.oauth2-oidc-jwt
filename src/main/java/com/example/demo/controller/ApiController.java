package com.example.demo.controller;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Skeletal REST API used for the assessment.
 *
 * <p>Both endpoints currently return placeholder data. Candidates are expected to replace the
 * placeholders with information extracted from the authenticated principal.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    /**
     * Returns information about the currently authenticated user.
     *
     * <p>Expected final behaviour: echo the {@code sub}, {@code email}, and {@code name} claims
     * of the caller (for example {@code sub: "peter-parker-123"},
     * {@code email: "peter.parker@dailybugle.com"}, {@code name: "Peter Parker"}), regardless of
     * whether the caller authenticated through an OIDC login session or presented a JWT bearer
     * token.
     */
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me() {
        // TODO: Candidate to implement... inject the authenticated principal (for example with
        //  @AuthenticationPrincipal OidcUser / @AuthenticationPrincipal Jwt, or by reading the
        //  Authentication from the SecurityContext) and return its identity claims.
        return ResponseEntity.ok(Map.of("message", "TODO: return the authenticated user's claims"));
    }

    /**
     * Returns the profile of the currently authenticated user.
     *
     * <p>Expected final behaviour: only callers holding the required role/scope (see
     * {@code SecurityConfig}) may access this endpoint; everybody else receives 403.
     */
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> profile() {
        // TODO: Candidate to implement... return the profile claims (name, email, preferred
        //  username, ...) of the authenticated user and restrict access to an authority such as
        //  SCOPE_profile:read using method security
        //  (@PreAuthorize("hasAuthority('SCOPE_profile:read')")) or SecurityConfig.
        return ResponseEntity.ok(Map.of("message", "TODO: return the authenticated user's profile"));
    }
}
