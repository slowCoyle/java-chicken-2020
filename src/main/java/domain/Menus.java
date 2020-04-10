package domain;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private final List<Menu> menus;

    public Menus() {
        this.menus = new ArrayList<>();
    }

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public void add(Menu menu) {
        menus.add(menu);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
