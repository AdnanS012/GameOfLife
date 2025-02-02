package org.example;

public final class Cell {
    private final boolean alive;

    public Cell(boolean alive) {
        this.alive = alive;
    }
    public Cell evolve(int liveNeighbors){
        if (liveNeighbors < 0) {
            throw new IllegalArgumentException("Number of live neighbors cannot be negative");
        }
        if (alive){
            return (liveNeighbors ==2 ) || liveNeighbors == 3 ? new Cell(true) : new Cell(false);
        } else{
            return liveNeighbors == 3 ? new Cell(true) : new Cell(false);
        }
    }

    public char display(){
        return alive ? '*' : '-';
    }
    boolean isAlive(){
        return alive;
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
