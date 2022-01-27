package com.group23.decide;

/**
 * Helper class to define the PARAMETERS struct as defined by the requirements
 */
public class Parameters {

    public double LENGTH1; // Length in LICs 0, 7, 12
    public double RADIUS1; // Radius in LICs 1, 8, 13
    public double EPSILON; // Deviation from PI in LICs 2, 9
    public double AREA1; // Area in LICs 3, 10, 14
    public int Q_PTS; // No. of consecutive points in LIC 4
    public int QUADS; // No. of quadrants in LIC 4
    public double DIST; // Distance in LIC 6
    public int N_PTS; // No. of consecutive pts. in LIC 6
    public int K_PTS; // No. of int pts. in LIC 7, 12
    public int A_PTS; // No. of int pts. in LIC 8, 13
    public int B_PTS; // No. of int pts. in LIC 8, 13
    public int C_PTS; // No. of int pts. in LIC 9
    public int D_PTS; // No. of int pts. in LIC 9
    public int E_PTS; // No. of int pts. in LIC 10, 14
    public int F_PTS; // No. of int pts. in LIC 10, 14
    public int G_PTS; // No. of int pts. in LIC 11
    public double LENGTH2; // Maximum length in LIC 12
    public double RADIUS2; // Maximum radius in LIC 13
    public double AREA2; // Maximum area in LIC 14

    /**
     * Constructor that creates the parameters struct.
     */
    public Parameters(double LENGTH1, double RADIUS1, double EPSILON, double AREA1, int Q_PTS, int QUADS, double DIST,
            int N_PTS, int A_PTS, int K_PTS, int B_PTS, int C_PTS, int D_PTS, int E_PTS, int F_PTS, int G_PTS,
            double LENGTH2, double RADIUS2, double AREA2) {
        this.LENGTH1 = LENGTH1;
        this.RADIUS1 = RADIUS1;
        this.EPSILON = EPSILON;
        this.AREA1 = AREA1;
        this.Q_PTS = Q_PTS;
        this.QUADS = QUADS;
        this.DIST = DIST;
        this.N_PTS = N_PTS;
        this.K_PTS = K_PTS;
        this.A_PTS = A_PTS;
        this.B_PTS = B_PTS;
        this.C_PTS = C_PTS;
        this.D_PTS = D_PTS;
        this.E_PTS = E_PTS;
        this.F_PTS = F_PTS;
        this.G_PTS = G_PTS;
        this.LENGTH2 = LENGTH2;
        this.RADIUS2 = RADIUS2;
        this.AREA2 = AREA2;
    }
}
