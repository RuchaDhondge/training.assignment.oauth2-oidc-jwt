# Mock OIDC Provider

A throwaway OpenID Connect provider used for local development and for the assessment.
It lets you complete an OIDC login flow and mint JWT access tokens without depending on a
real identity provider.

## Start

```bash
./mock-oidc-provider/start.sh
```

The script runs [`mock-oauth2-server`](https://github.com/navikt/mock-oauth2-server) in Docker
and publishes it on <http://localhost:9000>. Stop it with `Ctrl+C`.

Environment variables you can override:

| Variable             | Default                                   | Description                     |
|----------------------|-------------------------------------------|---------------------------------|
| `MOCK_OIDC_IMAGE`    | `ghcr.io/navikt/mock-oauth2-server:2.1.2` | Container image to run          |
| `MOCK_OIDC_PORT`     | `9000`                                    | Host port to publish            |
| `MOCK_OIDC_CONTAINER`| `mock-oidc-provider`                      | Container name                  |

## Endpoints

The provider hosts one issuer named `default`:

- Issuer URI: <http://localhost:9000/default>
- Discovery: <http://localhost:9000/default/.well-known/openid-configuration>
- JWKS: <http://localhost:9000/default/jwks>
- Debugger / token minting UI: <http://localhost:9000/default/debugger>

Any `client-id` / `client-secret` pair is accepted; the starter uses `demo-client` /
`demo-secret`. These are throwaway local development values only — never reuse them anywhere else.

## Claims

`config.json` makes every issued token carry the following claims, which is enough to implement
`/api/me` and `/api/profile`:

```json
{ "sub": "candidate", "name": "Candidate User", "email": "candidate@example.com", "roles": ["USER"] }
```

## Using another provider

The application only needs a spec-compliant OIDC provider. Feel free to replace this script with
Keycloak, Spring Authorization Server, Auth0, … as long as it listens on the issuer URI configured
in `src/main/resources/application.yml`.
