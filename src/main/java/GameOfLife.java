import org.example.GameRenderer;
import org.example.Grid;

import java.util.Scanner;

public class GameOfLife {
private final Grid grid;
private final GameRenderer renderer;


    public GameOfLife(int rows,int cols,int seedPercentage,Scanner scanner){
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null.");
        }
        this.grid = new Grid(rows,cols,seedPercentage);
        this.renderer = new GameRenderer(scanner);

    }

    public void start(int maxGenerations) {
        if(maxGenerations <0){
            throw new IllegalArgumentException("Max generations must be greater than zero.");
        }
        int generation = 0;

        while (generation < maxGenerations) {
            renderer.renderGrid(grid);
            if (grid.isAllDead()) {
                System.out.println("All cells are dead. Game Over!");
                break;
            }
          if(!renderer.askUserToContinue()){
              break;
          }

            grid.tick();
            generation++;
        }
    }
    public boolean isAllCellsDead() {
        return grid.isAllDead();
    }

}
