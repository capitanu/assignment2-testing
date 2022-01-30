package com.group23.decide;

import java.lang.Math;

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

    /**
     * This method takes 2 points in the cartesian system and calculates their euclidean distance from each other.
     *
     * @param point1
     *            - The first point
     * @param point2
     *            - The second point
     *
     * @return distance - the distance between the two points
     */
    public static double calculateDistance(Point point1, Point point2) {
        double square1 = Math.pow((point2.x - point1.x), 2);
        double square2 = Math.pow((point2.y - point1.y), 2);

        double distance = Math.sqrt(square1 + square2);

        return distance;
    }

    /**
     * This method takes 3 points in the cartesian system and calculates the angle P1-P2-P3
     *
     * @param point1
     *            - The first point
     * @param point2
     *            - The second point
     * @param point3
     *            - The third point
     *
     * @return angle - the P1-P2-P3 angle
     */
    public static double calculateAngle(Point point1, Point point2, Point point3) {
        double a = Math.pow(point2.x - point1.x, 2) + Math.pow(point2.y - point1.y, 2);
        double b = Math.pow(point2.x - point3.x, 2) + Math.pow(point2.y - point3.y, 2);
        double c = Math.pow(point3.x - point1.x, 2) + Math.pow(point3.y - point1.y, 2);

        return Math.acos((a + b - c) / Math.sqrt(4 * a * b));
    }

    /**
     * This method takes 3 points in the cartesian system and calculates the area made by the triangle (P1,P2,P3)
     *
     * @param point1
     *            - The first point
     * @param point2
     *            - The second point
     * @param point3
     *            - The third points
     *
     * @return area - the triangle (P1,P2,P3)
     */
    public static double calculateArea(Point point1, Point point2, Point point3) {
        double a = calculateDistance(point1, point2);
        double b = calculateDistance(point2, point3);
        double c = calculateDistance(point3, point1);
        double s = (a + b + c) / 2;
        double area = Math.sqrt(s * (s - a) * (s - b) * (s - c));
        // Impossible triangle, return 0, possiblity of throwing an exception
        if (Double.isNaN(area)) {
            return 0;
        }
        return area;
    }

    /**
     * This method takes 3 points in the cartesian system and calculates distance from point 1 to the line defined by
     * point 2 and point 3
     * 
     * @param point1
     *            - The first line point
     * @param point2
     *            - The second line point
     * @param point3
     *            - The third line point
     *
     * @return distance - from point1 to the line defined by point2 and point3
     */
    public static double calculateDistanceFromPointToLine(Point point1, Point point2, Point point3) {
        double numerator = Math
                .abs((point3.x - point2.x) * (point2.y - point1.y) - (point2.x - point1.x) * (point3.y - point2.y));
        double denominator = Math.sqrt(Math.pow(point3.x - point2.x, 2) + Math.pow(point3.y - point2.y, 2));
        return numerator / denominator;
    }

    /**
     * This method takes 1 point in the cartesian system and returns true if it is equal to the point that called the
     * function, or false otherwise.
     *
     * @param point
     *            - The point
     *
     * @return true if the points are equal, false otherwise
     */
    public boolean equals(Point point) {
        if (this.x == point.getX() && this.y == point.getY())
            return true;
        return false;
    }
}
