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
    void customHeadUsesPlayerHeadAndVanillaTweaksTexture() {
        assertEquals(HeadType.PIG, HeadType.from(EntityType.PIG));
        assertEquals(Material.PLAYER_HEAD, HeadType.PIG.material());
        assertTrue(HeadType.PIG.customTextured());
        assertEquals("Pig Head", HeadType.PIG.displayName());
        assertEquals(
                "http://textures.minecraft.net/texture/41ee7681adf00067f04bf42611c97641075a44ae2b1c0381d5ac6b3246211bfe",
                HeadType.PIG.textureUrl());
        assertEquals("data/more_mob_heads/loot_table/entities/pig.json", HeadType.PIG.textureSourcePath());
        assertEquals("1d3919599e3160de5c3e2ef9c8ea211761401f54", HeadType.PIG.textureSourceBlobSha());
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
    void everyCustomHeadHasPinnedTextureProvenance() {
        for (HeadType headType : HeadType.values()) {
            if (!headType.customTextured()) {
                continue;
            }

            assertTrue(headType.textureHash().matches("[0-9a-f]+"), headType + " should have a texture hash");
            assertTrue(
                    headType.textureSourcePath().startsWith("data/more_mob_heads/loot_table/entities/"),
                    headType + " should point to a More Mob Heads source file");
            assertTrue(
                    headType.textureSourceBlobSha().matches("[0-9a-f]{40}"),
                    headType + " should pin a source blob SHA");
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
