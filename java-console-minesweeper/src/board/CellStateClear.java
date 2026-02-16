package board;

import java.util.List;

public class CellStateClear implements CellState {
    public void mark(Cell cell) {
        //does nothing because it's already clear
    }

    public void undoTheMark(Cell cell) {

    }

    public void clear(Cell cell, List<Cell> surrCells) {
        //does nothing because it's already clear
    }
}
