import org.example.*;

import java.util.Scanner;

public class GameOfLife {
private final Grid grid;
    private final GridSeeder seeder;
    private final GridEvolver evolver;
    private final GridRenderer renderer;
    private final Scanner scanner;

    public GameOfLife(int rows,int cols,int seedPercentage,Scanner scanner){
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null.");
        }
        this.grid = new Grid(rows, cols);
        this.seeder = new GridSeeder(seedPercentage);
        this.evolver = new GridEvolver();
        this.renderer = new GridRenderer();
        this.scanner = scanner;

        grid.seed(seeder);

    }

    public void start(int maxGenerations) {
        if(maxGenerations <0){
            throw new IllegalArgumentException("Max generations must be greater than zero.");
        }
        int generation = 0;

        while (generation < maxGenerations) {
            grid.render(renderer);
            if (allCellsDead()) {
                System.out.println("All cells are dead. Game Over!");
                break;
            }
          if(!askUserToContinue()){
              break;
          }

            grid.evolve(evolver);
            generation++;
        }
    }

    public boolean allCellsDead() {
        return grid.allCellsDead();
    }

    private boolean askUserToContinue() {
        System.out.println("Press Enter to continue or type 'exit' to quit");
        return !scanner.nextLine().trim().equalsIgnoreCase("exit");
    }


}
