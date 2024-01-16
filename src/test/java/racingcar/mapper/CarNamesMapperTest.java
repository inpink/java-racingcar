package racingcar.mapper;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Assertions;

import java.util.stream.Stream;
import racingcar.domain.CarNames;

public class CarNamesMapperTest {

    @ParameterizedTest(name = "자동차 이름들을 ,로 구분하여 입력")
    @MethodSource("provideCarNames")
    void toCarNames(String input, List<String> expected) {
        // when
        CarNames carNames = CarNamesMapper.toCarNames(input);

        // then
        Assertions.assertEquals(expected, carNames.getCarNames());
    }

    private static Stream<Arguments> provideCarNames() {
        return Stream.of(
                Arguments.of("BMW,Mercedes,Audi", Arrays.asList("BMW", "Mercedes", "Audi")),
                Arguments.of("Ferrari,Lamborghini", Arrays.asList("Ferrari", "Lamborghini")),
                Arguments.of("Toyota", Arrays.asList("Toyota"))
        );
    }
}
