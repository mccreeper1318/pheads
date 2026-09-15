package io.github.mccreeper1318.pheads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

final class HeadDropConfig {

    private static final String PLAYER_HEADS_ENABLED_PATH = "player-heads.enabled";
    private static final String PLAYER_HEADS_CHANCE_PATH = "player-heads.drop-chance-percent";
    private static final Set<String> ALLOWED_KEYS = createAllowedKeys();

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

    static HeadDropConfig load(Path path) throws HeadDropConfigException {
        final String contents;
        try {
            contents = Files.readString(path, StandardCharsets.UTF_8);
        } catch (IOException exception) {
            throw new HeadDropConfigException("Could not read config.yml: " + exception.getMessage(), exception);
        }

        return parse(contents);
    }

    static HeadDropConfig parse(String contents) throws HeadDropConfigException {
        YamlConfiguration config = new YamlConfiguration();
        try {
            config.loadFromString(contents);
        } catch (InvalidConfigurationException exception) {
            throw new HeadDropConfigException("config.yml contains invalid YAML.", exception);
        }

        return from(config);
    }

    static HeadDropConfig from(FileConfiguration config) throws HeadDropConfigException {
        validateKnownKeys(config);
        requireSection(config, "heads");
        requireSection(config, "player-heads");

        Map<HeadType, Double> mobChances = new EnumMap<>(HeadType.class);
        for (HeadType headType : HeadType.values()) {
            String path = "heads." + headType.configKey();
            Object configuredValue = config.get(path, null);
            if (configuredValue == null && !headType.requiredInConfig()) {
                mobChances.put(headType, headType.defaultChance());
            } else {
                mobChances.put(headType, readPercent(config, path));
            }
        }

        boolean playerHeadsEnabled = readBoolean(config, PLAYER_HEADS_ENABLED_PATH);
        double playerHeadChance = readPercent(config, PLAYER_HEADS_CHANCE_PATH);

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

    private static void validateKnownKeys(FileConfiguration config) throws HeadDropConfigException {
        for (String key : config.getKeys(true)) {
            if (!ALLOWED_KEYS.contains(key)) {
                throw new HeadDropConfigException("Unknown configuration key '" + key + "'.");
            }
        }
    }

    private static void requireSection(FileConfiguration config, String path) throws HeadDropConfigException {
        Object value = config.get(path, null);
        if (!(value instanceof ConfigurationSection)) {
            throw new HeadDropConfigException("Missing required configuration section '" + path + "'.");
        }
    }

    private static double readPercent(FileConfiguration config, String path) throws HeadDropConfigException {
        Object value = requiredValue(config, path);
        if (!(value instanceof Number number)) {
            throw new HeadDropConfigException("Configuration value '" + path + "' must be a number from 0 to 100.");
        }

        double configured = number.doubleValue();
        if (!Double.isFinite(configured) || configured < 0.0D || configured > 100.0D) {
            throw new HeadDropConfigException("Configuration value '" + path + "' must be between 0 and 100.");
        }

        return configured;
    }

    private static boolean readBoolean(FileConfiguration config, String path) throws HeadDropConfigException {
        Object value = requiredValue(config, path);
        if (!(value instanceof Boolean booleanValue)) {
            throw new HeadDropConfigException("Configuration value '" + path + "' must be true or false.");
        }
        return booleanValue;
    }

    private static Object requiredValue(FileConfiguration config, String path) throws HeadDropConfigException {
        Object value = config.get(path, null);
        if (value == null) {
            throw new HeadDropConfigException("Missing required configuration value '" + path + "'.");
        }
        return value;
    }

    private static Set<String> createAllowedKeys() {
        Set<String> keys = new HashSet<>();
        keys.add("heads");
        for (HeadType headType : HeadType.values()) {
            keys.add("heads." + headType.configKey());
        }
        keys.add("player-heads");
        keys.add(PLAYER_HEADS_ENABLED_PATH);
        keys.add(PLAYER_HEADS_CHANCE_PATH);
        return Set.copyOf(keys);
    }
}
