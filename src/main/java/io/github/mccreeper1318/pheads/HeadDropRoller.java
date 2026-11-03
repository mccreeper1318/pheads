package io.github.mccreeper1318.pheads;

import java.util.concurrent.ThreadLocalRandom;
import java.util.function.DoubleSupplier;

final class HeadDropRoller {

    enum Result {
        NONE,
        NORMAL,
        PRIZE
    }

    private final DoubleSupplier rollSupplier;

    HeadDropRoller() {
        this(() -> ThreadLocalRandom.current().nextDouble(100.0D));
    }

    HeadDropRoller(DoubleSupplier rollSupplier) {
        this.rollSupplier = rollSupplier;
    }

    Result roll(double prizeChancePercent, double normalChancePercent) {
        if (DropChance.shouldDrop(prizeChancePercent, rollSupplier.getAsDouble())) {
            return Result.PRIZE;
        }
        if (DropChance.shouldDrop(normalChancePercent, rollSupplier.getAsDouble())) {
            return Result.NORMAL;
        }
        return Result.NONE;
    }
}
