package domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Menus {
    private static final ChickenLimitChecker chickenLimitChecker = new ChickenLimitChecker();

    private final List<Menu> menus;

    public Menus() {
        this.menus = new ArrayList<>();
    }

    public Menus(List<Menu> menus) {
        this.menus = menus;
    }

    public static Menus of(Menu menu, int amount) {
        List<Menu> menus = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            menus.add(menu);
        }
        return new Menus(menus);
    }

//    public void add(Menu menu) {
//        if (menu.isChicken() && validAmount(1)) {
//            throw new LimitChickenSizeException();
//        }
//        menus.add(menu);
//    }

    public void addAll(Menus menus) {
        List<Menu> menusValues = menus.menus;

        if (validAmount(menusValues.size())) {
            throw new LimitChickenSizeException();
        }

        this.menus.addAll(menusValues);
    }

    private boolean validAmount(int chickenSize) {
        int addedChickenSize = (int) menus.stream()
                .filter(menu -> menu.isChicken())
                .count()
                + chickenSize;

        return chickenLimitChecker.isLimit(addedChickenSize);
    }

    public List<Menu> getMenus() {
        return menus;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menus menus1 = (Menus) o;
        return Objects.equals(menus, menus1.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(menus);
    }
}
