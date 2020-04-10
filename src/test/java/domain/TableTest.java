package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {

    private static Table table;

    @BeforeEach
    void initialize() {
        table = new Table(1);
    }

    @Test
    @DisplayName("메뉴 추가 테스트")
    void addMenu() {
        List<Menu> menusValue = new ArrayList<>();
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);
        for (int i = 0; i < 10; i++) {
            menusValue.add(menu);
        }

        table.addMenus(new Menus(menusValue));

        Menus menus = table.getMenus();
        List<Menu> result = menus.getMenus();
        assertThat(result.size()).isEqualTo(10);
        assertThat(result.contains(new Menu(1, "후라이드", Category.CHICKEN, 16_000)));
    }

}