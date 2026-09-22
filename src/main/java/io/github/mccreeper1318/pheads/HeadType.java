package io.github.mccreeper1318.pheads;

import java.util.EnumMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

enum HeadType {

    CREEPER(EntityType.CREEPER, Material.CREEPER_HEAD, "creeper", "Creeper Head", true, 2.5D),
    ZOMBIE(EntityType.ZOMBIE, Material.ZOMBIE_HEAD, "zombie", "Zombie Head", true, 2.5D),
    SKELETON(EntityType.SKELETON, Material.SKELETON_SKULL, "skeleton", "Skeleton Skull", true, 2.5D),
    WITHER_SKELETON(EntityType.WITHER_SKELETON, Material.WITHER_SKELETON_SKULL, "wither-skeleton", "Wither Skeleton Skull", true, 2.5D),
    PIGLIN(EntityType.PIGLIN, Material.PIGLIN_HEAD, "piglin", "Piglin Head", true, 2.5D),
    ENDER_DRAGON(EntityType.ENDER_DRAGON, Material.DRAGON_HEAD, "ender-dragon", "Dragon Head", true, 100.0D),

    PIG(EntityType.PIG, "pig", "Pig Head", "41ee7681adf00067f04bf42611c97641075a44ae2b1c0381d5ac6b3246211bfe", "data/more_mob_heads/loot_table/entities/pig.json", "1d3919599e3160de5c3e2ef9c8ea211761401f54", 2.5D),
    COW(EntityType.COW, "cow", "Cow Head", "63d621100fea5883922e78bb448056448c983e3f97841948a2da747d6b08b8ab", "data/more_mob_heads/loot_table/entities/cow.json", "ce8cc1f549a5a96b3a98d9fafa4cba19462b862a", 2.5D),
    MOOSHROOM(EntityType.MOOSHROOM, "mooshroom", "Mooshroom Head", "da80606e82c642f141587733e3180ae57f646442c9fffd4e5997457e34311a29", "data/more_mob_heads/loot_table/entities/mooshroom.json", "8dd974618d80d9fc8f68d4c7249ee23f167592a6", 2.5D),
    SHEEP(EntityType.SHEEP, "sheep", "Sheep Head", "6dfe7cc46d749b153261c1dc11abbf2a3108ea1ba0b2650280eed1592dcfc75b", "data/more_mob_heads/loot_table/entities/sheep/white.json", "89e50cc3911c85affc37a20a5d549e3f3bc2cb30", 2.5D),
    CHICKEN(EntityType.CHICKEN, "chicken", "Chicken Head", "42af6e5847eea099e1b0ab8c20a9e5f3c7190158bda54e28133d9b271ec0cb4b", "data/more_mob_heads/loot_table/entities/chicken.json", "3c205ed9f210e69140ed6f068a0f0f53a36803bd", 2.5D),
    RABBIT(EntityType.RABBIT, "rabbit", "Rabbit Head", "cfd4f86cf7473fbae93b1e090489b64c0be126c7bb16ffc88c002447d5c72795", "data/more_mob_heads/loot_table/entities/rabbit.json", "a6883596a540aeaf8dd66567c588bb33b2f4a6d3", 2.5D),
    HORSE(EntityType.HORSE, "horse", "Horse Head", "6771800770cb4e814a3d91186fcd795ec82e06102ff7c1ee4e5c380102a0c70f", "data/more_mob_heads/loot_table/entities/horse.json", "ff98d1267c4d5dd4721c32377ffbb2efd42d6893", 2.5D),
    DONKEY(EntityType.DONKEY, "donkey", "Donkey Head", "4e25ee9273ad579d44bf406f6f6295586481ea198fd572076cd0c5882da7e6cc", "data/more_mob_heads/loot_table/entities/donkey.json", "125e00503e54c5da4ae7930058908cb3c3f325ff", 2.5D),
    MULE(EntityType.MULE, "mule", "Mule Head", "41c224a1031be434d25ae1885bf4ff400c9894c69bfef56a49354c5625c0c09c", "data/more_mob_heads/loot_table/entities/mule.json", "fd16404d89d9db8e6100a0fbfa8d77225e30a737", 2.5D),
    GOAT(EntityType.GOAT, "goat", "Goat Head", "87473e055df6e7fd98664e9fdb63675f088106305d744024a41bb358918a142b", "data/more_mob_heads/loot_table/entities/goat.json", "66717150ffb1b96e35aa086f3d249344b7a4f3a1", 2.5D),
    LLAMA(EntityType.LLAMA, "llama", "Llama Head", "80277e6b3d9f7819efc7da4b42745f7ab9a63ba8f36d6b84a7a250c6d1a358eb", "data/more_mob_heads/loot_table/entities/llama.json", "18cca29d28aeeb2b6a8b6377c288e14cd16a8f3e", 2.5D),
    CAMEL(EntityType.CAMEL, "camel", "Camel Head", "e67d4597340166e1978a668a06bf5755c17b4cb5b40ab8ff244093b6b8bc75d3", "data/more_mob_heads/loot_table/entities/camel.json", "44fec07b507956e566c1ea4df977ce0021de9d7b", 2.5D),
    CAT(EntityType.CAT, "cat", "Cat Head", "de28d30db3f8c3fe50ca4f26f3075e36f003ae8028135a8cd692f24c9a98ae1b", "data/more_mob_heads/loot_table/entities/cat.json", "809a57fe9a7bf14e7000ee8b0065d2946faecab2", 2.5D),
    WOLF(EntityType.WOLF, "wolf", "Wolf Head", "1ee33c2dc07d76b4f03e66427a08cba2e8179d075ae64b9ce150aa4209c5af39", "data/more_mob_heads/loot_table/entities/wolf.json", "3f0fd63d4c4d2051ee77986177dd2cdc78f7d183", 2.5D),
    FOX(EntityType.FOX, "fox", "Fox Head", "d7e0043111bc57090856259155571c7906e707046df041b8b572704c451fcd82", "data/more_mob_heads/loot_table/entities/fox.json", "0773baf51242e5c42d0f9cc99842f537bd3b0a19", 2.5D),
    BEE(EntityType.BEE, "bee", "Bee Head", "59ac16f296b461d05ea0785d477033e527358b4f30c266aa02f020157ffca736", "data/more_mob_heads/loot_table/entities/bee.json", "dee330e6afac2791a0cb94be65522ae61eff6069", 2.5D),
    TURTLE(EntityType.TURTLE, "turtle", "Turtle Head", "304931200ad460b650a190e8d41227c3999fbeb933b51ca49fd9e5920d1f8e7d", "data/more_mob_heads/loot_table/entities/turtle.json", "ae2b9be05a22db78fa9b0a227fbdabc99ae91e95", 2.5D),
    FROG(EntityType.FROG, "frog", "Frog Head", "a50d1073d41f193405d95b1d941f9fe1a7ff080e38155d7bb780bbbd8e86f70d", "data/more_mob_heads/loot_table/entities/frog.json", "9b073aa1371564190d2fcad06877875a47f516a6", 2.5D),
    AXOLOTL(EntityType.AXOLOTL, "axolotl", "Axolotl Head", "667e15eab73064b6680d1db98ba445ed0914ba35a799997c0da2b03ffc3a8826", "data/more_mob_heads/loot_table/entities/axolotl.json", "a34b7cbe11e50b603ed75a05d92f08ffa7960e53", 2.5D),
    SNIFFER(EntityType.SNIFFER, "sniffer", "Sniffer Head", "c84a7e7fe197b7e7419b51d46cc233551b9ec899de1afe7f653e4f8fb26a686e", "data/more_mob_heads/loot_table/entities/sniffer.json", "d89ae3a499e67fabe8f459f820ac76e1b5d2fdaf", 2.5D),

    ALLAY(EntityType.ALLAY, "allay", "Allay Head", "cc0389177dbaa92f0d5ffdf848862c7f9b36df222fbfd737e2639dc3059e0cf3", "data/more_mob_heads/loot_table/entities/allay.json", "6b5cf940079cb5f84b1e93d65e108f4e8e82183f", 2.5D),
    ARMADILLO(EntityType.ARMADILLO, "armadillo", "Armadillo Head", "6607ae7a701767336c06b0c4ffa81dff2cfd8bc070d95714a6badf0efb7263e1", "data/more_mob_heads/loot_table/entities/armadillo.json", "a279a103eaada394e4b2aad3e51e2ceed0bddd75", 2.5D),
    BAT(EntityType.BAT, "bat", "Bat Head", "3eb588dcd0bb57ce6ddab8e3afb6fd4330064eaac01b61a8e9769f0476f52f50", "data/more_mob_heads/loot_table/entities/bat.json", "c5553c29473c20bfa9a9d610db6c4773275754ea", 2.5D),
    COD(EntityType.COD, "cod", "Cod Head", "f246e19b32cf784549447e07b96072e1f656d78e93ccca5637485e6749734652", "data/more_mob_heads/loot_table/entities/cod.json", "7a1c3f50b6adfc9f270470f04bb01a5d44c02a33", 2.5D),
    DOLPHIN(EntityType.DOLPHIN, "dolphin", "Dolphin Head", "8e9688b950d880b55b7aa2cfcd76e5a0fa94aac6d16f78e833f7443ea29fed3", "data/more_mob_heads/loot_table/entities/dolphin.json", "c981c9b14bdc380a381d64b0f34aaba4261ece1f", 2.5D),
    GLOW_SQUID(EntityType.GLOW_SQUID, "glow-squid", "Glow Squid Head", "4b2e9b6581fed48a99e0323091ad5c3c326cda20073e28a902a0373f7382b59f", "data/more_mob_heads/loot_table/entities/glow_squid.json", "4b2b88b1a18f2c218b7d98127595bf9afb341a7c", 2.5D),
    IRON_GOLEM(EntityType.IRON_GOLEM, "iron-golem", "Iron Golem Head", "fe7c0719fabe116dce605199bcadc69a538860864ef15706983ff662822d9fe3", "data/more_mob_heads/loot_table/entities/iron_golem.json", "96ce2650bde383745084986eee3f2e41ab00b453", 2.5D),
    OCELOT(EntityType.OCELOT, "ocelot", "Ocelot Head", "9175cc43ea8ae20168a1f170810b4da4d9b4ebd3c9976e9fc22e9f995c3cbc3c", "data/more_mob_heads/loot_table/entities/ocelot.json", "0ba2dcd4471d625268135b6412f24f13fb08a8cf", 2.5D),
    PANDA(EntityType.PANDA, "panda", "Panda Head", "e546e436d166b17f0521bd8538ea13cd6ee3b5df102eb32e3e425cb285d44063", "data/more_mob_heads/loot_table/entities/panda.json", "f25bc52db367017f3083cb061242470703957875", 2.5D),
    PARROT(EntityType.PARROT, "parrot", "Parrot Head", "40a3d47f54e71a58bf8f57c5253fb2d213f4f55bb7934a19104bfb94edc76eaa", "data/more_mob_heads/loot_table/entities/parrot.json", "a34d1cb0fa40139999b4c5b480e4f793c8baff20", 2.5D),
    POLAR_BEAR(EntityType.POLAR_BEAR, "polar-bear", "Polar Bear Head", "cd8702911e616c0d32fbe778d195f21ecce9025bcbd09151e3d97af3192aa7ec", "data/more_mob_heads/loot_table/entities/polar_bear.json", "fd701ef0c044aaf62f39d7afa40e154972fc4b27", 2.5D),
    PUFFERFISH(EntityType.PUFFERFISH, "pufferfish", "Pufferfish Head", "e2733d5da59c82eaf310b382aff40bd513c44354dbbabfe14b066a556810a7f9", "data/more_mob_heads/loot_table/entities/pufferfish.json", "3b4573da12ace705e24f98c88fea987d008097e1", 2.5D),
    SALMON(EntityType.SALMON, "salmon", "Salmon Head", "791d9e69b795da4eaacfcf7350dfe8ae367fed833556706e040339dd7fe0240a", "data/more_mob_heads/loot_table/entities/salmon.json", "9fd103261c460d1c028e97dd714a68c6dea71902", 2.5D),
    SKELETON_HORSE(EntityType.SKELETON_HORSE, "skeleton-horse", "Skeleton Horse Head", "6e226705bd2a9e7bb8d6b0f4daa969b9e12d4ae5c66da693bb5f4a4a1e6aa296", "data/more_mob_heads/loot_table/entities/skeleton_horse.json", "983bbd71c2b23ddad70ea9785b5a91e178f2afa7", 2.5D),
    SNOW_GOLEM(EntityType.SNOW_GOLEM, "snow-golem", "Snow Golem Head", "caa3e17ef1b29a4b87fa43dee1db12c41fd39aa387fa13af2a079b5b378fde8b", "data/more_mob_heads/loot_table/entities/snow_golem.json", "898cc9064a233b0b9678eac2e90d96fae04c7ce0", 2.5D),
    SQUID(EntityType.SQUID, "squid", "Squid Head", "8351b7d9a4f36cfe31fd59d8c900e419a135144105e7a981caa5a168dcff325b", "data/more_mob_heads/loot_table/entities/squid.json", "4e09b5d7b5979d0e68128ba48b5cdc1454ad5456", 2.5D),
    STRIDER(EntityType.STRIDER, "strider", "Strider Head", "9c40fad1c11de9e6422b405426e9b97907f35bce345e3758604d3e7be7df884", "data/more_mob_heads/loot_table/entities/strider.json", "52bccfdfa22fb9b0979bc3d8c71d47fc1494f721", 2.5D),
    TADPOLE(EntityType.TADPOLE, "tadpole", "Tadpole Head", "3daf1653b5f59b5ec5a3f79609cb4233579fef07e693b61749e0900149edf563", "data/more_mob_heads/loot_table/entities/tadpole.json", "1b28237596845dac681d6e3a2c1bb67a79470341", 2.5D),
    TRADER_LLAMA(EntityType.TRADER_LLAMA, "trader-llama", "Trader Llama Head", "e89a2eb17705fe7154ab041e5c76a08d41546a31ba20ea3060e3ec8edc10412c", "data/more_mob_heads/loot_table/entities/trader_llama.json", "50df37f55ceaadeb9581546b0173af99e79fe056", 2.5D),
    TROPICAL_FISH(EntityType.TROPICAL_FISH, "tropical-fish", "Tropical Fish Head", "34a0c84dc3c090df7bafc4367a9fc6c8520da2f73efffb80e934d1189eadac41", "data/more_mob_heads/loot_table/entities/tropical_fish.json", "9db46755a8b2c2e75225963f6a708b6287329fb0", 2.5D),
    VILLAGER(EntityType.VILLAGER, "villager", "Villager Head", "1ef627f566ac0a7828bad93e9e4b9643d99a928a13d5f977bf441e40db1336bf", "data/more_mob_heads/loot_table/entities/villager.json", "f36a5597b4d099a978167ea5b3f434431cc2be37", 2.5D),
    WANDERING_TRADER(EntityType.WANDERING_TRADER, "wandering-trader", "Wandering Trader Head", "5f1379a82290d7abe1efaabbc70710ff2ec02dd34ade386bc00c930c461cf932", "data/more_mob_heads/loot_table/entities/wandering_trader.json", "40f379c8fcb8b50e63261151d867f78978d23da4", 2.5D),
    ZOMBIE_HORSE(EntityType.ZOMBIE_HORSE, "zombie-horse", "Zombie Horse Head", "6618ffbe1cfa2058fe80a065f70c128c225a1e0bc9deaf8b38b0395443f40909", "data/more_mob_heads/loot_table/entities/zombie_horse.json", "f9812636db03af392de93648e06a76ad68b0a376", 2.5D),
    BLAZE(EntityType.BLAZE, "blaze", "Blaze Head", "dee23dc7a10c6a87ef937454c0e94ed42c23aa641a91ed8470a3042d05c52c52", "data/more_mob_heads/loot_table/entities/blaze.json", "3bd819ccf7423e8b69c9cb7c2054b5af524c20df", 2.5D),
    BOGGED(EntityType.BOGGED, "bogged", "Bogged Head", "4f807a187077f836b93820b32d8d8341d4d32cd4c8c1115cf1da6374e0fbd3ff", "data/more_mob_heads/loot_table/entities/bogged.json", "1eb4db4663cd58e2a27db7107761acdf8f47ee2a", 2.5D),
    BREEZE(EntityType.BREEZE, "breeze", "Breeze Head", "a275728af7e6a29c88125b675a39d88ae9919bb61fdc200337fed6ab0c49d65c", "data/more_mob_heads/loot_table/entities/breeze.json", "dfde472a984d5add62f577b091c4c9deee51f304", 2.5D),
    CAVE_SPIDER(EntityType.CAVE_SPIDER, "cave-spider", "Cave Spider Head", "a6a1c2599fc91203a65a03d479c8dc87f662deac3663c16c5e04d625b3978a25", "data/more_mob_heads/loot_table/entities/cave_spider.json", "d94102ab7e1f9b8dd2b8ee164845d17587861ee5", 2.5D),
    DROWNED(EntityType.DROWNED, "drowned", "Drowned Head", "c3f7ccf61dbc3f9fe9a6333cde0c0e14399eb2eea71d34cf223b3ace22051", "data/more_mob_heads/loot_table/entities/drowned.json", "df20f792dae3fa18d959c753e7c0c062e4243145", 2.5D),
    ELDER_GUARDIAN(EntityType.ELDER_GUARDIAN, "elder-guardian", "Elder Guardian Head", "4a2d64f4a00e9c85f67262edcacb84523581ae0f37bdab22dd704524f62e169f", "data/more_mob_heads/loot_table/entities/elder_guardian.json", "45b9f3edaf5df8bb5f731994dcada75861d7d756", 2.5D),
    ENDERMAN(EntityType.ENDERMAN, "enderman", "Enderman Head", "8977a94f02498cad0cfdb65ca7cb72e23111a914d8c670acccc7a65b347d7776", "data/more_mob_heads/loot_table/entities/enderman.json", "eca0e0b1af97c129a78dec92fcb188ecae092ad9", 2.5D),
    ENDERMITE(EntityType.ENDERMITE, "endermite", "Endermite Head", "8c6b65c22b4465ba6793b2195cd5084ce83b88dca6e55eb9484540acd7352a50", "data/more_mob_heads/loot_table/entities/endermite.json", "ae3c8abf1668f0265fcee8f225ce03e6fbef52fe", 2.5D),
    EVOKER(EntityType.EVOKER, "evoker", "Evoker Head", "390fbd88f659d3963c68cbbcb7c7121d8195a8be65bbd2bf1257d1f69bccc0c7", "data/more_mob_heads/loot_table/entities/evoker.json", "1bc187d4f7355db22149ef8239521865fe94f4b1", 2.5D),
    GHAST(EntityType.GHAST, "ghast", "Ghast Head", "c53de31a2d0041a6ef75bf7a6c8468464db1aaa6201ebb1a6013edb2245c7607", "data/more_mob_heads/loot_table/entities/ghast.json", "ba3748728de5010afcbc88f9f2ba4343d4c36b98", 2.5D),
    GUARDIAN(EntityType.GUARDIAN, "guardian", "Guardian Head", "e2ba34416670454b1a20496f80b9398529f49003fc613eb930248ea9b5d1a391", "data/more_mob_heads/loot_table/entities/guardian.json", "1b2149c49a313d4b96ab6e9bcc2dcb5893f59a59", 2.5D),
    HOGLIN(EntityType.HOGLIN, "hoglin", "Hoglin Head", "bc4a7f57fc03b13aa2f9d83cdd4822b936793096daf51e78025bbd241ed6f68d", "data/more_mob_heads/loot_table/entities/hoglin.json", "4d4cb0b1339fed3ee3c115a24825cd6176cefd47", 2.5D),
    HUSK(EntityType.HUSK, "husk", "Husk Head", "7338318bc91a36cd5ab6aa885c9a4ee2bdacdaa5c66b2a99dfb0a560983f2480", "data/more_mob_heads/loot_table/entities/husk.json", "ee800303b3a919c6346aa649794595a9db0b75b8", 2.5D),
    ILLUSIONER(EntityType.ILLUSIONER, "illusioner", "Illusioner Head", "d382701c67d6c54c907558891dc176225112518771e061c5d8bd918479e6bdd8", "data/more_mob_heads/loot_table/entities/illusioner.json", "84001ad09e097e7d3e8c6c1b46a9fa3ea2243b4a", 2.5D),
    MAGMA_CUBE(EntityType.MAGMA_CUBE, "magma-cube", "Magma Cube Head", "b81718d4984847a4ad3ec081a4ebffd183743239aecab60322138a72609812c3", "data/more_mob_heads/loot_table/entities/magma_cube.json", "8e26b803b9cab6375451d4b243357db84f150194", 2.5D),
    PHANTOM(EntityType.PHANTOM, "phantom", "Phantom Head", "7e95153ec23284b283f00d19d29756f244313a061b70ac03b97d236ee57bd982", "data/more_mob_heads/loot_table/entities/phantom.json", "37320ecd1cdd281482fef5f0f1bf343797647c5d", 2.5D),
    PIGLIN_BRUTE(EntityType.PIGLIN_BRUTE, "piglin-brute", "Piglin Brute Head", "6488799c83ecb29452ceba89c3c0099219274ce5b2bfb8ad0b3ea4c65fac4630", "data/more_mob_heads/loot_table/entities/piglin_brute.json", "ede7bfe72bea706bb43fcaaf96f8e0f0c1da1627", 2.5D),
    PILLAGER(EntityType.PILLAGER, "pillager", "Pillager Head", "c225f0b49c5295048a409c9c601cca79aa8eb52aff5e2033ebb865f4367ef43e", "data/more_mob_heads/loot_table/entities/pillager.json", "c7eb5262bd6189e6b504615dcd0c212644391ab0", 2.5D),
    RAVAGER(EntityType.RAVAGER, "ravager", "Ravager Head", "eb4db2986140e251e32e70ed08c8a081720313ce257632be1ef94a0737394db", "data/more_mob_heads/loot_table/entities/ravager.json", "60b25df199d7f6a25169e1758fa1f196ecf54901", 2.5D),
    SHULKER(EntityType.SHULKER, "shulker", "Shulker Head", "fb9e6af6b819f3d90e67ce2e7059fbef31da2aa953d35e3454f1021fa912efde", "data/more_mob_heads/loot_table/entities/shulker.json", "317d346a1a0620797cc078604c8a425f220902ec", 2.5D),
    SILVERFISH(EntityType.SILVERFISH, "silverfish", "Silverfish Head", "f25e9fae371664de1a800c84d025124abb8f15111807c8bc1ab9126aacbd4f95", "data/more_mob_heads/loot_table/entities/silverfish.json", "e96fbaff36c3d4cf8a87813f39f0aac918e650d9", 2.5D),
    SLIME(EntityType.SLIME, "slime", "Slime Head", "c06424ec7a196b15f9ad5733a36a6d1f2e6a0d42ffce1e1508f90f312ac4caed", "data/more_mob_heads/loot_table/entities/slime.json", "7a5eb77655cb05ded4d07aa16ea8f7a67737a4bd", 2.5D),
    SPIDER(EntityType.SPIDER, "spider", "Spider Head", "de28e6629b6ed1da94d4a818761612c36fb3a6813c4b63fb9fea5076415f3f0c", "data/more_mob_heads/loot_table/entities/spider.json", "82238f36b5e618bcfa311c89fcf0ea232321701f", 2.5D),
    STRAY(EntityType.STRAY, "stray", "Stray Head", "592b5597085e35db53d9bda008cae72b2f00cd7d4cd8dc69ff174a55b689e6e", "data/more_mob_heads/loot_table/entities/stray.json", "8cb3d3c6f577e5a1d0a9526d263a81a11be8604a", 2.5D),
    VEX(EntityType.VEX, "vex", "Vex Head", "b9538f2830c4dea6996ed744785504e32e0e20d8663edab6b0222f2c022077bd", "data/more_mob_heads/loot_table/entities/vex.json", "3ade8dbbcac3b61e1aeac683de33ed3c2789df18", 2.5D),
    VINDICATOR(EntityType.VINDICATOR, "vindicator", "Vindicator Head", "2dabafde27ee12b09865047aff6f183fdb64e04dae1c00ccbde04ad93dcc6c95", "data/more_mob_heads/loot_table/entities/vindicator.json", "158616ece06af88495abd716baec44c81a59281d", 2.5D),
    WARDEN(EntityType.WARDEN, "warden", "Warden Head", "b2f3879b737127485eb35ddee748d06cf914b193d97753ae34e92230842831fb", "data/more_mob_heads/loot_table/entities/warden.json", "56d79e1d128242baa54b0635088517492b2c0f4a", 2.5D),
    WITCH(EntityType.WITCH, "witch", "Witch Head", "a520f12c63c7912186c4be4e30c33c5acaec0db0b6abd836d517d74a62275d4b", "data/more_mob_heads/loot_table/entities/witch.json", "bfc8ae9c723e9b254a826c9ee5f4a17374e35ce3", 2.5D),
    WITHER(EntityType.WITHER, "wither", "Wither Head", "eda10828f63b7ecdefd767b3245fbdaa13c3ec0c6b13774f1ee8d307c034c383", "data/more_mob_heads/loot_table/entities/wither.json", "0ffde2c41efa7764398f590c7635bb44b3e66afd", 2.5D),
    ZOGLIN(EntityType.ZOGLIN, "zoglin", "Zoglin Head", "2e3493a956bfd7588ed1a8ea858759667659d58100cbecd6d96ccc0ca9b36923", "data/more_mob_heads/loot_table/entities/zoglin.json", "077390588b0e12fdd9f10c5d8ed812e15791036c", 2.5D),
    ZOMBIE_VILLAGER(EntityType.ZOMBIE_VILLAGER, "zombie-villager", "Zombie Villager Head", "c8679e034767d518660d9416dc5eaf319d697682ac40c886e3c2bc8dfa1de1d", "data/more_mob_heads/loot_table/entities/zombie_villager.json", "610b3eec72b8fb6f6d1d796f579f45920239833c", 2.5D),
    ZOMBIFIED_PIGLIN(EntityType.ZOMBIFIED_PIGLIN, "zombified-piglin", "Zombified Piglin Head", "2df03128b002a70708d6825ed6cf54ddf694b3766d78d5649030b1cb8b34c6fa", "data/more_mob_heads/loot_table/entities/zombified_piglin.json", "19153ca18e54f3c480630b83c0e80a59ddac9b92", 2.5D);

    private static final String TEXTURE_BASE_URL = "http://textures.minecraft.net/texture/";
    private static final Map<EntityType, HeadType> BY_ENTITY_TYPE = new EnumMap<>(EntityType.class);

    static {
        for (HeadType headType : values()) {
            BY_ENTITY_TYPE.put(headType.entityType, headType);
        }
    }

    private final EntityType entityType;
    private final Material material;
    private final String configKey;
    private final String displayName;
    private final String textureHash;
    private final String textureSourcePath;
    private final String textureSourceBlobSha;
    private final boolean requiredInConfig;
    private final double defaultChance;

    HeadType(
            EntityType entityType,
            Material material,
            String configKey,
            String displayName,
            boolean requiredInConfig,
            double defaultChance) {
        this(entityType, material, configKey, displayName, null, null, null, requiredInConfig, defaultChance);
    }

    HeadType(
            EntityType entityType,
            String configKey,
            String displayName,
            String textureHash,
            String textureSourcePath,
            String textureSourceBlobSha,
            double defaultChance) {
        this(
                entityType,
                Material.PLAYER_HEAD,
                configKey,
                displayName,
                textureHash,
                textureSourcePath,
                textureSourceBlobSha,
                false,
                defaultChance);
    }

    private HeadType(
            EntityType entityType,
            Material material,
            String configKey,
            String displayName,
            String textureHash,
            String textureSourcePath,
            String textureSourceBlobSha,
            boolean requiredInConfig,
            double defaultChance) {
        this.entityType = entityType;
        this.material = material;
        this.configKey = configKey;
        this.displayName = displayName;
        this.textureHash = textureHash;
        this.textureSourcePath = textureSourcePath;
        this.textureSourceBlobSha = textureSourceBlobSha;
        this.requiredInConfig = requiredInConfig;
        this.defaultChance = defaultChance;
    }

    Material material() {
        return material;
    }

    String configKey() {
        return configKey;
    }

    String displayName() {
        return displayName;
    }

    boolean customTextured() {
        return textureHash != null;
    }

    String textureHash() {
        if (textureHash == null) {
            throw new IllegalStateException(configKey + " uses a native Minecraft head item.");
        }
        return textureHash;
    }

    String textureUrl() {
        return TEXTURE_BASE_URL + textureHash();
    }

    String textureSourcePath() {
        if (!customTextured()) {
            throw new IllegalStateException(configKey + " uses a native Minecraft head item.");
        }
        return textureSourcePath;
    }

    String textureSourceBlobSha() {
        if (!customTextured()) {
            throw new IllegalStateException(configKey + " uses a native Minecraft head item.");
        }
        return textureSourceBlobSha;
    }

    boolean requiredInConfig() {
        return requiredInConfig;
    }

    double defaultChance() {
        return defaultChance;
    }

    static HeadType from(EntityType entityType) {
        return BY_ENTITY_TYPE.get(entityType);
    }
}
