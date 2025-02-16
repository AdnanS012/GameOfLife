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
        System.setOut(new PrintStream(outputStream));

        grid.render(renderer);
        String output = outputStream.toString();

        assertNotNull(output);
        assertFalse(output.isEmpty());

        System.setOut(System.out);
    }


}
