package racingcar.domain;

import java.util.List;

public class CarNames {

    private final List<CarName> carNames;

    private CarNames(List<CarName> carNames) {
        this.carNames = carNames;
    }

    public static CarNames create(List<String> carNames) {
        List<CarName> convertedCarNames = carNames.stream()
                .map(name -> CarName.create(name))
                .toList();

        return new CarNames(convertedCarNames);
    }

    public List<String> getCarNames() {
        return carNames.stream()
                .map(name -> name.getName())
                .toList();
    }
}
