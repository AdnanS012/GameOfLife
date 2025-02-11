package org.example;

public class GridRenderer {
    public void render(Grid grid) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < grid.rows; i++) {
            for (int j = 0; j < grid.cols; j++) {
                grid.cells[i][j].render(output);
            }
            output.append(System.lineSeparator());
        }
        System.out.print(output);
    }
}
