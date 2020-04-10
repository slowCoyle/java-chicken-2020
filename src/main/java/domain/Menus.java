package domain;

import java.util.ArrayList;
import java.util.List;

public class Menus {
    private static final ChickenLimitChecker chickenLimitChecker = new ChickenLimitChecker();
    private static final int ADDED_CHICKEN_SIZE = 1;

    private final List<Menu> menus;

    public Menus() {
        this.menus = new ArrayList<>();
    }

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public void add(Menu menu) {
        if(menu.isChicken() && hasLimitChicken()) {
            throw new LimitChickenSizeException();
        }
        menus.add(menu);
    }

    public boolean hasLimitChicken() {
        int addedChickenSize = (int) menus.stream()
                .filter(menu -> menu.isChicken())
                .count()
                + ADDED_CHICKEN_SIZE;

        return chickenLimitChecker.isLimit(addedChickenSize);
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
