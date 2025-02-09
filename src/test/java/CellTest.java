import org.example.Cell;
import org.junit.Test;

import static org.junit.Assert.*;

public class CellTest {
    @Test
    public void testCellAliveOrDead() {
        Cell aliveCell = new Cell(true);
        Cell deadCell = new Cell(false);
        assertNotNull(aliveCell);
        assertNotNull(deadCell);
    }
    @Test
    public void testCellEvolve() {
        Cell aliveCell = new Cell(true);
        Cell deadCell = new Cell(false);

        // Alive cell with 2 or 3 neighbors stays alive
        assertEquals(aliveCell, aliveCell.evolve(2));
        assertEquals(aliveCell, aliveCell.evolve(3));

        // Alive cell with less than 2 or more than 3 neighbors dies
        assertEquals(new Cell(false), aliveCell.evolve(1));
        assertEquals(new Cell(false), aliveCell.evolve(4));

        // Dead cell with exactly 3 neighbors becomes alive
        assertEquals(new Cell(true), deadCell.evolve(3));

        // Dead cell with other than 3 neighbors stays dead
        assertEquals(deadCell, deadCell.evolve(2));
        assertEquals(deadCell, deadCell.evolve(4));
    }


    @Test
    public void testCellDisplay() {
        Cell aliveCell = new Cell(true);
        Cell deadCell = new Cell(false);
        assertEquals('*', aliveCell.display());
        assertEquals('-', deadCell.display());
    }
    @Test
    public void testEvolveWithNegativeNeighbors() {
        Cell aliveCell = new Cell(true);
        assertThrows(IllegalArgumentException.class, () -> aliveCell.evolve(-1));
    }
    @Test
    public void testEvolveWithMoreThanThreeNeighbors() {
        Cell aliveCell = new Cell(true);
        Cell deadCell = new Cell(false);

        // Alive cell with more than 3 neighbors dies
        assertEquals(new Cell(false), aliveCell.evolve(4));

        // Dead cell with more than 3 neighbors stays dead
        assertEquals(deadCell, deadCell.evolve(4));
    }

}
