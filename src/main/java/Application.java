import domain.Menu;
import domain.MenuRepository;
import domain.Table;
import domain.TableRepository;
import domain.command.Command;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        Command command = InputView.inputFeatureNumber();
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
        int tableNumber = InputView.inputTableNumber();

        if (command == Command.ORDER) {
            final List<Menu> menus = MenuRepository.menus();
            OutputView.printMenus(menus);

            Table table = TableRepository.find(1);
            int menuNumber = InputView.inputMenuNumber();
            int menuAmount = InputView.inputMenuAmount();

        }


    }
}
