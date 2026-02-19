package cellState;

import board.Board;
import board.Cell;

import java.util.List;

public class CellStateClear implements CellState {
    public void flag(Cell cell) {
        System.out.println("This cell is already clear.");
    }

    public void unflag(Cell cell) {
        System.out.println("This cell is already clear.");
    }

    public void clear(Board board, Cell cell, List<Cell> surrCells) {
        System.out.println("This cell is already clear.");
    }
}
