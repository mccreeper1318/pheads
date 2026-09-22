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
    void allZeroZeroThreeMobTypesResolve() {
        List<EntityType> supported = List.of(
                EntityType.ALLAY,
                EntityType.ARMADILLO,
                EntityType.BAT,
                EntityType.COD,
                EntityType.DOLPHIN,
                EntityType.GLOW_SQUID,
                EntityType.IRON_GOLEM,
                EntityType.OCELOT,
                EntityType.PANDA,
                EntityType.PARROT,
                EntityType.POLAR_BEAR,
                EntityType.PUFFERFISH,
                EntityType.SALMON,
                EntityType.SKELETON_HORSE,
                EntityType.SNOW_GOLEM,
                EntityType.SQUID,
                EntityType.STRIDER,
                EntityType.TADPOLE,
                EntityType.TRADER_LLAMA,
                EntityType.TROPICAL_FISH,
                EntityType.VILLAGER,
                EntityType.WANDERING_TRADER,
                EntityType.ZOMBIE_HORSE,
                EntityType.BLAZE,
                EntityType.BOGGED,
                EntityType.BREEZE,
                EntityType.CAVE_SPIDER,
                EntityType.DROWNED,
                EntityType.ELDER_GUARDIAN,
                EntityType.ENDERMAN,
                EntityType.ENDERMITE,
                EntityType.EVOKER,
                EntityType.GHAST,
                EntityType.GUARDIAN,
                EntityType.HOGLIN,
                EntityType.HUSK,
                EntityType.ILLUSIONER,
                EntityType.MAGMA_CUBE,
                EntityType.PHANTOM,
                EntityType.PIGLIN_BRUTE,
                EntityType.PILLAGER,
                EntityType.RAVAGER,
                EntityType.SHULKER,
                EntityType.SILVERFISH,
                EntityType.SLIME,
                EntityType.SPIDER,
                EntityType.STRAY,
                EntityType.VEX,
                EntityType.VINDICATOR,
                EntityType.WARDEN,
                EntityType.WITCH,
                EntityType.WITHER,
                EntityType.ZOGLIN,
                EntityType.ZOMBIE_VILLAGER,
                EntityType.ZOMBIFIED_PIGLIN);

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
        assertFalse(
                HeadItemFactory.profileIdFor(HeadType.SHEEP)
                        .equals(HeadItemFactory.profileIdFor(HeadType.SHEEP, "red")));
    }
}
