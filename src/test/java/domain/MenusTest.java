package domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenusTest {
    @ParameterizedTest
    @MethodSource("provideHasLimitChicken")
    @DisplayName("제한된 치킨 수 초과하는지 확인")
    void hasLimitChicken(int chickenSize, boolean result) {
        List<Menu> menusValue = new ArrayList<>();

        for (int i = 0; i < chickenSize; i++) {
            menusValue.add(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
        }

        Menus menus = new Menus(menusValue);
        assertThat(menus.hasLimitChicken()).isEqualTo(result);
    }

    private static Stream<Arguments> provideHasLimitChicken() {
        return Stream.of(
                Arguments.of(98, false),
                Arguments.of(99, true)
        );
    }

    @Test
    @DisplayName("제한된 치킨 수 초과하는지 주문")
    void addChickenTest() {
        List<Menu> menusValue = new ArrayList<>();
        Menu chicken = new Menu(1, "후라이드", Category.CHICKEN, 16_000);

        for (int i = 0; i < 100; i++) {
            menusValue.add(chicken);
        }

        Menus menus = new Menus(menusValue);
        assertThatThrownBy(() -> menus.add(chicken)).isInstanceOf(LimitChickenSizeException.class);
    }
}