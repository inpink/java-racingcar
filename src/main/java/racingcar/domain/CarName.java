package racingcar.domain;

import racingcar.util.StringUtil;

public class CarName {
    private final static int MIN_LENGTH = 1;
    private final static int MAX_LENGTH = 5;
    private final static String INVALID_NAME_LENGTH = "올바르지 않은 자동차 이름 길이입니다.";

    private final String name;

    private CarName(String name) {
        final String spaceDeleted = StringUtil.deleteAllSpaces(name);

        validate(spaceDeleted);

        this.name = spaceDeleted;
    }

    public static CarName create(String name) {
        return new CarName(name);
    }

    private void validate(String name) {
        validateLength(name);
    }

    private void validateLength(String name) {
        if (name.length() < MIN_LENGTH || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException(INVALID_NAME_LENGTH);
        }
    }

    public String getName() {
        return name;
    }
}
