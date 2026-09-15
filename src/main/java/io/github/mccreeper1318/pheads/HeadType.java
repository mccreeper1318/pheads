package io.github.mccreeper1318.pheads;

import java.util.EnumMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

enum HeadType {

    CREEPER(EntityType.CREEPER, Material.CREEPER_HEAD, "creeper", "Creeper Head", null, true, 2.5D),
    ZOMBIE(EntityType.ZOMBIE, Material.ZOMBIE_HEAD, "zombie", "Zombie Head", null, true, 2.5D),
    SKELETON(EntityType.SKELETON, Material.SKELETON_SKULL, "skeleton", "Skeleton Skull", null, true, 2.5D),
    WITHER_SKELETON(EntityType.WITHER_SKELETON, Material.WITHER_SKELETON_SKULL, "wither-skeleton", "Wither Skeleton Skull", null, true, 2.5D),
    PIGLIN(EntityType.PIGLIN, Material.PIGLIN_HEAD, "piglin", "Piglin Head", null, true, 2.5D),
    ENDER_DRAGON(EntityType.ENDER_DRAGON, Material.DRAGON_HEAD, "ender-dragon", "Dragon Head", null, true, 100.0D),
    PIG(EntityType.PIG, Material.PLAYER_HEAD, "pig", "Pig Head", "621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4", false, 2.5D),
    COW(EntityType.COW, Material.PLAYER_HEAD, "cow", "Cow Head", "5d6c6eda942f7f5f71c3161c7306f4aed307d82895f9d2b07ab4525718edc5", false, 2.5D),
    MOOSHROOM(EntityType.MOOSHROOM, Material.PLAYER_HEAD, "mooshroom", "Mooshroom Head", "d0bc61b9757a7b83e03cd2507a2157913c2cf016e7c096a4d6cf1fe1b8db", false, 2.5D),
    SHEEP(EntityType.SHEEP, Material.PLAYER_HEAD, "sheep", "Sheep Head", "6dfe7cc46d749b153261c1dc11abbf2a3108ea1ba0b2650280eed1592dcfc75b", false, 2.5D),
    CHICKEN(EntityType.CHICKEN, Material.PLAYER_HEAD, "chicken", "Chicken Head", "1638469a599ceef7207537603248a9ab11ff591fd378bea4735b346a7fae893", false, 2.5D),
    RABBIT(EntityType.RABBIT, Material.PLAYER_HEAD, "rabbit", "Rabbit Head", "5a6600680f4f5b132154e3413e29c93cf96ff2f2224ab87bee50959e0b0ee929", false, 2.5D),
    HORSE(EntityType.HORSE, Material.PLAYER_HEAD, "horse", "Horse Head", "8a5fabbcbc5481976fb938a519ead59eeee2a071df297384a8fe96788a9df5a6", false, 2.5D),
    DONKEY(EntityType.DONKEY, Material.PLAYER_HEAD, "donkey", "Donkey Head", "dfb6c3c052cf787d236a2915f8072b77c547497715d1d2f8cbc9d241d88a", false, 2.5D),
    MULE(EntityType.MULE, Material.PLAYER_HEAD, "mule", "Mule Head", "a0486a742e7dda0bae61ce2f55fa13527f1c3b334c57c034bb4cf132fb5f5f", false, 2.5D),
    GOAT(EntityType.GOAT, Material.PLAYER_HEAD, "goat", "Goat Head", "f03330398a0d833f53ae8c9a1cb393c74e9d31e18885870e86a2133d44f0c63c", false, 2.5D),
    LLAMA(EntityType.LLAMA, Material.PLAYER_HEAD, "llama", "Llama Head", "80277e6b3d9f7819efc7da4b42745f7ab9a63ba8f36d6b84a7a250c6d1a358eb", false, 2.5D),
    CAMEL(EntityType.CAMEL, Material.PLAYER_HEAD, "camel", "Camel Head", "74b8a333dfa92e7e5a95ad4ae2d84b1bafa33dc28c054925277f60e79dafc8c4", false, 2.5D),
    CAT(EntityType.CAT, Material.PLAYER_HEAD, "cat", "Cat Head", "de28d30db3f8c3fe50ca4f26f3075e36f003ae8028135a8cd692f24c9a98ae1b", false, 2.5D),
    WOLF(EntityType.WOLF, Material.PLAYER_HEAD, "wolf", "Wolf Head", "6e8c2a6e104a3e9d7397326f01bf25862f0aaf9e3830d49dbb9b4a4305358404", false, 2.5D),
    FOX(EntityType.FOX, Material.PLAYER_HEAD, "fox", "Fox Head", "fbdffe9642fc5280e68ce488e3bcf440687ed3bc566e315af824f428b6ff715", false, 2.5D),
    BEE(EntityType.BEE, Material.PLAYER_HEAD, "bee", "Bee Head", "59ac16f296b461d05ea0785d477033e527358b4f30c266aa02f020157ffca736", false, 2.5D),
    TURTLE(EntityType.TURTLE, Material.PLAYER_HEAD, "turtle", "Turtle Head", "0a4050e7aacc4539202658fdc339dd182d7e322f9fbcc4d5f99b5718a", false, 2.5D),
    FROG(EntityType.FROG, Material.PLAYER_HEAD, "frog", "Frog Head", "23ce6f9998ed2da757d1e6372f04efa20e57dfc17c3a06478657bbdf51c2f2a2", false, 2.5D),
    AXOLOTL(EntityType.AXOLOTL, Material.PLAYER_HEAD, "axolotl", "Axolotl Head", "24ad11acd293a3f3944d8de03f05e731b8f02d99ce0c2a685be705c56264761a", false, 2.5D),
    SNIFFER(EntityType.SNIFFER, Material.PLAYER_HEAD, "sniffer", "Sniffer Head", "87ad920a66e38cc3426a5bff084667e8772116915e298098567c139f222e2c42", false, 2.5D);

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
    private final boolean requiredInConfig;
    private final double defaultChance;

    HeadType(
            EntityType entityType,
            Material material,
            String configKey,
            String displayName,
            String textureHash,
            boolean requiredInConfig,
            double defaultChance) {
        this.entityType = entityType;
        this.material = material;
        this.configKey = configKey;
        this.displayName = displayName;
        this.textureHash = textureHash;
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

    String textureUrl() {
        if (textureHash == null) {
            throw new IllegalStateException(configKey + " uses a native Minecraft head item.");
        }
        return TEXTURE_BASE_URL + textureHash;
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
