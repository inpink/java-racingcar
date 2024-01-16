package racingcar.domain;

import static racingcar.domain.Positions.START_POSITION;

import java.util.List;

public class Cars {
    private final List<Car> cars;

    private Cars(List<Car> cars) {
        this.cars = cars;
    }

    public static Cars create(CarNames carNames) {
        List<Car> cars = carNames.getCarNames().stream()
                .map(name -> Car.create(name))
                .toList();

        return new Cars(cars);
    }

    public void moveRandomly(TryCount tryCount) {
        for (int i=0; i<tryCount.getCount(); i++) {
            cars.stream()
                    .forEach(car -> car.moveRandomly());
        }
    }

    public List<Car> calculateWinner() {
        int maxPosition = calculateMaxPosition();

        return cars.stream()
                .filter(car -> car.isSameMaxPosition(maxPosition))
                .toList();
    }

    public int calculateMaxPosition() {
        return cars.stream()
                .mapToInt(car -> car.getMaxPosition())
                .max()
                .orElse(START_POSITION);
    }

    public List<Car> getCars() {
        return cars;
    }
}
