package racingcar.view;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;

public class OutputView {
    public void outputWinners(List<Car> winners) {
        winners.stream()
                .forEach(winner -> System.out.println("우승자: " + winner.getCarName().getName()));
    }

    public void outputPositions(TryCount tryCount, Cars cars) {
        for (int index = 0; index < tryCount.getCount(); index++) {
            final int finalIndex = index;
            cars.getCars().stream()
                    .forEach(car -> System.out.println(car.getCarName().getName() + car.getPosition(finalIndex)));
            System.out.println();
        }
    }
}
