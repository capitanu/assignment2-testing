package com.group23.decide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integrations tests for the whole flow of the application
 */
public class IntegrationTests {

    public static final int ANDD = 1;
    public static final int ORR = 2;
    public static final int NOTUSED = 3;

    /**
     * Integration test #1 is suppossed to check the whole flow. This is done by manually setting input variables and
     * running the DECIDE program and checking the final output.
     * 
     * This test runs the configurations in such way that the program should consider to LAUNCH. The test is run twice
     * In order to manually do what the decide() function does (and thus checking the final output), but also the
     * intermediate steps
     *
     * Expected output: true
     */
    @Test
    public void testDecide() {
        // Input to the function.
        int NUMPOINTS = 10;

        Point[] POINTS = new Point[10];
        POINTS[0] = new Point(0, 0);
        POINTS[1] = new Point(-21.2, 12);
        POINTS[2] = new Point(5.1, -2.3);
        POINTS[3] = new Point(-4.5, -3);
        POINTS[4] = new Point(3, 2.78);
        POINTS[5] = new Point(-4.32, -3.1);
        POINTS[6] = new Point(7, 2.32);
        POINTS[7] = new Point(3.14, 3.14);
        POINTS[8] = new Point(1.3, 3.7);
        POINTS[9] = new Point(8.38, -6.7);

        Parameters PARAMETERS = new Parameters(13, 3.2, 1, 10.4, 3, 3, 7.78, 4, 2, 1, 1, 2, 3, 2, 1, 1, 7.32, 8.3, 5);

        int[][] LCM = {
                { ANDD, ANDD, ORR, ANDD, NOTUSED, ANDD, ORR, NOTUSED, NOTUSED, NOTUSED, ORR, NOTUSED, ANDD, ANDD, ORR },
                { ANDD, ANDD, ANDD, ANDD, NOTUSED, ORR, ORR, NOTUSED, ANDD, NOTUSED, NOTUSED, NOTUSED, ANDD, NOTUSED,
                        ORR },
                { ORR, ANDD, ANDD, ANDD, ANDD, ORR, NOTUSED, ORR, ANDD, NOTUSED, ORR, NOTUSED, NOTUSED, ANDD, ORR },
                { ANDD, ANDD, ANDD, ANDD, ORR, NOTUSED, ORR, ORR, ORR, ANDD, ANDD, NOTUSED, ORR, NOTUSED, NOTUSED },
                { NOTUSED, NOTUSED, ANDD, ORR, ANDD, ANDD, ORR, ANDD, NOTUSED, ORR, ORR, ANDD, ORR, NOTUSED, ORR },
                { ANDD, ORR, ORR, NOTUSED, ANDD, ANDD, NOTUSED, ANDD, ANDD, ANDD, NOTUSED, ORR, NOTUSED, NOTUSED,
                        NOTUSED },
                { ORR, ORR, NOTUSED, ORR, ORR, NOTUSED, ANDD, ANDD, ANDD, NOTUSED, NOTUSED, NOTUSED, ORR, ORR, ANDD },
                { NOTUSED, NOTUSED, ORR, ORR, ANDD, ANDD, ANDD, ANDD, ORR, ORR, ORR, ORR, ORR, NOTUSED, NOTUSED },
                { NOTUSED, ANDD, ANDD, ORR, NOTUSED, ANDD, ANDD, ORR, ANDD, ANDD, NOTUSED, ANDD, NOTUSED, ANDD, ANDD },
                { NOTUSED, NOTUSED, NOTUSED, ANDD, ORR, ANDD, NOTUSED, ORR, ANDD, ANDD, ORR, ORR, NOTUSED, ORR, ANDD },
                { ORR, NOTUSED, ORR, ANDD, ORR, NOTUSED, NOTUSED, ORR, NOTUSED, ORR, ANDD, ANDD, ANDD, ORR, ORR },
                { NOTUSED, NOTUSED, NOTUSED, NOTUSED, ANDD, ORR, NOTUSED, ORR, ANDD, ORR, ANDD, ANDD, ANDD, ORR,
                        NOTUSED },
                { ANDD, ANDD, NOTUSED, ORR, ORR, NOTUSED, ORR, ORR, NOTUSED, NOTUSED, ANDD, ANDD, ANDD, ANDD, ANDD },
                { ANDD, NOTUSED, ANDD, NOTUSED, NOTUSED, NOTUSED, ORR, NOTUSED, ANDD, ORR, ORR, ORR, ANDD, ANDD,
                        NOTUSED },
                { ORR, ORR, ORR, NOTUSED, ORR, NOTUSED, ANDD, NOTUSED, ANDD, ANDD, ORR, NOTUSED, ANDD, NOTUSED,
                        ANDD }, };

        boolean[] PUV = { true, true, false, true, false, false, false, false, true, false, true, false, true, true,
                true };

        Decide.checkData(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);

        /*
         * CMV true, true, true, true, false, true, true, false, true, true, true, true, true, true, true,
         */
        boolean[] CMV = LIC.computeCMV(NUMPOINTS, POINTS, PARAMETERS);
        boolean[] expectedCMV = { true, true, true, true, false, true, true, true, true, true, true, true, true, true,
                true };
        assertArrayEquals(CMV, expectedCMV);

        boolean[][] PUMatrix = PUM.computePUM(CMV, LCM);
        boolean[][] expectedPUM = {
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, false, true, false, false, true, false, true, true, true, false, true, true, true },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true } };
        assertArrayEquals(PUMatrix, expectedPUM);

        boolean[] FUVector = FUV.computeFUV(PUV, PUMatrix);
        boolean[] expectedFUV = { true, true, true, true, true, true, true, true, true, true, true, true, true, true,
                true };
        assertArrayEquals(FUVector, expectedFUV);

        // The LAUNCH should be true
        assertTrue(Decide.decide(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV));
    }

    /**
     * Integration test #2 is suppossed to check the whole flow. This is done by manually setting input variables and
     * running the DECIDE program and checking the final output.
     * 
     * This test runs the configurations in such way that the program should not LAUNCH. The test is run twice In order
     * to manually do what the decide() function does (and thus checking the final output), but also the intermediate
     * steps
     *
     * Expected output: false
     */
    @Test
    public void testDecideFalse() {
        // Input to the function.
        int NUMPOINTS = 10;

        Point[] POINTS = new Point[10];
        POINTS[0] = new Point(0, 0);
        POINTS[1] = new Point(23.4, -2);
        POINTS[2] = new Point(-3, -21);
        POINTS[3] = new Point(-8, 4.2);
        POINTS[4] = new Point(12.2, 3.4);
        POINTS[5] = new Point(-3.12, -4.12);
        POINTS[6] = new Point(7.1, 2.32);
        POINTS[7] = new Point(25, 25);
        POINTS[8] = new Point(1.54, 4.3);
        POINTS[9] = new Point(9.42, -7.5);

        Parameters PARAMETERS = new Parameters(10, 1, 0.01, 400, 3, 2, 100, 10, 1, 2, 1, 2, 2, 1, 1, 4, 20, 15, 5);

        int[][] LCM = {
                { ANDD, ORR, ANDD, ORR, ORR, ANDD, ORR, NOTUSED, NOTUSED, NOTUSED, NOTUSED, ANDD, NOTUSED, ORR, ORR },
                { ORR, ANDD, ORR, NOTUSED, NOTUSED, NOTUSED, ANDD, ORR, ANDD, NOTUSED, ORR, ORR, NOTUSED, ORR, ANDD },
                { ANDD, ORR, ANDD, NOTUSED, ORR, NOTUSED, ORR, ORR, ANDD, NOTUSED, ORR, ANDD, ANDD, ORR, NOTUSED },
                { ORR, NOTUSED, NOTUSED, ANDD, NOTUSED, ORR, NOTUSED, ORR, NOTUSED, ORR, NOTUSED, ORR, NOTUSED, NOTUSED,
                        NOTUSED },
                { ORR, NOTUSED, ORR, NOTUSED, ANDD, ORR, ORR, ORR, ORR, ANDD, ORR, ORR, ANDD, ORR, ORR },
                { ANDD, NOTUSED, NOTUSED, ORR, ORR, ANDD, NOTUSED, ANDD, NOTUSED, NOTUSED, NOTUSED, ORR, NOTUSED, ORR,
                        NOTUSED },
                { ORR, ANDD, ORR, NOTUSED, ORR, NOTUSED, ANDD, ANDD, NOTUSED, ORR, ORR, NOTUSED, ANDD, ORR, NOTUSED },
                { NOTUSED, ORR, ORR, ORR, ORR, ANDD, ANDD, ANDD, ANDD, ORR, ANDD, ANDD, NOTUSED, ORR, ORR },
                { NOTUSED, ANDD, ANDD, NOTUSED, ORR, NOTUSED, NOTUSED, ANDD, ANDD, NOTUSED, ORR, ORR, ANDD, ANDD, ORR },
                { NOTUSED, NOTUSED, NOTUSED, ORR, ANDD, NOTUSED, ORR, ORR, NOTUSED, ANDD, ANDD, ORR, NOTUSED, NOTUSED,
                        ORR },
                { NOTUSED, ORR, ORR, NOTUSED, ORR, NOTUSED, ORR, ANDD, ORR, ANDD, ANDD, NOTUSED, NOTUSED, ANDD, ORR },
                { ANDD, ORR, ANDD, ORR, ORR, ORR, NOTUSED, ANDD, ORR, ORR, NOTUSED, ANDD, NOTUSED, ANDD, NOTUSED },
                { NOTUSED, NOTUSED, ANDD, NOTUSED, ANDD, NOTUSED, ANDD, NOTUSED, ANDD, NOTUSED, NOTUSED, NOTUSED, ANDD,
                        NOTUSED, NOTUSED },
                { ORR, ORR, ORR, NOTUSED, ORR, ORR, ORR, ORR, ANDD, NOTUSED, ANDD, ANDD, NOTUSED, ANDD, NOTUSED },
                { ORR, ANDD, NOTUSED, NOTUSED, ORR, NOTUSED, NOTUSED, ORR, ORR, ORR, ORR, NOTUSED, NOTUSED, NOTUSED,
                        ANDD }, };
        boolean[] PUV = { true, false, true, true, true, false, true, false, false, true, true, true, false, false,
                true };

        Decide.checkData(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);

        boolean[] CMV = LIC.computeCMV(NUMPOINTS, POINTS, PARAMETERS);
        boolean[] expectedCMV = { true, true, true, false, true, true, false, true, true, true, false, true, true, true,
                false };

        assertArrayEquals(CMV, expectedCMV);

        boolean[][] PUMatrix = PUM.computePUM(CMV, LCM);
        boolean[][] expectedPUM = {
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, false, true, true, true, true, true, true, true, false },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, false, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, false, true, true, true, true, false, false, true, true, false, true, false, true, true },
                { true, true, true, true, true, true, false, true, true, true, false, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, false, true, true, true, true },
                { true, true, true, true, true, true, false, false, true, false, false, true, true, false, false },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, false, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, false, true, true, true, true },
                { true, false, true, true, true, true, true, true, true, true, false, true, true, true, false }, };

        assertArrayEquals(PUMatrix, expectedPUM);

        boolean[] FUVector = FUV.computeFUV(PUV, PUMatrix);
        boolean[] expectedFUV = { true, true, true, false, true, true, false, true, true, false, false, true, true,
                true, false };
        assertArrayEquals(FUVector, expectedFUV);

        // The LAUNCH should be false
        assertFalse(Decide.decide(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV));
    }

    /**
     * Integration test #3 is suppossed to check the whole flow. This is done by manually setting input variables and
     * running the DECIDE program and checking the final output.
     * 
     * This test runs the configurations in such way that the program should not LAUNCH.
     *
     * Expected output: false
     */
    @Test
    public void testNoLaunch() {
        // Input to the function.
        int NUMPOINTS = 10;

        Point[] POINTS = new Point[10];
        POINTS[0] = new Point(0, 0);
        POINTS[1] = new Point(5, 3);
        POINTS[2] = new Point(5, -2.3);
        POINTS[3] = new Point(-4.5, -3);
        POINTS[4] = new Point(3, 5.9);
        POINTS[5] = new Point(-4.2, -5.1);
        POINTS[6] = new Point(1, 2.2);
        POINTS[7] = new Point(14, 31);
        POINTS[8] = new Point(1.3, -3);
        POINTS[9] = new Point(8.8, -6.7);

        Parameters PARAMETERS = new Parameters(13, 3.2, 1, 10, 3, 3, 10, 4, 2, 1, 1, 2, 3, 2, 1, 1, 7.32, 8.3, 5);

        int[][] LCM = {
                { ANDD, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, NOTUSED, ORR, ORR, ORR, NOTUSED, ORR, ORR,
                        NOTUSED },
                { NOTUSED, ANDD, ANDD, NOTUSED, ANDD, ORR, NOTUSED, ANDD, ANDD, ORR, ANDD, ORR, ORR, ORR, ORR },
                { NOTUSED, ANDD, ANDD, ORR, ANDD, ANDD, ORR, NOTUSED, ANDD, ORR, ANDD, NOTUSED, NOTUSED, ORR, NOTUSED },
                { NOTUSED, NOTUSED, ORR, ANDD, ORR, NOTUSED, ANDD, NOTUSED, ORR, ANDD, NOTUSED, ORR, ORR, NOTUSED,
                        ANDD },
                { NOTUSED, ANDD, ANDD, ORR, ANDD, NOTUSED, ORR, ANDD, ANDD, NOTUSED, ORR, ANDD, NOTUSED, NOTUSED,
                        NOTUSED },
                { NOTUSED, ORR, ANDD, NOTUSED, NOTUSED, ANDD, NOTUSED, ANDD, ANDD, ORR, ANDD, ANDD, NOTUSED, NOTUSED,
                        ANDD },
                { NOTUSED, NOTUSED, ORR, ANDD, ORR, NOTUSED, ANDD, ANDD, NOTUSED, NOTUSED, NOTUSED, ANDD, ANDD, ANDD,
                        ANDD },
                { NOTUSED, ANDD, NOTUSED, NOTUSED, ANDD, ANDD, ANDD, ANDD, NOTUSED, NOTUSED, ANDD, NOTUSED, ANDD, ANDD,
                        ANDD },
                { ORR, ANDD, ANDD, ORR, ANDD, ANDD, NOTUSED, NOTUSED, ANDD, NOTUSED, ANDD, ANDD, ORR, ANDD, NOTUSED },
                { ORR, ORR, ORR, ANDD, NOTUSED, ORR, NOTUSED, NOTUSED, NOTUSED, ANDD, NOTUSED, ANDD, ANDD, ORR,
                        NOTUSED },
                { ORR, ANDD, ANDD, NOTUSED, ORR, ANDD, NOTUSED, ANDD, ANDD, NOTUSED, ANDD, ANDD, ANDD, NOTUSED, ORR },
                { NOTUSED, ORR, NOTUSED, ORR, ANDD, ANDD, ANDD, NOTUSED, ANDD, ANDD, ANDD, ANDD, ANDD, ANDD, ORR },
                { ORR, ORR, NOTUSED, ORR, NOTUSED, NOTUSED, ANDD, ANDD, ORR, ANDD, ANDD, ANDD, ANDD, ANDD, ORR },
                { ORR, ORR, ORR, NOTUSED, NOTUSED, NOTUSED, ANDD, ANDD, ANDD, ORR, NOTUSED, ANDD, ANDD, ANDD, ORR },
                { NOTUSED, ORR, NOTUSED, ANDD, NOTUSED, ANDD, ANDD, ANDD, NOTUSED, NOTUSED, ORR, ORR, ORR, ORR,
                        ANDD }, };

        boolean[] PUV = { true, true, false, true, false, true, true, true, true, true, true, true, true, true, true };

        Decide.checkData(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV);

        boolean[] CMV = LIC.computeCMV(NUMPOINTS, POINTS, PARAMETERS);

        boolean[] expectedCMV = { true, true, true, true, false, true, true, true, true, true, true, true, true, true,
                false };
        assertArrayEquals(CMV, expectedCMV);

        boolean[][] PUMatrix = PUM.computePUM(CMV, LCM);
        boolean[][] expectedPUM = {
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, false },
                { true, false, false, true, false, true, true, false, false, true, true, false, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, false },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, false },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, false },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, false, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, true, true, true, true, true, true, true, true, true, true, true, true },
                { true, true, true, false, true, false, false, false, true, true, true, true, true, true, false }, };
        assertArrayEquals(PUMatrix, expectedPUM);

        boolean[] FUVector = FUV.computeFUV(PUV, PUMatrix);
        boolean[] expectedFUV = { true, false, true, false, true, false, false, false, false, true, true, false, true,
                true, false };
        assertArrayEquals(FUVector, expectedFUV);

        // The LAUNCH should be false
        assertFalse(Decide.decide(NUMPOINTS, POINTS, PARAMETERS, LCM, PUV));
    }
}
