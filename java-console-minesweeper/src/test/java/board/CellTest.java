package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import cellState.CellState;
import cellState.CellStateClear;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class CellTest {
    Cell cell;

    @BeforeEach
    void setUp() {
        cell = new Cell(true);
    }

    @Test
    public void hasBomb() {
        assertTrue(cell.hasBomb());
    }

    @Test
    public void getSymbol() {
        assertEquals('X', cell.getSymbol());
        cell.setSymbol('F');
        assertEquals('F', cell.getSymbol());
    }

    @Test
    public void flag() {
        CellState state = mock(CellState.class);
        cell.setState(state);
        cell.flag();
        verify(state).flag(cell);
    }

    @Test
    public void unflag() {
        CellState state = mock(CellState.class);
        cell.setState(state);
        cell.unflag();
        verify(state).unflag(cell);
    }

    @Test
    public void clear() {
        CellState state = mock(CellState.class);
        cell.setState(state);
        Board board = new Board();
        List<Cell> cells = new ArrayList<Cell>();

        cell.clear(board, cells);
        verify(state).clear(board, cell, cells);
    }

    @Test
    public void hasBombOrClear() {
        Cell c = new Cell(false);
        CellState state = mock(CellStateClear.class);
        c.setState(state);

        assertTrue(c.hasBombOrClear());
    }
}
