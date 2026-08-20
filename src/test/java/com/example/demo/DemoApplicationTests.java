package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Smoke test verifying that the application context starts with the skeletal configuration.
 */
@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
        // TODO: Candidate to implement... add tests for /api/me and /api/profile using
        //  SecurityMockMvcRequestPostProcessors.jwt() and .oidcLogin() from spring-security-test.
    }
}
