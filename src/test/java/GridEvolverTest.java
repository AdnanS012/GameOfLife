import org.example.Grid;
import org.example.GridEvolver;
import org.example.GridSeeder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class GridEvolverTest {
    @Test
    public void testGridEvolvesWithoutErrors() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        GridEvolver evolver = new GridEvolver();

        grid.seed(seeder);
        assertDoesNotThrow(() -> grid.evolve(evolver));

    }
}
