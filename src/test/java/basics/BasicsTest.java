package basics;

import com.github.hubertwo.kata.stream.Fruit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * By doing this tasks you will learn how to use:
 * <p>
 * - {@link Stream#sorted()}
 * - {@link Stream#limit(long)}
 * - {@link Stream#mapToInt(ToIntFunction)}
 * - {@link Collectors#groupingBy(Function)}
 * - {@link Comparator#comparing(Function)}
 */
@SuppressWarnings("SimplifyStreamApiCallChains")
class BasicsTest {

    static final List<Fruit> FRUITS = List.of(
            new Fruit("Papaya", 109),
            new Fruit("Banana", 105),
            new Fruit("Kiwi", 46),
            new Fruit("Mango", 107),
            new Fruit("Peach", 48)
    );

    @Test
    @DisplayName("Task: Find 2 fruits with biggest amount of calories")
    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
      .sorted(Comparator.comparing(Fruit::getCalories).reversed())
      .limit(2)
     */
    //</editor-fold>
    void task1() {
        List<Fruit> mostCaloricFruits = FRUITS.stream()
                .collect(Collectors.toList());

        assertThat(mostCaloricFruits.size(), is(2));
        assertThat(mostCaloricFruits.get(0).getName(), is("Papaya"));
        assertThat(mostCaloricFruits.get(1).getName(), is("Mango"));
    }

    @Test
    @DisplayName("Task: Take half of each fruit and get the sum of calories")
    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
      FRUITS.stream().mapToInt((Fruit fruit) -> fruit.getCalories() / 2).sum();
     */
    //</editor-fold>
    void task2() {
        final int sumOfCalories = 0;  // FRUITS.stream()
        // Put your answer here

        assertThat(sumOfCalories, is(206));
    }

    @Test
    @DisplayName("Task: Group fruits by first letter")
    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
    .collect(Collectors.groupingBy(
        (Fruit fruit) -> fruit.getName().charAt(0),
        Collectors.toSet()
    ));
     */
    //</editor-fold>
    void task3() {
        final Map<Character, Set<Fruit>> mapOfFruits = Collections.emptyMap(); // FRUITS.stream()
                // Put your answer here

        assertThat(mapOfFruits.keySet(), containsInAnyOrder('B', 'K', 'M', 'P'));
        assertThat(mapOfFruits.get('B'), hasSize(1));
        assertThat(mapOfFruits.get('K'), hasSize(1));
        assertThat(mapOfFruits.get('M'), hasSize(1));
        assertThat(mapOfFruits.get('P'), hasSize(2));
    }

    @Test
    @DisplayName("Task: Put all fruits into one basket")
    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
         fruitBaskets.stream()
            .flatMap(Collection::stream).collect(Collectors.toList());
     */
    //</editor-fold>
    void task4() {
        final List<List<Fruit>> fruitBaskets = List.of(
                List.of(FRUITS.get(0), FRUITS.get(1)),
                List.of(FRUITS.get(3), FRUITS.get(4))
        );

        final List<Fruit> basketWithAllFruits = Collections.emptyList(); // fruitBaskets.stream()

        assertThat(basketWithAllFruits, containsInAnyOrder(FRUITS.get(0), FRUITS.get(1), FRUITS.get(3), FRUITS.get(4)));
        assertThat(basketWithAllFruits, not(contains(FRUITS.get(2))));
    }
}
