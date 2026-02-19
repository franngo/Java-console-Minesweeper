package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import cellState.CellState;
import cellState.CellStateClear;

import static org.mockito.Mockito.mock;

public class BoardTest {
    @Test
    public void test() {
        Cell celda = new Cell(true);
        CellState cc = new CellStateClear();
        Cell cell = mock(Cell.class);
        assertTrue(2+2==4);
    }
}
