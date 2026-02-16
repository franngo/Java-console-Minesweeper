package board;

import java.util.List;

public class CellStateUnknown implements CellState {
    public void mark(Cell cell) {

    }

    public void undoTheMark(Cell cell) {

    }

    public void clear(Cell cell, List<Cell> surrCells) {
        cell.validateThereIsNoBomb();
        int bs = this.countSurroundingBombs(surrCells);
        //cambiarle el estado a Clear y darle como nuevo símbolo el int bs
        /*
        Clear dice "already clear", Marked dice "this cell is marked. you must undo the mark to clear it", y
        Unknown efectivamente trata de limpiar la celda, lo cual puede resultar en explosión o éxito.
        Si efectivamente la va a limpiar, va a contar el número de celdas circundantes con bomba para el nuevo
        símbolo de la celda limpiada.
        */

    }

    private int countSurroundingBombs(List<Cell> cells) {
        long n = cells.stream().
                filter((cell) -> cell.hasBomb()).
                count();
        return (int) n;
    }
}
