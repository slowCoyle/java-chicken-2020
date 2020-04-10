package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ChickenLimitCheckerTest {

    @ParameterizedTest
    @MethodSource("provideisLimit")
    @DisplayName("제한을 넘어가는 사이즈 검사")
    void isLimit(int chickenSize, boolean result) {
        assertThat(ChickenLimitChecker.isLimit(chickenSize)).isEqualTo(result);
    }

    private static Stream<Arguments> provideisLimit() {
        return Stream.of(
                Arguments.of(99, false),
                Arguments.of(100, true)
        );
    }
}