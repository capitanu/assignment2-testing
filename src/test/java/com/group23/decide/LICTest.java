package com.group23.decide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for LIC, testing mainly the CMVs
 */
public class LICTest {

    /**
     * Testing that CMV0 works on a trivial case
     */
    @Test
    public void cmv0TrivialWorks() {
        Point p0 = new Point(0, 0);
        // Sending in the same point twice should return false since there aren't
        // two points with a distance of Length apart
        assertFalse(LIC.condition0(2, new Point[] { p0, p0 }, 1));
    }

    /**
     * Testing that CMV0 accepts inputs expected to be valid
     */
    @Test
    public void cmv0AcceptWorks() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(3, 3);
        // Distance from (0,0) -> (3,3) is sqrt(18) > Length 1 => Should return true
        assertTrue(LIC.condition0(2, new Point[] { p0, p1 }, 1));
    }

    /**
     * Testing that CMV0 rejects inputs expected to be invalid
     */
    @Test
    public void cmv0RejectWorks() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(3, 3);
        // Distance from (0,0) -> (3,3) is sqrt(18) < Length 10 => Should return false
        assertFalse(LIC.condition0(2, new Point[] { p0, p1 }, 10));
    }

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

    /**
     * Testing that CMV7 rejects inputs expected to be invalid
     */
    @Test
    public void cmv7RejectInvalid() {
        Point p1 = new Point(2, 2);
        Point p2 = new Point(3, 3);
        assertFalse(LIC.condition7(2, new Point[] { p1, p2 }, 2, 1.5));
    }

    /**
     * Testing that CMV7 rejects input not satisfied
     */
    @Test
    public void cmv7RejectWorks() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(-1, 1);
        Point p4 = new Point(1, 1);
        assertFalse(LIC.condition7(5, new Point[] { p0, p1, p2, p3, p4 }, 3, Math.sqrt(2)));
    }

    /**
     * Testing that CMV7 pass input not satisfied
     */
    @Test
    public void cmv7PassWorks() {
        Point p0 = new Point(0, 0);
        Point p1 = new Point(0, 1);
        Point p2 = new Point(1, 0);
        Point p3 = new Point(-1, 1);
        Point p4 = new Point(2, 1);
        assertTrue(LIC.condition7(5, new Point[] { p0, p1, p2, p3, p4 }, 3, Math.sqrt(2) - 0.001));
    }

    /**
     * Testing that CMV12 rejects incorrect NUMPOINTS
     */
    @Test
    public void cmv12RejectInvalidNumPoints() {
        Point[] points = new Point[] { new Point(0, 0), new Point(0, 1), };

        int K_PTS = 1;
        double LENGTH1 = 0.5;
        double LENGTH2 = 1.5;
        assertFalse(LIC.condition12(points.length, points, K_PTS, LENGTH1, LENGTH2));
    }

    /**
     * Testing that CMV12 rejects case where no points fullfill condition
     */
    @Test
    public void cmv12RejectInvalid() {
        Point[] points = new Point[] { new Point(0, 0), new Point(0, 1), new Point(1, 1), };

        int K_PTS = 1;
        double LENGTH1 = 0.5;
        double LENGTH2 = 0.2;
        assertFalse(LIC.condition12(points.length, points, K_PTS, LENGTH1, LENGTH2));
    }

    /**
     * Testing that CMV12 accepts a trivial case
     */
    @Test
    public void cmv12AcceptTrivial() {
        Point[] points = new Point[] { new Point(0, 0), new Point(0, 1), new Point(-1, 1), };

        int K_PTS = 1;
        double LENGTH1 = 0.5;
        double LENGTH2 = 1.5;
        assertTrue(LIC.condition12(points.length, points, K_PTS, LENGTH1, LENGTH2));
    }

    /**
     * Testing that CMV12 accepts a non-trivial case with many points
     */
    @Test
    public void cmv12AcceptWorks() {
        Point[] points = new Point[] { new Point(0, 0), new Point(0, 1), new Point(-1, 1), new Point(2, 5),
                new Point(-1, 1), };

        int K_PTS = 2;
        double LENGTH1 = 0.5;
        double LENGTH2 = 2.5;
        assertTrue(LIC.condition12(points.length, points, K_PTS, LENGTH1, LENGTH2));
    }

}
