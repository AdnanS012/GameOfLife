import org.example.Grid;
import org.example.GridEvolver;
import org.example.GridSeeder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GridEvolverTest {

    @Test
    public void testGridEvolvesWithoutErrors() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        GridEvolver evolver = new GridEvolver();

        grid.seed(seeder);
        assertDoesNotThrow(() -> evolver.evolve(grid));
    }



    @Test
    public void testNeighborCounting() {
        Grid grid = new Grid(3, 3);
        GridSeeder seeder = new GridSeeder(100); // All cells alive
        grid.seed(seeder);

        GridEvolver evolver = new GridEvolver();
        int count = evolver.countAliveNeighbors(grid, 1, 1);

        assertEquals(8, count, "A fully populated grid center should have 8 live neighbors.");
    }

    @Test
    public void testNeighborCountingOnEmptyGrid() {
        Grid grid = new Grid(3, 3);
        GridEvolver evolver = new GridEvolver();

        int count = evolver.countAliveNeighbors(grid, 1, 1);

        assertEquals(0, count, "All neighbors should be dead in an empty grid.");
    }
}
