package com.group23.decide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class PointTest {
    /**
     * Testing the behaviour of calculateDistance() where the actual distance is an integer
     */
    @Test
    public void checkCalcDistInteger() {
        // Two points to be evaluated
        Point point1 = new Point(2, 5);
        Point point2 = new Point(5, 1);

        // The actual value of the distance
        double expectedResult = 5;

        assertEquals(Point.calculateDistance(point1, point2), expectedResult);
    }

    /**
     * Testing the behaviour of calculateDistance() where the actual distance is not an integer, i.e. a digit with
     * decimals :)
     */
    @Test
    public void checkCalcDistDouble() {
        // Two points to be evaluated
        Point point1 = new Point(1, 8);
        Point point2 = new Point(4, 6);

        // The *actual* actual value of the distance. Not rounded down
        double expectedResult = Math.sqrt(13);

        assertEquals(Point.calculateDistance(point1, point2), expectedResult);
    }

    /**
     * Testing the behaviour of calculateAngle()
     */
    @Test
    public void checkCalcAngle() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(0, 0); // vertex of the angle
        Point p3 = new Point(0, 1);

        assertEquals(Point.calculateAngle(p1, p2, p3), Math.PI / 2, 1E-6);

    }

    /**
     * Testing the behaviour of calculateArea()
     */
    @Test
    public void checkCalcArea() {
        Point p1 = new Point(0, 0);
        Point p2 = new Point(0, 5); // vertex of the angle
        Point p3 = new Point(2, 1);

        assertEquals(Point.calculateArea(p1, p2, p3), 1, 5.0);

    }

    /**
     * Testing the behaviour of calculateDistanceFromPointToLine()
     */
    @Test
    public void checkCalculateDistanceFromPointToLine() {
        Point p1 = new Point(1, 0);
        Point p2 = new Point(0, 0);
        Point p3 = new Point(1, 1);

        assertEquals(Point.calculateDistanceFromPointToLine(p1, p2, p3), Math.sqrt(2) / 2, 1E-6);
    }

    /**
     * Testing the behaviour of equals if points are not equal
     */
    @Test
    public void checkPointNotEqual() {
        Point pt1 = new Point(1, 0);
        Point pt2 = new Point(0, 0);
        assertFalse(pt1.equals(pt2));
    }

    /**
     * Testing the behaviour of equals if points are equal
     */
    @Test
    public void checkPointEqual() {
        Point pt1 = new Point(1, 0);
        Point pt2 = new Point(1, 0);
        assertTrue(pt1.equals(pt2));
    }
}
