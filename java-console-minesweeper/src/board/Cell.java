package board;

import cellState.*;

import java.util.List;

public class Cell {
    final private boolean hasBomb;
    private CellState state;
    private char symbol;

    public Cell(boolean hasBomb) {
        this.hasBomb = hasBomb;
        this.symbol = 'X';
        this.state = new CellStateUnknown();
    }

    public boolean hasBomb() {
        return this.hasBomb;
    }

    public char getSymbol() {
        return this.symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void setState(CellState state) {
        this.state = state;
    }

    public void flag() {
        state.flag(this);
    }

    public void unflag() {
        state.unflag(this);
    }

    public void clear(Board board, List<Cell> cells) {
        state.clear(board, this, cells);
    }

    public boolean hasBombOrClear() {
        return this.hasBomb() || this.state instanceof CellStateClear;
    }

}
