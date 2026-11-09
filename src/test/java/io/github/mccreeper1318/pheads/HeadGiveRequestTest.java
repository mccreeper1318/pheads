package io.github.mccreeper1318.pheads;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class HeadGiveRequestTest {

    @Test
    void parsesNormalHeadRequest() {
        HeadGiveRequest request =
                HeadGiveRequest.parse(new String[] {"give", "pig"});

        assertEquals(HeadGiveRequest.Status.VALID, request.status());
        assertEquals(HeadGiveRequest.Kind.NORMAL, request.kind());
        assertEquals(HeadType.PIG, request.headType());
        assertFalse(request.trophy());
    }

    @Test
    void parsesTrophyHeadRequest() {
        HeadGiveRequest request =
                HeadGiveRequest.parse(new String[] {"give", "trophy", "creeper"});

        assertEquals(HeadGiveRequest.Status.VALID, request.status());
        assertEquals(HeadGiveRequest.Kind.TROPHY, request.kind());
        assertEquals(HeadType.CREEPER, request.headType());
        assertTrue(request.trophy());
    }

    @Test
    void normalizesMultiWordTrophyHeadKey() {
        HeadGiveRequest request =
                HeadGiveRequest.parse(
                        new String[] {"give", "trophy", "wither", "skeleton"});

        assertEquals(HeadGiveRequest.Status.VALID, request.status());
        assertEquals(HeadType.WITHER_SKELETON, request.headType());
        assertEquals("wither-skeleton", request.requestedKey());
    }

    @Test
    void missingTrophyHeadIsReported() {
        HeadGiveRequest request =
                HeadGiveRequest.parse(new String[] {"give", "trophy"});

        assertEquals(HeadGiveRequest.Status.MISSING_HEAD, request.status());
        assertTrue(request.trophy());
        assertNull(request.headType());
    }

    @Test
    void unsupportedTrophyHeadIsRejected() {
        HeadGiveRequest request =
                HeadGiveRequest.parse(
                        new String[] {"give", "trophy", "not-a-mob"});

        assertEquals(HeadGiveRequest.Status.UNKNOWN_HEAD, request.status());
        assertTrue(request.trophy());
        assertEquals("not-a-mob", request.requestedKey());
        assertNull(request.headType());
    }
}
