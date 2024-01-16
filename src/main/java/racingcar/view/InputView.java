package racingcar.view;

import racingcar.domain.CarNames;
import racingcar.domain.TryCount;
import racingcar.mapper.CarNamesMapper;
import racingcar.mapper.TryCountMapper;
import racingcar.util.InputUtil;

public class InputView {
    private final String INPUT_CAR_NAMES = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private final String INPUT_TRY_COUNT = "시도할 회수는 몇회인가요?";

    public CarNames inputCarNames() {
        final String input = InputUtil.input();
        return CarNamesMapper.toCarNames(input);
    }

    public TryCount inputTryCount() {
        final String input = InputUtil.input();
        return TryCountMapper.toTryCount(input);
    }

}
