package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HeadDropConfigTest {

    private static final String VALID_CONFIG = """
            heads:
              creeper: 2.5
              zombie: 2.5
              skeleton: 2.5
              wither-skeleton: 2.5
              piglin: 2.5
              ender-dragon: 100.0

            player-heads:
              enabled: false
              drop-chance-percent: 100.0
            """;

    @Test
    void validConfigurationParses() throws Exception {
        HeadDropConfig config = HeadDropConfig.parse(VALID_CONFIG);

        assertEquals(2.5D, config.chanceFor(HeadType.CREEPER));
        assertEquals(100.0D, config.chanceFor(HeadType.ENDER_DRAGON));
        assertFalse(config.playerHeadsEnabled());
        assertEquals(100.0D, config.playerHeadChance());
    }

    @Test
    void malformedYamlIsRejected() {
        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse("heads:\n  creeper: [\n"));

        assertTrue(exception.getMessage().contains("invalid YAML"));
    }

    @Test
    void wrongNumericTypeIsRejected() {
        String invalid = VALID_CONFIG.replace("creeper: 2.5", "creeper: often");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("heads.creeper"));
    }

    @Test
    void wrongBooleanTypeIsRejected() {
        String invalid = VALID_CONFIG.replace("enabled: false", "enabled: sometimes");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("player-heads.enabled"));
    }

    @Test
    void outOfRangePercentageIsRejected() {
        String invalid = VALID_CONFIG.replace("zombie: 2.5", "zombie: 125");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("heads.zombie"));
    }

    @Test
    void unknownConfigurationKeyIsRejected() {
        String invalid = VALID_CONFIG + "\nunexpected: true\n";

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("unexpected"));
    }

    @Test
    void missingRequiredValueIsRejected() {
        String invalid = VALID_CONFIG.replace("  piglin: 2.5\n", "");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("heads.piglin"));
    }
}
