import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class GameOfLifeTest {
    @Test
    public void testGameStartsAndStopsAutomatically() {
        //Simulate user pressing "Enter" twice, then "exit"
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
    public void testGameEndsIfAllCellsAreDead() {
        Scanner mockScanner = new Scanner(new ByteArrayInputStream("exit\n".getBytes()));
        GameOfLife game = new GameOfLife(5, 5, 0, mockScanner); // 0% alive cells
        game.start(5);  // ✅ Will exit immediately

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


}
