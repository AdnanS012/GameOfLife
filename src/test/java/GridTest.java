import org.example.Grid;
import org.example.GridEvolver;
import org.example.GridRenderer;
import org.example.GridSeeder;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;


public class GridTest {
    @Test
    public void testGridCreation() {
        assertDoesNotThrow(() -> new Grid(5, 5));

    }

    @Test
    public void testGridInvalidDimensions(){
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
    public void testAllCellsDeadAfterEvolution() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(0); // 0% chance of alive cells
        grid.seed(seeder);

        GridEvolver evolver = new GridEvolver();
        grid.evolve(evolver);

        assertTrue(grid.allCellsDead(), "After evolution, grid should remain dead.");
    }

    @Test
    public void testGridEvolution() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        GridEvolver evolver = new GridEvolver();

        grid.seed(seeder);
        assertDoesNotThrow(() -> grid.evolve(evolver));
    }


    @Test
    public void testGridRendering() {
        Grid grid = new Grid(5, 5);
        GridRenderer renderer = new GridRenderer();
        assertDoesNotThrow(() -> grid.render(renderer));
    }
    @Test
    public void testGridRenderingShoudhaveValidCharacter() {
        Grid grid = new Grid(3, 3);
        GridSeeder seeder = new GridSeeder(50);
        GridRenderer renderer = new GridRenderer();
        grid.seed(seeder);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        grid.render(renderer);
        String output = outputStream.toString().trim();

        assertNotNull(output);
        assertFalse(output.isEmpty());
        assertTrue(output.matches("[*\\-\\s]+"), "Grid output should only contain '*' and '-'.");

        System.setOut(System.out);
    }

}