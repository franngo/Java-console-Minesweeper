package cellState;

import board.Board;
import board.Cell;

import java.util.List;

public interface CellState {
    public void flag(Cell cell);
    public void unflag(Cell cell);
    public void clear(Board board, Cell cell, List<Cell> surrCells);
}
