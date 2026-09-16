package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Method;
import org.bukkit.event.EventHandler;
import org.bukkit.event.entity.EntityDeathEvent;
import org.junit.jupiter.api.Test;

class HeadDropListenerTest {

    @Test
    void cancelledDeathEventsAreIgnoredByRegistration() throws NoSuchMethodException {
        Method deathHandler = HeadDropListener.class.getDeclaredMethod("onEntityDeath", EntityDeathEvent.class);
        EventHandler eventHandler = deathHandler.getAnnotation(EventHandler.class);

        assertNotNull(eventHandler);
        assertTrue(eventHandler.ignoreCancelled());
    }
}
