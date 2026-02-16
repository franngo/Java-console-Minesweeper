package board;

import java.util.List;

public class Cell {
    final private boolean hasBomb;
    private CellState state;
    private char symbol;

    public Cell(boolean hasBomb) {
        this.hasBomb = hasBomb;
        this.symbol = 'X';
        this.state = new CellStateUnknown();
    }

    public boolean hasBomb() {
        return this.hasBomb;
    }

    public void mark() {
        state.mark(this);
    }

    public void undoTheMark() {
        state.undoTheMark(this);
    }

    public void clear(List<Cell> cells) {
        state.clear(this, cells);
        /*
        Clear dice "already clear", Marked dice "this cell is marked. you must undo the mark to clear it", y
        Unknown efectivamente trata de limpiar la celda, lo cual puede resultar en explosión o éxito.
        Si efectivamente la va a limpiar, va a contar el número de celdas circundantes con bomba para el nuevo
        símbolo de la celda limpiada.
        */
    }

    void validateThereIsNoBomb() {
        if(this.hasBomb()) {
            //show "game over" to the player
        }
    }

}
