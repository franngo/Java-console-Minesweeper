package board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    final private int rows = 8;
    final private int columns = 10;
    private Cell[][] cells; //must have 10 cells with a bomb

    public Board() {
        cells = new Cell[rows][columns]; //8 rows and 10 columns board

        //initialize some corner cells

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if(cell!=null) { //if not one of the already initialized
                    cell = new Cell(false);
                }
            }
        }

    }

    public Cell get(int row, int column) {
        return cells[row][column];
    }

    public void mark(int row, int column) {
        this.get(row, column).mark();
    }

    public void clear(int row, int column) {
        //first of all, we get the surrounding cells
        List<Cell> cs = new ArrayList<Cell>();

        for(int r = -1; r<2; r++) {
            for(int c = -1; c<2; c++) {
                if(r + row >= 0 && c + column >= 0  && r + row < rows && c + column < columns && !(r==0 && c==0)) {
                    cs.add(this.get(r+row, c+column));
                }
            }
        }

        this.get(row, column).clear(cs);
    }
}
