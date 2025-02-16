import org.example.Cell;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

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

        // Alive cell with 2 or 3 neighbors should remain alive
        aliveCell.computeNextState(2);
        aliveCell.evolve();
        final boolean[] wasExecuted = {false};
        aliveCell.executeIfAlive(() -> wasExecuted[0] = true);
        assertTrue(wasExecuted[0], "Alive cell should execute action.");

        // Dead cell with exactly 3 neighbors should become alive
        deadCell.computeNextState(3);
        deadCell.evolve();
        final boolean[] executedForDeadCell = {false};
        deadCell.executeIfAlive(() -> executedForDeadCell[0] = true);
        assertTrue(executedForDeadCell[0], "Dead cell should have come alive and executed action.");
    }

    @Test
    public void testCellRendering() {
        Cell aliveCell = new Cell(true);
        Cell deadCell = new Cell(false);

        StringBuilder outputAlive = new StringBuilder();
        StringBuilder outputDead = new StringBuilder();

        aliveCell.render(outputAlive);
        deadCell.render(outputDead);

        assertEquals("*", outputAlive.toString());
        assertEquals("-", outputDead.toString());
    }
    @Test
    public void testExecuteIfAliveDoesNotRunForDeadCell() {
        Cell deadCell = new Cell(false);
        final boolean[] wasExecuted = {false};

        deadCell.executeIfAlive(() -> wasExecuted[0] = true);

        assertFalse(wasExecuted[0], "Action should NOT run for a dead cell.");
    }


}
