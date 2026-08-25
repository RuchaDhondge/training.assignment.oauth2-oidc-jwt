package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Starter tests for the OAuth2/OIDC/JWT assignment.
 */
@SpringBootTest
@AutoConfigureMockMvc
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // smoke test: context should start
    }

    @Test
    void todo_me_with_oidc_login_returns_200() {
        // TODO: Candidate to implement with MockMvc + oidcLogin():
        //  GET /api/me -> 200
    }

    @Test
    void todo_profile_with_profile_read_scope_returns_200() {
        // TODO: Candidate to implement with MockMvc + jwt():
        //  GET /api/profile with scope profile:read -> 200
    }

    @Test
    void todo_profile_without_required_scope_returns_403() {
        // TODO: Candidate to implement with MockMvc + jwt():
        //  GET /api/profile without profile:read -> 403
    }

    @Test
    void todo_profile_unauthenticated_returns_401() {
        // TODO: Candidate to implement with MockMvc:
        //  GET /api/profile without authentication -> 401
    }
}
