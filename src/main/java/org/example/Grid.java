package org.example;

import java.util.Random;

public class Grid {
    private final int rows;
    private final int cols;
    private Cell[][] grid;

    public Grid(int rows,int cols,double seedPercentage){
        this.rows = rows;
        this.cols = cols;
        this.grid = new Cell[rows][cols];
        seedGrid(seedPercentage);
    }

    private void seedGrid(double seedPercentage){
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(random.nextDouble() < seedPercentage);
            }
        }
    }



}
