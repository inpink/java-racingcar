package racingcar.domain;

public class TryCount {

    private final int count;

    public TryCount(int count) {
        this.count = count;
    }

    public static TryCount create(int count) {
        return new TryCount(count);
    }

    public int getCount() {
        return count;
    }
}
