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
    }
}
