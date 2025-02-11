import org.example.Grid;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class GridTest {
    @Test
    public void testGridCreation() {
        assertDoesNotThrow(() -> new Grid(5, 5));

    }

    @Test
    public void testGridInvalidDimensions(){
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Grid(5, -1));
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, -1));
    }
    @Test
    public void testAllCellsDead() {
        Grid grid = new Grid(5, 5);
        assertTrue(grid.allCellsDead());
    }


}