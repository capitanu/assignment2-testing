package com.group23.decide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for LIC, testing mainly the CMVs
 */
public class LICTest {

    /**
     * Testing that CMV2 works on a trivial case
     */
    @Test
    public void cmv2TrivialWorks() {
        // should reject trivial case with identical points
        Point p0 = new Point(0, 0);
        assertFalse(LIC.condition2(3, new Point[]{p0, p0, p0}, 1E-1));
    }

    /**
     * Testing that CMV2 accepts inputs expected to be valid
     */
    @Test
    public void cmv2AcceptWorks() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(6, 1);

        assertTrue(LIC.condition2(3, new Point[]{p1, p2, p3}, 1E-1));
    }

    /**
     * Testing that CMV2 rejects inputs expected to be invalid
     */
    @Test
    public void cmv2RejectWorks() {
        // should reject points that are all aligned
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 3);
        Point p3 = new Point(4, 4);
        assertFalse(LIC.condition2(3, new Point[]{p1, p2, p3}, 1E-1));
    }

}