# Head Texture Sources

PHeads uses fixed Minecraft profile/texture references for supported mobs that do not have native Minecraft head items.

The profile data listed below is adapted from the Vanilla Tweaks **More Mob Heads** data pack. Vanilla Tweaks' current terms and required attribution are available at https://vanillatweaks.net/terms/. The repository root also contains the required `credits.txt` attribution.

To make the exact source bytes reproducible, the values were extracted from a preserved copy of **More Mob Heads v2.15.0 (MC 1.21-1.21.4)** in `RWELabs/Minecraft` at commit `4644939004389159c2a52b97e8b35a4dcf5ad75a`:

https://github.com/RWELabs/Minecraft/tree/4644939004389159c2a52b97e8b35a4dcf5ad75a/Modifications/Datapacks/Season%204/more%20mob%20heads%20v2.15.0%20(MC%201.21-1.21.4)

The RWELabs repository is used here only as a pinned snapshot of the Vanilla Tweaks pack. Permission and attribution for the adapted content are based on Vanilla Tweaks' terms, not on the mirror repository.

PHeads stores the texture hash/profile reference, not the PNG skin files, and does not call a third-party head API at runtime. Minecraft resolves the referenced textures through `textures.minecraft.net`.

## Canonical mappings

The canonical mappings below are used by commands and as fallbacks. Natural drops can override these canonical appearances with the matching persistent mob variant documented in the variant-aware mappings below.

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
| `allay` | Allay | `cc0389177dbaa92f0d5ffdf848862c7f9b36df222fbfd737e2639dc3059e0cf3` | `data/more_mob_heads/loot_table/entities/allay.json` | `6b5cf940079cb5f84b1e93d65e108f4e8e82183f` |
| `armadillo` | Armadillo | `6607ae7a701767336c06b0c4ffa81dff2cfd8bc070d95714a6badf0efb7263e1` | `data/more_mob_heads/loot_table/entities/armadillo.json` | `a279a103eaada394e4b2aad3e51e2ceed0bddd75` |
| `bat` | Bat | `3eb588dcd0bb57ce6ddab8e3afb6fd4330064eaac01b61a8e9769f0476f52f50` | `data/more_mob_heads/loot_table/entities/bat.json` | `c5553c29473c20bfa9a9d610db6c4773275754ea` |
| `cod` | Cod | `f246e19b32cf784549447e07b96072e1f656d78e93ccca5637485e6749734652` | `data/more_mob_heads/loot_table/entities/cod.json` | `7a1c3f50b6adfc9f270470f04bb01a5d44c02a33` |
| `dolphin` | Dolphin | `8e9688b950d880b55b7aa2cfcd76e5a0fa94aac6d16f78e833f7443ea29fed3` | `data/more_mob_heads/loot_table/entities/dolphin.json` | `c981c9b14bdc380a381d64b0f34aaba4261ece1f` |
| `glow-squid` | Glow Squid | `4b2e9b6581fed48a99e0323091ad5c3c326cda20073e28a902a0373f7382b59f` | `data/more_mob_heads/loot_table/entities/glow_squid.json` | `4b2b88b1a18f2c218b7d98127595bf9afb341a7c` |
| `iron-golem` | Iron Golem | `fe7c0719fabe116dce605199bcadc69a538860864ef15706983ff662822d9fe3` | `data/more_mob_heads/loot_table/entities/iron_golem.json` | `96ce2650bde383745084986eee3f2e41ab00b453` |
| `ocelot` | Ocelot | `9175cc43ea8ae20168a1f170810b4da4d9b4ebd3c9976e9fc22e9f995c3cbc3c` | `data/more_mob_heads/loot_table/entities/ocelot.json` | `0ba2dcd4471d625268135b6412f24f13fb08a8cf` |
| `panda` | Aggressive Panda | `e546e436d166b17f0521bd8538ea13cd6ee3b5df102eb32e3e425cb285d44063` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `parrot` | Red Parrot | `40a3d47f54e71a58bf8f57c5253fb2d213f4f55bb7934a19104bfb94edc76eaa` | `data/more_mob_heads/loot_table/entities/parrot.json` | `a34d1cb0fa40139999b4c5b480e4f793c8baff20` |
| `polar-bear` | Polar Bear | `cd8702911e616c0d32fbe778d195f21ecce9025bcbd09151e3d97af3192aa7ec` | `data/more_mob_heads/loot_table/entities/polar_bear.json` | `fd701ef0c044aaf62f39d7afa40e154972fc4b27` |
| `pufferfish` | Pufferfish | `e2733d5da59c82eaf310b382aff40bd513c44354dbbabfe14b066a556810a7f9` | `data/more_mob_heads/loot_table/entities/pufferfish.json` | `3b4573da12ace705e24f98c88fea987d008097e1` |
| `salmon` | Salmon | `791d9e69b795da4eaacfcf7350dfe8ae367fed833556706e040339dd7fe0240a` | `data/more_mob_heads/loot_table/entities/salmon.json` | `9fd103261c460d1c028e97dd714a68c6dea71902` |
| `skeleton-horse` | Skeleton Horse | `6e226705bd2a9e7bb8d6b0f4daa969b9e12d4ae5c66da693bb5f4a4a1e6aa296` | `data/more_mob_heads/loot_table/entities/skeleton_horse.json` | `983bbd71c2b23ddad70ea9785b5a91e178f2afa7` |
| `snow-golem` | Snow Golem | `caa3e17ef1b29a4b87fa43dee1db12c41fd39aa387fa13af2a079b5b378fde8b` | `data/more_mob_heads/loot_table/entities/snow_golem.json` | `898cc9064a233b0b9678eac2e90d96fae04c7ce0` |
| `squid` | Squid | `8351b7d9a4f36cfe31fd59d8c900e419a135144105e7a981caa5a168dcff325b` | `data/more_mob_heads/loot_table/entities/squid.json` | `4e09b5d7b5979d0e68128ba48b5cdc1454ad5456` |
| `strider` | Strider | `9c40fad1c11de9e6422b405426e9b97907f35bce345e3758604d3e7be7df884` | `data/more_mob_heads/loot_table/entities/strider.json` | `52bccfdfa22fb9b0979bc3d8c71d47fc1494f721` |
| `tadpole` | Tadpole | `3daf1653b5f59b5ec5a3f79609cb4233579fef07e693b61749e0900149edf563` | `data/more_mob_heads/loot_table/entities/tadpole.json` | `1b28237596845dac681d6e3a2c1bb67a79470341` |
| `trader-llama` | Creamy Trader Llama | `e89a2eb17705fe7154ab041e5c76a08d41546a31ba20ea3060e3ec8edc10412c` | `data/more_mob_heads/loot_table/entities/trader_llama.json` | `50df37f55ceaadeb9581546b0173af99e79fe056` |
| `tropical-fish` | Tropical Fish | `34a0c84dc3c090df7bafc4367a9fc6c8520da2f73efffb80e934d1189eadac41` | `data/more_mob_heads/loot_table/entities/tropical_fish.json` | `9db46755a8b2c2e75225963f6a708b6287329fb0` |
| `villager` | Armorer Villager | `1ef627f566ac0a7828bad93e9e4b9643d99a928a13d5f977bf441e40db1336bf` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `wandering-trader` | Wandering Trader | `5f1379a82290d7abe1efaabbc70710ff2ec02dd34ade386bc00c930c461cf932` | `data/more_mob_heads/loot_table/entities/wandering_trader.json` | `40f379c8fcb8b50e63261151d867f78978d23da4` |
| `zombie-horse` | Zombie Horse | `6618ffbe1cfa2058fe80a065f70c128c225a1e0bc9deaf8b38b0395443f40909` | `data/more_mob_heads/loot_table/entities/zombie_horse.json` | `f9812636db03af392de93648e06a76ad68b0a376` |
| `blaze` | Blaze | `dee23dc7a10c6a87ef937454c0e94ed42c23aa641a91ed8470a3042d05c52c52` | `data/more_mob_heads/loot_table/entities/blaze.json` | `3bd819ccf7423e8b69c9cb7c2054b5af524c20df` |
| `bogged` | Bogged | `4f807a187077f836b93820b32d8d8341d4d32cd4c8c1115cf1da6374e0fbd3ff` | `data/more_mob_heads/loot_table/entities/bogged.json` | `1eb4db4663cd58e2a27db7107761acdf8f47ee2a` |
| `breeze` | Breeze | `a275728af7e6a29c88125b675a39d88ae9919bb61fdc200337fed6ab0c49d65c` | `data/more_mob_heads/loot_table/entities/breeze.json` | `dfde472a984d5add62f577b091c4c9deee51f304` |
| `cave-spider` | Cave Spider | `a6a1c2599fc91203a65a03d479c8dc87f662deac3663c16c5e04d625b3978a25` | `data/more_mob_heads/loot_table/entities/cave_spider.json` | `d94102ab7e1f9b8dd2b8ee164845d17587861ee5` |
| `drowned` | Drowned | `c3f7ccf61dbc3f9fe9a6333cde0c0e14399eb2eea71d34cf223b3ace22051` | `data/more_mob_heads/loot_table/entities/drowned.json` | `df20f792dae3fa18d959c753e7c0c062e4243145` |
| `elder-guardian` | Elder Guardian | `4a2d64f4a00e9c85f67262edcacb84523581ae0f37bdab22dd704524f62e169f` | `data/more_mob_heads/loot_table/entities/elder_guardian.json` | `45b9f3edaf5df8bb5f731994dcada75861d7d756` |
| `enderman` | Enderman | `8977a94f02498cad0cfdb65ca7cb72e23111a914d8c670acccc7a65b347d7776` | `data/more_mob_heads/loot_table/entities/enderman.json` | `eca0e0b1af97c129a78dec92fcb188ecae092ad9` |
| `endermite` | Endermite | `8c6b65c22b4465ba6793b2195cd5084ce83b88dca6e55eb9484540acd7352a50` | `data/more_mob_heads/loot_table/entities/endermite.json` | `ae3c8abf1668f0265fcee8f225ce03e6fbef52fe` |
| `evoker` | Evoker | `390fbd88f659d3963c68cbbcb7c7121d8195a8be65bbd2bf1257d1f69bccc0c7` | `data/more_mob_heads/loot_table/entities/evoker.json` | `1bc187d4f7355db22149ef8239521865fe94f4b1` |
| `ghast` | Ghast | `c53de31a2d0041a6ef75bf7a6c8468464db1aaa6201ebb1a6013edb2245c7607` | `data/more_mob_heads/loot_table/entities/ghast.json` | `ba3748728de5010afcbc88f9f2ba4343d4c36b98` |
| `guardian` | Guardian | `e2ba34416670454b1a20496f80b9398529f49003fc613eb930248ea9b5d1a391` | `data/more_mob_heads/loot_table/entities/guardian.json` | `1b2149c49a313d4b96ab6e9bcc2dcb5893f59a59` |
| `hoglin` | Hoglin | `bc4a7f57fc03b13aa2f9d83cdd4822b936793096daf51e78025bbd241ed6f68d` | `data/more_mob_heads/loot_table/entities/hoglin.json` | `4d4cb0b1339fed3ee3c115a24825cd6176cefd47` |
| `husk` | Husk | `7338318bc91a36cd5ab6aa885c9a4ee2bdacdaa5c66b2a99dfb0a560983f2480` | `data/more_mob_heads/loot_table/entities/husk.json` | `ee800303b3a919c6346aa649794595a9db0b75b8` |
| `illusioner` | Illusioner | `d382701c67d6c54c907558891dc176225112518771e061c5d8bd918479e6bdd8` | `data/more_mob_heads/loot_table/entities/illusioner.json` | `84001ad09e097e7d3e8c6c1b46a9fa3ea2243b4a` |
| `magma-cube` | Magma Cube | `b81718d4984847a4ad3ec081a4ebffd183743239aecab60322138a72609812c3` | `data/more_mob_heads/loot_table/entities/magma_cube.json` | `8e26b803b9cab6375451d4b243357db84f150194` |
| `phantom` | Phantom | `7e95153ec23284b283f00d19d29756f244313a061b70ac03b97d236ee57bd982` | `data/more_mob_heads/loot_table/entities/phantom.json` | `37320ecd1cdd281482fef5f0f1bf343797647c5d` |
| `piglin-brute` | Piglin Brute | `6488799c83ecb29452ceba89c3c0099219274ce5b2bfb8ad0b3ea4c65fac4630` | `data/more_mob_heads/loot_table/entities/piglin_brute.json` | `ede7bfe72bea706bb43fcaaf96f8e0f0c1da1627` |
| `pillager` | Pillager | `c225f0b49c5295048a409c9c601cca79aa8eb52aff5e2033ebb865f4367ef43e` | `data/more_mob_heads/loot_table/entities/pillager.json` | `c7eb5262bd6189e6b504615dcd0c212644391ab0` |
| `ravager` | Ravager | `eb4db2986140e251e32e70ed08c8a081720313ce257632be1ef94a0737394db` | `data/more_mob_heads/loot_table/entities/ravager.json` | `60b25df199d7f6a25169e1758fa1f196ecf54901` |
| `shulker` | Shulker | `fb9e6af6b819f3d90e67ce2e7059fbef31da2aa953d35e3454f1021fa912efde` | `data/more_mob_heads/loot_table/entities/shulker.json` | `317d346a1a0620797cc078604c8a425f220902ec` |
| `silverfish` | Silverfish | `f25e9fae371664de1a800c84d025124abb8f15111807c8bc1ab9126aacbd4f95` | `data/more_mob_heads/loot_table/entities/silverfish.json` | `e96fbaff36c3d4cf8a87813f39f0aac918e650d9` |
| `slime` | Slime | `c06424ec7a196b15f9ad5733a36a6d1f2e6a0d42ffce1e1508f90f312ac4caed` | `data/more_mob_heads/loot_table/entities/slime.json` | `7a5eb77655cb05ded4d07aa16ea8f7a67737a4bd` |
| `spider` | Spider | `de28e6629b6ed1da94d4a818761612c36fb3a6813c4b63fb9fea5076415f3f0c` | `data/more_mob_heads/loot_table/entities/spider.json` | `82238f36b5e618bcfa311c89fcf0ea232321701f` |
| `stray` | Stray | `592b5597085e35db53d9bda008cae72b2f00cd7d4cd8dc69ff174a55b689e6e` | `data/more_mob_heads/loot_table/entities/stray.json` | `8cb3d3c6f577e5a1d0a9526d263a81a11be8604a` |
| `vex` | Vex | `b9538f2830c4dea6996ed744785504e32e0e20d8663edab6b0222f2c022077bd` | `data/more_mob_heads/loot_table/entities/vex.json` | `3ade8dbbcac3b61e1aeac683de33ed3c2789df18` |
| `vindicator` | Vindicator | `2dabafde27ee12b09865047aff6f183fdb64e04dae1c00ccbde04ad93dcc6c95` | `data/more_mob_heads/loot_table/entities/vindicator.json` | `158616ece06af88495abd716baec44c81a59281d` |
| `warden` | Warden | `b2f3879b737127485eb35ddee748d06cf914b193d97753ae34e92230842831fb` | `data/more_mob_heads/loot_table/entities/warden.json` | `56d79e1d128242baa54b0635088517492b2c0f4a` |
| `witch` | Witch | `a520f12c63c7912186c4be4e30c33c5acaec0db0b6abd836d517d74a62275d4b` | `data/more_mob_heads/loot_table/entities/witch.json` | `bfc8ae9c723e9b254a826c9ee5f4a17374e35ce3` |
| `wither` | Wither | `eda10828f63b7ecdefd767b3245fbdaa13c3ec0c6b13774f1ee8d307c034c383` | `data/more_mob_heads/loot_table/entities/wither.json` | `0ffde2c41efa7764398f590c7635bb44b3e66afd` |
| `zoglin` | Zoglin | `2e3493a956bfd7588ed1a8ea858759667659d58100cbecd6d96ccc0ca9b36923` | `data/more_mob_heads/loot_table/entities/zoglin.json` | `077390588b0e12fdd9f10c5d8ed812e15791036c` |
| `zombie-villager` | Zombie Armorer | `c8679e034767d518660d9416dc5eaf319d697682ac40c886e3c2bc8dfa1de1d` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombified-piglin` | Zombified Piglin | `2df03128b002a70708d6825ed6cf54ddf694b3766d78d5649030b1cb8b34c6fa` | `data/more_mob_heads/loot_table/entities/zombified_piglin.json` | `19153ca18e54f3c480630b83c0e80a59ddac9b92` |

## Variant-aware mappings

Natural drops use these mappings when Paper exposes the corresponding persistent mob property. The mob-level drop chance remains unchanged; variants do not have separate probabilities.

Transient states are intentionally excluded. Wolf anger, bee anger/nectar, strider cold state, Vex charging, and Wither projectile textures are not variant collectibles. Horse markings, villager biome types, shulker colors, tropical-fish patterns/colors, and salmon sizes are not distinguished because this pinned source does not provide corresponding variant head mappings. Name-driven Easter eggs such as `jeb_` sheep and Toast rabbits are also outside the normal variant resolver.

| PHeads key | Variant key | Display name | Texture hash | Vanilla Tweaks source path | Pinned source blob |
| --- | --- | --- | --- | --- | --- |
| `sheep` | `black` | Black Sheep Head | `13335e8065c7b5dfea58d3df7474f396af4fa0a2ba52a3c9b7fba68319271c91` | `data/more_mob_heads/loot_table/entities/sheep/black.json` | `80a62c5aeb1c3bc03d7920813ece95fa011c6357` |
| `sheep` | `blue` | Blue Sheep Head | `740e277da6c398b749a32f9d080f1cf4c4ef3f1f20dd9e5f422509e7ff593c0` | `data/more_mob_heads/loot_table/entities/sheep/blue.json` | `176b76c21f22717e2c2c7c2b5554bfe6b3226209` |
| `sheep` | `brown` | Brown Sheep Head | `3128d086bc81669fc2255bb22cadc66a0f5ed70885e84c32d37c1b484db35901` | `data/more_mob_heads/loot_table/entities/sheep/brown.json` | `0e736a7e79b6459a79e2cbf4f3ee60c21131c4f2` |
| `sheep` | `cyan` | Cyan Sheep Head | `5d42fcbcaf9d48f73ffb0c3c36f34b4643295f6daa6cc74ab9d242ed5aa5636` | `data/more_mob_heads/loot_table/entities/sheep/cyan.json` | `4fb88739bf4f6724d93b64245cda70acee1a279b` |
| `sheep` | `gray` | Gray Sheep Head | `3fafecf0603b2dcd7984d252586069895db9aa78e1841bd554b19508dcf967a1` | `data/more_mob_heads/loot_table/entities/sheep/gray.json` | `5a3e757192447b802d1eec5e3bcac276431b5712` |
| `sheep` | `green` | Green Sheep Head | `9ea887eae4b07636e9e2f906609b00ab8d9b86b74728b819ff6f376583ea139` | `data/more_mob_heads/loot_table/entities/sheep/green.json` | `29d2e154be932d5b30c877128f64b0b9da566cc8` |
| `sheep` | `light-blue` | Light Blue Sheep Head | `ebf23af8719c437b3ee84019ba3c9e69ca854d3a8afd5cba6d9696c053b48614` | `data/more_mob_heads/loot_table/entities/sheep/light_blue.json` | `aff70b87635eeb7b20c9bf0ff83e27c52d1585f8` |
| `sheep` | `light-gray` | Light Gray Sheep Head | `1d2e2e93a142bfd43f240d37de8f9b0976e76e65b22651908259e46db770e` | `data/more_mob_heads/loot_table/entities/sheep/light_gray.json` | `e7da5847066284c8f7ad2f112cc1195c14676ede` |
| `sheep` | `lime` | Lime Sheep Head | `6bead0342ae89b8dfd3d711a60add65e2c2bfea8d0bd274a7587deed7a31892e` | `data/more_mob_heads/loot_table/entities/sheep/lime.json` | `77decfbcdf55c90b68fe0a9563a5113973b42090` |
| `sheep` | `magenta` | Magenta Sheep Head | `a8e1f05f0dacca63a731874f90a693ffe21ff832e2b1e1d07b65c8764526f089` | `data/more_mob_heads/loot_table/entities/sheep/magenta.json` | `6d5951fab9c8511f06da2fae6699290776be5b08` |
| `sheep` | `orange` | Orange Sheep Head | `f684d04fa80aa59da14535dead3883d097fbba400625659f5259964806ba66f0` | `data/more_mob_heads/loot_table/entities/sheep/orange.json` | `e3d57c19126622d5860d95ec799fa2e641fc762a` |
| `sheep` | `pink` | Pink Sheep Head | `6363e8a93d287a84e640309ae83ca1de0a0b257505a20ec55b3349d40a44854` | `data/more_mob_heads/loot_table/entities/sheep/pink.json` | `cc12cafe1345f0fd81f3e278f5b8d2a1b07b1ab0` |
| `sheep` | `purple` | Purple Sheep Head | `3449d08291dae45a24673619602f435b57f4cd4e9e98d2e0fbec4f18144781d3` | `data/more_mob_heads/loot_table/entities/sheep/purple.json` | `3f7c9c53e6c824e238351ff9a16f197b72da6942` |
| `sheep` | `red` | Red Sheep Head | `5478e057158de6f45e2541cd17788e640ccb59723de59c254e82ab5711f3fc27` | `data/more_mob_heads/loot_table/entities/sheep/red.json` | `a6ff7597b64319d8a5526fa3f8834969129b7c6e` |
| `sheep` | `white` | White Sheep Head | `6dfe7cc46d749b153261c1dc11abbf2a3108ea1ba0b2650280eed1592dcfc75b` | `data/more_mob_heads/loot_table/entities/sheep/white.json` | `89e50cc3911c85affc37a20a5d549e3f3bc2cb30` |
| `sheep` | `yellow` | Yellow Sheep Head | `94b28f035735906f82ffc4dba99c9f0b55240e426cd1c525a9aa77180eec4934` | `data/more_mob_heads/loot_table/entities/sheep/yellow.json` | `9ab2355aefa280377d5e309d77b5e7ef0f1e52a1` |
| `cat` | `tabby` | Tabby Cat Head | `de28d30db3f8c3fe50ca4f26f3075e36f003ae8028135a8cd692f24c9a98ae1b` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `black` | Tuxedo Cat Head | `4fd10c8e75f67398c47587d25fc146f311c053cc5d0aeab8790bce36ee88f5f8` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `red` | Ginger Cat Head | `2113dbd3c6a078a17b4edb78ce07d836c38dace5027d4b0a83fd60e7ca7a0fcb` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `siamese` | Siamese Cat Head | `d5b3f8ca4b3a555ccb3d194449808b4c9d783327197800d4d65974cc685af2ea` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `british_shorthair` | British Shorthair Cat Head | `5389e0d5d3e81f84b570e2978244b3a73e5a22bcdb6874b44ef5d0f66ca24eec` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `calico` | Calico Cat Head | `340097271bb680fe981e859e8ba93fea28b813b1042bd277ea3329bec493eef3` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `persian` | Persian Cat Head | `ff40c746260ef91c96b27159795e87191ae7ce3d5f767bf8c74faad9689af25d` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `ragdoll` | Ragdoll Cat Head | `dc7a45d25889e3fdf7797cb258e26d4e94f5bc13eef00795dafef2e83e0ab511` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `white` | White Cat Head | `21d15ac9558e98b89aca89d3819503f1c5256c2197dd3c34df5aac4d72e7fbed` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `jellie` | Jellie Cat Head | `a0db41376ca57df10fcb1539e86654eecfd36d3fe75e8176885e93185df280a5` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `cat` | `all_black` | Black Cat Head | `22c1e81ff03e82a3e71e0cd5fbec607e11361089aa47f290d46c8a2c07460d92` | `data/more_mob_heads/loot_table/entities/cat.json` | `809a57fe9a7bf14e7000ee8b0065d2946faecab2` |
| `wolf` | `ashen` | Ashen Wolf Head | `72384c5cf18948b83a89548dba5a9945edeefc5e9654c5d6d38ae10a5d502e75` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `black` | Black Wolf Head | `c5a66a42b25f822a7e16a2187528d1a2e294a01d9f850671b94c95742bb4916e` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `chestnut` | Chestnut Wolf Head | `cb9b0d48442204ff6fd39fa074167118e9c066cde3888977d0f6036e1d8a69ee` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `pale` | Pale Wolf Head | `1ee33c2dc07d76b4f03e66427a08cba2e8179d075ae64b9ce150aa4209c5af39` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `rusty` | Rusty Wolf Head | `23455f6048a68098cd27634e3146c81c8269aeefcf0aff91cc976efa0baa1146` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `snowy` | Snowy Wolf Head | `4ecadab50aa8d41fa9b369a2f84f97456be7900b220ece3b95e8a00968660d5` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `spotted` | Spotty Wolf Head | `573b9a6431af26bcb31826eb6fd9f4b35b947ba5882c6e4aa93588633f7b8d9d` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `striped` | Striped Wolf Head | `7fc52fb3cdfc6aeb00e67c1b7a59d8d320df44656c7af6824b13ca60792aa7d7` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `wolf` | `woods` | Woods Wolf Head | `8d12ab17647b69c9421769572ac674de199124c284b9ed1f65a285c38cd2a504` | `data/more_mob_heads/loot_table/entities/wolf.json` | `3f0fd63d4c4d2051ee77986177dd2cdc78f7d183` |
| `frog` | `cold` | Cold Frog Head | `76877893e920ff5dfa4b5fbd14dabee2e6308a6f97c3a19b08e241a29eb9a5c3` | `data/more_mob_heads/loot_table/entities/frog.json` | `9b073aa1371564190d2fcad06877875a47f516a6` |
| `frog` | `temperate` | Temperate Frog Head | `a50d1073d41f193405d95b1d941f9fe1a7ff080e38155d7bb780bbbd8e86f70d` | `data/more_mob_heads/loot_table/entities/frog.json` | `9b073aa1371564190d2fcad06877875a47f516a6` |
| `frog` | `warm` | Warm Frog Head | `d5b0da43975b83c3322788dda317506333843aebe5512787cb2e3d769ed2b382` | `data/more_mob_heads/loot_table/entities/frog.json` | `9b073aa1371564190d2fcad06877875a47f516a6` |
| `axolotl` | `lucy` | Lucy Axolotl Head | `667e15eab73064b6680d1db98ba445ed0914ba35a799997c0da2b03ffc3a8826` | `data/more_mob_heads/loot_table/entities/axolotl.json` | `a34b7cbe11e50b603ed75a05d92f08ffa7960e53` |
| `axolotl` | `wild` | Wild Axolotl Head | `47cf0274998bf5a7f38b37036e154f112fa2e28bad40d5a7c94765fe4f52211e` | `data/more_mob_heads/loot_table/entities/axolotl.json` | `a34b7cbe11e50b603ed75a05d92f08ffa7960e53` |
| `axolotl` | `gold` | Gold Axolotl Head | `e58560115faad11619b3d55de79ef2a053f478a67194bbe9247edea0bc98e834` | `data/more_mob_heads/loot_table/entities/axolotl.json` | `a34b7cbe11e50b603ed75a05d92f08ffa7960e53` |
| `axolotl` | `cyan` | Cyan Axolotl Head | `851196d43930659d717e1b6a046a08d1220fcb4e31c4856bc33e7551986ef1d` | `data/more_mob_heads/loot_table/entities/axolotl.json` | `a34b7cbe11e50b603ed75a05d92f08ffa7960e53` |
| `axolotl` | `blue` | Blue Axolotl Head | `68fd10b0fef4595960b1f64193bc8a1865a2d2ed48b2e2ce03d994563027df95` | `data/more_mob_heads/loot_table/entities/axolotl.json` | `a34b7cbe11e50b603ed75a05d92f08ffa7960e53` |
| `rabbit` | `brown` | Brown Rabbit Head | `cfd4f86cf7473fbae93b1e090489b64c0be126c7bb16ffc88c002447d5c72795` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `rabbit` | `white` | White Rabbit Head | `9542d7160987148a5d8e20e469bd9b3c2a3946c7fb5923f55b9beae99185f` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `rabbit` | `black` | Black Rabbit Head | `b2b425ff2a236ab19cc9397195db40f8f185b191c40bf44b26e95eac9fb5efa3` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `rabbit` | `black-and-white` | Black and White Rabbit Head | `35f72a2195ebf4117c5056cfe2b7357ec5bf832ede1856a7773ee42a0d0fb3f0` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `rabbit` | `gold` | Gold Rabbit Head | `767b722656fdeec39974d3395c5e18b47c5e237bce5bbced9b7553aa14b54587` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `rabbit` | `salt-and-pepper` | Salt and Pepper Rabbit Head | `9238519ff39815b16c4062823e43161ffaac96894fe088b018e6a24c26e181ec` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `rabbit` | `the-killer-bunny` | The Killer Bunny Head | `71dd767929ef2fd2d43e86e8744c4b0d810853471201f2dfa18f96a67de56e2f` | `data/more_mob_heads/loot_table/entities/rabbit.json` | `a6883596a540aeaf8dd66567c588bb33b2f4a6d3` |
| `horse` | `white` | White Horse Head | `c7bc61609730f2cb010268fab0821bd47352699750a150599f21c3fc4e92591a` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `horse` | `creamy` | Creamy Horse Head | `42a0d54cc071267d6bfd5f523f8c89dcfdc5e805fabbb76010cb3befa465aa94` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `horse` | `chestnut` | Chestnut Horse Head | `6c8720d1f552693b40a9a33afa41cef06afd142833bed9fa5b887e88f05f49fa` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `horse` | `brown` | Brown Horse Head | `6771800770cb4e814a3d91186fcd795ec82e06102ff7c1ee4e5c380102a0c70f` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `horse` | `black` | Black Horse Head | `6723fa5be6ac2292a72230f5fd7ab663493bd8f7e64816424dc5bf24f133890c` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `horse` | `gray` | Gray Horse Head | `c25986102181083fb317bc5712f7104daa5a3e889264dfebb9159f6e08bac90c` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `horse` | `dark-brown` | Dark Brown Horse Head | `7f2341aaa0c82c22bbc207063e319291097c539adad9aa913eb8001b11aa59da` | `data/more_mob_heads/loot_table/entities/horse.json` | `ff98d1267c4d5dd4721c32377ffbb2efd42d6893` |
| `llama` | `creamy` | Creamy Llama Head | `4d67fd4bff293269cb908974dca83c33485e435ed5a8e1dbd6521c61687140` | `data/more_mob_heads/loot_table/entities/llama.json` | `18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e` |
| `llama` | `white` | White Llama Head | `80277e6b3d9f7819efc7da4b42745f7ab9a63ba8f36d6b84a7a250c6d1a358eb` | `data/more_mob_heads/loot_table/entities/llama.json` | `18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e` |
| `llama` | `brown` | Brown Llama Head | `c2b1ecff77ffe3b503c30a548eb23a1a08fa26fd67cdff389855d74921368` | `data/more_mob_heads/loot_table/entities/llama.json` | `18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e` |
| `llama` | `gray` | Gray Llama Head | `cf24e56fd9ffd7133da6d1f3e2f455952b1da462686f753c597ee82299a` | `data/more_mob_heads/loot_table/entities/llama.json` | `18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e` |
| `trader-llama` | `creamy` | Creamy Trader Llama Head | `e89a2eb17705fe7154ab041e5c76a08d41546a31ba20ea3060e3ec8edc10412c` | `data/more_mob_heads/loot_table/entities/trader_llama.json` | `50df37f55ceaadeb9581546b0173af99e79fe056` |
| `trader-llama` | `white` | White Trader Llama Head | `7087a556d4ffa95ecd2844f350dc43e254e5d535fa596f540d7e77fa67df4696` | `data/more_mob_heads/loot_table/entities/trader_llama.json` | `50df37f55ceaadeb9581546b0173af99e79fe056` |
| `trader-llama` | `brown` | Brown Trader Llama Head | `8424780b3c5c5351cf49fb5bf41fcb289491df6c430683c84d7846188db4f84d` | `data/more_mob_heads/loot_table/entities/trader_llama.json` | `50df37f55ceaadeb9581546b0173af99e79fe056` |
| `trader-llama` | `gray` | Gray Trader Llama Head | `be4d8a0bc15f239921efd8be3480ba77a98ee7d9ce00728c0d733f0a2d614d16` | `data/more_mob_heads/loot_table/entities/trader_llama.json` | `50df37f55ceaadeb9581546b0173af99e79fe056` |
| `parrot` | `red` | Red Parrot Head | `40a3d47f54e71a58bf8f57c5253fb2d213f4f55bb7934a19104bfb94edc76eaa` | `data/more_mob_heads/loot_table/entities/parrot.json` | `a34d1cb0fa40139999b4c5b480e4f793c8baff20` |
| `parrot` | `blue` | Blue Parrot Head | `b94bd3fcf4d46354ede8fef73126dbcab52b301a1c8c23b6cdfc12d612b61bea` | `data/more_mob_heads/loot_table/entities/parrot.json` | `a34d1cb0fa40139999b4c5b480e4f793c8baff20` |
| `parrot` | `green` | Green Parrot Head | `6a1dc33115232f800825cac9e3d9ed03fc18ae553c25b8059513000c59e354fe` | `data/more_mob_heads/loot_table/entities/parrot.json` | `a34d1cb0fa40139999b4c5b480e4f793c8baff20` |
| `parrot` | `cyan` | Light Blue Parrot Head | `7268ce37be8507ed67e3d40b617e2d72f66f9d20b106efb08e6ba041f9b9ef10` | `data/more_mob_heads/loot_table/entities/parrot.json` | `a34d1cb0fa40139999b4c5b480e4f793c8baff20` |
| `parrot` | `gray` | Gray Parrot Head | `71be723aa17393d99daddc119c98b2c79c54b35debe05c7138edeb8d0256dc46` | `data/more_mob_heads/loot_table/entities/parrot.json` | `a34d1cb0fa40139999b4c5b480e4f793c8baff20` |
| `panda` | `normal` | Panda Head | `59df47e015d5c1c68d72be11bb656380fc6db533aab38941a91b1d3d5e396497` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `panda` | `lazy` | Lazy Panda Head | `587f1f5db2e24df4daaed4685d6aee5deb7cdd029630f0079c1f8e1f9741acfd` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `panda` | `worried` | Worried Panda Head | `fb86fd1bf8cbce23bc08fb90691717611addc85ab823b7714aec98a5660eff15` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `panda` | `playful` | Playful Panda Head | `8cadd4bf3c4cace916680e1fef90b5d16ad6643951725668ba6b4996b69ca140` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `panda` | `brown` | Brown Panda Head | `1d5f6d6126728671b44c1c775f99617424e33611b5d31ad2acff2804eb96eb06` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `panda` | `weak` | Weak Panda Head | `cc56a355fbe0e2fbd28e85c4d815ffa5d1f9d5f8798dbc259ff88c4addb202ae` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `panda` | `aggressive` | Aggressive Panda Head | `e546e436d166b17f0521bd8538ea13cd6ee3b5df102eb32e3e425cb285d44063` | `data/more_mob_heads/loot_table/entities/panda.json` | `f25bc52db367017f3083cb061242470703957875` |
| `fox` | `red` | Fox Head | `d7e0043111bc57090856259155571c7906e707046df041b8b572704c451fcd82` | `data/more_mob_heads/loot_table/entities/fox.json` | `0773baf51242e5c42d0f9cc99842f537bd3b0a19` |
| `fox` | `snow` | Snow Fox Head | `41436377eb4c4b4e39fb0e1ed8899fb61ee1814a9169b8d08729ef01dc85d1ba` | `data/more_mob_heads/loot_table/entities/fox.json` | `0773baf51242e5c42d0f9cc99842f537bd3b0a19` |
| `mooshroom` | `red` | Red Mooshroom Head | `da80606e82c642f141587733e3180ae57f646442c9fffd4e5997457e34311a29` | `data/more_mob_heads/loot_table/entities/mooshroom.json` | `8dd974618d80d9fc8f68d4c7249ee23f167592a6` |
| `mooshroom` | `brown` | Brown Mooshroom Head | `7e6466302a5ab4398b4e477349808e5d9402ea3ad8fc42e2446e4bed0a5ed5e` | `data/more_mob_heads/loot_table/entities/mooshroom.json` | `8dd974618d80d9fc8f68d4c7249ee23f167592a6` |
| `villager` | `armorer` | Armorer Villager Head | `1ef627f566ac0a7828bad93e9e4b9643d99a928a13d5f977bf441e40db1336bf` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `butcher` | Butcher Villager Head | `a1bad64185e04bf1dafe3da84933d02545ea4a63221a10d0f07759179112bdc2` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `cartographer` | Cartographer Villager Head | `e3aecfbe801cf32b5d1b0b1f6680049666158678c53f4a651fc83e0df9d3738b` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `cleric` | Cleric Villager Head | `5b9e582e2f9b89d556e79c4697f706b1dd4929ecae3c07ee90bf1d5be319bf6f` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `farmer` | Farmer Villager Head | `d9272d03cda6290e4d925a7e850a745e711fe5760f6f06f93d92b8f8c739db07` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `fisherman` | Fisherman Villager Head | `d189fb4acd15d73ff2a58a88df0466ad9f4c154a2008e5c6265d5c2f07d39376` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `fletcher` | Fletcher Villager Head | `bf611f12e18ce44a57238eef1cae03cd9f730a7a45e0ec248f14ce84e9c48056` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `leatherworker` | Leatherworker Villager Head | `ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `librarian` | Librarian Villager Head | `cdcaa574babb40ee0fa83f2fd5ea20cff31ffa272fe113588ceee469682128e7` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `mason` | Mason Villager Head | `ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `nitwit` | Nitwit Villager Head | `ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `none` | Villager Head | `ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `shepherd` | Shepherd Villager Head | `2abf4e9154ac9271941c733eacc62dc9fc0a6dc1b5d67c78ca98afb5cb1be9b2` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `toolsmith` | Toolsmith Villager Head | `ae0e9591e11aaef4c2c51d9ac69514e340485defcc2c12c38cd12386c2ec6b78` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `villager` | `weaponsmith` | Weaponsmith Villager Head | `8476ffa410bbe7fa70909965a125f4a4e9a4fb1ce1b8b3c34bfb73aaffd4ce43` | `data/more_mob_heads/loot_table/entities/villager.json` | `f36a5597b4d099a978167ea5b3f434431cc2be37` |
| `zombie-villager` | `armorer` | Zombie Armorer Head | `c8679e034767d518660d9416dc5eaf319d697682ac40c886e3c2bc8dfa1de1d` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `butcher` | Zombie Butcher Head | `9cce8d6ce4124cec3e84a852e70f50293f244ddc9ee8578f7d6d8929e16bad69` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `cartographer` | Zombie Cartographer Head | `e60800b01012e963e7c20c8ba14b70a0264d146a850deffbca7bfe512f4cb23d` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `cleric` | Zombie Cleric Head | `2958578be0e12172734a78242dab14964abc85ab9b596361f7c5daf8f14a0feb` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `farmer` | Zombie Farmer Head | `f77d415f9baa4fa4b5e058f5b81bf7f003b0a2c90a4831e53a7dbc09841c5511` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `fisherman` | Zombie Fisherman Head | `6905d53fe4faeb0b315a6878c9ab81b4be52c31cd478c027f0d7ece9f6da8914` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `fletcher` | Zombie Fletcher Head | `2ea26ac0e25498adada4ecea58bb4e76da32d5ca2de307efe5e4218fb7c5ef89` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `leatherworker` | Zombie Leatherworker Head | `fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `librarian` | Zombie Librarian Head | `62211a1f409cca4249c70d20ca80399fa4844ea417458be988cc21eb4797375e` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `mason` | Zombie Mason Head | `fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `nitwit` | Zombie Nitwit Head | `fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `none` | Zombie Villager Head | `fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `shepherd` | Zombie Shepherd Head | `691391bef3a46ef267d3b7171086ba4c8d17f2a6b0f83fa2ac30efe914b7c249` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `toolsmith` | Zombie Toolsmith Head | `fb552c90f212e855d12255d5cd62ed38b9cd7e30e73f0ea779d1764330e69264` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `zombie-villager` | `weaponsmith` | Zombie Weaponsmith Head | `4370894b5cc305d87aa08c3b4b08587db68ff29e7a3ef354cad6abca50e5528b` | `data/more_mob_heads/loot_table/entities/zombie_villager.json` | `610b3eec72b8fb6f6d1d796f579f45920239833c` |
| `goat` | `normal` | Goat Head | `87473e055df6e7fd98664e9fdb63675f088106305d744024a41bb358918a142b` | `data/more_mob_heads/loot_table/entities/goat.json` | `66717150ffb1b96e35aa086f3d249344b7a4f3a1` |
| `goat` | `screaming` | Screaming Goat Head | `bda485ac23512420891a5ae1e8de989f091d848d15a9068da4720d316fc4330f` | `data/more_mob_heads/loot_table/entities/goat.json` | `66717150ffb1b96e35aa086f3d249344b7a4f3a1` |


## Adding another custom head

Any future custom-textured `HeadType` or variant appearance must include all three pieces of provenance metadata in code:

1. the texture hash,
2. the source path inside the pinned source pack, and
3. the exact Git blob SHA containing that source value.

Regression tests enforce that canonical and variant custom-head definitions cannot omit the source path or pinned blob SHA.
