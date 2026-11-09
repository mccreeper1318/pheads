package io.github.mccreeper1318.pheads;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.EnumMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.bukkit.Particle;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

final class HeadDropConfig {

    private static final String PLAYER_HEADS_ENABLED_PATH = "player-heads.enabled";
    private static final String PLAYER_HEADS_CHANCE_PATH = "player-heads.drop-chance-percent";
    private static final String PRIZE_HEADS_PATH = "prize-heads";
    private static final String PRIZE_CHANCES_PATH = "prize-heads.chances";
    private static final String PRIZE_PARTICLES_PATH = "prize-heads.particles";
    private static final String PRIZE_PARTICLES_ENABLED_PATH = "prize-heads.particles.enabled";
    private static final String PRIZE_PARTICLE_TYPE_PATH = "prize-heads.particles.type";
    private static final String PRIZE_PARTICLE_COUNT_PATH = "prize-heads.particles.count";
    private static final double DEFAULT_PRIZE_CHANCE = 0.10D;
    private static final Particle DEFAULT_PRIZE_PARTICLE = Particle.END_ROD;
    private static final int DEFAULT_PRIZE_PARTICLE_COUNT = 20;
    private static final Set<String> ALLOWED_KEYS = createAllowedKeys();

    private final Map<HeadType, Double> mobChances;
    private final Map<HeadType, Double> prizeChances;
    private final boolean playerHeadsEnabled;
    private final double playerHeadChance;
    private final boolean prizeParticlesEnabled;
    private final Particle prizeParticle;
    private final int prizeParticleCount;

    private HeadDropConfig(
            Map<HeadType, Double> mobChances,
            Map<HeadType, Double> prizeChances,
            boolean playerHeadsEnabled,
            double playerHeadChance,
            boolean prizeParticlesEnabled,
            Particle prizeParticle,
            int prizeParticleCount) {
        this.mobChances = mobChances;
        this.prizeChances = prizeChances;
        this.playerHeadsEnabled = playerHeadsEnabled;
        this.playerHeadChance = playerHeadChance;
        this.prizeParticlesEnabled = prizeParticlesEnabled;
        this.prizeParticle = prizeParticle;
        this.prizeParticleCount = prizeParticleCount;
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

        return from(config, findExplicitlyNullOptionalHeadValues(contents));
    }

    private static HeadDropConfig from(
            FileConfiguration config,
            Set<String> explicitlyNullOptionalHeadValues) throws HeadDropConfigException {
        validateKnownKeys(config);
        requireSection(config, "heads");
        requireSection(config, "player-heads");

        Map<HeadType, Double> mobChances = new EnumMap<>(HeadType.class);
        for (HeadType headType : HeadType.values()) {
            String path = "heads." + headType.configKey();
            Object configuredValue = config.get(path, null);
            if (configuredValue == null && !headType.requiredInConfig()) {
                if (explicitlyNullOptionalHeadValues.contains(path)) {
                    throw new HeadDropConfigException(
                            "Configuration value '" + path + "' must be a number from 0 to 100.");
                }
                mobChances.put(headType, headType.defaultChance());
            } else {
                mobChances.put(headType, readPercent(config, path));
            }
        }

        boolean prizeHeadsConfigured = config.get(PRIZE_HEADS_PATH, null) != null;
        if (prizeHeadsConfigured) {
            requireSection(config, PRIZE_HEADS_PATH);

            Object chanceSection = config.get(PRIZE_CHANCES_PATH, null);
            if (chanceSection != null && !(chanceSection instanceof ConfigurationSection)) {
                throw new HeadDropConfigException(
                        "Configuration value '" + PRIZE_CHANCES_PATH + "' must be a section.");
            }

            Object particleSection = config.get(PRIZE_PARTICLES_PATH, null);
            if (particleSection != null && !(particleSection instanceof ConfigurationSection)) {
                throw new HeadDropConfigException(
                        "Configuration value '" + PRIZE_PARTICLES_PATH + "' must be a section.");
            }
        }

        Map<HeadType, Double> prizeChances = new EnumMap<>(HeadType.class);
        double missingPrizeChance = prizeHeadsConfigured ? DEFAULT_PRIZE_CHANCE : 0.0D;
        for (HeadType headType : HeadType.values()) {
            String path = PRIZE_CHANCES_PATH + "." + headType.configKey();
            Object configuredValue = config.get(path, null);
            prizeChances.put(
                    headType,
                    configuredValue == null ? missingPrizeChance : readPercent(config, path));
        }

        boolean playerHeadsEnabled = readBoolean(config, PLAYER_HEADS_ENABLED_PATH);
        double playerHeadChance = readPercent(config, PLAYER_HEADS_CHANCE_PATH);

        boolean prizeParticlesEnabled = prizeHeadsConfigured
                && readOptionalBoolean(config, PRIZE_PARTICLES_ENABLED_PATH, true);
        Particle prizeParticle =
                readOptionalParticle(config, PRIZE_PARTICLE_TYPE_PATH, DEFAULT_PRIZE_PARTICLE);
        int prizeParticleCount = readOptionalInteger(
                config,
                PRIZE_PARTICLE_COUNT_PATH,
                DEFAULT_PRIZE_PARTICLE_COUNT,
                0,
                1000);

        return new HeadDropConfig(
                mobChances,
                prizeChances,
                playerHeadsEnabled,
                playerHeadChance,
                prizeParticlesEnabled,
                prizeParticle,
                prizeParticleCount);
    }

    double chanceFor(HeadType headType) {
        return mobChances.getOrDefault(headType, 0.0D);
    }

    double prizeChanceFor(HeadType headType) {
        return prizeChances.getOrDefault(headType, 0.0D);
    }

    boolean playerHeadsEnabled() {
        return playerHeadsEnabled;
    }

    double playerHeadChance() {
        return playerHeadChance;
    }

    boolean prizeParticlesEnabled() {
        return prizeParticlesEnabled;
    }

    Particle prizeParticle() {
        return prizeParticle;
    }

    int prizeParticleCount() {
        return prizeParticleCount;
    }

    private static void validateKnownKeys(FileConfiguration config) throws HeadDropConfigException {
        for (String key : config.getKeys(true)) {
            if (!ALLOWED_KEYS.contains(key)) {
                throw new HeadDropConfigException("Unknown configuration key '" + key + "'.");
            }
        }
    }

    private static void requireSection(FileConfiguration config, String path)
            throws HeadDropConfigException {
        Object value = config.get(path, null);
        if (!(value instanceof ConfigurationSection)) {
            throw new HeadDropConfigException(
                    "Missing required configuration section '" + path + "'.");
        }
    }

    private static double readPercent(FileConfiguration config, String path)
            throws HeadDropConfigException {
        Object value = requiredValue(config, path);
        if (!(value instanceof Number number)) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' must be a number from 0 to 100.");
        }

        double configured = number.doubleValue();
        if (!Double.isFinite(configured) || configured < 0.0D || configured > 100.0D) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' must be between 0 and 100.");
        }

        return configured;
    }

    private static boolean readBoolean(FileConfiguration config, String path)
            throws HeadDropConfigException {
        Object value = requiredValue(config, path);
        if (!(value instanceof Boolean booleanValue)) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' must be true or false.");
        }
        return booleanValue;
    }

    private static boolean readOptionalBoolean(
            FileConfiguration config,
            String path,
            boolean defaultValue) throws HeadDropConfigException {
        Object value = config.get(path, null);
        if (value == null) {
            return defaultValue;
        }
        if (!(value instanceof Boolean booleanValue)) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' must be true or false.");
        }
        return booleanValue;
    }

    private static Particle readOptionalParticle(
            FileConfiguration config,
            String path,
            Particle defaultValue) throws HeadDropConfigException {
        Object value = config.get(path, null);
        if (value == null) {
            return defaultValue;
        }
        if (!(value instanceof String configured)) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' must be a particle name.");
        }

        final Particle particle;
        try {
            particle = Particle.valueOf(
                    configured.trim().toUpperCase(Locale.ROOT).replace('-', '_'));
        } catch (IllegalArgumentException exception) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' is not a valid particle type.",
                    exception);
        }

        if (particle.getDataType() != Void.class) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path
                            + "' must be a particle that does not require extra data.");
        }
        return particle;
    }

    private static int readOptionalInteger(
            FileConfiguration config,
            String path,
            int defaultValue,
            int minimum,
            int maximum) throws HeadDropConfigException {
        Object value = config.get(path, null);
        if (value == null) {
            return defaultValue;
        }
        if (!(value instanceof Number number)) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' must be an integer from "
                            + minimum + " to " + maximum + ".");
        }

        double configured = number.doubleValue();
        if (!Double.isFinite(configured)
                || configured != Math.rint(configured)
                || configured < minimum
                || configured > maximum) {
            throw new HeadDropConfigException(
                    "Configuration value '" + path + "' must be an integer from "
                            + minimum + " to " + maximum + ".");
        }
        return (int) configured;
    }

    private static Object requiredValue(FileConfiguration config, String path)
            throws HeadDropConfigException {
        Object value = config.get(path, null);
        if (value == null) {
            throw new HeadDropConfigException(
                    "Missing required configuration value '" + path + "'.");
        }
        return value;
    }

    private static Set<String> findExplicitlyNullOptionalHeadValues(String contents) {
        Set<String> explicitlyNullPaths = new HashSet<>();
        int headsIndent = -1;

        for (String rawLine : contents.split("\\R", -1)) {
            String line = stripYamlComment(rawLine);
            if (line.isBlank()) {
                continue;
            }

            int indent = leadingSpaces(line);
            String trimmed = line.substring(indent).trim();

            if (headsIndent < 0) {
                if (indent == 0 && isHeadsSectionDeclaration(trimmed)) {
                    headsIndent = indent;
                }
                continue;
            }

            if (indent <= headsIndent) {
                headsIndent = indent == 0 && isHeadsSectionDeclaration(trimmed) ? indent : -1;
                continue;
            }

            int colonIndex = trimmed.indexOf(':');
            if (colonIndex <= 0) {
                continue;
            }

            String key = normalizeYamlKey(trimmed.substring(0, colonIndex).trim());
            HeadType matchingHeadType = null;
            for (HeadType headType : HeadType.values()) {
                if (!headType.requiredInConfig() && headType.configKey().equals(key)) {
                    matchingHeadType = headType;
                    break;
                }
            }
            if (matchingHeadType == null) {
                continue;
            }

            String scalar = trimmed.substring(colonIndex + 1).trim();
            if (scalar.isEmpty()
                    || "~".equals(scalar)
                    || "null".equalsIgnoreCase(scalar)) {
                explicitlyNullPaths.add("heads." + matchingHeadType.configKey());
            }
        }

        return Set.copyOf(explicitlyNullPaths);
    }

    private static boolean isHeadsSectionDeclaration(String trimmed) {
        int colonIndex = trimmed.indexOf(':');
        if (colonIndex <= 0) {
            return false;
        }

        String keySource = trimmed.substring(0, colonIndex).trim();
        if (!"heads".equals(normalizeYamlKey(keySource))) {
            return false;
        }

        String nodeProperties = trimmed.substring(colonIndex + 1).trim();
        return nodeProperties.isEmpty()
                || nodeProperties.startsWith("&")
                || nodeProperties.startsWith("!");
    }

    private static String normalizeYamlKey(String keySource) {
        YamlConfiguration keyConfig = new YamlConfiguration();
        try {
            keyConfig.loadFromString(keySource + ": true");
        } catch (InvalidConfigurationException exception) {
            return keySource;
        }

        Set<String> keys = keyConfig.getKeys(false);
        return keys.size() == 1 ? keys.iterator().next() : keySource;
    }

    private static int leadingSpaces(String value) {
        int index = 0;
        while (index < value.length() && value.charAt(index) == ' ') {
            index++;
        }
        return index;
    }

    private static String stripYamlComment(String line) {
        boolean inSingleQuotes = false;
        boolean inDoubleQuotes = false;

        for (int index = 0; index < line.length(); index++) {
            char current = line.charAt(index);

            if (current == '\'' && !inDoubleQuotes) {
                if (inSingleQuotes
                        && index + 1 < line.length()
                        && line.charAt(index + 1) == '\'') {
                    index++;
                    continue;
                }
                inSingleQuotes = !inSingleQuotes;
                continue;
            }

            if (current == '"' && !inSingleQuotes) {
                boolean escaped = index > 0 && line.charAt(index - 1) == '\\';
                if (!escaped) {
                    inDoubleQuotes = !inDoubleQuotes;
                }
                continue;
            }

            if (current == '#'
                    && !inSingleQuotes
                    && !inDoubleQuotes
                    && (index == 0 || Character.isWhitespace(line.charAt(index - 1)))) {
                return line.substring(0, index);
            }
        }

        return line;
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

        keys.add(PRIZE_HEADS_PATH);
        keys.add(PRIZE_CHANCES_PATH);
        for (HeadType headType : HeadType.values()) {
            keys.add(PRIZE_CHANCES_PATH + "." + headType.configKey());
        }
        keys.add(PRIZE_PARTICLES_PATH);
        keys.add(PRIZE_PARTICLES_ENABLED_PATH);
        keys.add(PRIZE_PARTICLE_TYPE_PATH);
        keys.add(PRIZE_PARTICLE_COUNT_PATH);

        return Set.copyOf(keys);
    }
}
