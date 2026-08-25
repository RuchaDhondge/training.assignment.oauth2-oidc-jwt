# OAuth 2.0 / OIDC / JWT Assignment Starter

## Objective

Build a small Spring Boot API that demonstrates two ways of securing endpoints: OIDC Login for browser-based user authentication and JWT bearer-token authentication for API access. Protect the API using an OAuth 2.0 scope and verify authentication and authorization behavior.

This starter is intentionally small and suitable for roughly **2–3 hours**:
**Understand → Configure → Implement → Test → Verify → Explain**.

## Prerequisites

- Java 17+
- Docker
- Git

## Setup

```bash
git clone https://github.com/RuchaDhondge/training.assignment.oauth2-oidc-jwt.git
cd training.assignment.oauth2-oidc-jwt
./mock-oidc-provider/start.sh
./mvnw spring-boot:run
```

- App: `http://localhost:8080`
- Mock issuer: `http://localhost:9000`
- Mock provider details and token steps: [`mock-oidc-provider/README.md`](mock-oidc-provider/README.md)

## What you need to implement

Keep changes focused to these files:
- `src/main/resources/application.yml`
- `src/main/java/com/example/demo/config/SecurityConfig.java`
- `src/main/java/com/example/demo/controller/ApiController.java`
- `src/test/java/com/example/demo/DemoApplicationTests.java`

Tasks:
1. Configure OIDC login client settings.
2. Implement `/api/me` for authenticated OIDC user identity (`sub`, `email`, `name`).
3. Configure JWT resource server validation using issuer/JWKS from the mock provider.
4. Implement `/api/profile` for JWT-based API access.
5. Protect `/api/profile` with `profile:read` (`SCOPE_profile:read`).
6. Add/complete MockMvc security tests.

PKCE note: treat PKCE as part of Authorization Code security handled by framework/provider (not a manual implementation task in this assignment).

## Testing

### MockMvc tests
Use Spring Security test support (`oidcLogin()` and `jwt()`) to validate your configuration quickly.

### Runtime curl verification
After starting provider + app, verify these runtime scenarios:

1. No `Authorization` header → **401**
2. Invalid JWT → **401**
3. JWT with `profile:write` → **403**
4. JWT with `profile:read` → **200**

Use the mock provider token variants from `mock-oidc-provider/README.md`:
- `scope=profile:read`
- `scope=profile:write`
- `scope=openid profile email`

## Conceptual questions

1. OAuth 2.0 vs OIDC: what is the difference, and why is OIDC used for `/api/me`?
2. ID token vs access token: what is each token for, and which one is used for API authorization?
3. Why do missing/invalid credentials return 401, while insufficient scope returns 403?
4. How does `profile:read` map to Spring Security authority, and what is JWKS used for?

## Helpful commands

```bash
./mvnw test
./mvnw verify
```
