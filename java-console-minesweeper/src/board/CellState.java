package board;

import java.util.List;

public interface CellState {
    public void mark(Cell cell);
    public void undoTheMark(Cell cell);
    public void clear(Cell cell, List<Cell> surrCells);
}
