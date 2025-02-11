import org.example.Cell;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class CellTest {
    @Test
    public void testIllegalNeighborCount() {
        Cell cell = new Cell(true);
        assertThrows(IllegalArgumentException.class, () -> cell.computeNextState(-1));
    }
    @Test
    public void testCellCreation() {
        assertDoesNotThrow(() -> new Cell(true));
        assertDoesNotThrow(() -> new Cell(false));
    }

    @Test
    public void testCellEvolutionBehavior() {
        Cell aliveCell = new Cell(true);
        Cell deadCell = new Cell(false);

        // Compute next state but don't evolve yet
        aliveCell.computeNextState(2);  // Should stay alive
        aliveCell.evolve();
        assertDoesNotThrow(() -> aliveCell.evolve());  // Ensure evolving doesn't break

        deadCell.computeNextState(3); // Should become alive
        deadCell.evolve();
        assertDoesNotThrow(() -> deadCell.evolve());
    }

}
