package com.group23.decide;

/**
 * Helper class that addressess all the LIC conditions
 */
public class LIC {

    /**
     * Function that checks if there exists at least one pair of consecutive points that are at a distance greater than
     * Length apart.
     *
     * @param NUMPOINTS
     *            - The number of data points
     *
     * @param POINTS
     *            - The array of points
     *
     * @param Length
     *            - The length to be evaluated against
     *
     * @return true if the there exists two consecutive points that are at a distance greater than the param length.
     *         False otherwise.
     */
    public static boolean condition0(int NUMPOINTS, Point[] POINTS, double Length) {
        for (int i = 0; i < NUMPOINTS - 1; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i + 1];
            if (Point.calculateDistance(p1, p2) > Length) {
                return true;
            }
        }
        return false;
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
     * @param NUMPOINTS
     *            the number of data points
     * @param POINTS
     *            the data points
     * @param Q_PTS
     *            the number of expected consecutive points
     * @param QUADS
     *            the number of quadrants
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition4(int NUMPOINTS, Point[] POINTS, int Q_PTS, int QUADS) {

        for (int i = 0; i <= NUMPOINTS - Q_PTS; i++) {
            boolean[] q_filled = { false, false, false, false };
            for (int j = i; j - i < Q_PTS; j++) {
                if (POINTS[j].getX() == 0) {
                    if (POINTS[j].getY() >= 0) {
                        q_filled[0] = true;
                        continue;
                    } else {
                        q_filled[2] = true;
                        continue;
                    }
                }
                if (POINTS[j].getY() == 0) {
                    if (POINTS[j].getX() >= 0) {
                        q_filled[0] = true;
                        continue;
                    } else {
                        q_filled[1] = true;
                        continue;
                    }
                }
                if (POINTS[j].getX() > 0 && POINTS[j].getY() > 0) {
                    q_filled[0] = true;
                    continue;
                }
                if (POINTS[j].getX() < 0 && POINTS[j].getY() > 0) {
                    q_filled[1] = true;
                    continue;
                }
                if (POINTS[j].getX() < 0 && POINTS[j].getY() < 0) {
                    q_filled[2] = true;
                    continue;
                }
                if (POINTS[j].getX() > 0 && POINTS[j].getY() < 0) {
                    q_filled[3] = true;
                    continue;
                }
            }
            int cnt = 0;
            for (int quads = 0; quads < 4; quads++) {
                if (q_filled[quads])
                    cnt++;
            }

            if (cnt > QUADS)
                return true;
        }
        return false;
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
     * @param NUMPOINTS
     *            the number of data points
     * @param POINTS
     *            the data points
     * @param N_PTS
     *            the number of expected consecutive points
     * @param DIST
     *            the distance to be checked with
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition6(int NUMPOINTS, Point[] POINTS, int N_PTS, double DIST) {
        if (NUMPOINTS < 3) {
            return false;
        }
        for (int i = 0; i <= NUMPOINTS - N_PTS; i++) {
            if (POINTS[i].equals(POINTS[N_PTS + i - 1])) {
                for (int j = i + 1; j - i + 1 < N_PTS; j++) {
                    if (Point.calculateDistance(POINTS[i], POINTS[j]) > DIST)
                        return true;
                }
            } else {
                for (int j = i + 1; j - i + 1 < N_PTS; j++) {
                    if (Point.calculateDistanceFromPointToLine(POINTS[j], POINTS[i], POINTS[i + N_PTS - 1]) > DIST)
                        return true;
                }
            }
        }
        return false;
    }

    /**
     * Function that computes condition 7 of the LIC.
     *
     * @param NUMPOINTS
     *            the number of points
     * @param POINTS
     *            the data points
     * @param K_PTS
     *            the consecutive distance
     * @param LENGTH1
     *            the distance of the points
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition7(int NUMPOINTS, Point[] POINTS, int K_PTS, double LENGTH1) {
        if (NUMPOINTS < 3)
            return false;
        for (int i = 0; i + K_PTS - 1 < NUMPOINTS; i++) {
            if (Point.calculateDistance(POINTS[i], POINTS[i + K_PTS - 1]) > LENGTH1)
                return true;
        }
        return false;
    }

    /**
     * Function that checks if there exists at least one set of three data points separated by
     * A_PTS and B_PTS that cannot be contained within/on a circle of RADIUS1.
     *
     * @param NUMPOINTS
     *            - The number of data points
     *
     * @param POINTS
     *            - The array of points
     *
     * @param A_PTS
     *            - The amount of points in between points p0 and p1.
     *
     * @param B_PTS - The amount of points in between points p1 and p2.
     *
     * @param RADIUS1 - The radius of the circle we want to evaluate whether the set {p0, p1, p2}
     *                can fit in
     *
     * @return true if there exists at least one set of three data points separated by A_PTS and B_PTS
     *  that cannot be contained within/on a circle of RADIUS1.
     */
    public static boolean condition8(int NUMPOINTS, Point[] POINTS, int A_PTS, int B_PTS, int RADIUS1) {
        // Base cases
        if((NUMPOINTS < 5) || (A_PTS < 1) || (B_PTS < 1)){
            return false;
        }

        for(int i = 0; i < NUMPOINTS - 2 - A_PTS - B_PTS; i++){
            Point p0 = POINTS[i];

            // Don't think this point is necessary, makes code easier to understand though :P
            Point p1 = POINTS[i + 1 + A_PTS];

            Point p2 = POINTS[i + 2 + A_PTS + B_PTS];

            // If points p0 and p2 are nearer each other than the diameter (RADIUS*2), then its true
            if(Point.calculateDistance(p0, p2) < RADIUS1*2){
                return true;
            }
        }

        // Didn't find a set of 3 points that could be contained within a circle with radius RADIUS1.
        return false;
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
