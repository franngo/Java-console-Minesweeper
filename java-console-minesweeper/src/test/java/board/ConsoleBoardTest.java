package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import cellState.CellState;
import cellState.CellStateClear;

import java.util.Scanner;


public class ConsoleBoardTest {
    ConsoleBoard cb;
    //mocks
    Board board;
    Scanner scanner;

    @BeforeEach
    void setUp() {
        board = mock(Board.class);
        scanner = mock(Scanner.class);
        cb = new ConsoleBoard(board, scanner);
    }

    @Test
    void startGame() {
        when(board.getIsActive()).thenReturn(true).thenReturn(true).thenReturn(false);
        when(scanner.nextLine()).thenReturn("clear 3 4").thenReturn("clear a-4");
        cb.startGame();
        verify(board, times(2)).showBoardOnConsole();
    }
}
