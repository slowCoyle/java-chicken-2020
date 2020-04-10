package view;

import domain.NoExistTableNumberException;
import domain.TableRepository;
import domain.command.Command;
import domain.command.CommandMissMatchException;

import java.util.Arrays;
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        String input = scanner.nextLine();

        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException | NoExistTableNumberException e) {
            System.out.println("숫자를 입력해주세요");
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
}
