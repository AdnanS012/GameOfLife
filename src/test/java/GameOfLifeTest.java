import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameOfLifeTest {
    @Test
    public void testGameOfLifeInitialization() {
        GameOfLife game = new GameOfLife();
        assertNotNull(game);
    }

}
