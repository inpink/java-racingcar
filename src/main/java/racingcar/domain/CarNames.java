package racingcar.domain;

import java.util.List;

public class CarNames {
    private final static int MIN_COUNT = 1;
    private final static String INVALID_NAMES_COUNT = "올바르지 않은 자동차 개수입니다.";


    private final List<CarName> carNames;

    private CarNames(List<CarName> carNames) {
        validate(carNames);
        this.carNames = carNames;
    }

    public static CarNames create(List<String> carNames) {
        List<CarName> convertedCarNames = carNames.stream()
                .map(name -> CarName.create(name))
                .toList();

        return new CarNames(convertedCarNames);
    }

    private void validate(List<CarName> carNames) {
        validateSize(carNames);
    }

    private void validateSize(List<CarName> carNames) {
        if (carNames.size() < MIN_COUNT) {
            throw new IllegalArgumentException(INVALID_NAMES_COUNT);
        }
    }

    public List<String> getCarNames() {
        return carNames.stream()
                .map(name -> name.getName())
                .toList();
    }
}
