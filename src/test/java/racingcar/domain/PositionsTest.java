package racingcar.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class PositionsTest {

    @Test
    void testPositionsAfterMovesAndNotMoves() {
        // Given
        Positions positions = Positions.createEmpty();

        // When
        positions.move();
        positions.notMove();
        positions.move();

        List<Integer> expected = List.of(1, 1, 2);

        // Then
        assertEquals(expected, positions.getPositions());
    }
}
