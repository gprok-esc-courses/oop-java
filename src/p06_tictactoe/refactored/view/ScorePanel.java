package p06_tictactoe.refactored.view;

import javax.swing.*;

public class ScorePanel extends JPanel {

    private JLabel scoreLabel;

    public ScorePanel() {
        scoreLabel = new JLabel("SCORE - X:0, O: 0");
        add(scoreLabel);
    }

    public void setScoreLabel(int scoreX, int scoreO) {
        scoreLabel.setText("SCORE - X:" + scoreX + ", O: " + scoreO);
    }

}
