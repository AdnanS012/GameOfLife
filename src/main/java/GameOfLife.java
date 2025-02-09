import org.example.Grid;

import java.util.Scanner;

public class GameOfLife {
private final Grid grid;
private final Scanner scanner;


    public GameOfLife(int rows,int cols,int seedPercentage,Scanner scanner){
        if (scanner == null) {
            throw new IllegalArgumentException("Scanner cannot be null.");
        }
        this.grid = new Grid(rows,cols,seedPercentage);
        this.scanner = scanner;
    }

    public void start(int maxGenerations) {
        if(maxGenerations <0){
            throw new IllegalArgumentException("Max generations must be greater than zero.");
        }
        int generation = 0;

        while (generation < maxGenerations) {
            grid.printGrid();
            if (grid.isAllDead()) {
                System.out.println("All cells are dead. Game Over!");
                break;
            }

            System.out.println("Press Enter to continue or type 'exit' to quit");

            if (scanner.hasNextLine()) {  // ✅ Check before reading input
                String input = scanner.nextLine().trim();
                if (input.equalsIgnoreCase("exit")) {
                    break;
                }
            } else {
                break;  // ✅ Exit loop if no input is available (JUnit case)
            }

            grid.tick();
            generation++;
        }
    }
    public boolean isAllCellsDead() {
        return grid.isAllDead();
    }

}
