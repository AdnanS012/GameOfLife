import org.example.GameRenderer;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameOfLifeTest {
    @Test
    public void testGameStartsAndStopsAutomatically() {
        String simulatedUserInput = "\n\nexit\n";
        Scanner mockScanner = new Scanner(new ByteArrayInputStream(simulatedUserInput.getBytes()));

        GameOfLife game = new GameOfLife(5, 5, 50, mockScanner);
        assertDoesNotThrow(() -> game.start(5));
    }


}
