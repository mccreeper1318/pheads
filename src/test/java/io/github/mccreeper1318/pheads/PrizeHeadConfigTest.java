package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.bukkit.Particle;
import org.junit.jupiter.api.Test;

class PrizeHeadConfigTest {

    private static final String BASE_CONFIG = """
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
    void olderConfigKeepsPrizeHeadsDisabled() throws Exception {
        HeadDropConfig config = HeadDropConfig.parse(BASE_CONFIG);

        assertEquals(0.0D, config.prizeChanceFor(HeadType.PIG));
        assertFalse(config.prizeParticlesEnabled());
    }

    @Test
    void prizeChanceAndParticlesAreConfiguredIndependently() throws Exception {
        String configured = BASE_CONFIG + """
                
                prize-heads:
                  chances:
                    pig: 0.25
                  particles:
                    enabled: true
                    type: END_ROD
                    count: 12
                """;

        HeadDropConfig config = HeadDropConfig.parse(configured);

        assertEquals(0.25D, config.prizeChanceFor(HeadType.PIG));
        assertEquals(0.10D, config.prizeChanceFor(HeadType.COW));
        assertTrue(config.prizeParticlesEnabled());
        assertEquals(Particle.END_ROD, config.prizeParticle());
        assertEquals(12, config.prizeParticleCount());
    }

    @Test
    void invalidPrizeChanceIsRejected() {
        String configured = BASE_CONFIG + """
                
                prize-heads:
                  chances:
                    pig: 125
                """;

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(configured));

        assertTrue(exception.getMessage().contains("prize-heads.chances.pig"));
    }

    @Test
    void invalidParticleTypeIsRejected() {
        String configured = BASE_CONFIG + """
                
                prize-heads:
                  particles:
                    type: DEFINITELY_NOT_A_PARTICLE
                """;

        HeadDropConfigException exception = assertThrows(
                HeadDropConfigException.class,
                () -> HeadDropConfig.parse(configured));

        assertTrue(exception.getMessage().contains("prize-heads.particles.type"));
    }
}
