package racingcar.controller;

import racingcar.domain.CarNames;
import racingcar.domain.Cars;
import racingcar.domain.TryCount;
import racingcar.domain.Winners;
import racingcar.view.InputView;

public class RacingGameController {

    private final InputView inputView;

    public RacingGameController(InputView inputView) {
        this.inputView = inputView;
    }

    public void play() {
        CarNames carNames = inputView.inputCarNames();
        TryCount tryCount = inputView.inputTryCount();

        Cars cars = Cars.create(carNames);
        cars.moveRandomly(tryCount);

        /*Winners winners = Winners.create(cars.calculateWinner());
        System.out.println(winners.getWinners());*/
    }
}
