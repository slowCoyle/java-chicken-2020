package domain.command;

import java.util.Arrays;

public enum Command {
    // TODO : 커맨드에 알맞는 동작 설정하기
    ORDER(1, "주문등록"),
    PAYMENT(2, "결제하기"),
    PROGRAM_END(3, "프로그램 종료");

    private final int number;
    private final String command;

    Command(int number, String command) {
        this.number = number;
        this.command = command;
    }

    public static Command of(String number) {
        int commandNumber = Integer.parseInt(number);

        return Arrays.stream(Command.values())
                .filter(command -> command.is(commandNumber))
                .findAny()
                .orElseThrow(CommandMissMatchException::new);
    }

    private boolean is(int number) {
        return this.number == number;
    }

    @Override
    public String toString() {
        return String.format("%d _ %s \n", number, command);
    }
}
