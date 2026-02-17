package board;

import CellState.CellState;
import CellState.CellStateUnknown;

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

    public void setState(CellState state) {
        this.state = state;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public void mark() {
        state.mark(this);
    }

    public void undoTheMark() {
        state.undoTheMark(this);
    }

    public void clear(Board board, List<Cell> cells) {
        state.clear(board, this, cells);
    }

}
