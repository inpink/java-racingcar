package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CarNameTest {

    @ParameterizedTest
    @ValueSource(strings = {"A", "Ab", "ABC", "ABCD", "ABCDE"})
    void create_withValidLengths(String name) {
        // when
        CarName carName = CarName.create(name);

        // then
        SoftAssertions.assertSoftly(softly -> {
            assertNotNull(carName);
            assertEquals(name, carName.getName());
        });
    }

    @ParameterizedTest
    @ValueSource(strings = {"", " ", "ABCDEF"})
    void create_withInvalidLengths(String name) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> CarName.create(name));
    }
}

