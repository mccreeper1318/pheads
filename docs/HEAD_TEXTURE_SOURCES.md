# Head Texture Sources

PHeads 0.0.2 uses fixed Minecraft profile/texture references for supported mobs that do not have native Minecraft head items.

The profile data listed below is adapted from the Vanilla Tweaks **More Mob Heads** data pack. Vanilla Tweaks' current terms and required attribution are available at https://vanillatweaks.net/terms/. The repository root also contains the required `credits.txt` attribution.

To make the exact source bytes reproducible, the values were extracted from a preserved copy of **More Mob Heads v2.15.0 (MC 1.21-1.21.4)** in `RWELabs/Minecraft` at commit `4644939004389159c2a52b97e8b35a4dcf5ad75a`:

https://github.com/RWELabs/Minecraft/tree/4644939004389159c2a52b97e8b35a4dcf5ad75a/Modifications/Datapacks/Season%204/more%20mob%20heads%20v2.15.0%20(MC%201.21-1.21.4)

The RWELabs repository is used here only as a pinned snapshot of the Vanilla Tweaks pack. Permission and attribution for the adapted content are based on Vanilla Tweaks' terms, not on the mirror repository.

PHeads stores the texture hash/profile reference, not the PNG skin files, and does not call a third-party head API at runtime. Minecraft resolves the referenced textures through `textures.minecraft.net`.

## Canonical 0.0.2 mappings

Variant-bearing mobs intentionally use one canonical appearance in 0.0.2. Variant-specific heads may be added separately later.

| PHeads key | Canonical appearance | Texture hash | Vanilla Tweaks source path | Pinned source blob |
| --- | --- | --- | --- | --- |
| `pig` | Pig | `41ee7681adf00067f04bf42611c97641075a44ae2b1c0381d5ac6b3246211bfe` | `data/more_mob_heads/loot_table/entities/pig.json` | `1d3919599e3160de5c3e2ef9c8ea211761401f54` |
| `cow` | Cow | `63d621100fea5883922e78bb448056448c983e3f97841948a2da747d6b08b8ab` | `data/more_mob_heads/loot_table/entities/cow.json` | `ce8cc1f549a5a96b3a98d9fafa4cba19462b862a` |
| `mooshroom` | Red Mooshroom | `da80606e82c642f141587733e3180ae57f646442c9fffd4e5997457e34311a29` | `data/more_mob_heads/loot_table/entities/mooshroom.json` | `8dd974618d80d9fc8f68d4c7249ee23f167592a6` |
| `sheep` | White Sheep | `6dfe7cc46d749b153261c1dc11abbf2a3108ea1ba0b2650280eed1592dcfc75b` | `data/more_mob_heads/loot_table/entities/sheep/white.json` | `89e50cc3911c85affc37a20a5d549e3f3bc2cb30` |
| `chicken` | Chicken | `42af6e5847eea099e1b0ab8c20a9e5f3c7190158bda54e28133d9b271ec0cb4b` | `data/more_mob_heads/loot_table/entities/chicken.json` | `3c205ed9f210e69140ed6f068a0f0f53a36803bd` |
| `rabbit` | Brown Rabbit | `cfd4f86cf7473fbae93b1e090489b64c0be126c7bb16ffc88c002447d5c72795` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `horse` | Brown Horse | `6771800770cb4e814a3d91186fcd795ec82e06102ff7c1ee4e5c380102a0c70f` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `donkey` | Donkey | `4e25ee9273ad579d44bf406f6f6295586481ea198fd572076cd0c5882da7e6cc` | `data/more_mob_heads/loot_table/entities/donkey.json` | `125e00503e54c5da4ae7930058908cb3c3f325ff` |
| `mule` | Mule | `41c224a1031be434d25ae1885bf4ff400c9894c69bfef56a49354c5625c0c09c` | `data/more_mob_heads/loot_table/entities/mule.json` | `fd16404d89d9db8e6100a0fbfa8d77225e30a737` |
| `goat` | Normal Goat | `87473e055df6e7fd98664e9fdb63675f088106305d744024a41bb358918a142b` | `data/more_mob_heads/loot_table/entities/goat.json` | `66717150ffb1b96e35aa086f3d249344b7a4f3a1` |
| `llama` | White Llama | `80277e6b3d9f7819efc7da4b42745f7ab9a63ba8f36d6b84a7a250c6d1a358eb` | `data/more_mob_heads/loot_table/entities/llama.json` | `18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e` |
| `camel` | Camel | `e67d4597340166e1978a668a06bf5755c17b4cb5b40ab8ff244093b6b8bc75d3` | `data/more_mob_heads/loot_table/entities/camel.json` | `44fec07b507956e566c1ea4df977ce0021de9d7b` |
| `cat` | Tabby Cat | `de28d30db3f8c3fe50ca4f26f3075e36f003ae8028135a8cd692f24c9a98ae1b` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `wolf` | Pale Wolf | `1ee33c2dc07d76b4f03e66427a08cba2e8179d075ae64b9ce150aa4209c5af39` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `fox` | Red Fox | `d7e0043111bc57090856259155571c7906e707046df041b8b572704c451fcd82` | `data/more_mob_heads/loot_table/entities/fox.json` | `0773baf51242e5c42d0f9cc99842f537bd3b0a19` |
| `bee` | Normal Bee | `59ac16f296b461d05ea0785d477033e527358b4f30c266aa02f020157ffca736` | `data/more_mob_heads/loot_table/entities/bee.json` | `dee330e6afac2791a0cb94be65522ae61eff6069` |
| `turtle` | Turtle | `304931200ad460b650a190e8d41227c3999fbeb933b51ca49fd9e5920d1f8e7d` | `data/more_mob_heads/loot_table/entities/turtle.json` | `ae2b9be05a22db78fa9b0a227fbdabc99ae91e95` |
| `frog` | Temperate Frog | `a50d1073d41f193405d95b1d941f9fe1a7ff080e38155d7bb780bbbd8e86f70d` | `data/more_mob_heads/loot_table/entities/frog.json` | `9b073aa1371564190d2fcad06877875a47f516a6` |
| `axolotl` | Lucy Axolotl | `667e15eab73064b6680d1db98ba445ed0914ba35a799997c0da2b03ffc3a8826` | `data/more_mob_heads/loot_table/entities/axolotl.json` | `a34b7cbe11e50b603ed75a05d92f08ffa7960e53` |
| `sniffer` | Sniffer | `c84a7e7fe197b7e7419b51d46cc233551b9ec899de1afe7f653e4f8fb26a686e` | `data/more_mob_heads/loot_table/entities/sniffer.json` | `d89ae3a499e67fabe8f459f820ac76e1b5d2fdaf` |

## Adding another custom head

Any future custom-textured `HeadType` must include all three pieces of provenance metadata in code:

1. the texture hash,
2. the source path inside the pinned source pack, and
3. the exact Git blob SHA containing that source value.

Regression tests enforce that custom head definitions cannot omit the source path or pinned blob SHA.
