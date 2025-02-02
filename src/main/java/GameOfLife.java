import org.example.Grid;

import java.util.Scanner;

public class GameOfLife {
private final Grid grid;


    public GameOfLife(int rows,int cols,double seedPercentage) {
        this.grid = new Grid(rows,cols,seedPercentage);
    }

    public void start(){
        Scanner scanner = new Scanner(System.in);
        while(true){
            grid.printGrid();
            if(grid.isAllDead()){
                System.out.println("All cells are dead. Game Over!");
                break;
            }
            System.out.println("Press Enter to continue or type 'exit' to quit");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit")){
                break;
            }
            grid.tick();
        }
        scanner.close();
    }
}
