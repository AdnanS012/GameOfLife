package org.example;

public final class Cell {
    private boolean alive;
    private boolean nextState;
    public Cell(boolean alive) {
        this.alive = alive;
    }

    public void computeNextState(int liveNeighbors){
        if (liveNeighbors < 0) {
            throw new IllegalArgumentException("Number of live neighbors cannot be negative");
        }
        nextState = alive ? (liveNeighbors == 2 || liveNeighbors == 3) : (liveNeighbors == 3);

    }

    public void evolve(){
        this.alive = nextState;
    }

    public void render(StringBuilder output){
        output.append(alive ? '*' : '-');
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Cell cell = (Cell) obj;
        return alive == cell.alive;
    }

    @Override
    public int hashCode() {
        return Boolean.hashCode(alive);
    }
}
