package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class NewMobHeadConfigTest {

    private static final String OLD_CONFIG = """
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
    void olderConfigDefaultsNewMobHeadChances() throws Exception {
        HeadDropConfig config = HeadDropConfig.parse(OLD_CONFIG);

        assertEquals(2.5D, config.chanceFor(HeadType.CREAKING));
        assertEquals(2.5D, config.chanceFor(HeadType.HAPPY_GHAST));
        assertEquals(2.5D, config.chanceFor(HeadType.COPPER_GOLEM));
        assertEquals(2.5D, config.chanceFor(HeadType.NAUTILUS));
        assertEquals(2.5D, config.chanceFor(HeadType.ZOMBIE_NAUTILUS));
        assertEquals(2.5D, config.chanceFor(HeadType.CAMEL_HUSK));
        assertEquals(2.5D, config.chanceFor(HeadType.PARCHED));
        assertEquals(2.5D, config.chanceFor(HeadType.SULFUR_CUBE));
    }

    @Test
    void newMobChanceCanBeConfiguredIndependently() throws Exception {
        String configured = OLD_CONFIG.replace(
                "  ender-dragon: 100.0\n",
                "  ender-dragon: 100.0\n  happy-ghast: 7.5\n");

        HeadDropConfig config = HeadDropConfig.parse(configured);

        assertEquals(7.5D, config.chanceFor(HeadType.HAPPY_GHAST));
        assertEquals(2.5D, config.chanceFor(HeadType.CREAKING));
    }
}
