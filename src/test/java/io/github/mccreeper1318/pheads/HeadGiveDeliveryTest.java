package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.jupiter.api.Test;

class HeadGiveDeliveryTest {

    @Test
    void availableInventoryDoesNotUseWorldFallback() {
        Object head = new Object();
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
        Object head = new Object();
        AtomicInteger fallbackCalls = new AtomicInteger();
        AtomicReference<Object> dropped = new AtomicReference<>();

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
        Object head = new Object();
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
