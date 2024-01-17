package racingcar.mapper;

import java.util.Arrays;
import java.util.List;
import racingcar.domain.CarNames;
import racingcar.util.StringUtil;

public class CarNamesMapper {
    private CarNamesMapper() {
    }

    public static CarNames toCarNames(String input) {
        String spaceDeleted = StringUtil.deleteAllSpaces(input);

        List<String> carNames = Arrays.stream(input.split(","))
                .toList();

        return CarNames.create(carNames);
    }

}
