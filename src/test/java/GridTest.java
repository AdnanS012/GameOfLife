import org.example.Grid;
import org.example.GridEvolver;
import org.example.GridRenderer;
import org.example.GridSeeder;
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
    public void testGridSeeding() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        assertDoesNotThrow(() -> grid.seed(seeder));
    }

    @Test
    public void testGridEvolution() {
        Grid grid = new Grid(5, 5);
        GridSeeder seeder = new GridSeeder(50);
        GridEvolver evolver = new GridEvolver();

        grid.seed(seeder);
        assertDoesNotThrow(() -> grid.evolve(evolver));
    }


    @Test
    public void testGridRendering() {
        Grid grid = new Grid(5, 5);
        GridRenderer renderer = new GridRenderer();
        assertDoesNotThrow(() -> grid.render(renderer));
    }

}