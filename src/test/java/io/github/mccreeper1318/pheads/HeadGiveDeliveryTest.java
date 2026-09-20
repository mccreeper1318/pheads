package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.junit.jupiter.api.Test;

class HeadGiveDeliveryTest {

    @Test
    void availableInventoryDoesNotUseWorldFallback() {
        ItemStack head = new ItemStack(Material.CREEPER_HEAD);
        AtomicInteger fallbackCalls = new AtomicInteger();

        HeadGiveDelivery.Result result = HeadGiveDelivery.deliver(
                head,
                item -> Map.of(),
                item -> {
                    fallbackCalls.incrementAndGet();
                    return true;
                });

        assertEquals(HeadGiveDelivery.Result.INVENTORY, result);
        assertTrue(result.successful());
        assertEquals(0, fallbackCalls.get());
    }

    @Test
    void fullInventoryFallsBackToSingleWorldDrop() {
        ItemStack head = new ItemStack(Material.CREEPER_HEAD);
        AtomicInteger fallbackCalls = new AtomicInteger();
        AtomicReference<ItemStack> dropped = new AtomicReference<>();

        HeadGiveDelivery.Result result = HeadGiveDelivery.deliver(
                head,
                item -> Map.of(0, item),
                item -> {
                    fallbackCalls.incrementAndGet();
                    dropped.set(item);
                    return true;
                });

        assertEquals(HeadGiveDelivery.Result.WORLD, result);
        assertTrue(result.successful());
        assertEquals(1, fallbackCalls.get());
        assertSame(head, dropped.get());
    }

    @Test
    void cancelledFallbackSpawnReportsDeliveryFailureWithoutRetry() {
        ItemStack head = new ItemStack(Material.CREEPER_HEAD);
        AtomicInteger fallbackCalls = new AtomicInteger();

        HeadGiveDelivery.Result result = HeadGiveDelivery.deliver(
                head,
                item -> Map.of(0, item),
                item -> {
                    fallbackCalls.incrementAndGet();
                    return false;
                });

        assertEquals(HeadGiveDelivery.Result.FAILED, result);
        assertFalse(result.successful());
        assertEquals(1, fallbackCalls.get());
    }
}
