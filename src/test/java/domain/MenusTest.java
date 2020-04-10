package domain;

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
    @Test
    void addAll() {
        Menus menus = new Menus();

        List<Menu> orderedMenusValue = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            orderedMenusValue.add(new Menu(1, "후라이디", Category.CHICKEN, 10000));
        }

        Menus orderedMenus = new Menus(orderedMenusValue);
        menus.addAll(orderedMenus);

        assertThat(menus.getMenus().size()).isEqualTo(3);
    }

    @Test
    @DisplayName("치킨 수를 초과하는 addAll 테스트")
    void addAll2() {
        Menus menus = new Menus();

        List<Menu> orderedMenusValue = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            orderedMenusValue.add(new Menu(1, "후라이디", Category.CHICKEN, 10000));
        }

        Menus orderedMenus = new Menus(orderedMenusValue);
        assertThatThrownBy(() -> menus.addAll(orderedMenus)).isInstanceOf(LimitChickenSizeException.class);
    }

    @Test
    @DisplayName("주문한 메뉴만큼의 같은 메뉴 리스트 생성")
    void of() {
        Menu menu = new Menu(1, "후라이디", Category.CHICKEN, 10000);

        Menus menus = Menus.of(menu, 30);

        List<Menu> expectedValue = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            expectedValue.add(new Menu(1, "후라이디", Category.CHICKEN, 10000));
        }

        Menus expected = new Menus(expectedValue);

        assertThat(menus).isEqualTo(expected);
    }
}