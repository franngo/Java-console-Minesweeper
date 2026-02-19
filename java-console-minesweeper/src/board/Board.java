package board;

import java.util.ArrayList;
import java.util.List;

public class Board {
    final private int rows = 8;
    final private int columns = 10;
    final private Cell[][] cells; //must have 10 cells with a bomb
    private boolean isActive = true;

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

        for(int r=0; r<8; r++) {
            for(int c=0; c<10; c++) {
                if(this.get(r,c)==null) { //if not one of the already initialized
                    cells[r][c] = new Cell(false); //must randomize 10 cells with bomb
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

    public boolean getIsActive() {
        return this.isActive;
    }

    public void finishGame() {
        this.isActive = false;
    }

    public Cell get(int row, int column) {
        return cells[row][column];
    }

    public void flag(int row, int column) {
        this.get(row, column).flag();
    }

    public void unflag(int row, int column) {
        this.get(row, column).unflag();
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

        this.get(row, column).clear(this, cs);
    }

    public void showBoardOnConsole() {
        System.out.println();
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                System.out.printf("|" + cell.getSymbol());
            }
            System.out.println("|");
        }
    }

    public void checkVictory() {
        if(this.hasNoCellsToBeCleared()) { //if all cells with no bomb are clear
            System.out.println("Congrats! You won the game.");
            this.finishGame();
        }
    }

    private boolean hasNoCellsToBeCleared() {
        for (Cell[] row : cells) {
            for (Cell cell : row) {
                if(!cell.hasBombOrClear()) { //if has no bomb but it's flagged or unknown
                    return false;
                }
            }
        }
        return true;
    }
}
