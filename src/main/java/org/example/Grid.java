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

    public  void seedGrid(double seedPercentage){
        Random random = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = new Cell(random.nextDouble() < seedPercentage);
            }
        }
    }
    public void tick(){
        Cell[][] newGrid = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int aliveNeighbors = countAliveNeighbors(i,j);
                newGrid[i][j] = grid[i][j].evolve(aliveNeighbors);
            }
        }
        grid = newGrid;
    }
    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols && grid[r][c].isAlive()) {
                    count++;
                }
            }
        }
        return count;
    }
   public boolean isAllDead(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j].isAlive()){
                    return false;
                }
            }
        }
        return true;
   }
   public void  printGrid(){
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                System.out.print(grid[i][j].display());
            }
            System.out.println();
        }

   }

}
