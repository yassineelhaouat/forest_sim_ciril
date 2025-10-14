package yassine.model;

public class Cell {
    private CellState state;

    public Cell(CellState state) {
        this.state = state;
    }

    public CellState getState() {
        return state;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public void setOnFire() {
        if (state == CellState.TREE) {
            state = CellState.FIRE;
        }
    }
}
