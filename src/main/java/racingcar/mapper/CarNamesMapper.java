package racingcar.mapper;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarNames;

public class CarNamesMapper {

    private CarNamesMapper() {
    }

    public static CarNames toCarNames(String input) {
        String spaceDeleted = input.replace(" ","");

        List<String> carNames = Arrays.stream(input.split(","))
                .toList();

        return CarNames.create(carNames);
    }

}
