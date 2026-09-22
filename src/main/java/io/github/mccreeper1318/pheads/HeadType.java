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
    SNIFFER(EntityType.SNIFFER, "sniffer", "Sniffer Head", "c84a7e7fe197b7e7419b51d46cc233551b9ec899de1afe7f653e4f8fb26a686e", "data/more_mob_heads/loot_table/entities/sniffer.json", "d89ae3a499e67fabe8f459f820ac76e1b5d2fdaf", 2.5D);

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
