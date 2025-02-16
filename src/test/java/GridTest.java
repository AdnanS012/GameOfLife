import org.example.Grid;
import org.example.GridSeeder;
import org.junit.Test;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;


public class GridTest {
    @Test
    public void testGridCreation() {
        assertDoesNotThrow(() -> new Grid(5, 5));

    }

    @Test
    public void testGridInvalidDimensions() {
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, 5));
        assertThrows(IllegalArgumentException.class, () -> new Grid(5, -1));
        assertThrows(IllegalArgumentException.class, () -> new Grid(-1, -1));
    }

    @Test
    public void testGridSeeding() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        assertDoesNotThrow(() -> grid.seed(seeder));
    }

    @Test
    public void testAllCellsDeadInitially() {
        Grid grid = new Grid(3, 3);
        assertTrue(grid.allCellsDead(), "Grid should start with all dead cells.");
    }



    @Test
    public void testAllCellsDeadAfterSeedingWithZeroPercentage() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(0); // 0% chance of alive cells
        grid.seed(seeder);

        assertTrue(grid.allCellsDead(), "After seeding with 0%, grid should remain dead.");
    }




}