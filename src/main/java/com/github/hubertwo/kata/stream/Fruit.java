package com.github.hubertwo.kata.stream;

import java.util.Objects;

/**
 * Fruit representation.
 *
 * @author https://github.com/HubertWo
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

    /**
     * Returning only name of fruit for readability.
     */
    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Fruit fruit = (Fruit) o;
        return calories == fruit.calories &&
                Objects.equals(name, fruit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, calories);
    }
}