package com.github.hubertwo.kata.stream;

import com.github.hubertwo.kata.stream.exception.FruitNotAvailableException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * Tests of Fruit vendor machine.
 * Does not contain any tasks.
 */
class FruitVendorMachineTest {

    private static final Fruit PEACH = new Fruit("Peach", 48);

    @Test
    void getFruit() throws FruitNotAvailableException {
        final FruitVendorMachine givenFruitVendorMachine = new FruitVendorMachine(Arrays.asList(PEACH));

        final Fruit actualFruit = givenFruitVendorMachine.getFruit(PEACH.getName());

        assertThat(actualFruit).isNotNull();
    }

    @Test
    @DisplayName("Throw exception when fruit is not available")
    void throwFruitNotAvailableException() {
        final FruitVendorMachine givenFruitVendorMachine = new FruitVendorMachine(Collections.emptyList());

        final Throwable actualException = catchThrowable(() -> givenFruitVendorMachine.getFruit("ANY"));

        assertThat(actualException)
                .isInstanceOf(FruitNotAvailableException.class)
                .hasMessage("Fruit name: ANY");
    }

    @Test
    void fruitsAreBeingRemovedFromMachine() throws FruitNotAvailableException {
        final FruitVendorMachine givenFruitVendorMachine = new FruitVendorMachine(Arrays.asList(PEACH, PEACH));

        // Get first fruit
        assertThat(givenFruitVendorMachine.hasFruits()).isTrue();
        givenFruitVendorMachine.getFruit(PEACH.getName());

        // Get second fruit
        assertThat(givenFruitVendorMachine.hasFruits()).isTrue();
        givenFruitVendorMachine.getFruit(PEACH.getName());

        // No more fruits left in machine
        assertThat(givenFruitVendorMachine.hasFruits()).isFalse();
    }

}