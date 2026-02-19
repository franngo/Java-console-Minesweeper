package board;

import java.util.Scanner;

public class ConsoleBoard {
    private final Board board;
    private final Scanner scanner = new Scanner(System.in);

    public ConsoleBoard() {
        this.board = new Board();
    }

    public void startGame() {
        System.out.println("Welcome to Minesweeper! You can use the commands clear, flag, and unflag. Next to" +
                " one of these commands, you must enter the row and the column number. For example: clear 5-7");
        while(board.getIsActive()) {
            board.showBoardOnConsole();
            String input = scanner.nextLine();
            this.processInput(input);
            //if isActive has changed, the loop and the game will finish in the next condition check.
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

        //Second part of an input must have the row-column format
        if (!parts[1].matches("\\d-\\d")) {
            System.out.println("Invalid input format. Use row-column next to the command (For example: 3-4)");
            return;
        }

        String[] coords = parts[1].split("-");
        int row = Integer.parseInt(coords[0]);
        int column = Integer.parseInt(coords[1]);

        //The row number can't be 8 or 9, since there are no 8th nor 9th row.
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
