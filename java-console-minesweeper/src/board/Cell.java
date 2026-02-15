package board;

import java.util.List;

public class Cell {
    private boolean hasBomb;
    private CellState state;

    public Cell(boolean hasBomb) {
        this.hasBomb = hasBomb;
        this.state = new CellStateUnknown();
    }

    public boolean hasBomb() {
        return this.hasBomb;
    }

    public void mark() {

    }

    public void clear(List<Cell> cells) {
        this.validateThereIsNoBomb(cells);
        state.clear(this);
    }

    private void validateThereIsNoBomb(List<Cell> cells) {
        for(Cell cell : cells) {
            if(cell.hasBomb()) {

            }
        };
    }

}
