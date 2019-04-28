package com.github.hubertwo.kata.stream.basics;

import com.github.hubertwo.kata.stream.Fruit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

/**
 * By doing this tasks you will learn how to use:
 * <p>
 * - {@link Stream#sorted}
 * - {@link Stream#limit(long)}
 * - {@link Stream#reduce}
 * - {@link Stream#mapToInt(ToIntFunction)}
 * - {@link Stream#flatMap(Function)}
 * - {@link Collectors#groupingBy(Function)}
 * - {@link Collectors#counting()}
 * - {@link Comparator#comparing(Function)}
 * - {@link Function#identity()}
 * - {@link Stream#generate(Supplier)}
 * </p>
 *
 * @author https://github.com/HubertWo
 */
@SuppressWarnings("SimplifyStreamApiCallChains")
class BasicsTest {

    private static final Fruit BANANA = new Fruit("Banana", 105);
    private static final Fruit PAPAYA = new Fruit("Papaya", 109);
    private static final Fruit KIWI = new Fruit("Kiwi", 46);
    private static final Fruit MANGO = new Fruit("Mango", 107);
    private static final Fruit PEACH = new Fruit("Peach", 48);

    private static final Set<Fruit> FRUITS = Set.of(PAPAYA, BANANA, KIWI, MANGO, PEACH);

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
      .sorted(Comparator.comparing(Fruit::getCalories).reversed())
      .limit(2)
     */
    //</editor-fold>
    @Test
    @DisplayName("Task: Find 2 fruits with biggest amount of calories")
    void task1() {
        List<Fruit> mostCaloricFruits = FRUITS.stream().collect(toList()); // TODO:  FRUITS.stream()

        assertThat(mostCaloricFruits.size(), is(2));
        assertThat(mostCaloricFruits.get(0).getName(), is(PAPAYA));
        assertThat(mostCaloricFruits.get(1).getName(), is(MANGO));
    }

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
      FRUITS.stream().mapToInt((Fruit fruit) -> fruit.getCalories() / 2).sum();
     */
    //</editor-fold>
    @Test
    @DisplayName("Task: Take half of each fruit and get the sum of calories")
    void task2() {
        final int sumOfCalories = 0; // TODO: FRUITS.stream()

        assertThat(sumOfCalories, is(206));
    }

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
    .collect(Collectors.groupingBy(
        (Fruit fruit) -> fruit.getName().charAt(0),
        Collectors.toSet()
    ));
     */
    //</editor-fold>
    @Test
    @DisplayName("Task: Group fruits by first letter")
    void task3() {
        final Map<Character, Set<Fruit>> mapOfFruits = Collections.emptyMap(); // TODO: FRUITS.stream()

        assertThat(mapOfFruits.keySet(), containsInAnyOrder('B', 'K', 'M', 'P'));
        assertThat(mapOfFruits.get('B'), hasSize(1));
        assertThat(mapOfFruits.get('K'), hasSize(1));
        assertThat(mapOfFruits.get('M'), hasSize(1));
        assertThat(mapOfFruits.get('P'), hasSize(2));
    }

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
         Solution 1.

         fruitBaskets.stream()
            .flatMap(Collection::stream)
            .collect(Collectors.toList());

         Solution 2 - just to illustrate the concept of flatMap.

         fruitBaskets.stream()
                .map(basket -> basket.stream())
                .reduce(Stream.empty(), Stream::concat)
                .collect(Collectors.toList());

     */
    //</editor-fold>
    @Test
    @DisplayName("Task: Put all fruits into one basket")
    void task4() {
        final List<List<Fruit>> fruitBaskets = List.of(
                List.of(BANANA, PAPAYA),
                List.of(MANGO, PEACH)
        );

        final List<Fruit> basketWithAllFruits = Collections.emptyList(); // TODO: fruitBaskets.stream()

        assertThat(basketWithAllFruits, containsInAnyOrder(BANANA, PAPAYA, MANGO, PEACH));
        assertThat(basketWithAllFruits, not(contains(KIWI)));
    }

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
        basket.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    */
    //</editor-fold>
    @Test
    @DisplayName("Task: Count amount of each fruit in the basket")
    void task5() {
        final List<Fruit> basket = List.of(MANGO, PAPAYA, MANGO, PEACH, KIWI, KIWI, KIWI);

        final Map<Fruit, Long> countedFruit = Collections.emptyMap(); //  TODO: basket.stream()

        assertThat(countedFruit.size(), is(4));
        assertThat(countedFruit.keySet(), containsInAnyOrder(MANGO, PAPAYA, PEACH, KIWI));
        assertThat(countedFruit.get(MANGO), is(2l));
        assertThat(countedFruit.get(PAPAYA), is(1l));
        assertThat(countedFruit.get(PEACH), is(1l));
        assertThat(countedFruit.get(KIWI), is(3l));
    }

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
         FRUITS.stream()
                .reduce(new Fruit("", 0), (mixedFruit, fruitToAdd) -> new Fruit(
                        mixedFruit.getName() + fruitToAdd.getName(),
                        mixedFruit.getCalories() + fruitToAdd.getCalories()
                ));
    */
    //</editor-fold>
    @Test
    @DisplayName("Task: Mix all fruits together and construct one, big, new Fruit")
    void task6() {
        final Fruit bigJuicyFruit = null; // TODO: FRUITS.stream()

        assertThat(bigJuicyFruit, notNullValue());
        assertThat(bigJuicyFruit.getCalories(), is(415));
        assertThat(bigJuicyFruit.getName(), not(isEmptyString()));
    }

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
         final Stream<Fruit> infiniteStreamOfFruits = Stream
                .generate(fruitSupplier);
     */
    //</editor-fold>
    @Test
    @DisplayName("Task: Generate list of 10 randomly picked fruits")
    void task7() {

        // Random fruit supplier
        final Supplier<Fruit> randomFruitSupplier = new Supplier<>() {
            final Random random = new Random();
            final List<Fruit> fruits = new ArrayList<>(FRUITS);

            @Override
            public Fruit get() {
                return fruits.get(random.nextInt(fruits.size()));
            }
        };

        final Stream<Fruit> infiniteStreamOfFruits = Stream.empty(); // TODO: Stream.


        List<Fruit> pickedFruits = infiniteStreamOfFruits
                .limit(10)
                .collect(Collectors.toList());

        assertThat(pickedFruits, hasSize(10));
    }

    // <editor-fold defaultstate="collapsed" desc="Click here to see the answer">
    /*
            IntStream
                .range(0, fruitList.size())
                .filter(i -> i % 2 == 1)
                .mapToObj(fruitList::get)
                .collect(toList());
     */
    //</editor-fold>
    @Test
    @DisplayName("Task: Collect only second and forth (with odd index) fruit from fruitList.")
    void task8() {
        // Do you why list have to be sorted?
        final List<Fruit> fruitList = new ArrayList<>(FRUITS).stream()
                .sorted(Comparator.comparing(Fruit::getName))
                .collect(toList());

        List<Fruit> filteredFruits = fruitList; // TODO: change to stream.

        assertThat(filteredFruits, hasSize(2));
        assertThat(filteredFruits.get(0), is(PAPAYA));
        assertThat(filteredFruits.get(1), is(BANANA));
    }

}
