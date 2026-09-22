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
  allay: 2.5
  armadillo: 2.5
  bat: 2.5
  cod: 2.5
  dolphin: 2.5
  glow-squid: 2.5
  iron-golem: 2.5
  ocelot: 2.5
  panda: 2.5
  parrot: 2.5
  polar-bear: 2.5
  pufferfish: 2.5
  salmon: 2.5
  skeleton-horse: 2.5
  snow-golem: 2.5
  squid: 2.5
  strider: 2.5
  tadpole: 2.5
  trader-llama: 2.5
  tropical-fish: 2.5
  villager: 2.5
  wandering-trader: 2.5
  zombie-horse: 2.5
  blaze: 2.5
  bogged: 2.5
  breeze: 2.5
  cave-spider: 2.5
  drowned: 2.5
  elder-guardian: 2.5
  enderman: 2.5
  endermite: 2.5
  evoker: 2.5
  ghast: 2.5
  guardian: 2.5
  hoglin: 2.5
  husk: 2.5
  illusioner: 2.5
  magma-cube: 2.5
  phantom: 2.5
  piglin-brute: 2.5
  pillager: 2.5
  ravager: 2.5
  shulker: 2.5
  silverfish: 2.5
  slime: 2.5
  spider: 2.5
  stray: 2.5
  vex: 2.5
  vindicator: 2.5
  warden: 2.5
  witch: 2.5
  wither: 2.5
  zoglin: 2.5
  zombie-villager: 2.5
  zombified-piglin: 2.5

player-heads:
  enabled: false
  drop-chance-percent: 100.0
```

PHeads adds configured drops without removing or replacing vanilla drops.

Existing configuration files from earlier releases remain valid in 0.0.3. If a newly added mob key is absent from an older configuration, PHeads uses a `2.5%` drop chance for that mob until the key is added to `config.yml`.

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

The following 75 mobs drop a `PLAYER_HEAD` with a fixed Minecraft texture reference and a mob-specific display name:

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
- Allay
- Armadillo
- Bat
- Cod
- Dolphin
- Glow Squid
- Iron Golem
- Ocelot
- Panda
- Parrot
- Polar Bear
- Pufferfish
- Salmon
- Skeleton Horse
- Snow Golem
- Squid
- Strider
- Tadpole
- Trader Llama
- Tropical Fish
- Villager
- Wandering Trader
- Zombie Horse
- Blaze
- Bogged
- Breeze
- Cave Spider
- Drowned
- Elder Guardian
- Enderman
- Endermite
- Evoker
- Ghast
- Guardian
- Hoglin
- Husk
- Illusioner
- Magma Cube
- Phantom
- Piglin Brute
- Pillager
- Ravager
- Shulker
- Silverfish
- Slime
- Spider
- Stray
- Vex
- Vindicator
- Warden
- Witch
- Wither
- Zoglin
- Zombie Villager
- Zombified Piglin

The plugin does not call an external head API to create these items. It stores fixed profile/texture references that Minecraft resolves through `textures.minecraft.net`.

The custom mob-head profile data is adapted from Vanilla Tweaks' **More Mob Heads** data pack under the Vanilla Tweaks project terms. Required attribution is in [`credits.txt`](credits.txt), and the exact canonical variant, texture hash, source path, and pinned source blob for every custom head are documented in [`docs/HEAD_TEXTURE_SOURCES.md`](docs/HEAD_TEXTURE_SOURCES.md).

For mobs that have visual variants, PHeads currently uses one canonical head appearance per mob type. Variant-specific collectible heads are planned separately.

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
