package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;

class PrizeHeadPresentationTest {

    @Test
    void nativeAndCustomHeadsGetMobSpecificTrophyNames() {
        PrizeHeadPresentation creeper = PrizeHeadPresentation.forHead(HeadType.CREEPER);
        PrizeHeadPresentation pig = PrizeHeadPresentation.forHead(HeadType.PIG);

        assertEquals("✦ Creeper Trophy ✦", creeper.displayName());
        assertEquals("✦ Pig Trophy ✦", pig.displayName());
        assertEquals("creeper", creeper.mobKey());
        assertEquals("pig", pig.mobKey());
        assertEquals("prize", creeper.tier());
        assertNotEquals(creeper.displayName(), pig.displayName());
    }
}
