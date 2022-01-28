package com.group23.decide;

/**
 * Helper class that addressess all the LIC conditions
 */
public class LIC {

    /**
     * Function that computes condition 0 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition0() {
        // TODO: Write condition 0 of the LIC
        return true;
    }

    /**
     * Function that computes condition 1 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition1() {
        // TODO: Write condition 1 of the LIC
        return true;
    }

    /**
     * Checks if there exists 3 consecutive that form an angle smaller than PI - EPSILON or greater than PI + EPSILON.
     * The vertex of the angle must also be distinct from the two other points
     *
     * @param NUMPOINTS
     *            - the number of data points
     * @param POINTS
     *            - data points
     * @param EPSILON
     *            - epsilon used in the condition
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition2(int NUMPOINTS, Point[] POINTS, double EPSILON) {
        for (int i = 0; i < NUMPOINTS - 2; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i + 1]; // vertex of the angle
            Point p3 = POINTS[i + 2];
            if (Point.calculateDistance(p1, p2) != 0 && Point.calculateDistance(p2, p3) != 0) {
                double angle = Point.calculateAngle(p1, p2, p3);
                if (angle < Math.PI - EPSILON || angle > Math.PI + EPSILON)
                    return true;
            }
        }
        return false;
    }

    /**
     * Checks if there exists at least one set of 3 consecutive points that are the vertices of a triangle of area
     * greater than AREA1
     *
     * @param NUMPOINTS
     *            - the number of data points
     * @param POINTS
     *            - data points
     * @param AREA1
     *            - threshold value
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition3(int NUMPOINTS, Point[] POINTS, double AREA1) {
        for (int i = 0; i < NUMPOINTS - 2; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i + 1];
            Point p3 = POINTS[i + 2];

            double area = Math.abs((p1.getX() * (p2.getY() - p3.getY()) + p2.getX() * (p3.getY() - p1.getY())
                    + p3.getX() * (p1.getY() - p2.getY())) / 2.0);

            if (area > AREA1)
                return true;

        }
        return false;
    }

    /**
     * Function that computes condition 4 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition4() {
        // TODO: Write condition 4 of the LIC
        return true;
    }

    /**
     * Checks if there exists at least one set of 2 consecutive data points such that p2.x - p1.x < 0.
     *
     * @param NUMPOINTS
     *            - the number of data points
     * @param POINTS
     *            - data points
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition5(int NUMPOINTS, Point[] POINTS) {
        for (int i = 0; i < NUMPOINTS - 1; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i + 1];

            if (p2.getX() - p1.getX() < 0)
                return true;

        }
        return false;
    }

    /**
     * Function that computes condition 6 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition6() {
        // TODO: Write condition 6 of the LIC
        return true;
    }

    /**
     * Function that computes condition 7 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition7() {
        // TODO: Write condition 7 of the LIC
        return true;
    }

    /**
     * Function that computes condition 8 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition8() {
        // TODO: Write condition 8 of the LIC
        return true;
    }

    /**
     * Function that computes condition 9 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition9() {
        // TODO: Write condition 9 of the LIC
        return true;
    }

    /**
     * Function that computes condition 10 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition10() {
        // TODO: Write condition 10 of the LIC
        return true;
    }

    /**
     * Function that computes condition 11 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition11() {
        // TODO: Write condition 11 of the LIC
        return true;
    }

    /**
     * Function that computes condition 12 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition12() {
        // TODO: Write condition 12 of the LIC
        return true;
    }

    /**
     * Function that computes condition 13 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition13() {
        // TODO: Write condition 13 of the LIC
        return true;
    }

    /**
     * Function that computes condition 14 of the LIC.
     *
     * @param ...
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition14() {
        // TODO: Write condition 14 of the LIC
        return true;
    }

    public static boolean[] computeCMV() {
        // TODO: Replace this with the function calls to all the conditions
        boolean[] CMV = { false, true, true };
        return CMV;
    }
}
