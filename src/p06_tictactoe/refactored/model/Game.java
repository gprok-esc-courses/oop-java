package p06_tictactoe.refactored.model;

public class Game implements CellButtonListener {
    private Board board;
    private Player playerX, playerO, currentPlayer;
    private GameListener gameListener;

    public Game() {
        board = new Board();
        playerX = new Player(Cell.PLAYER_X);
        playerO = new Player(Cell.PLAYER_O);
        currentPlayer = playerX;
    }

    @Override
    public int buttonClicked(int row, int col) {
        System.out.println(row + " " + col);
        int value = currentPlayer.getValue();
        board.play(row, col, value);
        if(board.hasWinner()) {
            gameListener.win(value);
        }
        else if(board.isTie()) {
            gameListener.tie();
        }

        currentPlayer = currentPlayer == playerX ? playerO : playerX;

        return value;
    }

    public void setGameListener(GameListener gameListener) {
        this.gameListener = gameListener;
    }
}
