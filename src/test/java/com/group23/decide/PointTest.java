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

}