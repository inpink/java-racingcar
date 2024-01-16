package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class Positions {

    private final static int START_POSITION = 0;
    private final List<Integer> positions;

    public Positions(List<Integer> positions) {
        this.positions = positions;
    }

    public static Positions createEmpty() {
        return new Positions(new ArrayList<>());
    }

    public void move() {
        positions.add(getLastPosition() + 1);
    }

    public void notMove() {
        positions.add(getLastPosition());
    }

    private int getLastPosition() {
        if (positions.size() == 0) {
            return START_POSITION;
        }
        return positions.get(positions.size() - 1);
    }

    public List<Integer> getPositions() {
        return positions;
    }
}
