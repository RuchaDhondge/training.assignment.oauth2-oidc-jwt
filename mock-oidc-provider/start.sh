#!/usr/bin/env bash
#
# Starts a mock OpenID Connect provider on http://localhost:9000.
#
# The provider is a placeholder: it only needs to expose a discovery document
# (/default/.well-known/openid-configuration), an authorization endpoint, a token
# endpoint and a JWKS endpoint so that the Spring Boot application can complete
# the OIDC login flow and validate JWTs.
#
# Usage:
#   ./mock-oidc-provider/start.sh
#
set -euo pipefail

IMAGE="${MOCK_OIDC_IMAGE:-ghcr.io/navikt/mock-oauth2-server:2.1.2}"
PORT="${MOCK_OIDC_PORT:-9000}"
CONTAINER_NAME="${MOCK_OIDC_CONTAINER:-mock-oidc-provider}"

if ! command -v docker >/dev/null 2>&1; then
  echo "docker is required to run the mock OIDC provider." >&2
  echo "Alternatively, replace this script with any other OIDC provider listening on port ${PORT}." >&2
  exit 1
fi

echo "Starting ${IMAGE} as '${CONTAINER_NAME}' on http://localhost:${PORT} ..."
docker run --rm \
  --name "${CONTAINER_NAME}" \
  -p "${PORT}:8080" \
  -e JSON_CONFIG_PATH=/config/config.json \
  -v "$(cd "$(dirname "$0")" && pwd)/config.json:/config/config.json:ro" \
  "${IMAGE}"
