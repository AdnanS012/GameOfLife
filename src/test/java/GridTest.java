import org.example.Grid;
import org.junit.Test;

import static org.junit.Assert.assertNotNull;

public class GridTest {
    @Test
    public void testGridInitialization() {
        Grid grid = new Grid(5,5,0.5);
        assertNotNull(grid);
    }
}
