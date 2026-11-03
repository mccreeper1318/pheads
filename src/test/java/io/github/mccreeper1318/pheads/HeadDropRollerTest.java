package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;

class HeadDropRollerTest {

    @Test
    void prizeSuccessStopsBeforeNormalRoll() {
        AtomicInteger calls = new AtomicInteger();
        HeadDropRoller roller = new HeadDropRoller(() -> {
            calls.incrementAndGet();
            return 0.01D;
        });

        assertEquals(HeadDropRoller.Result.PRIZE, roller.roll(0.10D, 100.0D));
        assertEquals(1, calls.get());
    }

    @Test
    void normalRollRunsAfterPrizeMiss() {
        Deque<Double> rolls = new ArrayDeque<>();
        rolls.add(50.0D);
        rolls.add(1.0D);
        HeadDropRoller roller = new HeadDropRoller(rolls::removeFirst);

        assertEquals(HeadDropRoller.Result.NORMAL, roller.roll(0.10D, 2.5D));
        assertEquals(0, rolls.size());
    }

    @Test
    void noDropWhenBothRollsMiss() {
        Deque<Double> rolls = new ArrayDeque<>();
        rolls.add(50.0D);
        rolls.add(50.0D);
        HeadDropRoller roller = new HeadDropRoller(rolls::removeFirst);

        assertEquals(HeadDropRoller.Result.NONE, roller.roll(0.10D, 2.5D));
    }
}
