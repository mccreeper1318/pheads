package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Proxy;
import io.papermc.paper.world.WeatheringCopperState;
import java.util.Map;
import org.bukkit.DyeColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Cat;
import org.bukkit.entity.Chicken;
import org.bukkit.entity.CopperGolem;
import org.bukkit.entity.Cow;
import org.bukkit.entity.Panda;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Sheep;
import org.bukkit.entity.ZombieNautilus;
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
    void keyedRegistryVariantResolvesFromKilledEntity() {
        Cat.Type tabbyType = proxy(Cat.Type.class, Map.of("getKey", NamespacedKey.minecraft("tabby")));
        Cat tabbyCat = proxy(Cat.class, Map.of("getCatType", tabbyType));

        HeadVariantAppearance appearance = HeadVariantResolver.resolve(tabbyCat, HeadType.CAT);

        assertEquals("tabby", appearance.key());
        assertEquals("Tabby Cat Head", appearance.displayName());
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
    void cowPersistentVariantsResolveAllThreeAppearances() {
        assertVariant(
                proxy(Cow.class, Map.of("getVariant", Cow.Variant.COLD)),
                HeadType.COW,
                "cold",
                "Cold Cow Head");
        assertVariant(
                proxy(Cow.class, Map.of("getVariant", Cow.Variant.TEMPERATE)),
                HeadType.COW,
                "temperate",
                "Temperate Cow Head");
        assertVariant(
                proxy(Cow.class, Map.of("getVariant", Cow.Variant.WARM)),
                HeadType.COW,
                "warm",
                "Warm Cow Head");
    }

    @Test
    void pigPersistentVariantsResolveAllThreeAppearances() {
        assertVariant(
                proxy(Pig.class, Map.of("getVariant", Pig.Variant.COLD)),
                HeadType.PIG,
                "cold",
                "Cold Pig Head");
        assertVariant(
                proxy(Pig.class, Map.of("getVariant", Pig.Variant.TEMPERATE)),
                HeadType.PIG,
                "temperate",
                "Temperate Pig Head");
        assertVariant(
                proxy(Pig.class, Map.of("getVariant", Pig.Variant.WARM)),
                HeadType.PIG,
                "warm",
                "Warm Pig Head");
    }

    @Test
    void chickenPersistentVariantsResolveAllThreeAppearances() {
        assertVariant(
                proxy(Chicken.class, Map.of("getVariant", Chicken.Variant.COLD)),
                HeadType.CHICKEN,
                "cold",
                "Cold Chicken Head");
        assertVariant(
                proxy(Chicken.class, Map.of("getVariant", Chicken.Variant.TEMPERATE)),
                HeadType.CHICKEN,
                "temperate",
                "Temperate Chicken Head");
        assertVariant(
                proxy(Chicken.class, Map.of("getVariant", Chicken.Variant.WARM)),
                HeadType.CHICKEN,
                "warm",
                "Warm Chicken Head");
    }

    @Test
    void copperGolemWeatheringResolvesVisibleHeadVariant() {
        CopperGolem weathered = proxy(
                CopperGolem.class,
                Map.of("getWeatheringState", WeatheringCopperState.WEATHERED));

        HeadVariantAppearance appearance =
                HeadVariantResolver.resolve(weathered, HeadType.COPPER_GOLEM);

        assertEquals("weathered", appearance.key());
        assertEquals("Weathered Copper Golem Head", appearance.displayName());
        assertEquals(
                "d51795c439f5e2c4b08d90272127f29cb4e0b1a7d4eeb687591aa58003802a1a",
                appearance.textureHash());
    }

    @Test
    void zombieNautilusVariantResolvesTemperateAndWarmAppearances() {
        ZombieNautilus temperate = proxy(
                ZombieNautilus.class,
                Map.of("getVariant", ZombieNautilus.Variant.TEMPERATE));
        ZombieNautilus warm = proxy(
                ZombieNautilus.class,
                Map.of("getVariant", ZombieNautilus.Variant.WARM));

        assertEquals(
                "temperate",
                HeadVariantResolver.resolve(temperate, HeadType.ZOMBIE_NAUTILUS).key());
        HeadVariantAppearance warmAppearance =
                HeadVariantResolver.resolve(warm, HeadType.ZOMBIE_NAUTILUS);
        assertEquals("warm", warmAppearance.key());
        assertEquals("Coral Zombie Nautilus Shell", warmAppearance.displayName());
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
                    appearance.sourcePath().startsWith("data/more_mob_heads/loot_table/entities/")
                            || appearance.sourcePath()
                                    .equals("src/main/resources/data/more_mob_heads.json"),
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

    private static void assertVariant(
            org.bukkit.entity.Entity entity,
            HeadType headType,
            String expectedKey,
            String expectedDisplayName) {
        HeadVariantAppearance appearance = HeadVariantResolver.resolve(entity, headType);
        assertEquals(expectedKey, appearance.key());
        assertEquals(expectedDisplayName, appearance.displayName());
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
