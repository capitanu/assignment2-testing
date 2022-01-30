package com.group23.decide;
/**
 * A helper class that is supposed to hold the radius and center of a circle.
 */
public class Circle {

    private double radius;
    private Point center;

    /**
     * The constructor for a Circle takes two arguments, radius and center and returns an Object of type Circle.
     */
    public Circle(double radius, Point center) {
        this.radius = radius;
        this.center = center;
    }

    /**
     * Getter for x
     */
    public double getRadius() {
        return radius;
    }

    /**
     * Getter for y
     */
    public Point getCenter() {
        return center;
    }
}
