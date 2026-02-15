package board;

public class Board {

    private Cell[][] cells = new Cell[8][10];

    public Cell get(int fila, int column) {
        return cells[fila][column];
    }

}
