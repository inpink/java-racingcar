package racingcar;

import racingcar.controller.RacingGameController;
import racingcar.domain.RandomNumberGenerator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Application {
    public static void main(String[] args) {
        RacingGameController racingGameController = new RacingGameController(
                new InputView(),
                new OutputView(),
                new RandomNumberGenerator());

        racingGameController.play();
    }
}
