package io.github.mccreeper1318.pheads;

import java.util.EnumMap;
import java.util.Map;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;

enum HeadType {
    CREEPER(EntityType.CREEPER, Material.CREEPER_HEAD, "creeper"),
    ZOMBIE(EntityType.ZOMBIE, Material.ZOMBIE_HEAD, "zombie"),
    SKELETON(EntityType.SKELETON, Material.SKELETON_SKULL, "skeleton"),
    WITHER_SKELETON(EntityType.WITHER_SKELETON, Material.WITHER_SKELETON_SKULL, "wither-skeleton"),
    PIGLIN(EntityType.PIGLIN, Material.PIGLIN_HEAD, "piglin"),
    ENDER_DRAGON(EntityType.ENDER_DRAGON, Material.DRAGON_HEAD, "ender-dragon");

    private static final Map<EntityType, HeadType> BY_ENTITY_TYPE = new EnumMap<>(EntityType.class);

    static {
        for (HeadType headType : values()) {
            BY_ENTITY_TYPE.put(headType.entityType, headType);
        }
    }

    private final EntityType entityType;
    private final Material material;
    private final String configKey;

    HeadType(EntityType entityType, Material material, String configKey) {
        this.entityType = entityType;
        this.material = material;
        this.configKey = configKey;
    }

    Material material() {
        return material;
    }

    String configKey() {
        return configKey;
    }

    static HeadType from(EntityType entityType) {
        return BY_ENTITY_TYPE.get(entityType);
    }
}
