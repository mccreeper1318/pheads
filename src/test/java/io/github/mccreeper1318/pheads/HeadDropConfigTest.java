package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HeadDropConfigTest {

    private static final String VALID_0_0_1_CONFIG = """
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
    void existingZeroZeroOneConfigurationParsesWithDefaultsForNewHeads() throws Exception {
        HeadDropConfig config = HeadDropConfig.parse(VALID_0_0_1_CONFIG);

        assertEquals(2.5D, config.chanceFor(HeadType.CREEPER));
        assertEquals(100.0D, config.chanceFor(HeadType.ENDER_DRAGON));
        assertEquals(2.5D, config.chanceFor(HeadType.PIG));
        assertEquals(2.5D, config.chanceFor(HeadType.SNIFFER));
        assertFalse(config.playerHeadsEnabled());
        assertEquals(100.0D, config.playerHeadChance());
    }

    @Test
    void newHeadChanceCanBeConfiguredIndependently() throws Exception {
        String configured = VALID_0_0_1_CONFIG.replace(
                "  ender-dragon: 100.0\n",
                "  ender-dragon: 100.0\n  pig: 7.5\n");

        HeadDropConfig config = HeadDropConfig.parse(configured);

        assertEquals(7.5D, config.chanceFor(HeadType.PIG));
        assertEquals(2.5D, config.chanceFor(HeadType.COW));
    }

    @Test
    void explicitNullNewHeadChancesAreRejected() {
        String[] invalidPigDeclarations = {
            "  pig:\n",
            "  pig: null\n",
            "  pig: ~\n",
            "  pig: # intentionally blank\n",
            "  \"pig\": null\n",
            "  'pig': null\n",
            "  \"p\\u0069g\": null\n"
        };

        for (String pigDeclaration : invalidPigDeclarations) {
            String invalid = VALID_0_0_1_CONFIG.replace(
                    "  ender-dragon: 100.0\n",
                    "  ender-dragon: 100.0\n" + pigDeclaration);

            HeadDropConfigException exception = assertThrows(
                    HeadDropConfigException.class,
                    () -> HeadDropConfig.parse(invalid));

            assertTrue(exception.getMessage().contains("heads.pig"));
        }
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
        String invalid = VALID_0_0_1_CONFIG.replace("creeper: 2.5", "creeper: often");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("heads.creeper"));
    }

    @Test
    void wrongBooleanTypeIsRejected() {
        String invalid = VALID_0_0_1_CONFIG.replace("enabled: false", "enabled: sometimes");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("player-heads.enabled"));
    }

    @Test
    void outOfRangePercentageIsRejected() {
        String invalid = VALID_0_0_1_CONFIG.replace("zombie: 2.5", "zombie: 125");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("heads.zombie"));
    }

    @Test
    void outOfRangeCustomHeadPercentageIsRejected() {
        String invalid = VALID_0_0_1_CONFIG.replace(
                "  ender-dragon: 100.0\n",
                "  ender-dragon: 100.0\n  pig: 125\n");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("heads.pig"));
    }

    @Test
    void unknownConfigurationKeyIsRejected() {
        String invalid = VALID_0_0_1_CONFIG + "\nunexpected: true\n";

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("unexpected"));
    }

    @Test
    void missingOriginalRequiredValueIsRejected() {
        String invalid = VALID_0_0_1_CONFIG.replace("  piglin: 2.5\n", "");

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(invalid));

        assertTrue(exception.getMessage().contains("heads.piglin"));
    }
}
