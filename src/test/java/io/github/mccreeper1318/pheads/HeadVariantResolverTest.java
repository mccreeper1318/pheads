package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Proxy;
import java.util.Map;
import org.bukkit.DyeColor;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Sheep;
import org.junit.jupiter.api.Test;

class HeadVariantResolverTest {

    @Test
    void singlePropertyVariantResolvesFromKilledEntity() {
        Sheep redSheep = proxy(Sheep.class, Map.of("getColor", DyeColor.RED));

        HeadVariantAppearance appearance = HeadVariantResolver.resolve(redSheep, HeadType.SHEEP);

        assertEquals("red", appearance.key());
        assertEquals("Red Sheep Head", appearance.displayName());
        assertEquals(
                "5478e057158de6f45e2541cd17788e640ccb59723de59c254e82ab5711f3fc27",
                appearance.textureHash());
    }

    @Test
    void recessivePandaRequiresMatchingHiddenGene() {
        assertEquals(
                "brown",
                HeadVariantResolver.pandaVariantKey(Panda.Gene.BROWN, Panda.Gene.BROWN));
        assertEquals(
                "normal",
                HeadVariantResolver.pandaVariantKey(Panda.Gene.BROWN, Panda.Gene.NORMAL));
        assertEquals(
                "weak",
                HeadVariantResolver.pandaVariantKey(Panda.Gene.WEAK, Panda.Gene.WEAK));
        assertEquals(
                "aggressive",
                HeadVariantResolver.pandaVariantKey(Panda.Gene.AGGRESSIVE, Panda.Gene.NORMAL));
    }

    @Test
    void nonVariantMobHasNoAppearanceOverride() {
        assertNull(HeadVariantResolver.appearanceFor(HeadType.BLAZE, "anything"));
    }

    @Test
    void everyVariantAppearanceHasPinnedTextureProvenance() {
        assertFalse(HeadVariantResolver.allAppearances().isEmpty());

        for (HeadVariantAppearance appearance : HeadVariantResolver.allAppearances()) {
            assertFalse(appearance.key().isBlank());
            assertFalse(appearance.displayName().isBlank());
            assertTrue(appearance.textureHash().matches("[0-9a-f]+"), appearance.displayName());
            assertTrue(
                    appearance.sourcePath().startsWith("data/more_mob_heads/loot_table/entities/"),
                    appearance.displayName());
            assertTrue(
                    appearance.sourceBlobSha().matches("[0-9a-f]{40}"),
                    appearance.displayName());
        }
    }

    @Test
    void variantProfilesUseStableDistinctIds() {
        assertEquals(
                HeadItemFactory.profileIdFor(HeadType.SHEEP, "red"),
                HeadItemFactory.profileIdFor(HeadType.SHEEP, "red"));
        assertFalse(
                HeadItemFactory.profileIdFor(HeadType.SHEEP, "red")
                        .equals(HeadItemFactory.profileIdFor(HeadType.SHEEP, "blue")));
        assertFalse(
                HeadItemFactory.profileIdFor(HeadType.SHEEP)
                        .equals(HeadItemFactory.profileIdFor(HeadType.SHEEP, "white")));
    }

    @SuppressWarnings("unchecked")
    private static <T> T proxy(Class<T> type, Map<String, Object> responses) {
        return (T) Proxy.newProxyInstance(
                type.getClassLoader(),
                new Class<?>[] {type},
                (proxy, method, args) -> {
                    if (responses.containsKey(method.getName())) {
                        return responses.get(method.getName());
                    }
                    if (method.getName().equals("toString")) {
                        return type.getSimpleName() + "Proxy";
                    }
                    if (method.getReturnType() == boolean.class) {
                        return false;
                    }
                    if (method.getReturnType() == int.class) {
                        return 0;
                    }
                    if (method.getReturnType() == double.class) {
                        return 0.0D;
                    }
                    if (method.getReturnType() == float.class) {
                        return 0.0F;
                    }
                    if (method.getReturnType() == long.class) {
                        return 0L;
                    }
                    return null;
                });
    }
}
