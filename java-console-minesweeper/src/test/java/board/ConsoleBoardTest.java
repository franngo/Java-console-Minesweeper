package board;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

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
    void startGameAndProcessInput() {
        when(board.getIsActive()).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).
                thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(true).thenReturn(false);
        when(scanner.nextLine()).thenReturn("clear 3 4").thenReturn("clear a-4").thenReturn("clear 8-4").
                thenReturn("clear 9-4").thenReturn("clear 7-4").thenReturn("flag 7-4").thenReturn("unflag 7-4").
                thenReturn("pan 7-4");
        cb.startGame();
        verify(board, times(8)).showBoardOnConsole();
    }
}
