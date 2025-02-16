
import org.junit.Test;
import java.io.ByteArrayInputStream;
import java.util.Scanner;


import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GameOfLifeTest {
    @Test
    public void testGameStartsAndStopsAutomatically() {
        String simulatedUserInput = "\n\nexit\n";
        Scanner mockScanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        GameOfLife game = new GameOfLife(5, 5, 50, mockScanner);
        assertDoesNotThrow(() -> game.start(5));
    }


    @Test
    public void testGameLoopEndsOnExit() {
        String simulatedInput = "\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 20, scanner);
        assertDoesNotThrow(() -> game.start(5));
    }

    @Test
    public void testGameWithZeroMaxGenerations() {
        Scanner mockScanner = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 20, mockScanner);
        game.start(0);
        assertDoesNotThrow(() -> game.start(0));
    }
}
