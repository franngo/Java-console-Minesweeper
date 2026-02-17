package board;

import java.util.List;

public class CellStateMarked implements CellState {
    public void mark(Cell cell) {
        //show "This cell is already marked" to the player
    }

    public void undoTheMark(Cell cell) {
        cell.setState(new CellStateUnknown());
        cell.setSymbol('X');
    }

    public void clear(Cell cell, List<Cell> surrCells) {
        //show "This cell is marked. you must undo the mark to clear it" to the player
    }
}
