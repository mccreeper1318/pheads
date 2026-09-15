# Changelog

## 0.0.2

### Added

- Added configurable custom-textured heads for pigs, cows, mooshrooms, sheep, chickens, rabbits, horses, donkeys, mules, goats, llamas, camels, cats, wolves, foxes, bees, turtles, frogs, axolotls, and sniffers.
- Added per-head texture provenance documentation and required Vanilla Tweaks attribution.

### Changed

- Existing 0.0.1 configurations remain valid; newly added mob head chances default to 2.5% when omitted.
- Custom mob-head profile references are sourced from Vanilla Tweaks More Mob Heads with each source file pinned to an exact snapshot blob.

## 0.0.1

### Added

- Initial Paper 26.2 and Java 25 plugin foundation.
- Configurable drop chances for supported vanilla mob heads.
- Optional player-head drops, disabled by default.
- `/pheads reload` for reloading configuration without restarting the server.
- Gradle 9.7.1 wrapper for consistent local and CI builds.
- Dependabot updates for Gradle and GitHub Actions, excluding the Paper API.
- Push and pull-request test/build CI for all branches.
- Release automation for JAR and SHA-256 artifacts.
- Initial configuration and forward-facing README documentation.

### Changed

- Head-drop rolls now only occur when the killed mob or player is credited to a player killer.
- CI and release builds now use the checked-in Gradle wrapper.
- Updated JUnit to 6.1.3 and `actions/checkout` to v7 through Dependabot.

### Fixed

- Prerelease tags now validate against the base project version and attach correctly named JAR and SHA-256 artifacts.
- Invalid configuration reloads now fail validation without replacing the last-known-good active settings.
- Player-caused bed and respawn-anchor explosion deaths now qualify for configured head drops when Paper does not expose a player killer directly.
- Release lineage is now enforced: stable tags must be reachable from `main`, while alpha, beta, and release-candidate tags must be reachable from `dev`.
