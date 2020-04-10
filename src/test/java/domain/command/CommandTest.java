package domain.command;

import domain.command.exception.CommandMissMatchException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CommandTest {
    @Test
    @DisplayName("터무니 없는 커맨드 입력")
    void of() {
        assertThatThrownBy(() -> Command.of("4")).isInstanceOf(CommandMissMatchException.class);
    }

    @ParameterizedTest
    @MethodSource("provideOf")
    @DisplayName("알맞은 커맨드 입력")
    void of2(String commandNumber, Command command) {
        assertThat(Command.of(commandNumber)).isEqualTo(command);
        assertThatThrownBy(() -> Command.of("4")).isInstanceOf(CommandMissMatchException.class);
    }

    private static Stream<Arguments> provideOf() {
        return Stream.of(
                Arguments.of("1", Command.ORDER),
                Arguments.of("2", Command.PAYMENT),
                Arguments.of("3", Command.PROGRAM_END)
        );
    }

    @Test
    void isNotEnd() {
        Command command = Command.of("1");
        assertThat(command.isNotEnd()).isTrue();
    }
}