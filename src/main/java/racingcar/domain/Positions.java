package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    private final List<Integer> positions;

    public Positions(List<Integer> positions) {
        this.positions = positions;
    }

    public static Positions createEmpty() {
        return new Positions(new ArrayList<>());
    }
}
