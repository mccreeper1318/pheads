package io.github.mccreeper1318.pheads;

import java.util.EnumMap;
import java.util.Map;
import java.util.logging.Logger;
import org.bukkit.configuration.file.FileConfiguration;

final class HeadDropConfig {

    private final Map<HeadType, Double> mobChances;
    private final boolean playerHeadsEnabled;
    private final double playerHeadChance;

    private HeadDropConfig(
            Map<HeadType, Double> mobChances,
            boolean playerHeadsEnabled,
            double playerHeadChance) {
        this.mobChances = mobChances;
        this.playerHeadsEnabled = playerHeadsEnabled;
        this.playerHeadChance = playerHeadChance;
    }

    static HeadDropConfig from(FileConfiguration config, Logger logger) {
        Map<HeadType, Double> mobChances = new EnumMap<>(HeadType.class);
        for (HeadType headType : HeadType.values()) {
            String path = "heads." + headType.configKey();
            mobChances.put(headType, readPercent(config, path, logger));
        }

        boolean playerHeadsEnabled = config.getBoolean("player-heads.enabled", false);
        double playerHeadChance = readPercent(config, "player-heads.drop-chance-percent", logger);

        return new HeadDropConfig(mobChances, playerHeadsEnabled, playerHeadChance);
    }

    double chanceFor(HeadType headType) {
        return mobChances.getOrDefault(headType, 0.0D);
    }

    boolean playerHeadsEnabled() {
        return playerHeadsEnabled;
    }

    double playerHeadChance() {
        return playerHeadChance;
    }

    private static double readPercent(FileConfiguration config, String path, Logger logger) {
        double configured = config.getDouble(path, 0.0D);
        double sanitized = DropChance.sanitize(configured);

        if (Double.compare(configured, sanitized) != 0) {
            logger.warning(() -> "Configuration value '" + path + "' must be between 0 and 100. Using " + sanitized + ".");
        }

        return sanitized;
    }
}
