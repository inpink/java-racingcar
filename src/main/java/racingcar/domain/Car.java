package racingcar.domain;

public class Car {
    private final static int MIN_MOVE_NUMBER = 4;
    private final NumberGenerator numberGenerator;
    private final CarName carName;
    private final Positions positions;

    private Car(NumberGenerator numberGenerator, CarName carName, Positions positions) {
        this.numberGenerator = numberGenerator;
        this.carName = carName;
        this.positions = positions;
    }

    public static Car create(CarName name, NumberGenerator numberGenerator) {
        return new Car(numberGenerator, name, Positions.createEmpty());
    }

    public void moveByNumber() {
        int moveNumber = numberGenerator.generate();

        if (moveNumber >= MIN_MOVE_NUMBER) {
            positions.move();
        }
        if (moveNumber < MIN_MOVE_NUMBER) {
            positions.notMove();
        }
    }

    public boolean isSameLastPosition(int lastPosition) {
        return lastPosition == getLastPosition();
    }

    public int getLastPosition() {
        return positions.getLastPosition();
    }

    public CarName getCarName() {
        return carName;
    }

    public int getPosition(int index) {
        return positions.getPosition(index);
    }
}
