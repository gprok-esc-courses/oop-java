package p06_tictactoe.refactored.model;

public interface GameListener {
    public void win(int value, int scoreX, int scoreO);
    public void tie();
}
