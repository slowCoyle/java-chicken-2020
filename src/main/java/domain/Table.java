package domain;

import java.util.Objects;

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

    public void addMenus(Menus menus) {
        this.menus.addAll(menus);
    }

    public boolean isSameTo(int tableNumber) {
        return this.number == tableNumber;
    }

    public boolean isExistMenus() {
        return menus.isExistMenu();
    }

    public Menus getMenus() {
        return menus;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Table table = (Table) o;
        return number == table.number &&
                Objects.equals(menus, table.menus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, menus);
    }
}
