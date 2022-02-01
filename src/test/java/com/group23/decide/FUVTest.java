package com.group23.decide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for FUV computation
 */
public class FUVTest {

    /**
     * Test case that tests all three of the conditions of the PUM. That is, if one row is full of true, if PUV[i] is
     * false and if PUV[i] is true, but at least one element is false.
     */
    public void testComputeFUV() {
        boolean[][] testPUM = { { false, true, true, true }, { true, true, true, true }, { false, true, true, true },
                { false, true, true, true } };

        boolean[] testFUV = FUV.computeFUV(testPUM);

        assertTrue(testFUV[0]);
        assertTrue(testFUV[1]);
        assertFalse(testFUV[2]);
        assertFalse(testFUV[3]);
    }

}
