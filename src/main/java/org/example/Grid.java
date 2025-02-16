package org.example;

import java.util.Random;

public class Grid {
    final int rows;
    final int cols;
    final Cell[][] cells;

    public Grid(int rows, int cols) {
        if (rows <= 0 || cols <= 0) {
            throw new IllegalArgumentException("Rows and columns must be greater than zero.");
        }
        this.rows = rows;
        this.cols = cols;
        this.cells = new Cell[rows][cols];
        initializeEmptyGrid();

    }

    private void initializeEmptyGrid() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(false);
            }
        }
    }

    public void seed(GridSeeder seeder) {
        seeder.seed(this);
    }


    public boolean allCellsDead() {
        final boolean[] anyAlive = {false};// array to allow modification using inside lamba
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                cell.executeIfAlive(() -> anyAlive[0] = true);
            }
        }
        return !anyAlive[0];
    }

}
