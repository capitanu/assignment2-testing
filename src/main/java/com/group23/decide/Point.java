package com.group23.decide;

/**
 * A helper inner class that is suppossed to hold the coordinates of a plannar point.
 */
public class Point {

    private int x;
    private int y;

    /**
     * The constructor for a Point takes two arguments, x and y and returns an Object of type Point.
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Getter for x
     */
    public int getX() {
        return x;
    }

    /**
     * Getter for y
     */
    public int getY() {
        return y;
    }

    /**
     * Setter for x
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Setter for y
     */
    public void setY(int y) {
        this.y = y;
    }

}
