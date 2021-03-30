package p06_tictactoe.refactored.model;

public class Game implements CellButtonListener {
    private Board board;
    private Player playerX, playerO, currentPlayer;

    public Game() {
        board = new Board();
        playerX = new Player(Cell.PLAYER_X);
        playerO = new Player(Cell.PLAYER_O);
        currentPlayer = playerX;
    }

    @Override
    public void buttonClicked(int row, int col) {
        System.out.println(row + " " + col);
    }
}
