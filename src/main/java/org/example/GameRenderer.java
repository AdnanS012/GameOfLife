package org.example;

import java.util.Optional;
import java.util.Scanner;

public class GameRenderer {
    private final Scanner scanner;

    public GameRenderer(Scanner scanner) {
        this.scanner = Optional.ofNullable(scanner)
                .orElseThrow(() -> new IllegalArgumentException("Scanner cannot be null"));

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
