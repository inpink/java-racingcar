package racingcar.domain;

public class TryCount {
    private final static int MIN_COUNT = 1;
    private final static String INVALID_TRY_COUNT = "올바르지 않은 시도 횟수입니다.";


    private final int count;

    public TryCount(int count) {
        validate(count);
        this.count = count;
    }

    public static TryCount create(int count) {
        return new TryCount(count);
    }

    private void validate(int count) {
        validateCount(count);
    }

    private void validateCount(int count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(INVALID_TRY_COUNT);
        }
    }

    public int getCount() {
        return count;
    }
}
