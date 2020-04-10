package domain.table;

import domain.table.exception.NoExistTableNumberException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void checkTableNumber(int tableNumber) {
        boolean isNotExist = tables().stream()
                .noneMatch(table -> table.isSameTo(tableNumber));
        if (isNotExist) {
            throw new NoExistTableNumberException();
        }
    }

    public static Table find(int number) {
        return tables.stream()
                .filter(table -> table.isSameTo(number))
                .findFirst()
                .orElseThrow(NoExistTableNumberException::new);
    }
}
