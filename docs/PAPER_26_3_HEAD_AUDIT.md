# Paper 26.3 Head Coverage Audit

This audit compares PHeads against Paper `26.3.build.135-beta`. It is documentation/research for the 0.1.0 compatibility update; it does not add new heads or variants.

## Current coverage

PHeads defines 89 mob heads in the 0.1.2 development line: 6 native Minecraft head types and 83 custom-textured mob heads. Player heads are handled separately when enabled.

The Paper 26.3 migration does not invalidate the existing `HeadType` catalog or current variant resolver coverage.

## Newer Paper 26.3 mobs

Issue #20 adds the eight newer Paper 26.3 mobs to the 0.1.2 development line:

- Creaking
- Happy Ghast
- Copper Golem
- Nautilus
- Zombie Nautilus
- Camel Husk
- Parched
- Sulfur Cube

Paper also exposes `Giant` as a living mob. Giant is a legacy, non-naturally-spawning entity rather than a new Paper 26.3 mob, so it is documented as an unsupported candidate but intentionally excluded from #20.

`ArmorStand` and `Mannequin` are living entities in the API but are not normal mobs and are outside PHeads' mob-head scope.

## Existing variant coverage

PHeads currently resolves persistent appearance variants for:

- sheep color
- cat type
- wolf variant
- frog variant
- axolotl variant
- rabbit type
- horse color
- llama / trader llama color
- parrot variant
- panda genes
- fox type
- mooshroom variant
- cow variant
- pig variant
- chicken variant
- villager profession
- zombie-villager profession
- screaming goat state

Temporary states such as anger, charging, nectar, or the strider cold state are intentionally not treated as head variants.

## Issue #30 persistent appearance evaluation

Paper 26.3 exposes additional persistent visual data on existing supported mobs. The 0.1.2 evaluation produced the following result:

| Mob | Paper 26.3 appearance data | 0.1.2 result |
| --- | --- | --- |
| Cow | `cold`, `temperate`, `warm` variants | implemented with three pinned textures |
| Pig | `cold`, `temperate`, `warm` variants | implemented with three pinned textures |
| Chicken | `cold`, `temperate`, `warm` variants | implemented with three pinned textures |
| Salmon | `small`, `medium`, `large` size variants | intentionally unsupported; pinned source has one salmon head |
| Snow Golem | pumpkin/derp state via `Snowman#isDerp()`; derp mode means no pumpkin | intentionally unsupported; pinned source has one snow-golem head |
| Bogged | sheared state via `Bogged#isSheared()` | intentionally unsupported; pinned source has one bogged head |
| Goat | left/right horn presence via `Goat#hasLeftHorn()` / `hasRightHorn()` plus screaming state | intentionally unsupported beyond normal/screaming; no horn-presence texture sets |
| Shulker | dye color | intentionally unsupported; pinned source has one shulker head |
| Tropical Fish | pattern, body color, pattern color | intentionally unsupported; pinned source has one canonical head and no practical combination matrix |
| Villager | biome/type in addition to profession | profession-only; pinned source has no biome/type-by-profession matrix |
| Zombie Villager | biome/type in addition to profession | profession-only; pinned source has no biome/type-by-profession matrix |
| Horse | markings in addition to color | color-only; pinned source has no marking-by-color matrix |

Cow, pig, and chicken sound variants are audio-only and are not head appearances. No unsupported appearance is synthesized or guessed.

## Variant/state considerations for new mobs

The 0.1.2 implementation evaluated the persistent appearance data exposed for the new mobs:

- **Zombie Nautilus:** `temperate` and `warm` variants use distinct sourced shell textures.
- **Copper Golem:** unaffected, exposed, weathered, and oxidized states use distinct sourced head textures. Behavioral golem state is intentionally ignored.
- **Sulfur Cube:** registry-backed archetypes remain canonical-only because the pinned source provides a single Sulfur Cube head rather than distinct archetype textures.

## Texture provenance findings

PHeads' existing custom textures are pinned to Vanilla Tweaks More Mob Heads v2.15.0 (MC 1.21-1.21.4), preserved at RWELabs/Minecraft commit `4644939004389159c2a52b97e8b35a4dcf5ad75a`.

That snapshot predates the eight newer mobs in #20 and does not contain the newer cow, pig, or chicken appearance sets.

For 0.1.2, PHeads uses the MIT-licensed Teak's Tweaks More Mob Heads data pinned at commit `5ca969779e614cc5f84012677b25fc01e5f1156c`, with `src/main/resources/data/more_mob_heads.json` pinned to Git blob `33ad209c4498514c7bc2726aeb1a2643334de6f2`. This source provides complete cold/temperate/warm textures for cows, pigs, and chickens, so #30 implements those nine appearances. The same pinned data contains only one salmon, snow golem, bogged, shulker, and tropical-fish head; normal/screaming goats without horn-presence sets; profession-only villager heads; and color-only horse heads. Those remaining candidates are intentionally unsupported rather than fabricated.

## Follow-up work

- #20 — implemented on the 0.1.2 development line with pinned texture provenance.
- #30 — implements sourced cow, pig, and chicken variants and records the remaining evaluated candidates as intentionally unsupported.

The original 0.1.0 release remained limited to Paper 26.3 compatibility and the audit; new head content begins with the later 0.1.2 development line.

## Reference sources

- Paper 26.3 API Javadocs: `https://jd.papermc.io/paper/26.3/`
- Pinned More Mob Heads v2.15.0 snapshot: `RWELabs/Minecraft@4644939004389159c2a52b97e8b35a4dcf5ad75a`
- Pinned newer More Mob Heads data: `teakivy/teaks-tweaks@5ca969779e614cc5f84012677b25fc01e5f1156c`
