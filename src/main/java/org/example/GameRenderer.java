package org.example;

import java.util.Scanner;

public class GameRenderer {
    private final Scanner scanner;

    public GameRenderer(Scanner scanner) {
        if(scanner == null){
            throw new IllegalArgumentException("Scanner cannot be null");
        }
        this.scanner = scanner;
    }

    public void renderGrid(Grid grid) {
       grid.printGrid();
    }

    public boolean askUserToContinue(){
        System.out.println("Press Enter to continue or type 'exit' to quit");
        String input = scanner.nextLine().trim();
        return !input.equalsIgnoreCase("exit");
    }
}
