package com.github.hubertwo.kata.stream.basics;

import com.github.hubertwo.kata.stream.Fruit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toUnmodifiableList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.not;

/**
 * By doing this tasks you will learn how to use:
 * <p>
 * - {@link Predicate#not}
 * </p>
 *
 * @author https://github.com/HubertWo
 */
@SuppressWarnings("SimplifyStreamApiCallChains")
@DisplayName("Stream basics - Java 11")
class BasicsJava11Test {

    private static final Fruit BANANA = new Fruit("Banana", 105);
    private static final Fruit PAPAYA = new Fruit("Papaya", 109);
    private static final Fruit KIWI = new Fruit("Kiwi", 46);
    private static final Fruit MANGO = new Fruit("Mango", 107);
    private static final Fruit PEACH = new Fruit("Peach", 48);

    private static final Set<Fruit> FRUITS = Set.of(PAPAYA, BANANA, KIWI, MANGO, PEACH);

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
      FRUITS.stream()
                .filter(Predicate.not(f -> f.equals(BANANA)))
                .collect(toUnmodifiableList());
     */
    //</editor-fold>
    @Test
    @DisplayName("Task: Get all fruits except BANANA")
    void task1() {
        List<Fruit> everythingExceptBanana = FRUITS.stream()
                // TODO: put your answer here
                .collect(toUnmodifiableList());

        assertThat(everythingExceptBanana)
                .doesNotContain(BANANA)
                .containsExactlyInAnyOrder(PAPAYA, KIWI, MANGO, PEACH);
    }
}
