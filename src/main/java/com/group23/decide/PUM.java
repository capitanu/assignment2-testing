package com.group23.decide;

public class PUM {

    public static boolean[][] computePUM(boolean[] CMV, int[][] LCM) {
        if (CMV == null || LCM == null || LCM.length != CMV.length || LCM[0].length != CMV.length) {
            throw new IllegalArgumentException("LCM or CMV are null");
        }
        boolean[][] rtn = new boolean[CMV.length][CMV.length];
        for (int i = 0; i < rtn.length; i++) {
            for (int j = 0; j < rtn[0].length; j++) {
                switch (LCM[i][j]) {
                case Decide.NOTUSED:
                    rtn[i][j] = true;
                    break;
                case Decide.ANDD:
                    rtn[i][j] = CMV[i] && CMV[j];
                    break;
                case Decide.ORR:
                    rtn[i][j] = CMV[i] || CMV[j];
                    break;
                default:
                    throw new IllegalArgumentException("LCM is not properly configured");
                }
            }
        }

        return rtn;
    }

}
