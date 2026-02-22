package cellState;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

import board.*;

import java.util.ArrayList;
import java.util.List;


public class CellStateFlaggedTest {
    CellState state;
    //mock
    Cell cell;

    @BeforeEach
    void setUp() {
        state = new CellStateFlagged();
        cell = mock(Cell.class);
    }

    @Test
    public void flag() {
        state.flag(cell);
        //we just send a message to System.out
        verifyNoInteractions(cell);
    }

    @Test
    public void unflag() {
        state.unflag(cell);
        verify(cell).setState(any());
        verify(cell).setSymbol('X');
    }

    @Test
    public void clear() {
        Board board = new Board();
        List<Cell> surrCells = new ArrayList<Cell>();

        state.clear(board, cell, surrCells);
        //we just send a message to System.out
        verifyNoInteractions(cell);
    }
}
