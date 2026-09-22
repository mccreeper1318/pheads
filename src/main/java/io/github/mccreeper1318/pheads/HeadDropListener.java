package io.github.mccreeper1318.pheads;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Tag;
import org.bukkit.block.Block;
import org.bukkit.damage.DamageSource;
import org.bukkit.damage.DamageType;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.SkullMeta;

final class HeadDropListener implements Listener {

    private final KillAttributionTracker killAttributionTracker;
    private HeadDropConfig config;

    HeadDropListener(HeadDropConfig config) {
        this(config, new KillAttributionTracker());
    }

    HeadDropListener(HeadDropConfig config, KillAttributionTracker killAttributionTracker) {
        this.config = config;
        this.killAttributionTracker = killAttributionTracker;
    }

    void setConfig(HeadDropConfig config) {
        this.config = config;
    }

    @EventHandler(priority = EventPriority.MONITOR, ignoreCancelled = true)
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (event.getAction() != Action.RIGHT_CLICK_BLOCK || event.useInteractedBlock() == Event.Result.DENY) {
            return;
        }

        Block clickedBlock = event.getClickedBlock();
        if (clickedBlock == null || !isBadRespawnPointTrigger(clickedBlock.getType())) {
            return;
        }

        Location sourceLocation = clickedBlock.getLocation().add(0.5D, 0.5D, 0.5D);
        killAttributionTracker.recordBadRespawnPointTrigger(
                new KillAttributionTracker.DamagePoint(
                        clickedBlock.getWorld().getUID(),
                        sourceLocation.getX(),
                        sourceLocation.getY(),
                        sourceLocation.getZ()),
                event.getPlayer().getUniqueId());
    }

    @EventHandler(ignoreCancelled = true)
    public void onEntityDeath(EntityDeathEvent event) {
        if (!isPlayerAttributed(event)) {
            return;
        }

        if (event.getEntity() instanceof Player player) {
            handlePlayerDeath(event, player);
            return;
        }

        HeadType headType = HeadType.from(event.getEntityType());
        if (headType == null) {
            return;
        }

        if (shouldDrop(config.chanceFor(headType))) {
            event.getDrops().add(HeadItemFactory.create(headType));
        }
    }

    private boolean isPlayerAttributed(EntityDeathEvent event) {
        Player directKiller = event.getEntity().getKiller();
        UUID directKillerId = directKiller == null ? null : directKiller.getUniqueId();

        DamageSource damageSource = event.getDamageSource();
        Entity causingEntity = damageSource.getCausingEntity();
        UUID causingPlayerId = causingEntity instanceof Player player ? player.getUniqueId() : null;

        boolean badRespawnPoint = DamageType.BAD_RESPAWN_POINT.equals(damageSource.getDamageType());
        KillAttributionTracker.DamagePoint sourcePoint = badRespawnPoint
                ? toDamagePoint(damageSource.getDamageLocation(), event.getEntity().getWorld().getUID())
                : null;

        return killAttributionTracker.resolvePlayer(
                        directKillerId,
                        causingPlayerId,
                        badRespawnPoint,
                        sourcePoint)
                != null;
    }

    private KillAttributionTracker.DamagePoint toDamagePoint(Location location, UUID fallbackWorldId) {
        if (location == null) {
            return null;
        }

        UUID worldId = location.getWorld() == null ? fallbackWorldId : location.getWorld().getUID();
        return new KillAttributionTracker.DamagePoint(
                worldId,
                location.getX(),
                location.getY(),
                location.getZ());
    }

    private boolean isBadRespawnPointTrigger(Material material) {
        return material == Material.RESPAWN_ANCHOR || Tag.BEDS.isTagged(material);
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
