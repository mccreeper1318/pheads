# Paper 26.3 Head Coverage Audit

This audit compares PHeads against Paper `26.3.build.135-beta`. It is documentation/research for the 0.1.0 compatibility update; it does not add new heads or variants.

## Current coverage

PHeads currently defines 81 mob heads: 6 native Minecraft head types and 75 custom-textured mob heads. Player heads are handled separately when enabled.

The Paper 26.3 migration does not invalidate the existing `HeadType` catalog or current variant resolver coverage.

## Missing mob candidates

Eight newer Paper 26.3 mobs are not currently represented by `HeadType` and are tracked for 0.1.2 in #20:

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

PHheads currently resolves persistent appearance variants for:

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

Temporary states such as anger, charging, nectar, or cold-state behavior are intentionally not treated as head variants.

## Confirmed persistent appearance gaps on supported mobs

Paper 26.3 exposes additional persistent visual data that PHeads does not currently use:

| Mob | Paper 26.3 appearance data | PHeads status |
| --- | --- | --- |
| Cow | `cold`, `temperate`, `warm` variants | canonical texture only |
| Pig | `cold`, `temperate`, `warm` variants | canonical texture only |
| Chicken | `cold`, `temperate`, `warm` variants | canonical texture only |
| Salmon | `small`, `medium`, `large` size variants | canonical texture only |
| Shulker | dye color | canonical texture only |
| Tropical Fish | pattern, body color, pattern color | canonical texture only |
| Villager | biome/type in addition to profession | profession only |
| Zombie Villager | biome/type in addition to profession | profession only |
| Horse | markings in addition to color | color only; already intentionally limited by source data |

Cow, pig, and chicken sound variants are audio-only and are not head appearances.

These existing-mob appearance gaps are tracked in #30 for 0.1.2.

## Variant/state considerations for new mobs

The eight newer mobs in #20 also need variant/state evaluation during implementation:

- **Zombie Nautilus:** Paper exposes `temperate` and `warm` variants.
- **Copper Golem:** Paper exposes weathering/oxidation state and golem state. Weathering can affect appearance; behavioral state should not create a head variant unless the visible head differs.
- **Sulfur Cube:** Paper exposes registry-backed archetypes. Archetypes should only map to separate heads when they visibly affect the head and matching sourced textures exist.

## Texture provenance findings

PHheads' existing custom textures are pinned to Vanilla Tweaks More Mob Heads v2.15.0 (MC 1.21-1.21.4), preserved at RWELabs/Minecraft commit `4644939004389159c2a52b97e8b35a4dcf5ad75a`.

That snapshot predates the eight newer mobs in #20. It also contains only one canonical head texture for cow, pig, chicken, salmon, shulker, and tropical fish, so it cannot provide the missing appearance variants identified above.

No additional texture hashes should be added until a suitable source can be pinned and attributed. If an API variant has no acceptable texture source, it should remain intentionally unsupported.

## Follow-up work

- #20 — add the eight newer Paper 26.3 mobs, with variant/state support only where distinct sourced textures exist.
- #30 — add/evaluate missing persistent appearance variants for mobs PHeads already supports.

Both implementation tracks are deferred to 0.1.2. The 0.1.0 release remains limited to the Paper 26.3 compatibility update and audit.

## Reference sources

- Paper 26.3 API Javadocs: `https://jd.papermc.io/paper/26.3/`
- Pinned More Mob Heads v2.15.0 snapshot: `RWELabs/Minecraft@4644939004389159c2a52b97e8b35a4dcf5ad75a`
