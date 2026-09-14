package io.github.mccreeper1318.pheads;

import java.time.Duration;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.Objects;
import java.util.UUID;
import java.util.function.LongSupplier;

final class KillAttributionTracker {

    static final long DEFAULT_MAX_AGE_NANOS = Duration.ofSeconds(2L).toNanos();
    static final double MAX_SOURCE_DISTANCE_SQUARED = 4.0D;

    private static final int MAX_TRACKED_BAD_RESPAWN_TRIGGERS = 128;

    private final long maxAgeNanos;
    private final LongSupplier nanoTime;
    private final Deque<BadRespawnTrigger> badRespawnTriggers = new ArrayDeque<>();

    KillAttributionTracker() {
        this(DEFAULT_MAX_AGE_NANOS, System::nanoTime);
    }

    KillAttributionTracker(long maxAgeNanos, LongSupplier nanoTime) {
        if (maxAgeNanos <= 0L) {
            throw new IllegalArgumentException("maxAgeNanos must be positive");
        }

        this.maxAgeNanos = maxAgeNanos;
        this.nanoTime = Objects.requireNonNull(nanoTime, "nanoTime");
    }

    void recordBadRespawnPointTrigger(DamagePoint sourcePoint, UUID playerId) {
        Objects.requireNonNull(sourcePoint, "sourcePoint");
        Objects.requireNonNull(playerId, "playerId");

        long now = nanoTime.getAsLong();
        purgeExpired(now);

        while (badRespawnTriggers.size() >= MAX_TRACKED_BAD_RESPAWN_TRIGGERS) {
            badRespawnTriggers.removeFirst();
        }

        badRespawnTriggers.addLast(new BadRespawnTrigger(sourcePoint, playerId, now));
    }

    UUID resolvePlayer(
            UUID directKillerId,
            UUID causingPlayerId,
            boolean badRespawnPoint,
            DamagePoint sourcePoint) {
        if (directKillerId != null) {
            return directKillerId;
        }

        if (causingPlayerId != null) {
            return causingPlayerId;
        }

        if (!badRespawnPoint || sourcePoint == null) {
            return null;
        }

        long now = nanoTime.getAsLong();
        purgeExpired(now);

        Iterator<BadRespawnTrigger> iterator = badRespawnTriggers.descendingIterator();
        while (iterator.hasNext()) {
            BadRespawnTrigger trigger = iterator.next();
            if (trigger.sourcePoint().worldId().equals(sourcePoint.worldId())
                    && trigger.sourcePoint().distanceSquared(sourcePoint) <= MAX_SOURCE_DISTANCE_SQUARED) {
                return trigger.playerId();
            }
        }

        return null;
    }

    private void purgeExpired(long now) {
        while (!badRespawnTriggers.isEmpty()) {
            BadRespawnTrigger oldest = badRespawnTriggers.peekFirst();
            long age = now - oldest.recordedAtNanos();
            if (age >= 0L && age <= maxAgeNanos) {
                return;
            }
            badRespawnTriggers.removeFirst();
        }
    }

    record DamagePoint(UUID worldId, double x, double y, double z) {

        DamagePoint {
            Objects.requireNonNull(worldId, "worldId");
        }

        double distanceSquared(DamagePoint other) {
            double dx = x - other.x;
            double dy = y - other.y;
            double dz = z - other.z;
            return (dx * dx) + (dy * dy) + (dz * dz);
        }
    }

    private record BadRespawnTrigger(DamagePoint sourcePoint, UUID playerId, long recordedAtNanos) {}
}
