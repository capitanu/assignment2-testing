package com.group23.decide;

public class Decide {

    // Used encoding (similar to #define in C) for abstraction.
    public static final int ANDD = 1;
    public static final int ORR = 2;
    public static final int NOTUSED = 3;

    public static void checkData(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, int[][] LCM, boolean[] PUV) {
        // number of points in the list needs to be equal to the declared NUMPOINTS.
        Preconditions.checkArgument(POINTS.length == NUMPOINTS);

        // The maximum amount of points should be between 2 and 100.
        Preconditions.checkInInterval(NUMPOINTS, 2, 100);

        // The LCM matrix needs to be symmetric
        for (int i = 0; i < LCM.length; i++) {
            for (int j = 0; j < LCM[0].length; j++) {
                Preconditions.checkArgument(LCM[i][j] == LCM[j][i]);
            }
        }

        Preconditions.checkArgument(PARAMETERS.DIST >= 0);
    }

    public static void decide(int NUMPOINTS, Point[] POINTS, Parameters PARAMETERS, int[][] LCM, boolean[] PUV) {

        // Basic checks on the input data
        checkData(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);

        // Compute CMV
        boolean[] CMV = LIC.computeCMV(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);

        // Compute the PUM
        boolean[][] PUMatrix = PUM.computePUM(CMV, LCM);

    }

    public static void main(String[] args) {

        // Input to the function.
        // TODO: Move to a separate file that would be later parsed. - also to be discussed

        int NUMPOINTS = 5;

        Point[] POINTS = new Point[5];
        POINTS[0] = new Point(3, 5);
        POINTS[1] = new Point(2, 1);
        POINTS[2] = new Point(1, 1);
        POINTS[3] = new Point(-1, 7);
        POINTS[4] = new Point(-5, -3);

        Parameters PARAMETERS = new Parameters(7, 8, 9, 3, 4, 4, 6, 6, 7, 13, 8, 9, 9, 10, 10, 11, 12, 13, 14);

        int[][] LCM = {
                { ANDD, ANDD, ORR, ANDD, NOTUSED, NOTUSED, ANDD, ORR, ORR, ANDD, ORR, NOTUSED, NOTUSED, ORR, NOTUSED },
                { ANDD, ANDD, NOTUSED, ORR, ANDD, ANDD, ORR, NOTUSED, ORR, ORR, ANDD, NOTUSED, ORR, ANDD, NOTUSED },
                { ORR, NOTUSED, ANDD, ANDD, ANDD, NOTUSED, NOTUSED, NOTUSED, ORR, ANDD, ANDD, ANDD, NOTUSED, NOTUSED,
                        ORR },
                { ANDD, ORR, ANDD, ANDD, ORR, NOTUSED, ORR, ORR, ANDD, ORR, ANDD, NOTUSED, ORR, ANDD, ANDD },
                { NOTUSED, ANDD, ANDD, ORR, ANDD, ORR, ANDD, NOTUSED, NOTUSED, ORR, ORR, ANDD, NOTUSED, ANDD, ANDD },
                { NOTUSED, ANDD, NOTUSED, NOTUSED, ORR, ANDD, ORR, NOTUSED, ORR, ORR, ANDD, ANDD, NOTUSED, ORR, ORR },
                { ANDD, ORR, NOTUSED, ORR, ANDD, ORR, ANDD, ORR, ORR, NOTUSED, NOTUSED, ANDD, ORR, NOTUSED, ORR },
                { ORR, NOTUSED, NOTUSED, ORR, NOTUSED, NOTUSED, ORR, ANDD, ANDD, NOTUSED, ORR, ORR, ANDD, ANDD,
                        NOTUSED },
                { ORR, ORR, ORR, ANDD, NOTUSED, ORR, ORR, ANDD, ANDD, ORR, ORR, ANDD, NOTUSED, ORR, NOTUSED },
                { ANDD, ORR, ANDD, ORR, ORR, ORR, NOTUSED, NOTUSED, ORR, ANDD, NOTUSED, NOTUSED, ANDD, ORR, ORR },
                { ORR, ANDD, ANDD, ANDD, ORR, ANDD, NOTUSED, ORR, ORR, NOTUSED, ANDD, ORR, ANDD, ORR, NOTUSED },
                { NOTUSED, NOTUSED, ANDD, NOTUSED, ANDD, ANDD, ANDD, ORR, ANDD, NOTUSED, ORR, ANDD, ORR, NOTUSED,
                        NOTUSED },
                { NOTUSED, ORR, NOTUSED, ORR, NOTUSED, NOTUSED, ORR, ANDD, NOTUSED, ANDD, ANDD, ORR, ANDD, ANDD, ANDD },
                { ORR, ANDD, NOTUSED, ANDD, ANDD, ORR, NOTUSED, ANDD, ORR, ORR, ORR, NOTUSED, ANDD, ANDD, ORR },
                { NOTUSED, NOTUSED, ORR, ANDD, ANDD, ORR, ORR, NOTUSED, NOTUSED, ORR, NOTUSED, NOTUSED, ANDD, ORR,
                        ANDD } };

        boolean[] PUV = { true, true, false, true, false, false, false, true, true, false, true, false, true, true,
                false };

        decide(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);

    }
}
