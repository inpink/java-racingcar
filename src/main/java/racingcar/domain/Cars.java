package racingcar.domain;

import java.util.List;
import java.util.stream.IntStream;

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
}
