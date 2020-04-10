package domain;

import domain.table.exception.NoExistTableNumberException;
import domain.table.Table;
import domain.table.TableRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @ParameterizedTest
    @ValueSource(ints = {0,4,7})
    @DisplayName("테이블 번호 존재 확인")
    void isExist(int tableNumber) {
        assertThatThrownBy(() -> TableRepository.checkTableNumber(tableNumber))
                .isInstanceOf(NoExistTableNumberException.class);
    }

    @Test
    @DisplayName("테이블 가져오기")
    void find() {
        System.out.println();
        assertThat(TableRepository.find(1)).isEqualTo(new Table(1));
    }
}