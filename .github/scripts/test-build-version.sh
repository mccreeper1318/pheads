#!/usr/bin/env bash
set -euo pipefail

BASE_VERSION="$(./gradlew -q properties --no-daemon | sed -n 's/^version: //p' | head -n 1)"
VERSIONS=(
  "$BASE_VERSION-alpha.1"
  "$BASE_VERSION-beta.1"
  "$BASE_VERSION-rc.1"
  "$BASE_VERSION"
)

for release_version in "${VERSIONS[@]}"; do
  ./gradlew clean jar --no-daemon -PreleaseVersion="$release_version" >/dev/null

  jar_path="build/libs/pheads-$release_version.jar"
  if [[ ! -f "$jar_path" ]]; then
    echo "Expected build output not found: $jar_path" >&2
    exit 1
  fi

  plugin_yml="$(unzip -p "$jar_path" plugin.yml)"
  if ! grep -Fxq "version: '$release_version'" <<<"$plugin_yml"; then
    echo "Expected plugin.yml version $release_version in $jar_path" >&2
    echo "$plugin_yml" >&2
    exit 1
  fi
done

echo "Release build version regression tests passed."
