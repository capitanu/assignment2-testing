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

    /**
     * This function checks if a given point is within a given circle For a point to be in the circle, x and y must
     * satisfy: (point.x - center.x)^2 + (point.y - center.y)^2 < radius^2
     *
     * @param point
     *            - The point to be evaluated if it's in the circle
     *
     * @param circle
     *            - The circle that we're evaluating
     *
     * @return true if point is inside circle, false otherwise
     */
    public static boolean pointIsInCircle(Point point, Circle circle) {
        if ((Math.pow(point.x - circle.getCenter().x, 2) + Math.pow(point.y - circle.getCenter().y, 2)) < Math
                .pow(circle.getRadius(), 2)) {
            return true;
        }
        return false;
    }

    /**
     * This function takes 2 points and calculates the smallest circle that intersects both points p0 and p1
     *
     * @param p0
     *            - The first point to be evaluated
     *
     * @param p1
     *            - The second point to be evaluated
     *
     * @return circle - the smallest circle that intersects both points p0 and p1
     */
    public static Circle findSmallestCircle2Points(Point p0, Point p1) {
        double radius = calculateDistance(p0, p1) / 2;
        Point center = new Point((p0.x + p1.x) / 2, (p0.y + p1.y) / 2);

        Circle circle = new Circle(radius, center);
        return circle;
    }

    /**
     * This function calculates the radius of a circle with 3 points given, according to
     * https://www.mathopenref.com/trianglecircumcircle.html
     *
     * @param p0
     *            - The first point to be evaluated
     *
     * @param p1
     *            - The second point to be evaluated
     *
     * @param p2
     *            - The third point to be evaluated
     *
     * @return radius - The radius of the circle with the three points on its edge.
     */
    public static double findCircle3Points(Point p0, Point p1, Point p2) {
        double dist1 = calculateDistance(p0, p1);
        double dist2 = calculateDistance(p0, p2);
        double dist3 = calculateDistance(p1, p2);

        double numerator = (dist1 * dist2 * dist3);
        double denominator = Math.sqrt(
                (dist1 + dist2 + dist3) * (dist2 + dist3 - dist1) * (dist3 + dist1 - dist2) * (dist1 + dist2 - dist3));
        double radius = numerator / denominator;

        return radius;
    }

    /**
     * This function takes 3 points and calculates all combinations of circles that can be achieved with these 3 points.
     * There are only 2 cases for smallest circles: 1) Two points intersect the circle, otherwise the circle can be
     * shrunk 2) Three points intersect the circle This leads to evaluating the following possible circles: Circle has 2
     * points on its edge: {p0,p1} || {p0,p2} || {p1,p2} And Circle has 3 points on its edge: {p0, p1, p2}
     *
     * @param p0
     *            - the first point to be evaluated
     *
     * @param p1
     *            - the second point to be evaluated
     *
     * @param p2
     *            - the third point to be evaluted
     *
     * @return The radius of the smallest circle that contains all 3 points.
     *
     */
    public static double calcRadiusSmallestCircle(Point p0, Point p1, Point p2) {
        // 2 points or more are the same => return greatest dist
        if (p0.equals(p1) || p0.equals(p2) || p1.equals(p2)) {
            return Math.max(calculateDistance(p0, p1), Math.max(calculateDistance(p0, p2), calculateDistance(p1, p2)))
                    / 2;
        }

        // Else find the smallest circle containing all 3 points
        // The circle will either intersect 2 or 3 points
        // => have to test {p0, p1}, {p0, p2}, {p1, p3} and {p0, p1, p2}
        // Src: https://www.geeksforgeeks.org/minimum-enclosing-circle-set-1/.

        // Set the possible radius's to inf
        double radius = Double.POSITIVE_INFINITY;
        double radius2 = Double.POSITIVE_INFINITY;
        double radius3 = Double.POSITIVE_INFINITY;
        double radius4 = Double.POSITIVE_INFINITY;

        // Create circles and find the smallest circles given the 2 points
        Circle circle1 = findSmallestCircle2Points(p0, p1);
        Circle circle2 = findSmallestCircle2Points(p0, p2);
        Circle circle3 = findSmallestCircle2Points(p1, p2);

        // Check if the point not on the edge of the circle, is actually inside the circle.
        // If it is not, then it should not be considered valid and don't update the radius.
        // Else set the radius to whatever the smallest circle's radius is.
        if (pointIsInCircle(p2, circle1)) {
            radius = circle1.getRadius();
        }
        if (pointIsInCircle(p1, circle2)) {
            radius2 = circle2.getRadius();
        }
        if (pointIsInCircle(p0, circle3)) {
            radius3 = circle3.getRadius();
        }

        // No need to check if point in circle since its trivial...
        radius4 = findCircle3Points(p0, p1, p2);

        // Return the smallest of the 4 radius's
        return Math.min(radius, Math.min(radius2, Math.min(radius3, radius4)));
    }
	
}
