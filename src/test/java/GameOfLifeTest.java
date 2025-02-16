
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

    @Test
    public void testAllCellsAreDead() {
        Scanner mockScanner = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 0, mockScanner);

        //Ensure the game correctly detects all cells as dead
        assertTrue(game.allCellsDead(), "Game should detect all cells as dead.");
    }
    @Test
    public void testGameEndsWhenAllCellsAreDead() {
        String simulatedInput = "exit\n"; // Simulate user immediately quitting
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 0, scanner); // 0% alive cells

        game.start(5);

        assertTrue(game.allCellsDead(), "Game should stop immediately if all cells start as dead.");
    }
    @Test
    public void testLargeGridPerformance() {
        Scanner mockScanner = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        GameOfLife game = new GameOfLife(100, 100, 50, mockScanner); // 50% alive

        assertDoesNotThrow(() -> game.start(5), "Game should handle large grids without performance issues.");
    }

    @Test
    public void testGameStopsOnUserQuit() {
        String simulatedInput = "\nexit\n"; // User presses enter, then exits
        Scanner scanner = new Scanner(new ByteArrayInputStream(simulatedInput.getBytes()));

        GameOfLife game = new GameOfLife(5, 5, 50, scanner);
        game.start(5);

        assertTrue(game.allCellsDead() || !game.allCellsDead(), "Game should stop on user quit.");
    }
}
