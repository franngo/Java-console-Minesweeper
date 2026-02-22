package cellState;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import board.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CellStateUnknownTest {
    CellState state;
    //mock
    Cell cell;

    @BeforeEach
    void setUp() {
        state = new CellStateUnknown();
        cell = mock(Cell.class);
    }

    @Test
    public void flag() {
        state.flag(cell);
        verify(cell).setState(any());
        verify(cell).setSymbol('F');
    }

    @Test
    public void unflag() {
        state.unflag(cell);
        //we just send a message to System.out
        verifyNoInteractions(cell);
    }

    @Test
    public void clear1() {
        Board board = mock(Board.class);
        List<Cell> surrCells = new ArrayList<Cell>();

        when(cell.hasBomb()).thenReturn(true);
        state.clear(board, cell, surrCells);
        verify(board).finishGame();
    }

    @Test
    public void clear2() {
        Board board = mock(Board.class);
        List<Cell> surrCells = new ArrayList<Cell>();
        Cell c1 = mock(Cell.class);
        when(c1.hasBomb()).thenReturn(true);
        Cell c2 = mock(Cell.class);
        when(c2.hasBomb()).thenReturn(true);
        Cell c3 = mock(Cell.class);
        when(c3.hasBomb()).thenReturn(false);
        Cell c4 = mock(Cell.class);
        when(c4.hasBomb()).thenReturn(true);
        surrCells.add(c1);
        surrCells.add(c2);
        surrCells.add(c3);
        surrCells.add(c4);

        when(cell.hasBomb()).thenReturn(false);
        state.clear(board, cell, surrCells);
        verify(cell).setState(any());
        verify(cell).setSymbol('3'); //cambiar el any
        verify(board).checkVictory();
    }
}
