# PHeads

PHeads is a lightweight Paper plugin that adds configurable head drops for mobs with vanilla head items. Player head drops are also supported and are disabled by default.

PHeads only rolls its configured head drops when the killed mob or player is credited to a player killer. Environmental deaths, mob kills, and other deaths without a player killer do not trigger PHeads drops.

## Requirements

- Paper 26.2
- Java 25

## Installation

1. Download the latest `pheads-<version>.jar` from the GitHub Releases page.
2. Place the JAR in your server's `plugins` folder.
3. Start or restart the server once to generate `plugins/PHeads/config.yml`.
4. Edit the drop chances as needed.
5. Run `/pheads reload` to apply configuration changes, or restart the server.

## Configuration

Drop chances are percentages from `0.0` to `100.0`.

```yaml
heads:
  creeper: 2.5
  zombie: 2.5
  skeleton: 2.5
  wither-skeleton: 2.5
  piglin: 2.5
  ender-dragon: 100.0

player-heads:
  enabled: false
  drop-chance-percent: 100.0
```

PHeads adds configured drops without removing or replacing vanilla drops.

## Commands

| Command | Description | Permission |
| --- | --- | --- |
| `/pheads reload` | Reloads `config.yml` without restarting the server. | `pheads.reload` |

The `pheads.reload` permission defaults to server operators.

## Supported heads

| Entity | Dropped item |
| --- | --- |
| Creeper | Creeper Head |
| Zombie | Zombie Head |
| Skeleton | Skeleton Skull |
| Wither Skeleton | Wither Skeleton Skull |
| Piglin | Piglin Head |
| Ender Dragon | Dragon Head |
| Player | Player Head, when enabled |

Player heads use the killed player's profile so the dropped head keeps that player's skin.

## Building from source

The project uses Java 25 and the included Gradle 9.7.1 wrapper.

Linux/macOS:

```bash
./gradlew clean build
```

Windows:

```bat
gradlew.bat clean build
```

The plugin JAR is created in `build/libs/`.

## Development workflow

- `dev` is the working branch and the repository default branch.
- `main` is reserved for stable releases.
- Stable merges into `main` are performed manually by the repository owner.
