package domain;

import domain.category.Category;
import domain.menu.Menu;
import domain.menu.Menus;
import domain.order.exception.LimitChickenSizeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    @DisplayName("메뉴 사이즈")
    void calculateSize() {
        Menu menu = new Menu(1, "후라이디", Category.CHICKEN, 10000);

        Menus menus = Menus.of(menu, 30);

        assertThat(menus.calculateSize(menu)).isEqualTo(30);
    }
}