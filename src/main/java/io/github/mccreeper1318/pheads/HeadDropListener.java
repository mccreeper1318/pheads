package io.github.mccreeper1318.pheads;

import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

final class HeadDropListener implements Listener {

    private final HeadDropConfig config;

    HeadDropListener(HeadDropConfig config) {
        this.config = config;
    }

    @EventHandler
    public void onEntityDeath(EntityDeathEvent event) {
        if (event.getEntity() instanceof Player player) {
            handlePlayerDeath(event, player);
            return;
        }

        HeadType headType = HeadType.from(event.getEntityType());
        if (headType == null) {
            return;
        }

        if (shouldDrop(config.chanceFor(headType))) {
            event.getDrops().add(new ItemStack(headType.material()));
        }
    }

    private void handlePlayerDeath(EntityDeathEvent event, Player player) {
        if (!config.playerHeadsEnabled() || !shouldDrop(config.playerHeadChance())) {
            return;
        }

        ItemStack playerHead = new ItemStack(Material.PLAYER_HEAD);
        playerHead.editMeta(SkullMeta.class, skullMeta -> skullMeta.setPlayerProfile(player.getPlayerProfile()));
        event.getDrops().add(playerHead);
    }

    private boolean shouldDrop(double chancePercent) {
        return DropChance.shouldDrop(chancePercent, ThreadLocalRandom.current().nextDouble(100.0D));
    }
}
