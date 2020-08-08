package com.github.hubertwo.kata.stream.basics;

import com.github.hubertwo.kata.stream.Fruit;
import com.github.hubertwo.kata.stream.FruitVendorMachine;
import com.github.hubertwo.kata.stream.exception.FruitNotAvailableException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

/**
 * This task shows how to manage exceptions inside the stream.
 */
public class ExceptionsTest {

    private static final Fruit BANANA = new Fruit("Banana", 105);
    private static final Fruit PAPAYA = new Fruit("Papaya", 109);

    @Test()
    @DisplayName("Example - translating checked exception to unchecked")
    void runtimeExceptionTest() {
        final FruitVendorMachine givenFruitVendorMachine = new FruitVendorMachine(Arrays.asList(BANANA));
        final List<String> givenFruitsToRequest = Arrays.asList(BANANA.getName(), PAPAYA.getName());

        // Vendor machine has fruits
        assertThat(givenFruitVendorMachine.hasFruits())
                .isTrue();

        final Throwable actualThrowable = catchThrowable(() -> {
            givenFruitsToRequest.stream()
                    .map(fruitName -> {
                        try {
                            return givenFruitVendorMachine.getFruit(fruitName);
                        } catch (FruitNotAvailableException e) {
                            // Translating checked exception to unchecked
                            // This will stop the execution of the rest of the stream
                            throw new IllegalStateException(e);
                        }
                    })
                    .collect(toList());

        });

        assertThat(actualThrowable)
                .isInstanceOf(IllegalStateException.class)
                .hasCauseInstanceOf(FruitNotAvailableException.class);

        assertThat(actualThrowable.getCause())
                .hasMessage("Fruit name: Papaya");

        // Vendor machine state has been changed
        assertThat(givenFruitVendorMachine.hasFruits())
                .isFalse();
    }

}
