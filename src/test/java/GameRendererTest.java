import org.example.GameRenderer;
import org.example.Grid;
import org.junit.Test;


import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class GameRendererTest {

    @Test
    public void testConstructorWithNullScanner() {
        assertThrows(IllegalArgumentException.class, () -> new GameRenderer(null), "Constructor should throw IllegalArgumentException when scanner is null.");
    }

    @Test
    public void testRenderGrid() {
        Grid grid = new Grid(3, 3, 50);
        String simulatedInput = "\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        GameRenderer renderer = new GameRenderer(scanner);
        assertDoesNotThrow(() -> renderer.renderGrid(grid));
    }

    @Test
    public void testAskUserToContinue() {
        String simulatedInput = "\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        GameRenderer renderer = new GameRenderer(scanner);
        assertTrue(renderer.askUserToContinue(), "User pressing Enter should continue the game.");

        simulatedInput = "exit\n";
        scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        renderer = new GameRenderer(scanner);
        assertFalse(renderer.askUserToContinue(), "User typing 'exit' should quit the game.");
    }
    @Test
    public void testRenderGridOutput() {
        Grid grid = new Grid(3, 3, 20);
        String simulatedInput = "\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        GameRenderer renderer = new GameRenderer(scanner);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        renderer.renderGrid(grid);

        String output = outputStream.toString();
        assertNotNull(output);
        assertFalse(output.isEmpty());

        System.setOut(System.out);
    }


}
