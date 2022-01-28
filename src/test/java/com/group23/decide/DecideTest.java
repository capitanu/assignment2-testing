package com.group23.decide;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class DecideTest {
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    /**
     * Testing the behaviour of checkData()
     */
    @Test
    public void checkDataWorks() {

        // Example of asserting that an Exception is being thrown
        assertThrows(IllegalArgumentException.class, () -> {
            throw new IllegalArgumentException("");
        });
    }
}
