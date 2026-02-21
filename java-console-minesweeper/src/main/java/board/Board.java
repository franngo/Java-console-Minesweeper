package board;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Board {
    final private int rows = 8;
    final private int columns = 10;
    final private Cell[][] cells; //must have 10 cells with a bomb
    private boolean isActive = true;

    public Board() {
        this(8, 10); //8 rows and 10 columns board
    }

    public Board(int rs, int cs) {
        this.cells = new Cell[rs][cs];

        //we initialize some corner cells with no bomb
        cells[0][0] = new Cell(false);
        cells[0][1] = new Cell(false);
        cells[0][2] = new Cell(false);
        cells[1][0] = new Cell(false);
        cells[1][1] = new Cell(false);
        cells[2][0] = new Cell(false);

        //we also initialize 10 random cells with a bomb
        int i = 0;
        Random rand = new Random();
        while(i<10) {
            int rw = rand.nextInt(rs);
            int cl = rand.nextInt(cs);
            if(this.get(rw,cl)==null) { //if not one of the already initialized
                cells[rw][cl] = new Cell(true); //must randomize 10 cells with bomb
                i++;
            }
        }

        //we initialize the rest of the cells with no bomb
        for(int r=0; r<rs; r++) {
            for(int c=0; c<cs; c++) {
                if(this.get(r,c)==null) { //if not one of the already initialized
                    cells[r][c] = new Cell(false);
                }
            }
        }

        //we clear the initial corner cells with no bomb
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
        System.out.println("      0 1 2 3 4 5 6 7 8 9");
        System.out.println();
        for(int r=0; r<8; r++) {
            System.out.printf(r + "    ");
            for(int c=0; c<10; c++) {
                Cell current = this.get(r,c);
                System.out.printf("|" + current.getSymbol());
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
