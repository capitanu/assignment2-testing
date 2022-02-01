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
     * @param LENGTH1
     *            - The length to be evaluated against
     *
     * @return true if the there exists two consecutive points that are at a distance greater than the param length.
     *         False otherwise.
     */
    public static boolean condition0(int NUMPOINTS, Point[] POINTS, double LENGTH1) {
        for (int i = 0; i < NUMPOINTS - 1; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i + 1];
            if (Point.calculateDistance(p1, p2) > LENGTH1) {
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
     * Function that checks if there exists at least one set of three data points separated by A_PTS and B_PTS that
     * cannot be contained within/on a circle of RADIUS1.
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
     * @param B_PTS
     *            - The amount of points in between points p1 and p2.
     *
     * @param RADIUS1
     *            - The radius of the circle we want to evaluate whether the set {p0, p1, p2} can fit in
     *
     * @return true if there exists at least one set of three data points separated by A_PTS and B_PTS that cannot be
     *         contained within/on a circle of RADIUS1.
     */
    public static boolean condition8(int NUMPOINTS, Point[] POINTS, int A_PTS, int B_PTS, double RADIUS1) {
        // Base cases
        if ((NUMPOINTS < 5) || (A_PTS < 1) || (B_PTS < 1)) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - 2 - A_PTS - B_PTS; i++) {
            Point p0 = POINTS[i];

            // point p1 comes directly after the A_PTS intervening
            Point p1 = POINTS[i + 1 + A_PTS];

            // point p2 comes directly after the B_PTS intervening
            Point p2 = POINTS[i + 2 + A_PTS + B_PTS];

            // This calculates the radius of the smallest circle that contains all 3 points.
            double radiusSmallestCircle = Point.calcRadiusSmallestCircle(p0, p1, p2);

            // if the radius of the smallest circle containing the 3 points is greater than
            // the provided RADIUS1 => the 3 points cannot be contained by a circle with radius RADIUS1.
            if (radiusSmallestCircle > RADIUS1) {
                return true;
            }
        }

        // Didn't find a set of 3 points that could not be contained within a circle with radius RADIUS1.
        return false;
    }

    /**
     * Function that checks if there exists at least one set of three data points separated by C_PTS and D_PTS that form
     * an angle such that angle < (PI - EPSILON) || angle > (PI + EPSILON)
     *
     * @param NUMPOINTS
     *            - The number of data points
     *
     * @param POINTS
     *            - The array of points
     *
     * @param C_PTS
     *            - The amount of points in between points p0 and p1.
     *
     * @param D_PTS
     *            - The amount of points in between points p1 and p2.
     *
     * @param EPSILON
     *            - The value to evaluate the angle against
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition9(int NUMPOINTS, Point[] POINTS, int C_PTS, int D_PTS, double EPSILON) {
        // Base cases
        if ((NUMPOINTS < 5) || (C_PTS < 1) || (D_PTS < 1)) {
            return false;
        }

        for (int i = 0; i < NUMPOINTS - 2 - C_PTS - D_PTS; i++) {
            Point p0 = POINTS[i];

            // point p1 comes directly after the C_PTS intervening
            // p1 is always the vertex of the angle.
            Point p1 = POINTS[i + 1 + C_PTS];

            // point p2 comes directly after the D_PTS intervening
            Point p2 = POINTS[i + 2 + C_PTS + D_PTS];

            // if first or last (or both) points equal to middle(vertex)point => cond not held.
            if ((Point.calculateDistance(p0, p1) != 0) && (Point.calculateDistance(p1, p2) != 0)) {
                double angle = Point.calculateAngle(p0, p1, p2);
                if ((angle < Math.PI - EPSILON) || (angle > Math.PI + EPSILON)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * Function that computes condition 10 of the LIC.
     *
     * @param NUMPOINTS
     *            the number of points
     * @param POINTS
     *            the data points
     * @param AREA1
     *            the area
     * @param E_PTS
     *            the first consecutive distance
     * @param F_PTS
     *            the second consecutive distance
     *
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition10(int NUMPOINTS, Point[] POINTS, double AREA1, int E_PTS, int F_PTS) {
        if (NUMPOINTS < 5 || E_PTS < 1 || F_PTS < 1 || (E_PTS + F_PTS) > (NUMPOINTS - 3))
            return false;
        for (int i = 0; i + E_PTS + F_PTS + 2 < NUMPOINTS; i++) {
            double area = Point.calculateArea(POINTS[i], POINTS[i + E_PTS + 1], POINTS[i + E_PTS + F_PTS + 2]);
            if (area > AREA1)
                return true;
        }
        return false;
    }

    /**
     * Function that computes condition 11 of the LIC.
     *
     * @param NUMPOINTS
     *            the number of points
     * @param POINTS
     *            the data points
     * @param G_PTS
     *            the consecutive distance
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition11(int NUMPOINTS, Point[] POINTS, int G_PTS) {
        if (NUMPOINTS < 3 || G_PTS < 1 || G_PTS > NUMPOINTS - 2)
            return false;
        for (int i = 0; i + G_PTS < NUMPOINTS; i++) {
            if (POINTS[i + G_PTS].getX() - POINTS[i].getX() < 0)
                return true;
        }
        return false;
    }

    /**
     * Function that computes condition 12 of the LIC.
     *
     * @param NUMPOINTS
     *            the number of points
     * @param POINTS
     *            the data points
     * @param K_PTS
     *            the consecutive distance
     * @param LENGTH1
     *            the lower bound distance
     * @param LENGTH2
     *            the upper bound distance
     *
     * @return true if the condition is met, false otherwise
     */
    public static boolean condition12(int NUMPOINTS, Point[] POINTS, int K_PTS, double LENGTH1, double LENGTH2) {
        if (NUMPOINTS < 3 || LENGTH2 < 0)
            return false;
        boolean cond1 = false, cond2 = false;

        for (int i = 0; i + K_PTS + 1 < NUMPOINTS; i++) {
            double dist = Point.calculateDistance(POINTS[i], POINTS[i + K_PTS + 1]);
            if (dist > LENGTH1)
                cond1 = true;
            if (dist < LENGTH2)
                cond2 = true;
            if (cond1 && cond2)
                return true;
        }

        return false;
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
    public static boolean condition14(int NUMPOINTS, Point[] POINTS, int E_PTS, int F_PTS, double AREA1, double AREA2) {
        boolean first = false;
        boolean second = false;

        for (int i = 0; i < NUMPOINTS - 2 - E_PTS - F_PTS; i++) {
            Point p1 = POINTS[i];
            Point p2 = POINTS[i + 1 + E_PTS];
            Point p3 = POINTS[i + 2 + E_PTS + F_PTS];
            double area = Point.calculateArea(p1, p2, p3);

            if (area > AREA1) {
                first = true;
            }

            if (area < AREA2) {
                second = true;
            }
        }

        if (first && second && NUMPOINTS >= 5) {
            return true;
        }

        return false;
    }

    public static boolean[] computeCMV(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, int[][] LCM,
            boolean[] PUV) {
        boolean[] CMV = { condition0(NUMPOINTS, POINTS, PARAMETERS.LENGTH1), condition1(),
                condition2(NUMPOINTS, POINTS, PARAMETERS.EPSILON), condition3(NUMPOINTS, POINTS, PARAMETERS.AREA1),
                condition4(NUMPOINTS, POINTS, PARAMETERS.Q_PTS, PARAMETERS.QUADS), condition5(NUMPOINTS, POINTS),
                condition6(NUMPOINTS, POINTS, PARAMETERS.N_PTS, PARAMETERS.DIST),
                condition7(NUMPOINTS, POINTS, PARAMETERS.K_PTS, PARAMETERS.LENGTH1),
                condition8(NUMPOINTS, POINTS, PARAMETERS.A_PTS, PARAMETERS.B_PTS, PARAMETERS.RADIUS1),
                condition9(NUMPOINTS, POINTS, PARAMETERS.C_PTS, PARAMETERS.D_PTS, PARAMETERS.EPSILON),
                condition10(NUMPOINTS, POINTS, PARAMETERS.AREA1, PARAMETERS.E_PTS, PARAMETERS.F_PTS),
                condition11(NUMPOINTS, POINTS, PARAMETERS.G_PTS),
                condition12(NUMPOINTS, POINTS, PARAMETERS.K_PTS, PARAMETERS.LENGTH1, PARAMETERS.LENGTH2), condition13(),
                condition14(NUMPOINTS, POINTS, PARAMETERS.E_PTS, PARAMETERS.F_PTS, PARAMETERS.AREA1,
                        PARAMETERS.AREA2) };
        return CMV;
    }
}
