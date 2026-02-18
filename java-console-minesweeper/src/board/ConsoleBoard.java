package board;

import java.util.Scanner;

public class ConsoleBoard {
    private Board board;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleBoard() {
        this.board = new Board();
    }

    public void startGame() {
        System.out.println("Welcome to Minesweeper! You can use the commands clear, flag, and unflag. Next to" +
                "one of these commands, you must enter the row and the column number. For example: clear 5-7");
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
        String[] parts = input.split(" ");

        //Input must have only 2 parts
        if (parts.length != 2) {
            System.out.println("Invalid input format. Inputs must have only 2 parts: command and row-column " +
                    "(For example: clear 6-2)");
            return;
        }

        if (!parts[1].matches("\\d-\\d")) {
            System.out.println("Invalid input format. Use row-column next to the command (For example: 3-4)");
            return;
        }

        String[] coords = parts[1].split("-");
        int row = Integer.parseInt(coords[0]);
        int column = Integer.parseInt(coords[1]);

        if (row==8 || row==9) {
            System.out.println("Invalid input. Rows only go from 0 to 7.");
            return;
        }

        String command = parts[0];

        switch(command) {
            case "clear":
                board.clear(row, column);
                break;
            case "flag":
                board.flag(row, column);
                break;
            case "unflag":
                board.unflag(row, column);
                break;
            default:
                System.out.println("Invalid input. The only valid commands are: clear - flag - unflag");
        }

    }
}
