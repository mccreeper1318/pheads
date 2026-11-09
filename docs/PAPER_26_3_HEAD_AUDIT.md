# Paper 26.3 Head Coverage Audit

This audit compares PHeads against Paper `26.3.build.135-beta`. It is documentation/research for the 0.1.0 compatibility update; it does not add new heads or variants.

## Current coverage

PHeads defines 89 mob heads in the 0.1.1 development line: 6 native Minecraft head types and 83 custom-textured mob heads. Player heads are handled separately when enabled.

The Paper 26.3 migration does not invalidate the existing `HeadType` catalog or current variant resolver coverage.

## Newer Paper 26.3 mobs

Issue #20 adds the eight newer Paper 26.3 mobs to the 0.1.1 development line:

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
- villager profession
- zombie-villager profession
- screaming goat state

Temporary states such as anger, charging, nectar, or the strider cold state are intentionally not treated as head variants.

## Confirmed persistent appearance gaps on supported mobs

Paper 26.3 exposes additional persistent visual data that PHeads does not currently use:

| Mob | Paper 26.3 appearance data | PHeads status |
| --- | --- | --- |
| Cow | `cold`, `temperate`, `warm` variants | canonical texture only |
| Pig | `cold`, `temperate`, `warm` variants | canonical texture only |
| Chicken | `cold`, `temperate`, `warm` variants | canonical texture only |
| Salmon | `small`, `medium`, `large` size variants | canonical texture only |
| Snow Golem | pumpkin/derp state via `Snowman#isDerp()`; derp mode means no pumpkin | canonical texture only |
| Bogged | sheared state via `Bogged#isSheared()` | canonical texture only |
| Goat | left/right horn presence via `Goat#hasLeftHorn()` / `hasRightHorn()` in addition to screaming state | screaming state only; horn presence ignored |
| Shulker | dye color | canonical texture only |
| Tropical Fish | pattern, body color, pattern color | canonical texture only |
| Villager | biome/type in addition to profession | profession only |
| Zombie Villager | biome/type in addition to profession | profession only |
| Horse | markings in addition to color | color only; already intentionally limited by source data |

Cow, pig, and chicken sound variants are audio-only and are not head appearances.

These existing-mob appearance gaps are tracked in #30 for 0.1.1.

## Variant/state considerations for new mobs

The 0.1.1 implementation evaluated the persistent appearance data exposed for the new mobs:

- **Zombie Nautilus:** `temperate` and `warm` variants use distinct sourced shell textures.
- **Copper Golem:** unaffected, exposed, weathered, and oxidized states use distinct sourced head textures. Behavioral golem state is intentionally ignored.
- **Sulfur Cube:** registry-backed archetypes remain canonical-only because the pinned source provides a single Sulfur Cube head rather than distinct archetype textures.

## Texture provenance findings

PHeads' existing custom textures are pinned to Vanilla Tweaks More Mob Heads v2.15.0 (MC 1.21-1.21.4), preserved at RWELabs/Minecraft commit `4644939004389159c2a52b97e8b35a4dcf5ad75a`.

That snapshot predates the eight newer mobs in #20. It also contains only one canonical head texture for cow, pig, chicken, salmon, snow golem, bogged, shulker, and tropical fish. For goats it contains only normal and screaming-goat textures, with no left/right horn-presence variants. It therefore cannot provide the missing appearances identified above.

For the eight newer mobs, 0.1.1 uses the MIT-licensed Teak's Tweaks More Mob Heads data pinned at commit `5ca969779e614cc5f84012677b25fc01e5f1156c`, with `src/main/resources/data/more_mob_heads.json` pinned to Git blob `33ad209c4498514c7bc2726aeb1a2643334de6f2`. Unsupported variants remain intentionally omitted when no distinct pinned texture is available.

## Follow-up work

- #20 — implemented on the 0.1.1 development line with pinned texture provenance.
- #30 — add/evaluate missing persistent appearance variants for mobs PHeads already supports.

The original 0.1.0 release remained limited to Paper 26.3 compatibility and the audit; new head content begins with the later 0.1.1 development line.

## Reference sources

- Paper 26.3 API Javadocs: `https://jd.papermc.io/paper/26.3/`
- Pinned More Mob Heads v2.15.0 snapshot: `RWELabs/Minecraft@4644939004389159c2a52b97e8b35a4dcf5ad75a`
- Pinned newer More Mob Heads data: `teakivy/teaks-tweaks@5ca969779e614cc5f84012677b25fc01e5f1156c`
