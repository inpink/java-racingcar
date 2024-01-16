package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.SoftAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class CarNamesTest {

    static Stream<List<String>> validCarNamesProvider() {
        return Stream.of(
                List.of("Car1"),
                List.of("Car1", "Car2"),
                List.of("A", "B", "C", "D", "E")
        );
    }

    static Stream<List<String>> invalidCarNamesProvider() {
        return Stream.of(
                List.of(),
                List.of(" ", " "),
                List.of("Car", "Car"), // duplicated
                List.of("A", "B", "A") // duplicated
        );
    }

    @ParameterizedTest
    @MethodSource("validCarNamesProvider")
    void create_withValidNumberOfNames(List<String> names) {
        // when
        CarNames carNames = CarNames.create(names);

        // then
        SoftAssertions.assertSoftly(softly -> {
            assertNotNull(carNames);
            assertEquals(names.size(), carNames.getCarNames().size());
        });
    }

    @ParameterizedTest
    @MethodSource("invalidCarNamesProvider")
    void create_withInvalidNumberOfNames(List<String> names) {
        // when & then
        assertThrows(IllegalArgumentException.class, () -> CarNames.create(names));
    }
}
