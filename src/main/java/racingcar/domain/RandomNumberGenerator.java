package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class RandomNumberGenerator implements NumberGenerator {
    private final static int MIN_RANDOM_RANGE = 0;
    private final static int MAX_RANDOM_RANGE = 9;

    @Override
    public int generate() {
        return Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);
    }
}
