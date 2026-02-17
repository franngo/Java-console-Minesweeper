package board;

public class ConsoleBoard {
    private Board board;

    public ConsoleBoard() {
        this.board = new Board();
    }

    public void startGame() {
        while(board.getIsActive()) {
            //mostrar en pantalla el tablero
            //recibir input
            //delegar mensaje al Board según la acción del input
            //si se cambia isActive del Board, termina el loop y termina la partida
        }
    }
}
