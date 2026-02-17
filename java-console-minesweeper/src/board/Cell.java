package board;

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

    public void clear(List<Cell> cells) {
        state.clear(this, cells);
    }

    void validateThereIsNoBomb() {
        if(this.hasBomb()) {
            //show "game over" to the player
        }
    }

}
