package org.example;

public class GridEvolver {
    public void evolve(Grid grid){
        grid.computeNextStates();
        grid.evolveCells();
    }
}
