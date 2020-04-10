package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRepositoryTest {
    @Test
    @DisplayName("메뉴 생성받기")
    void find() {
        Menu menu = MenuRepository.find(1);

        assertThat(menu).isEqualTo(new Menu(1, "후라이드", Category.CHICKEN, 16_000));
    }
}