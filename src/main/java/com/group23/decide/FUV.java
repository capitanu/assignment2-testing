package com.group23.decide;

public class FUV {

    public static boolean[] computeFUV(boolean[][] PUMatrix) {
        boolean[] rtn = new boolean[PUMatrix.length];

        for (int i = 0; i < PUMatrix.length; i++) {
            rtn[i] = true;
            for (int j = 0; j < PUMatrix[i].length; j++) {
                if (!PUMatrix[i][j]) {
                    rtn[i] = false;
                }
            }
        }

        return rtn;
    }
}
