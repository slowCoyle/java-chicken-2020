package view;

import domain.Menu;
import domain.Table;

import java.util.List;

public class OutputView {
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String EXIST_MENU_TABLE_BOTTOM_LINE = "└ ₩ ┘";

    public static void printTables(final List<Table> tables) {
        System.out.println("## 테이블 목록");
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printTableBottomLine(tables);
    }

    public static void printMenus(final List<Menu> menus) {
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    private static void printTableBottomLine(final List<Table> tables) {
        for (final Table table : tables) {
            printBottomLine(table);
        }
        System.out.println();
    }

    private static void printBottomLine(Table table) {
        if (table.isExistMenus()) {
            System.out.printf(EXIST_MENU_TABLE_BOTTOM_LINE, table);
            return;
        }
        System.out.printf(BOTTOM_LINE, table);
    }

    public static void printLimitChickenWarningMessage() {
        System.out.println("치킨의 수가 99개를 넘었습니다.");
    }
}
