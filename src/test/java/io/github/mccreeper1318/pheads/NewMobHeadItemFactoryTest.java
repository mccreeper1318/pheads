package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockbukkit.mockbukkit.MockBukkit;

class NewMobHeadItemFactoryTest {

    @BeforeEach
    void setUp() {
        MockBukkit.mock();
    }

    @AfterEach
    void tearDown() {
        MockBukkit.unmock();
    }

    @Test
    void createsNewCustomHeadWithPinnedProfile() {
        ItemStack item = HeadItemFactory.create(HeadType.HAPPY_GHAST);

        assertEquals(Material.PLAYER_HEAD, item.getType());
        SkullMeta skullMeta = (SkullMeta) item.getItemMeta();
        assertNotNull(skullMeta.getPlayerProfile());
        assertEquals(
                HeadItemFactory.profileIdFor(HeadType.HAPPY_GHAST),
                skullMeta.getPlayerProfile().getUniqueId());
    }
}
