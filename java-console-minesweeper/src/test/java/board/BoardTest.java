package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void constructor() {
        assertFalse(board.get(0,0).hasBomb());
        assertFalse(board.get(0,1).hasBomb());
        assertFalse(board.get(0,2).hasBomb());
        assertFalse(board.get(1,0).hasBomb());
        assertFalse(board.get(1,1).hasBomb());
        assertFalse(board.get(2,0).hasBomb());

        //all cells are initialized
        for (Cell[] row : board.getCells()) {
            for (Cell cell : row) {
                assertNotEquals(null, cell);
            }
        }

        //there are only 10 cells with a bomb
        int i = 0;
        for (Cell[] row : board.getCells()) {
            for (Cell cell : row) {
                if(cell.hasBomb()) {
                    i++;
                }
            }
        }
        assertEquals(10, i);
    }

    @Test
    public void getActive() {
        assertTrue(board.getIsActive());
    }

    @Test
    public void finishGame() {
        board.finishGame();
        assertFalse(board.getIsActive());
    }

    @Test
    public void get() {
        Cell[][] cells = board.getCells();

        assertEquals(cells[3][5], board.get(3,5));
    }

    @Test
    public void flag() {
        Cell[][] cells = board.getCells();
        Cell cell = mock(Cell.class);
        cells[4][8] = cell;

        board.flag(4, 8);
        verify(cell).flag();
    }

    @Test
    public void unflag() {
        Cell[][] cells = board.getCells();
        Cell cell = mock(Cell.class);
        cells[4][8] = cell;

        board.unflag(4, 8);
        verify(cell).unflag();
    }

    @Test
    public void clear() {
        Cell[][] cells = board.getCells();
        Cell cell = mock(Cell.class);
        cells[4][8] = cell;

        board.clear(4, 8);
        verify(cell).clear(eq(board), any());
    }

    @Test
    public void showBoardOnConsole() {
        Cell[][] cells = board.getCells();
        for(int r=0; r<8; r++) {
            for(int c=0; c<10; c++) {
                cells[r][c] = mock(Cell.class);
            }
        }

        board.showBoardOnConsole();
        for (Cell[] row : board.getCells()) {
            for (Cell cell : row) {
                verify(cell).getSymbol();
            }
        }

    }

    @Test
    public void checkVictory() {
        Cell[][] cells = board.getCells();
        for(int r=0; r<8; r++) {
            for(int c=0; c<10; c++) {
                cells[r][c] = mock(Cell.class);
                when(cells[r][c].hasBombOrClear()).thenReturn(true);
            }
        }

        board.checkVictory();
        for (Cell[] row : board.getCells()) {
            for (Cell cell : row) {
                verify(cell).hasBombOrClear();
            }
        }

        assertFalse(board.getIsActive());
    }

}
