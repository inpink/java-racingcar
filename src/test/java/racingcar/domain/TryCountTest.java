package racingcar.domain;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class TryCountTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 5, 10})
    void create_withValidCount(int count) {
        // when
        TryCount tryCount = TryCount.create(count);

        // then
        SoftAssertions.assertSoftly(softly -> {
            assertNotNull(tryCount);
            assertEquals(count, tryCount.getCount());
        });
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, -10})
    void create_withInvalidCount(int count) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> TryCount.create(count));
    }
}

