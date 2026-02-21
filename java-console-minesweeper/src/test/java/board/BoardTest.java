package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import cellState.CellState;
import cellState.CellStateClear;

public class BoardTest {
    Board board;

    @BeforeEach
    void setUp() {
        board = new Board();
    }

    @Test
    public void test() {
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
}
