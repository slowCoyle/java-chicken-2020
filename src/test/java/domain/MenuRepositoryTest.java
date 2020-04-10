package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class MenuRepositoryTest {
    @Test
    @DisplayName("메뉴 생성받기")
    void find() {
        Menu menu = MenuRepository.find(1);

        assertThat(menu).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }

    @ParameterizedTest
    @DisplayName("잘못된 메뉴 번호 생성")
    @ValueSource(ints = {0, 7, 20, 23})
    void checkMenuNumber(int menuNumber) {
        assertThatThrownBy(() -> MenuRepository.checkMenuNumber(menuNumber))
                .isInstanceOf(NoExistMenuNumberException.class);
    }
}