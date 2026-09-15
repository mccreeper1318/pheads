package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class KillAttributionTrackerTest {

    private static final UUID WORLD_ID = UUID.fromString("00000000-0000-0000-0000-000000000001");
    private static final UUID OTHER_WORLD_ID = UUID.fromString("00000000-0000-0000-0000-000000000002");
    private static final UUID DIRECT_KILLER_ID = UUID.fromString("00000000-0000-0000-0000-000000000010");
    private static final UUID CAUSING_PLAYER_ID = UUID.fromString("00000000-0000-0000-0000-000000000011");
    private static final UUID TRIGGER_PLAYER_ID = UUID.fromString("00000000-0000-0000-0000-000000000012");
    private static final UUID NEWER_TRIGGER_PLAYER_ID = UUID.fromString("00000000-0000-0000-0000-000000000013");

    private AtomicLong now;
    private KillAttributionTracker tracker;

    @BeforeEach
    void setUp() {
        now = new AtomicLong(1_000_000L);
        tracker = new KillAttributionTracker(KillAttributionTracker.DEFAULT_MAX_AGE_NANOS, now::get);
    }

    @Test
    void directPlayerKillerTakesPriority() {
        assertEquals(
                DIRECT_KILLER_ID,
                tracker.resolvePlayer(DIRECT_KILLER_ID, CAUSING_PLAYER_ID, false, null));
    }

    @Test
    void causingPlayerSupportsIndirectProjectileAttribution() {
        assertEquals(
                CAUSING_PLAYER_ID,
                tracker.resolvePlayer(null, CAUSING_PLAYER_ID, false, null));
    }

    @Test
    void recentBadRespawnPointTriggerProvidesFallbackAttribution() {
        KillAttributionTracker.DamagePoint triggerPoint = point(WORLD_ID, 10.5D, 64.5D, -3.5D);
        tracker.recordBadRespawnPointTrigger(triggerPoint, TRIGGER_PLAYER_ID);

        assertEquals(
                TRIGGER_PLAYER_ID,
                tracker.resolvePlayer(null, null, true, point(WORLD_ID, 11.0D, 64.5D, -3.0D)));
    }

    @Test
    void newestMatchingBadRespawnPointTriggerWins() {
        KillAttributionTracker.DamagePoint triggerPoint = point(WORLD_ID, 10.5D, 64.5D, -3.5D);
        tracker.recordBadRespawnPointTrigger(triggerPoint, TRIGGER_PLAYER_ID);
        now.incrementAndGet();
        tracker.recordBadRespawnPointTrigger(triggerPoint, NEWER_TRIGGER_PLAYER_ID);

        assertEquals(
                NEWER_TRIGGER_PLAYER_ID,
                tracker.resolvePlayer(null, null, true, triggerPoint));
    }

    @Test
    void staleOrUnrelatedBadRespawnPointTriggersAreIgnored() {
        KillAttributionTracker.DamagePoint triggerPoint = point(WORLD_ID, 10.5D, 64.5D, -3.5D);
        tracker.recordBadRespawnPointTrigger(triggerPoint, TRIGGER_PLAYER_ID);

        assertNull(tracker.resolvePlayer(
                null,
                null,
                true,
                point(OTHER_WORLD_ID, 10.5D, 64.5D, -3.5D)));
        assertNull(tracker.resolvePlayer(
                null,
                null,
                true,
                point(WORLD_ID, 20.5D, 64.5D, -3.5D)));

        now.addAndGet(KillAttributionTracker.DEFAULT_MAX_AGE_NANOS + 1L);
        assertNull(tracker.resolvePlayer(null, null, true, triggerPoint));
    }

    @Test
    void environmentalDeathsRemainUnattributed() {
        assertNull(tracker.resolvePlayer(null, null, false, null));
        assertNull(tracker.resolvePlayer(
                null,
                null,
                true,
                point(WORLD_ID, 10.5D, 64.5D, -3.5D)));
    }

    private KillAttributionTracker.DamagePoint point(UUID worldId, double x, double y, double z) {
        return new KillAttributionTracker.DamagePoint(worldId, x, y, z);
    }
}
