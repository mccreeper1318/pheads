#!/usr/bin/env bash
set -euo pipefail

TAG="${1:-}"
if [[ -z "$TAG" ]]; then
  echo "Usage: $0 <release-tag>" >&2
  exit 2
fi

if [[ "$TAG" =~ ^[0-9]+\.[0-9]+\.[0-9]+$ ]]; then
  REQUIRED_BRANCH="main"
  RELEASE_KIND="stable"
elif [[ "$TAG" =~ ^[0-9]+\.[0-9]+\.[0-9]+-(alpha|beta|rc)\.[0-9]+$ ]]; then
  REQUIRED_BRANCH="dev"
  RELEASE_KIND="prerelease"
else
  echo "Unsupported release tag: $TAG" >&2
  echo "Expected x.x.x, x.x.x-alpha.x, x.x.x-beta.x, or x.x.x-rc.x" >&2
  exit 2
fi

TAG_REF="refs/tags/$TAG"
TARGET_REF="refs/remotes/origin/$REQUIRED_BRANCH"

if ! TAG_COMMIT="$(git rev-parse --verify "${TAG_REF}^{commit}" 2>/dev/null)"; then
  echo "Release lineage check failed: tag '$TAG' does not resolve to a commit." >&2
  exit 1
fi

if ! git rev-parse --verify "${TARGET_REF}^{commit}" >/dev/null 2>&1; then
  echo "Release lineage check failed: required branch reference '$TARGET_REF' is unavailable." >&2
  exit 1
fi

if ! git merge-base --is-ancestor "$TAG_COMMIT" "$TARGET_REF"; then
  echo "Release lineage check failed: $RELEASE_KIND tag '$TAG' ($TAG_COMMIT) is not reachable from origin/$REQUIRED_BRANCH." >&2
  if [[ "$RELEASE_KIND" == "stable" ]]; then
    echo "Stable x.x.x releases must be tagged from a commit already merged to main." >&2
  else
    echo "Prerelease alpha/beta/rc releases must be tagged from a commit reachable from dev." >&2
  fi
  exit 1
fi

echo "Release lineage check passed: $RELEASE_KIND tag '$TAG' is reachable from origin/$REQUIRED_BRANCH."
