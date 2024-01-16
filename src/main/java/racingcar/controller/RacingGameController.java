package racingcar.controller;

import java.util.List;
import racingcar.domain.Car;
import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class RacingGameController {

    private final InputView inputView;
    private final OutputView outputView;

    public RacingGameController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void play() {
        CarNames carNames = inputView.inputCarNames();
        TryCount tryCount = inputView.inputTryCount();

        Cars cars = Cars.create(carNames);
        cars.moveRandomly(tryCount);

        List<Car> winners = cars.calculateWinner();
        output(tryCount, cars, winners);
    }

    private void output(TryCount tryCount, Cars cars, List<Car> winners) {
        outputView.outputPositions(tryCount, cars);
        outputView.outputWinners(winners);
    }
}
