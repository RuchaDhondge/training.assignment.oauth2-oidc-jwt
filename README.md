# OAuth 2.0 / OIDC / JWT Assessment Starter

Starter repository for the OAuth 2.0, OpenID Connect and JWT assessment. The project boots as-is,
so you can focus on the security implementation instead of on project setup.

## Prerequisites

- Java 17 (JDK)
- Docker (only needed for the mock OIDC provider)
- No local Maven install required — the Maven Wrapper (`./mvnw`) is included

## Project layout

```
.
├── mvnw / mvnw.cmd / .mvn/          # Maven Wrapper
├── pom.xml                          # Spring Boot 3.2.x, Java 17
├── mock-oidc-provider/              # Throwaway OIDC provider (see its README.md)
│   ├── README.md
│   ├── config.json
│   └── start.sh
└── src/main
    ├── java/com/example/demo
    │   ├── DemoApplication.java     # Spring Boot entry point
    │   ├── config/SecurityConfig.java   # TODO: candidate implements the security rules
    │   └── controller/ApiController.java # TODO: candidate implements /api/me and /api/profile
    └── resources/application.yml    # Commented-out OIDC configuration
```

## Run the application

```bash
./mvnw spring-boot:run
```

On Windows use `mvnw.cmd spring-boot:run`.

The app listens on <http://localhost:8080>. Out of the box every request requires authentication,
so `/api/me` and `/api/profile` are rejected until you wire up the OIDC login and/or the JWT
resource server.

Other useful commands:

```bash
./mvnw test        # run the tests
./mvnw verify      # full build
```

## Run the mock OIDC provider

In a second terminal:

```bash
./mock-oidc-provider/start.sh
```

It publishes an OIDC provider on <http://localhost:9000> with the issuer
`http://localhost:9000/default`. See [`mock-oidc-provider/README.md`](mock-oidc-provider/README.md)
for endpoints, credentials and how to mint tokens.

## Your tasks

1. Uncomment and complete the `spring.security.oauth2.client` and
   `spring.security.oauth2.resourceserver` sections in `src/main/resources/application.yml`.
2. Complete `SecurityConfig` so that the app supports both browser based OIDC login and JWT
   bearer token access, and maps token claims to Spring Security authorities.
3. Complete `ApiController`:
   - `GET /api/me` — returns the authenticated user's identity claims.
   - `GET /api/profile` — returns profile claims and is restricted to an authority/scope.
4. Add tests using `spring-boot-starter-test` and `spring-security-test`
   (e.g. `SecurityMockMvcRequestPostProcessors.jwt()` / `oidcLogin()`).

Every place that needs your attention is marked with a `// TODO: Candidate to implement...`
comment.
