package com.group23.decide;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for PUM computation
 */
public class PUMTest {

    public static final int ANDD = 1;
    public static final int ORR = 2;
    public static final int NOTUSED = 3;

    /**
     * Test computePUM throws exception on wrong input
     */
    @Test
    public void computePUMExceptionOnWrongInput() {
        int[][] LCM = { { ANDD, ORR, NOTUSED }, { NOTUSED, ANDD, ORR }, { ORR, ANDD, NOTUSED } };
        assertThrows(IllegalArgumentException.class, () -> PUM.computePUM(null, LCM));
    }

    /**
     * Test computePUM throws exception on wrong input
     */
    @Test
    public void computePUMExceptionOnWrongInput2() {
        int[][] LCM = { { ANDD, ORR, NOTUSED }, { 0, ANDD, ORR }, { ORR, ANDD, 0 } };
        boolean[] CMV = { true, true, false };
        assertThrows(IllegalArgumentException.class, () -> PUM.computePUM(CMV, LCM));
    }

    /**
     * Test computePUM throws exception on wrong input
     */
    @Test
    public void computePUMExceptionOnWrongInput3() {
        int[][] LCM = { { ANDD, ORR, NOTUSED }, { NOTUSED, ANDD, ORR }, { ORR, ANDD, NOTUSED } };
        boolean[] CMV = { true, true };
        assertThrows(IllegalArgumentException.class, () -> PUM.computePUM(CMV, LCM));
    }

    /**
     * Test computePUM throws exception on wrong input
     */
    @Test
    public void computePUMreturnCorrectInput() {
        int[][] LCM = { { ANDD, ORR, ANDD }, { ORR, ANDD, NOTUSED }, { ANDD, NOTUSED, ANDD } };
        boolean[] CMV = { true, true, false };

        boolean[][] PUMatrix = PUM.computePUM(CMV, LCM);

        assertEquals(PUMatrix[0][0], true);
        assertEquals(PUMatrix[0][1], true);
        assertEquals(PUMatrix[0][2], false);
        assertEquals(PUMatrix[1][0], true);
        assertEquals(PUMatrix[1][1], true);
        assertEquals(PUMatrix[1][2], true);
        assertEquals(PUMatrix[2][0], false);
        assertEquals(PUMatrix[2][1], true);
        assertEquals(PUMatrix[2][2], false);
    }
}
