import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GameOfLifeTest {
    @Test
    public void testGameOfLifeInitialization() {
        GameOfLife game = new GameOfLife(5,5,0.5);
        assertNotNull(game);
    }
    @Test
    public void testGameOfLifeStart(){
        GameOfLife game = new GameOfLife(5,5,0.5);
        game.start();
        assertNotNull(game);
    }

}
