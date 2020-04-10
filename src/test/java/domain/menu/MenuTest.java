package domain.menu;

import domain.category.Category;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MenuTest {

    @ParameterizedTest
    @MethodSource("provideIsChickenSource")
    void isChicken(Menu menu, boolean result) {
        assertThat(menu.isChicken()).isEqualTo(result);
    }

    private static Stream<Arguments> provideIsChickenSource() {
        return Stream.of(
                Arguments.of(new Menu(1, "치킨", Category.CHICKEN, 10), true),
                Arguments.of(new Menu(2, "음료", Category.BEVERAGE, 10), false)
        );
    }
}