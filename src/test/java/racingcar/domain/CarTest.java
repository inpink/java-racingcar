package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class CarTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    private static class TestNumberGenerator implements NumberGenerator {
        private final int numberToReturn;

        public TestNumberGenerator(int numberToReturn) {
            this.numberToReturn = numberToReturn;
        }

        @Override
        public int generate() {
            return numberToReturn;
        }
    }

    @Test
    void move() {
        // given
        Car car = Car.create(CarName.create("car"), new TestNumberGenerator(MOVING_FORWARD));

        // when
        car.moveByNumber();

        // then
        assertEquals(1, car.getLastPosition());
    }

    @Test
    void notMove() {
        // given
        Car car = Car.create(CarName.create("car"), new TestNumberGenerator(STOP));

        // when
        car.moveByNumber();

        // then
        assertEquals(0, car.getLastPosition());
    }
}

