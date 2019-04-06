package com.github.hubertwo.kata.stream.basics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * This task you will show you how to use:
 * <p>
 * - {@link Collectors#groupingBy(Function)}}
 * - {@link Function#identity()}
 * - {@link Collectors#counting()}
 * - {@link Stream#count()}
 * </p>
 */
class PalindromeTest {

    /**
     * Word is an palindrome candidate when each character of word occurs even number of
     * times or only one character occurs odd number of times.
     *
     * @return true if {@param word} is an palindrome candidate
     */
    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
        if (word.length() == 0) {
            return false;
        }

        final Map<Integer, Long> countedCharacters = word
                .chars()
                .boxed()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        // Count number of characters which occurred odd number of times
        final long oddCharactersCount = countedCharacters.values().stream()
                .filter(count -> count % 2 != 0)
                .count();

        // Only one character with odd number of occurrences is allowed
        return oddCharactersCount <= 1;
    */
    //</editor-fold>
    private static boolean isPalindromeCandidate(final String word) {
        // TODO: implement using {@link Stream}
        throw new IllegalStateException("Not implemented yet");
    }

    @Test
    @DisplayName("Is palindrome candidate")
    void palindromeCandidate() {
        assertThat(isPalindromeCandidate(""), is(false));
        assertThat(isPalindromeCandidate("a"), is(true));
        assertThat(isPalindromeCandidate("ab"), is(false));
        assertThat(isPalindromeCandidate("aab"), is(true));
        assertThat(isPalindromeCandidate("aabb"), is(true));
        assertThat(isPalindromeCandidate("aabbc"), is(true));
    }
}
