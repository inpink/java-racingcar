package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private final static int MIN_RANDOM_RANGE = 0;
    private final static int MAX_RANDOM_RANGE = 9;
    private final static int MIN_MOVE_NUMBER = 4;

    private final CarName carName;
    private final Positions positions;

    private Car(CarName carName, Positions positions) {
        this.carName = carName;
        this.positions = positions;
    }

    public static Car create(CarName name) {
        return new Car(name, Positions.createEmpty());
    }

    public void moveRandomly() {
        int randomNumber = Randoms.pickNumberInRange(MIN_RANDOM_RANGE, MAX_RANDOM_RANGE);

        if (randomNumber >= MIN_MOVE_NUMBER) {
            positions.move();
        }
        if (randomNumber < MIN_MOVE_NUMBER) {
            positions.notMove();
        }
    }

    public boolean isSameMaxPosition(int maxPosition) {
        return maxPosition == getMaxPosition();
    }

    public int getMaxPosition() {
        return positions.getLastPosition();
    }

    public CarName getCarName() {
        return carName;
    }

    public Positions getPositions() {
        return positions;
    }

    public int getPosition(int index) {
        return positions.getPosition(index);
    }
}
