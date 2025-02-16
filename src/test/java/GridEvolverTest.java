import org.example.*;
import org.junit.jupiter.api.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

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
    public void testEmptyGridStaysEmpty() {
        Grid grid = new Grid(3, 3);
        GridSeeder seeder = new GridSeeder(0);
        grid.seed(seeder);

        GridEvolver evolver = new GridEvolver();
        evolver.evolve(grid);

        // All cells should still be dead
        assertTrue(grid.allCellsDead(), "A fully empty grid should stay empty after evolution.");
    }

    @Test
    public void testEvolutionPreservesSomeCells() {
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

        assertTrue(someCellsStillAlive[0], "At least some cells should still be alive after evolution.");
    }

}
