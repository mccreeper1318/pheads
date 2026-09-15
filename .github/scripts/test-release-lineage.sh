#!/usr/bin/env bash
set -euo pipefail

SCRIPT_DIR="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
VERIFIER="$SCRIPT_DIR/verify-release-lineage.sh"
TMP_DIR="$(mktemp -d)"
trap 'rm -rf "$TMP_DIR"' EXIT

REPO="$TMP_DIR/repo"
git init -q "$REPO"
cd "$REPO"
git config user.name "PHeads CI"
git config user.email "ci@example.invalid"

printf 'base\n' > state.txt
git add state.txt
git commit -q -m "base"
git branch -M main
git branch dev

git update-ref refs/remotes/origin/main "$(git rev-parse main)"
git update-ref refs/remotes/origin/dev "$(git rev-parse dev)"

git switch -q dev
printf 'dev\n' >> state.txt
git add state.txt
git commit -q -m "dev change"
git update-ref refs/remotes/origin/dev "$(git rev-parse dev)"
git tag 0.0.1-alpha.2

"$VERIFIER" 0.0.1-alpha.2 >/dev/null

git tag 0.0.1
if output="$("$VERIFIER" 0.0.1 2>&1)"; then
  echo "Expected stable tag outside main to fail lineage validation." >&2
  exit 1
fi
if [[ "$output" != *"not reachable from origin/main"* ]]; then
  echo "Stable failure did not report the expected main-lineage error:" >&2
  echo "$output" >&2
  exit 1
fi

git branch -f main dev
git update-ref refs/remotes/origin/main "$(git rev-parse main)"
"$VERIFIER" 0.0.1 >/dev/null

git switch -q -c side main
printf 'side\n' >> state.txt
git add state.txt
git commit -q -m "side change"
git tag 0.0.1-rc.1

if output="$("$VERIFIER" 0.0.1-rc.1 2>&1)"; then
  echo "Expected prerelease tag outside dev to fail lineage validation." >&2
  exit 1
fi
if [[ "$output" != *"not reachable from origin/dev"* ]]; then
  echo "Prerelease failure did not report the expected dev-lineage error:" >&2
  echo "$output" >&2
  exit 1
fi

echo "Release lineage regression tests passed."
