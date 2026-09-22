# PHeads

PHeads is a lightweight Paper plugin that adds configurable head drops for supported mobs. Mobs with native Minecraft head items keep those real items, while supported mobs without native heads use custom-textured player heads. Optional player head drops are also supported and are disabled by default.

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
  pig: 2.5
  cow: 2.5
  mooshroom: 2.5
  sheep: 2.5
  chicken: 2.5
  rabbit: 2.5
  horse: 2.5
  donkey: 2.5
  mule: 2.5
  goat: 2.5
  llama: 2.5
  camel: 2.5
  cat: 2.5
  wolf: 2.5
  fox: 2.5
  bee: 2.5
  turtle: 2.5
  frog: 2.5
  axolotl: 2.5
  sniffer: 2.5

player-heads:
  enabled: false
  drop-chance-percent: 100.0
```

PHeads adds configured drops without removing or replacing vanilla drops.

Existing 0.0.1 configuration files remain valid in 0.0.2. If a newly added mob key is absent from an older configuration, PHeads uses a `2.5%` drop chance for that mob until the key is added to `config.yml`.

## Commands

`/ph` is the short alias for `/pheads`.

| Command | Description | Permission |
| --- | --- | --- |
| `/pheads reload` | Reloads `config.yml` without restarting the server. | `pheads.reload` |
| `/ph give <mob-head>` | Gives the executing player one supported mob head. | `pheads.give` |

Both command permissions default to server operators. Supported mob-head names are available through tab completion.

## Supported heads

### Native Minecraft heads

| Entity | Dropped item |
| --- | --- |
| Creeper | Creeper Head |
| Zombie | Zombie Head |
| Skeleton | Skeleton Skull |
| Wither Skeleton | Wither Skeleton Skull |
| Piglin | Piglin Head |
| Ender Dragon | Dragon Head |
| Player | Player Head, when enabled |

### Custom-textured mob heads

The following mobs drop a `PLAYER_HEAD` with a fixed Minecraft texture reference and a mob-specific display name:

- Pig
- Cow
- Mooshroom
- Sheep
- Chicken
- Rabbit
- Horse
- Donkey
- Mule
- Goat
- Llama
- Camel
- Cat
- Wolf
- Fox
- Bee
- Turtle
- Frog
- Axolotl
- Sniffer

The plugin does not call an external head API to create these items. It stores fixed profile/texture references that Minecraft resolves through `textures.minecraft.net`.

The custom mob-head profile data is adapted from Vanilla Tweaks' **More Mob Heads** data pack under the Vanilla Tweaks project terms. Required attribution is in [`credits.txt`](credits.txt), and the exact canonical variant, texture hash, source path, and pinned source blob for every custom head are documented in [`docs/HEAD_TEXTURE_SOURCES.md`](docs/HEAD_TEXTURE_SOURCES.md).

For mobs that have visual variants, 0.0.2 currently uses one canonical head appearance per mob type. Variant-specific collectible heads can be added separately in a future release.

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
