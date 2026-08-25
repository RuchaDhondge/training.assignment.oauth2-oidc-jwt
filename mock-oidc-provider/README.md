# Mock OIDC Provider

This folder contains a local, throwaway OpenID Connect (OIDC) provider used by this assignment.
Use it to:
- perform browser login for `/api/me`
- generate JWT access tokens for `/api/profile`

You do **not** need to build or sign JWTs manually.

## Start the provider

```bash
./mock-oidc-provider/start.sh
```

The script runs `mock-oauth2-server` in Docker on `http://localhost:9000`.
Stop it with `Ctrl+C` in that terminal.

## Important endpoints

- Issuer: `http://localhost:9000`
- Discovery: `http://localhost:9000/.well-known/openid-configuration`
- JWKS: `http://localhost:9000/jwks`
- Debugger / token UI: `http://localhost:9000/debugger`

## Client credentials for this assignment

Use the same values as `application.yml`:
- client-id: `user-api`
- client-secret: `user-api-secret`

(For this mock server, any pair is accepted. Use these fixed values for consistency.)

These are local development-only values for this assignment. Do not reuse them in real systems.

## Identity claims in tokens

The provider always includes:
- `sub = peter-parker-123`
- `email = peter.parker@dailybugle.com`
- `name = Peter Parker`

## Generate the 3 required token variants

1. Open `http://localhost:9000/debugger`
2. Select issuer `default`
3. Use client-id `user-api` and client-secret `user-api-secret`
4. Set `scope` exactly as shown below
5. Mint token and copy the `access_token`

### Token A (read scope)
- Scope: `profile:read`
- Expected `/api/profile` result: **200**

### Token B (write-only scope)
- Scope: `profile:write`
- Expected `/api/profile` result: **403**

### Token C (no profile read scope)
- Scope: `openid profile email`
- Expected `/api/profile` result: **403**

If no bearer token is sent, or the token is invalid, `/api/profile` should return **401**.
