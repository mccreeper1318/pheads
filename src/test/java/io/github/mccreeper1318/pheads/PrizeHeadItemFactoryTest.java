package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.persistence.PersistentDataType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;

class PrizeHeadItemFactoryTest {

    @BeforeEach
    void setUp() {
        MockBukkit.mock();
    }

    @AfterEach
    void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void createsNativePrizeHeadWithPresentationAndMetadata() {
        ItemStack item = HeadItemFactory.createPrize(HeadType.CREEPER);

        assertEquals(Material.CREEPER_HEAD, item.getType());
        assertPrizeMetadata(item, "creeper");
        assertTrue(item.getItemMeta().hasEnchantmentGlintOverride());
        assertTrue(item.getItemMeta().getEnchantmentGlintOverride());
    }

    @Test
    void createsCustomTexturedPrizeHeadWithPresentationAndMetadata() {
        ItemStack item = HeadItemFactory.createPrize(HeadType.PIG);

        assertEquals(Material.PLAYER_HEAD, item.getType());
        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
        assertNotNull(skullMeta.getPlayerProfile());
        assertPrizeMetadata(item, "pig");
        assertTrue(skullMeta.hasEnchantmentGlintOverride());
        assertTrue(skullMeta.getEnchantmentGlintOverride());
    }

    private static void assertPrizeMetadata(ItemStack item, String mobKey) {
        var data = item.getItemMeta().getPersistentDataContainer();
        assertEquals(
                (byte) 1,
                data.get(
                        NamespacedKey.fromString("pheads:special_head"),
                        PersistentDataType.BYTE));
        assertEquals(
                mobKey,
                data.get(
                        NamespacedKey.fromString("pheads:mob"),
                        PersistentDataType.STRING));
        assertEquals(
                "prize",
                data.get(
                        NamespacedKey.fromString("pheads:tier"),
                        PersistentDataType.STRING));
        assertNotNull(item.getItemMeta().lore());
    }
}
