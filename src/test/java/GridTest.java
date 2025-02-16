import org.example.Grid;
import org.example.GridEvolver;
import org.example.GridRenderer;
import org.example.GridSeeder;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


public class GridTest {
    @Test
    public void testGridCreation() {
        assertDoesNotThrow(() -> new Grid(5, 5));

    }

    @Test
    public void testGridInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Grid(5, -1));
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, -1));
    }

    @Test
    public void testGridSeeding() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        assertDoesNotThrow(() -> grid.seed(seeder));
    }

    @Test
    public void testAllCellsDeadInitially() {
        Grid grid = new Grid(3, 3);
        assertTrue(grid.allCellsDead(), "Grid should start with all dead cells.");
    }



    @Test
    public void testAllCellsDeadAfterSeedingWithZeroPercentage() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(0); // 0% chance of alive cells
        grid.seed(seeder);

        assertTrue(grid.allCellsDead(), "After seeding with 0%, grid should remain dead.");
    }

    @Test
    public void testGridChangesAfterEvolution() {
        Grid grid = new Grid(3, 3);
        GridSeeder seeder = new GridSeeder(100); // All cells start alive
        grid.seed(seeder);

        GridEvolver evolver = new GridEvolver();
        StringBuilder beforeEvolution = new StringBuilder();
        StringBuilder afterEvolution = new StringBuilder();

        GridRenderer renderer = new GridRenderer();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // Capture grid state before evolution
        renderer.render(grid);
        beforeEvolution.append(outputStream.toString().trim());
        outputStream.reset();

        // Perform evolution
        evolver.evolve(grid);

        // Capture grid state after evolution
        renderer.render(grid);
        afterEvolution.append(outputStream.toString().trim());
        System.setOut(System.out);

        // The grid state should change after evolution
        assertNotEquals(beforeEvolution.toString(), afterEvolution.toString(),
                "Grid should change after evolution, proving applyEvolution() is working.");
    }
    @Test
    public void testSomeCellsSurviveAfterEvolution() {
        Grid grid = new Grid(3, 3);
        GridSeeder seeder = new GridSeeder(50); // 50% chance of alive cells
        grid.seed(seeder);

        GridEvolver evolver = new GridEvolver();
        evolver.evolve(grid);

        boolean[] someCellsStillAlive = {false};

        GridRenderer renderer = new GridRenderer();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        renderer.render(grid);
        String output = outputStream.toString().trim();
        System.setOut(System.out);

        if (output.contains("*")) {
            someCellsStillAlive[0] = true;
        }

        assertTrue(someCellsStillAlive[0], "Some cells should still be alive after evolution.");
    }

}