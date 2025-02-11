package org.example;

import java.util.Random;

public class Grid {
private final int rows;
private final int cols;
private final Cell[][] cells;

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
}}
