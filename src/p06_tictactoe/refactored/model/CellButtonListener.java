package p06_tictactoe.refactored.model;

public interface CellButtonListener {
    public int buttonClicked(int row, int col);
    public void playAgain();
}
