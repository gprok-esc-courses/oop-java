package p06_tictactoe.refactored.model;

public class Player {
    private int value;
    private int score;

    public Player(int value) {
        this.value = value;
        score = 0;
    }

    public int getValue() {
        return value;
    }

    public int getScore() {
        return score;
    }

    public void addWin() {
        score++;
    }
}
