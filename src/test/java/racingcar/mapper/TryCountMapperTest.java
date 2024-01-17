package racingcar.mapper;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.TryCount;

class TryCountMapperTest {
    @ParameterizedTest
    @ValueSource(strings = {"1", "10", "123"})
    void toTryCount_withValidInput(String input) {
        // when
        TryCount tryCount = TryCountMapper.toTryCount(input);

        // then
        SoftAssertions.assertSoftly(softly -> {
            assertNotNull(tryCount);
            assertThat(tryCount.getCount()).isEqualTo(Integer.parseInt(input));
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "1.5", "-1", "0x10"})
    @NullAndEmptySource
    void toTryCount_withInvalidInput(String input) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> TryCountMapper.toTryCount(input));
    }
}

