package io.github.mccreeper1318.pheads;

import java.util.Map;

final class HeadGiveDelivery {

    private HeadGiveDelivery() {}

    static <T> Result deliver(
            T item,
            InventoryAdder<T> inventoryAdder,
            WorldDropper<T> worldDropper) {
        Map<Integer, T> leftovers = inventoryAdder.add(item);
        if (leftovers.isEmpty()) {
            return Result.INVENTORY;
        }

        for (T leftover : leftovers.values()) {
            if (!worldDropper.drop(leftover)) {
                return Result.FAILED;
            }
        }

        return Result.WORLD;
    }

    enum Result {
        INVENTORY,
        WORLD,
        FAILED;

        boolean successful() {
            return this != FAILED;
        }
    }

    @FunctionalInterface
    interface InventoryAdder<T> {
        Map<Integer, T> add(T item);
    }

    @FunctionalInterface
    interface WorldDropper<T> {
        boolean drop(T item);
    }
}
