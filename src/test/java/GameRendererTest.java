import org.example.Grid;
import org.example.GridRenderer;
import org.example.GridSeeder;
import org.junit.Test;


import java.io.ByteArrayOutputStream;
import java.io.PrintStream;


import static org.junit.jupiter.api.Assertions.*;

public class GameRendererTest {
    @Test
    public void testRenderGrid() {
        Grid grid = new Grid(3, 3);
        GridSeeder seeder = new GridSeeder(50);
        GridRenderer renderer = new GridRenderer();

        grid.seed(seeder);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream)); // Redirect output to capture it

        renderer.render(grid);

        String output = outputStream.toString();

        assertNotNull(output);
        assertFalse(output.isEmpty());

        System.setOut(System.out); // Restore System.out
    }

    @Test
    public void testRenderEmptyGrid() {
        Grid grid = new Grid(3, 3);
        GridRenderer renderer = new GridRenderer();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        renderer.render(grid);

        String output = outputStream.toString().trim();
        String expectedOutput = "---\n---\n---"; // Expected output for an empty grid

        assertEquals(expectedOutput, output);

        System.setOut(System.out);
    }

    @Test
    public void testRenderFullyAliveGrid() {
        Grid grid = new Grid(3, 3);
        GridSeeder seeder = new GridSeeder(100); // All cells alive
        GridRenderer renderer = new GridRenderer();

        grid.seed(seeder);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        renderer.render(grid);

        String output = outputStream.toString().trim();
        String expectedOutput = "***\n***\n***"; // Expected output for fully alive grid

        assertEquals(expectedOutput, output);

        System.setOut(System.out);
    }


}
