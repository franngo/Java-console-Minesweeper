package cellState;

import board.Board;
import board.Cell;

import java.util.List;

public class CellStateUnknown implements CellState {
    public void flag(Cell cell) {
        cell.setState(new CellStateFlagged());
        cell.setSymbol('F');
    }

    public void unflag(Cell cell) {
        System.out.println("This cell is not flagged. you can't unflag if there's no flag in the cell.");
    }

    /*
    This state tries to clean the cell, which can result in success or explosion.
    If it actually cleans the cell, it's gonna count the number of surrounding cells with a bomb for the new
    cleaned cell's symbol.
     */
    public void clear(Board board, Cell cell, List<Cell> surrCells) {
        if(cell.hasBomb()) {
            System.out.println("BOOM! Game over.");
            board.finishGame();
        } else {
            int bs = this.countSurroundingBombs(surrCells);
            cell.setState(new CellStateClear());
            char cbs = (char) (bs + '0');
            cell.setSymbol(cbs);
            board.checkVictory();
        }
    }

    private int countSurroundingBombs(List<Cell> cells) {
        long n = cells.stream().
                filter((cell) -> cell.hasBomb()).
                count();
        return (int) n;
    }
}
