import org.example.Grid;
import org.example.GridSeeder;
import org.junit.Test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GridSeederTest {
    @Test
    public void testGridSeederCreation() {
        assertDoesNotThrow(() -> new GridSeeder(50));
    }

    @Test
    public void testInvalidSeedPercentage() {
        assertThrows(IllegalArgumentException.class, () -> new GridSeeder(-10));
        assertThrows(IllegalArgumentException.class, () -> new GridSeeder(110));
    }

    @Test
    public void testGridSeedingDoesNotThrow() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        assertDoesNotThrow(() -> grid.seed(seeder));
    }

}
