package cellState;

import board.Board;
import board.Cell;

import java.util.List;

public class CellStateFlagged implements CellState {
    public void flag(Cell cell) {
        System.out.println("This cell is already flagged.");
    }

    public void unflag(Cell cell) {
        cell.setState(new CellStateUnknown());
        cell.setSymbol('X');
    }

    public void clear(Board board, Cell cell, List<Cell> surrCells) {
        System.out.println("This cell is flagged. you must unflag it first to clear it.");
    }
}
