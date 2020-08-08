package com.github.hubertwo.kata.stream.exception;

/**
 * Indicates that fruit is not longer available.
 */
public class FruitNotAvailableException extends Exception {

    public FruitNotAvailableException(String message) {
        super(message);
    }
}
