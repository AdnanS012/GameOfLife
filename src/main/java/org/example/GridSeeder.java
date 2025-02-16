package org.example;

import java.util.Random;

public class GridSeeder {
    private final int seedPercentage;
    private final Random random = new Random();

    public GridSeeder(int seedPercentage) {
        if (seedPercentage < 0 || seedPercentage > 100) {
            throw new IllegalArgumentException("Seed percentage must be between 0 and 100");
        }
        this.seedPercentage = seedPercentage;
    }

    public void seed(Grid grid) {
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.cols; j++) {
                boolean isAlive = random.nextInt(100) < seedPercentage;
                grid.cells[i][j] = new Cell(isAlive);
            }
        }
    }


}
