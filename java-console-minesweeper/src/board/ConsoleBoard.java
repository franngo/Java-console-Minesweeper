package board;

import java.util.Scanner;

public class ConsoleBoard {
    private Board board;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleBoard() {
        this.board = new Board();
    }

    public void startGame() {
        while(board.getIsActive()) {
            //mostrar en pantalla el tablero
            board.showBoardOnConsole();
            //recibir input
            String input = scanner.nextLine();
            //delegar mensaje al Board según la acción del input
            this.processInput(input);
            //si se cambia isActive del Board, en el próximo giro termina el loop y termina la partida
        }
    }

    private void processInput(String input) {

    }
}
