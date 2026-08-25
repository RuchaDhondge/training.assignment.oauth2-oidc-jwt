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
 * placeholders with information from the authenticated principal.
 */
@RestController
@RequestMapping("/api")
public class ApiController {

    /**
     * Returns OIDC identity details for the currently authenticated user.
     *
     * <p>Expected final behaviour: return {@code sub}, {@code email}, and {@code name} from the
     * authenticated user (for example: peter-parker-123, peter.parker@dailybugle.com, Peter
     * Parker).
     */
    @GetMapping("/me")
    public ResponseEntity<Map<String, Object>> me() {
        // TODO: Candidate to implement... use Spring Security principal support (for example
        //  @AuthenticationPrincipal OidcUser) to return sub/email/name for the logged-in user.
        return ResponseEntity.ok(Map.of("message", "TODO: return the authenticated user's claims"));
    }

    /**
     * Returns authenticated profile information from a JWT bearer-token call.
     *
     * <p>Expected final behaviour: return profile claims and enforce access only when the caller
     * has scope {@code profile:read} (authority {@code SCOPE_profile:read}).
     */
    @GetMapping("/profile")
    public ResponseEntity<Map<String, Object>> profile() {
        // TODO: Candidate to implement... return authenticated profile claims and protect this
        //  endpoint via SecurityConfig and/or method security based on SCOPE_profile:read.
        return ResponseEntity.ok(Map.of("message", "TODO: return the authenticated user's profile"));
    }
}
