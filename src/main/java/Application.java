import domain.*;
import domain.command.Command;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Command command = InputView.inputFeatureNumber();
        while (command.isNotEnd()) {
            final List<Table> tables = TableRepository.tables();
            OutputView.printTables(tables);
            int tableNumber = InputView.inputTableNumber();
            Table table = TableRepository.find(tableNumber);
            if (command == Command.ORDER) {
                order(table);
            }
            if (command == Command.PAYMENT) {
                OutputView.printMenus(table.getMenus());
            }

            command = InputView.inputFeatureNumber();
        }
    }

    private static void order(Table table) {
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        // TODO: order 도 추상화 할 수 있지 않을까 ?
        int menuNumber = InputView.inputMenuNumber();
        Menu menu = MenuRepository.find(menuNumber);
        inputMenuAmount(table, menu);
    }

    private static void inputMenuAmount(Table table, Menu menu) {
        int menuAmount = InputView.inputMenuAmount();
        Menus order = Menus.of(menu, menuAmount);
        try {
            table.addMenus(order);
        } catch (LimitChickenSizeException e) {
            OutputView.printLimitChickenWarningMessage();
            inputMenuAmount(table, menu);
        }
    }
}
