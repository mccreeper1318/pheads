package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.junit.jupiter.api.Test;

class HeadTypeTest {

    @Test
    void nativeHeadUsesNativeMinecraftItem() {
        assertEquals(HeadType.CREEPER, HeadType.from(EntityType.CREEPER));
        assertEquals(Material.CREEPER_HEAD, HeadType.CREEPER.material());
        assertFalse(HeadType.CREEPER.customTextured());
    }

    @Test
    void customHeadUsesPlayerHeadAndBundledTexture() {
        assertEquals(HeadType.PIG, HeadType.from(EntityType.PIG));
        assertEquals(Material.PLAYER_HEAD, HeadType.PIG.material());
        assertTrue(HeadType.PIG.customTextured());
        assertEquals("Pig Head", HeadType.PIG.displayName());
        assertEquals(
                "http://textures.minecraft.net/texture/621668ef7cb79dd9c22ce3d1f3f4cb6e2559893b6df4a469514e667c16aa4",
                HeadType.PIG.textureUrl());
    }

    @Test
    void allInitialPassiveMobTypesResolve() {
        List<EntityType> supported = List.of(
                EntityType.PIG,
                EntityType.COW,
                EntityType.MOOSHROOM,
                EntityType.SHEEP,
                EntityType.CHICKEN,
                EntityType.RABBIT,
                EntityType.HORSE,
                EntityType.DONKEY,
                EntityType.MULE,
                EntityType.GOAT,
                EntityType.LLAMA,
                EntityType.CAMEL,
                EntityType.CAT,
                EntityType.WOLF,
                EntityType.FOX,
                EntityType.BEE,
                EntityType.TURTLE,
                EntityType.FROG,
                EntityType.AXOLOTL,
                EntityType.SNIFFER);

        for (EntityType entityType : supported) {
            HeadType headType = HeadType.from(entityType);
            assertNotNull(headType, entityType + " should have a head definition");
            assertTrue(headType.customTextured(), entityType + " should use the custom-textured path");
            assertEquals(Material.PLAYER_HEAD, headType.material());
        }
    }

    @Test
    void customHeadProfilesUseStableIds() {
        assertEquals(
                HeadItemFactory.profileIdFor(HeadType.PIG),
                HeadItemFactory.profileIdFor(HeadType.PIG));
        assertFalse(
                HeadItemFactory.profileIdFor(HeadType.PIG)
                        .equals(HeadItemFactory.profileIdFor(HeadType.COW)));
    }
}
