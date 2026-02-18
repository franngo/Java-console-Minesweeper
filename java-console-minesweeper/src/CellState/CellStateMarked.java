package CellState;

import board.Board;
import board.Cell;

import java.util.List;

public class CellStateMarked implements CellState {
    public void mark(Cell cell) {
        System.out.println("This cell is already marked.");
    }

    public void undoTheMark(Cell cell) {
        cell.setState(new CellStateUnknown());
        cell.setSymbol('X');
    }

    public void clear(Board board, Cell cell, List<Cell> surrCells) {
        System.out.println("This cell is marked. you must undo the mark to clear it.");
    }
}
