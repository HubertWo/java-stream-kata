package basics;

import com.github.hubertwo.kata.stream.Fruit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;


@SuppressWarnings("SimplifyStreamApiCallChains")
class BasicsTest {

    static final List<Fruit> FRUITS = List.of(
            new Fruit("Banana", 105),
            new Fruit("Kiwi", 46),
            new Fruit("Mango", 107),
            new Fruit("Peach", 48)
    );

    @Test
    @DisplayName("Task: Find 2 fruits with biggest amounts of calories")
    //<editor-fold  defaultstate="collapsed" desc="Click here to see the answer">
    /**
     * .sorted(Comparator.comparing(Fruit::getCalories).reversed())
     * .limit(2)
     */
        //</editor-fold>
    void order() {

        List<Fruit> fruits = FRUITS.stream()
                // PUT your answer here
                .collect(Collectors.toList());

        assertThat(fruits.size(), is(2));
        assertThat(fruits.get(0).getName(), is("Mango"));
        assertThat(fruits.get(1).getName(), is("Banana"));
    }
}
