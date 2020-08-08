package com.github.hubertwo.kata.stream;

import com.github.hubertwo.kata.stream.exception.FruitNotAvailableException;

import java.util.ArrayList;
import java.util.List;

/**
 * Fruit distributor provides fruits.
 * <p>
 * Not thread safe.
 */
public final class FruitVendorMachine {

    private final List<Fruit> fruits;

    public FruitVendorMachine(List<Fruit> fruits) {
        this.fruits = new ArrayList<>(fruits);
    }

    /**
     * Returns fruit from {@link #fruits}.
     *
     * @param fruitName name of the requested fruit.
     * @return requested fruit
     * @throws FruitNotAvailableException when given fruit is no longer available
     */
    public Fruit getFruit(final String fruitName) throws FruitNotAvailableException {

        Fruit fruit = fruits.stream()
                .filter(f -> f.getName().equals(fruitName))
                .findFirst()
                .orElseThrow(() -> {
                    String message = String.format("Fruit name: %s", fruitName);
                    return new FruitNotAvailableException(message);
                });

        fruits.remove(fruit);

        return fruit;
    }

    /**
     * Checks if vendor machine has fruits.
     *
     * @return true if machine has fruits false otherwise
     */
    public boolean hasFruits() {
        return !fruits.isEmpty();
    }

}
