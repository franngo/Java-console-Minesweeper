package board;

import java.util.List;

public class CellStateMarked implements CellState {
    public void mark(Cell cell) {

    }

    public void undoTheMark(Cell cell) {

    }

    public void clear(Cell cell, List<Cell> surrCells) {
        //show "This cell is marked. you must undo the mark to clear it" to the player
    }
}
