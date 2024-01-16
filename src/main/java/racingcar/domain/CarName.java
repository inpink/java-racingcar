package racingcar.domain;

public class CarName {
    private final static int MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 5;

    private final String name;

    private CarName(String name) {
        this.name = name;
    }

    public static CarName create(String name) {
        return new CarName(name);
    }

    public String getName() {
        return name;
    }
}
