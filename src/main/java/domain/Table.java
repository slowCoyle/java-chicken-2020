package domain;

public class Table {
    private final int number;
    private final Menus menus;

    public Table(final int number) {
        this(number, new Menus());
    }

    public Table(int number, Menus menus) {
        this.number = number;
        this.menus = menus;
    }

    public void addMenu(Menu menu) {
        menus.add(menu);
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public Menus getMenus() {
        return menus;
    }
}
