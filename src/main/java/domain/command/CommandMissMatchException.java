package domain.command;

public class CommandMissMatchException extends IllegalArgumentException {
    private static final String COMMAND_MISMATCH_EXCEPTION = "잘못된 커맨드가 입력되었습니다.";

    public CommandMissMatchException() {
        super(COMMAND_MISMATCH_EXCEPTION);
    }
}
