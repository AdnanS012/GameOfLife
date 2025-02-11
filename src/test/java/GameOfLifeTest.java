import org.example.GameRenderer;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameOfLifeTest {
    @Test
    public void testGameStartsAndStopsAutomatically() {
        String simulatedUserInput = "\n\nexit\n";
        Scanner mockScanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        GameOfLife game = new GameOfLife(5,5,50, mockScanner);
        game.start(5);  // max 5 generations

        assertNotNull(game);
    }
    @Test
    public void testGameInitialization() {
        Scanner mockScanner = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        GameOfLife game = new GameOfLife(5,5,50, mockScanner);
        assertNotNull(game);
    }


    @Test
    public void testConstructorWithNullScanner() {
        assertThrows(IllegalArgumentException.class, () -> new GameRenderer(null), "Constructor should throw IllegalArgumentException when scanner is null.");
    }

    @Test
    public void testGameEndsIfAllCellsAreDead() {
        Scanner mockScanner = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 0, mockScanner); // 0% alive cells
        game.start(5);  //Will exit immediately

        assertTrue(game.isAllCellsDead());
    }
    @Test
    public void testGameLoopEndsOnExit() {
        String simulatedInput = "\nexit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 50, scanner);
        game.start(5);
        assertNotNull(game);
    }

    @Test
    public void testGameEndsWhenAllCellsDead() {
        String simulatedInput = "exit\n";
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 0, scanner);
        game.start(5);
        assertTrue(game.isAllCellsDead());
    }
    @Test
    public void testGameWithZeroMaxGenerations() {
        Scanner mockScanner = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 50, mockScanner);
        game.start(0);
        assertFalse(game.isAllCellsDead());
    }

}
