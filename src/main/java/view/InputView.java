package view;

import domain.MenuRepository;
import domain.NoExistMenuNumberException;
import domain.NoExistTableNumberException;
import domain.TableRepository;
import domain.command.Command;
import domain.command.CommandMissMatchException;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 테이블을 선택하세요.");
        String input = scanner.nextLine();

        try {
            int tableNumber = Integer.parseInt(input);
            return validTableNumberExist(tableNumber);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            return inputTableNumber();
        }
    }

    private static int validTableNumberExist(int input) {
        try {
            TableRepository.checkTableNumber(input);
            return input;
        } catch (NoExistTableNumberException e) {
            System.out.println("존재하지 않습니다.");
            return inputTableNumber();
        }
    }

    public static Command inputFeatureNumber() {
        System.out.println("## 메인 화면");
        System.out.println(makeCommandString());

        try {
            return Command.of(scanner.nextLine());
        } catch (CommandMissMatchException | NumberFormatException e) {
            System.out.println("기능에 알맞은 숫자를 입력해주세요");
            return inputFeatureNumber();
        }
    }

    private static StringBuilder makeCommandString() {
        StringBuilder stringBuilder = new StringBuilder();

        Arrays.stream(Command.values())
                .map(Command::toString)
                .forEach(stringBuilder::append);

        return stringBuilder;
    }

    public static int inputMenuNumber() {
        System.out.println("## 등록할 메뉴를 선택하세요.");
        String input = scanner.nextLine();

        try {
            int menuNumber = Integer.parseInt(input);
            return validMenuNumberExist(menuNumber);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            return inputMenuNumber();
        }
    }

    private static int validMenuNumberExist(int number) {
        try {
            MenuRepository.checkMenuNumber(number);
            return number;
        } catch (NoExistMenuNumberException e) {
            System.out.println("존재하지 않습니다.");
            return inputMenuNumber();
        }
    }

    public static int inputMenuAmount() {
        System.out.println("## 메뉴의 수량을 입력하세요.");
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println("숫자를 입력해주세요");
            return inputMenuNumber();
        }
    }
}