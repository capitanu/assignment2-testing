package com.group23.decide;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.Test;

public class PreconditionsTest {
    @Test
    public void checkArgumentSucceedsForTrue() {
        Preconditions.checkArgument(true);
    }

    @Test
    public void checkArgumentFailsForFalse() {
        assertThrows(IllegalArgumentException.class, () -> Preconditions.checkArgument(false));
    }

    @Test
    public void checkInIntervalSucceedsForValuesInInterval() {
        Preconditions.checkInInterval(50, 0, 100);
    }

    @Test
    public void checkInIntervalFailsForValuesNotInInterval() {
        assertThrows(IllegalArgumentException.class, () -> Preconditions.checkInInterval(0, 50, 100));
    }
}
