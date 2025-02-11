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

private void initializeEmptyGrid(){
    for (int i =0; i<rows; i++){
        for (int j =0; j<cols; j++){
            cells[i][j] = new Cell(false);
        }
    }
}
public void seed(GridSeeder seeder){
    seeder.seed(this);
}

public void evolve(GridEvolver evolver){
evolver.evolve(this);
}

public boolean allCellsDead(){
    for(Cell[] row: cells){
        for(Cell cell: row){
            if(cell !=null){
                return false;
            }
        }
    }
    return true;
}

public  void render(GridRenderer renderer){
    renderer.render(this);
}
    void computeNextStates() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int liveNeighbors = countAliveNeighbors(i, j);
                cells[i][j].computeNextState(liveNeighbors);
            }
        }
    }
void evolveCells(){
    for(Cell[] row : cells){
        for(Cell cell : row){
            cell.evolve();
        }
    }
}

    private int countAliveNeighbors(int row, int col) {
        int count = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < rows && c >= 0 && c < cols) {
                    count++; // No need to check state, all cells participate in evolution
                }
            }
        }
        return count;
    }


}
