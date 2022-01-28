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
        assertFalse(LIC.condition2(3, new Point[] { p0, p0, p0 }, 1E-1));
    }

    /**
     * Testing that CMV2 accepts inputs expected to be valid
     */
    @Test
    public void cmv2AcceptWorks() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(6, 1);

        assertTrue(LIC.condition2(3, new Point[] { p1, p2, p3 }, 1E-1));
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
        assertFalse(LIC.condition2(3, new Point[] { p1, p2, p3 }, 1E-1));
    }

    /**
     * Testing that CMV3 works on a trivial case
     */
    @Test
    public void cmv3TrivialWorks() {
        // should reject trivial case with identical points and area 0
        Point p0 = new Point(0, 0);
        assertFalse(LIC.condition3(3, new Point[] { p0, p0, p0 }, 1));
    }

    /**
     * Testing that CMV3 accepts inputs expected to be valid
     */
    @Test
    public void cmv3AcceptWorks() {
        // True area = 14
        Point p1 = new Point(0, 0);
        Point p2 = new Point(2, 5);
        Point p3 = new Point(6, 1);

        assertTrue(LIC.condition3(3, new Point[] { p1, p2, p3 }, 13.99));
    }

    /**
     * Testing that CMV3 rejects inputs expected to be invalid
     */
    @Test
    public void cmv3RejectWorks() {
        // should reject points that are all aligned
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 3);
        Point p3 = new Point(4, 4);
        assertFalse(LIC.condition3(3, new Point[] { p1, p2, p3 }, 20));
    }

    /**
     * Testing that CMV4 works on a trivial case
     */
    @Test
    public void cmv4TrivialWorks() {
        // should reject trivial case with 3 quads and 2 point
        Point p0 = new Point(0, 0);
        assertFalse(LIC.condition4(2, new Point[] { p0, p0 }, 2, 3));
    }

    /**
     * Testing that CMV4 rejects 6 points, 4 consecutive within 3 quadrants
     */
    @Test
    public void cmv4FailOn4Consecutive3Quadrant() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(1, 1);
        Point p2 = new Point(2, 1);
        Point p3 = new Point(-1, 3);
        Point p4 = new Point(-2, -2);
        Point p5 = new Point(-2, -7);
        // Should fail since it says MORE than QUADS, not more or equal
        assertFalse(LIC.condition4(6, new Point[] { p0, p1, p2, p3, p4, p5 }, 4, 3));
    }

    /**
     * Testing that CMV4 accepts 6 points, 4 consecutive within 3 quadrants
     */
    @Test
    public void cmv4PassOn4Consecutive3Quadrant() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(-2, 1);
        Point p2 = new Point(-2, -3);
        Point p3 = new Point(1, -3);
        Point p4 = new Point(-2, 5);
        Point p5 = new Point(-10, 20);

        // Should return true since the first 4 points are in 4 quadrants
        assertTrue(LIC.condition4(6, new Point[] { p0, p1, p2, p3, p4, p5 }, 4, 3));
    }

    /**
     * Testing that CMV5 works on a trivial case
     */
    @Test
    public void cmv5TrivialWorks() {
        // should reject trivial case with identical points and x difference 0
        Point p0 = new Point(0, 0);
        assertFalse(LIC.condition5(2, new Point[] { p0, p0 }));
    }

    /**
     * Testing that CMV5 accepts inputs expected to be valid
     */
    @Test
    public void cmv5AcceptWorks() {
        Point p1 = new Point(2, 0);
        Point p2 = new Point(1, 5);

        assertTrue(LIC.condition5(2, new Point[] { p1, p2 }));
    }

    /**
     * Testing that CMV5 rejects inputs expected to be invalid
     */
    @Test
    public void cmv5RejectWorks() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 3);
        assertFalse(LIC.condition5(2, new Point[] { p1, p2 }));
    }

}
