package CellState;

import board.Board;
import board.Cell;

import java.util.List;

public class CellStateClear implements CellState {
    public void mark(Cell cell) {
        System.out.println("This cell is already clear.");
    }

    public void undoTheMark(Cell cell) {
        System.out.println("This cell is already clear.");
    }

    public void clear(Board board, Cell cell, List<Cell> surrCells) {
        System.out.println("This cell is already clear.");
    }
}
