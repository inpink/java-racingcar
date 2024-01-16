package racingcar.util;

public class IntegerUtil {

    private IntegerUtil() {
    }

    public static boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
            return true;
        } catch (NumberFormatException ex) {
            return false;
        }
    }
}
