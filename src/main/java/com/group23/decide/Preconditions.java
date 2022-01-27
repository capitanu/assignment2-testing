package com.group23.decide;

public final class Preconditions {

    private Preconditions() { }

    /**
     * Throwing an IllegalArgumentException if a condition is not satisfied
     *
     * @param isTrue the condition to check
     * @throws IllegalArgumentException if the condition to check is false
     */
    public static void checkArgument(boolean isTrue) {
        if (!isTrue) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Checking if a certain value is contained in an interval
     *
     * @param value    the value to check
     * @param a        left boundary of the interval (inclusive)
     * @param b        right boundary of the interval (inclusive)
     * @return the value if it is contained [a, b]
     * @throws IllegalArgumentException if value isn't contained in interval
     */
    public static double checkInInterval(int value, int a, int b) {
        checkArgument(value >= a && value <= b);
        return value;
    }
}
