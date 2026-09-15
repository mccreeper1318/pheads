package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class DropChanceTest {

    @Test
    void zeroPercentNeverDrops() {
        assertFalse(DropChance.shouldDrop(0.0D, 0.0D));
        assertFalse(DropChance.shouldDrop(-10.0D, 0.0D));
    }

    @Test
    void oneHundredPercentAlwaysDrops() {
        assertTrue(DropChance.shouldDrop(100.0D, 99.999D));
        assertTrue(DropChance.shouldDrop(150.0D, 99.999D));
    }

    @Test
    void configuredChanceUsesExclusiveUpperBoundary() {
        assertTrue(DropChance.shouldDrop(25.0D, 24.999D));
        assertFalse(DropChance.shouldDrop(25.0D, 25.0D));
    }

    @Test
    void invalidRollIsRejected() {
        assertThrows(IllegalArgumentException.class, () -> DropChance.shouldDrop(50.0D, -0.1D));
        assertThrows(IllegalArgumentException.class, () -> DropChance.shouldDrop(50.0D, 100.0D));
    }
}
