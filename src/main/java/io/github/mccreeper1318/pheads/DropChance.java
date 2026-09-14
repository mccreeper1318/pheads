package io.github.mccreeper1318.pheads;

final class DropChance {

    private DropChance() {
    }

    static boolean shouldDrop(double chancePercent, double rollPercent) {
        if (rollPercent < 0.0D || rollPercent >= 100.0D) {
            throw new IllegalArgumentException("rollPercent must be >= 0 and < 100");
        }

        double chance = sanitize(chancePercent);
        return chance >= 100.0D || (chance > 0.0D && rollPercent < chance);
    }

    static double sanitize(double chancePercent) {
        if (!Double.isFinite(chancePercent)) {
            return 0.0D;
        }
        return Math.max(0.0D, Math.min(100.0D, chancePercent));
    }
}
