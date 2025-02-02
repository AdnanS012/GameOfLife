import org.example.Grid;
import org.junit.Test;

import static org.junit.Assert.*;

public class GridTest {
    @Test
    public void testGridInitialization() {
        Grid grid = new Grid(5,5,0.5);
        assertNotNull(grid);
    }
    @Test
    public void testTick(){
        Grid grid = new Grid(5,5,0.5);
        grid.tick();
        assertNotNull(grid);
    }
    @Test
    public void testIsNotAllDead() {
        Grid grid = new Grid(5, 5, 1.0); // Initialize with 100% alive cells
        assertFalse(grid.isAllDead());
    }
    @Test
    public void testEvolveGrid(){
        Grid grid = new Grid(3,3,0.0);
        grid.seedGrid(1.0);
        grid.tick();
        assertFalse(grid.isAllDead());
    }
    @Test
    public void testIsAllDead() {
        Grid grid = new Grid(5, 5, 0.0); // Initialize with 100% dead cells
        assertTrue(grid.isAllDead());
    }
    @Test
    public void testPrintGridWithAliveCell(){
        Grid grid = new Grid(3,3,0.0);
        grid.seedGrid(5.0);
        grid.printGrid();
    }
    @Test
    public void testPrintGridWithDeadCell(){
        Grid grid = new Grid(3,3,0.0);
        grid.printGrid();
    }

    @Test
    public void testSeedGrid(){
        Grid grid = new Grid(3,3,0.0);
        grid.seedGrid(5.0);
        grid.printGrid();
    }
}
