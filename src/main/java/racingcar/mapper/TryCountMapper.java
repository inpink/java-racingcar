package racingcar.mapper;

import racingcar.domain.TryCount;
import racingcar.util.IntegerUtil;
import racingcar.util.StringUtil;

public class TryCountMapper {
    private final static String INVALID_INTEGER_INPUT = "정수가 필요합니다.";

    private TryCountMapper() {
    }

    public static TryCount toTryCount(String input) {
        String spaceDeleted = StringUtil.deleteAllSpaces(input);

        validateInteger(spaceDeleted);
        int parsedCount = Integer.parseInt(spaceDeleted);

        return TryCount.create(parsedCount);
    }

    private static void validateInteger(String spaceDeleted) {
        if (!IntegerUtil.isInteger(spaceDeleted)) {
            throw new IllegalArgumentException(INVALID_INTEGER_INPUT);
        }
    }
}
