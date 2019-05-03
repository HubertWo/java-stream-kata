package com.github.hubertwo.kata.stream.basics;

import org.assertj.core.data.Percentage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * This task you will show you how to use:
 * <p>
 * - {@link java.util.stream.Stream#iterate)}
 * - {@link java.util.stream.Stream#reduce)}
 * </p>
 *
 * @author https://github.com/HubertWo
 */
@DisplayName("Fibonacci Sequence")
class FibonacciSequenceTest {

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
        return Stream
            .iterate(new long[]{1, 1}, (long[] results) -> new long[]{results[1], results[0] + results[1]})
            .limit(sequenceIndex)
            .reduce((a, b) -> b)
            .orElse(new long[]{0, 0})[0];
     */
    //</editor-fold>

    /**
     * Calculates {@param sequenceIndex} of Fibonacci sequence.
     *
     * @see <a href="https://simple.wikipedia.org/wiki/Fibonacci_number">Wikipedia</a>
     */
    static long fibonacciSequence(long sequenceIndex) {
        throw new IllegalStateException("Not implemented yet");
    }

    @Test
    @DisplayName("Task: Calculate Fibonacci Sequence")
    void task() {
        assertThat(fibonacciSequence(0)).isEqualTo(0);
        assertThat(fibonacciSequence(1)).isEqualTo(1);
        assertThat(fibonacciSequence(2)).isEqualTo(1);
        assertThat(fibonacciSequence(3)).isEqualTo(2);
        assertThat(fibonacciSequence(10)).isEqualTo(55);

        final double goldenRatio = (double) fibonacciSequence(20) / fibonacciSequence(19);
        assertThat(goldenRatio).isCloseTo(1.61d, Percentage.withPercentage(2));
    }


}
