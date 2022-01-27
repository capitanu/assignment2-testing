package com.group23.decide;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class PreconditionsTest {
    @Test
    void checkArgumentSucceedsForTrue() {
        Preconditions.checkArgument(true);
    }

    @Test
    void checkArgumentFailsForFalse() {
        assertThrows(IllegalArgumentException.class, () -> {
            Preconditions.checkArgument(false);
        });
    }

    @Test
    void checkInIntervalSucceedsForValuesInInterval() {
        Preconditions.checkInInterval(50, 0, 100);
    }

    @Test
    void checkInIntervalFailsForValuesNotInInterval() {
        assertThrows(IllegalArgumentException.class, () -> {
            Preconditions.checkInInterval(0, 50, 100);
        });
    }
}
