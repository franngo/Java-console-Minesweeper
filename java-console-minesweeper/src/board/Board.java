package board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    final private int rows = 8;
    final private int columns = 10;
    private Cell[][] cells; //must have 10 cells with a bomb

    public Board() {
        cells = new Cell[rows][columns]; //8 rows and 10 columns board

        //we initialize some corner cells
        cells[0][0] = new Cell(false);
        cells[0][1] = new Cell(false);
        cells[0][2] = new Cell(false);
        cells[1][0] = new Cell(false);
        cells[1][1] = new Cell(false);
        cells[2][0] = new Cell(false);
        cells[2][1] = new Cell(true);

        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if(cell!=null) { //if not one of the already initialized
                    cell = new Cell(false); //must randomize 10 cells with bomb
                }
            }
        }

        //we clear the initial cells
        this.clear(0, 0);
        this.clear(0, 1);
        this.clear(0, 2);
        this.clear(1, 0);
        this.clear(1, 1);
        this.clear(2, 0);

    }

    public Cell get(int row, int column) {
        return cells[row][column];
    }

    public void mark(int row, int column) {
        this.get(row, column).mark();
    }

    public void undoTheMark(int row, int column) {
        this.get(row, column).undoTheMark();
    }

    public void clear(int row, int column) {
        /*
        First of all, we get the surrounding cells, which will be needed to show the amount of bombs surrounding
        the cleared cell, in case this one is actually cleared.
         */

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
