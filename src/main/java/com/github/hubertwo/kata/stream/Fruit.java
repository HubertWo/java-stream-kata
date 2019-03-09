package com.github.hubertwo.kata.stream;

/**
 * Fruit representation.
 */
public final class Fruit {
    private final String name;
    private final int calories;

    public Fruit(String name, int calories) {
        this.name = name;
        this.calories = calories;
    }

    public String getName() {
        return name;
    }

    public int getCalories() {
        return calories;
    }
}