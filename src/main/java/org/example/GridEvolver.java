package org.example;

public class GridEvolver {
    public void evolve(Grid grid) {
        computeNextStates(grid);
        applyEvolution(grid);
    }
    private void computeNextStates(Grid grid) {
            for (int i = 0; i < grid.rows; i++) {
                for (int j = 0; j < grid.cols; j++) {
                    int liveNeighbors = countAliveNeighbors(grid,i, j);
                    grid.cells[i][j].computeNextState(liveNeighbors);
                }
            }
        }
    private void applyEvolution(Grid grid) {
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.cols; j++) {
                grid.cells[i][j].evolve();
            }
        }
    }

    private int countAliveNeighbors(Grid grid, int row, int col) {
        int[] count = {0};
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (i == 0 && j == 0) continue;
                int r = row + i;
                int c = col + j;
                if (r >= 0 && r < grid.rows && c >= 0 && c < grid.cols) {
                    grid.cells[r][c].executeIfAlive(() -> count[0]++);
                }
            }
        }
        return count[0];
    }

}
