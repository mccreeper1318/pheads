package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import com.destroystokyo.paper.profile.PlayerProfile;
import org.bukkit.Keyed;
import org.bukkit.damage.DamageSource;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.meta.SkullMeta;
import org.junit.jupiter.api.Test;

class PaperApiCompatibilityTest {

    @Test
    void skullProfileContractUsedByPHeadsIsAvailable() throws NoSuchMethodException {
        assertNotNull(SkullMeta.class.getMethod("setPlayerProfile", PlayerProfile.class));
        assertEquals(PlayerProfile.class, Player.class.getMethod("getPlayerProfile").getReturnType());
    }

    @Test
    void deathAttributionDamageSourceContractIsAvailable() throws NoSuchMethodException {
        assertEquals(DamageSource.class, EntityDeathEvent.class.getMethod("getDamageSource").getReturnType());
        assertNotNull(DamageSource.class.getMethod("getCausingEntity"));
        assertNotNull(DamageSource.class.getMethod("getDamageLocation"));
        assertNotNull(DamageSource.class.getMethod("getDamageType"));
    }

    @Test
    void keyedVariantContractIsAvailable() throws NoSuchMethodException {
        assertNotNull(Keyed.class.getMethod("getKey"));
    }
}
