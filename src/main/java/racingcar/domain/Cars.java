package racingcar.domain;

import static racingcar.domain.Positions.START_POSITION;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(CarNames carNames, NumberGenerator numberGenerator) {
        List<Car> cars = carNames.getCarNames().stream()
                .map(name -> Car.create(name, numberGenerator))
                .toList();

        return new Cars(cars);
    }

    public void moveRandomly(TryCount tryCount) {
        for (int i = 0; i < tryCount.getCount(); i++) {
            cars.stream()
                    .forEach(car -> car.moveByNumber());
        }
    }

    public List<Car> calculateWinner() {
        int maxPosition = calculateMaxPosition();

        return cars.stream()
                .filter(car -> car.isSameLastPosition(maxPosition))
                .toList();
    }

    public int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getLastPosition())
                .max()
                .orElse(START_POSITION);
    }

    public List<Car> getCars() {
        return cars;
    }
}
