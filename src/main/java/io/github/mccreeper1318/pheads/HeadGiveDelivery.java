package io.github.mccreeper1318.pheads;

import java.util.Map;
import org.bukkit.inventory.ItemStack;

final class HeadGiveDelivery {

    private HeadGiveDelivery() {}

    static Result deliver(
            ItemStack item,
            InventoryAdder inventoryAdder,
            WorldDropper worldDropper) {
        Map<Integer, ItemStack> leftovers = inventoryAdder.add(item);
        if (leftovers.isEmpty()) {
            return Result.INVENTORY;
        }

        for (ItemStack leftover : leftovers.values()) {
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
    interface InventoryAdder {
        Map<Integer, ItemStack> add(ItemStack item);
    }

    @FunctionalInterface
    interface WorldDropper {
        boolean drop(ItemStack item);
    }
}
