package board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private Cell[][] cells = new Cell[8][10]; //8 rows and 10 columns board

    public Cell get(int row, int column) {
        return cells[row][column];
    }

    public void mark(int row, int column) {
        this.get(row, column).mark();
    }

    public void clear(int row, int column) {
        List<Cell> cs = new ArrayList<Cell>();
        this.get(row, column).clear(cs);
    }
}
