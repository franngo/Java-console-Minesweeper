package CellState;

import board.Board;
import board.Cell;

import java.util.List;

public interface CellState {
    public void mark(Cell cell);
    public void undoTheMark(Cell cell);
    public void clear(Board board, Cell cell, List<Cell> surrCells);
}
