package p06_tictactoe.refactored.view;

import p06_tictactoe.refactored.model.CellButtonListener;

import javax.swing.*;
import java.awt.*;

public class GameFrame extends JFrame {

    private ScorePanel scorePanel;
    private BoardPanel boardPanel;

    public GameFrame(CellButtonListener buttonListener) {

        setSize(300, 340);
        setTitle("TicTacToe done right");

        scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.NORTH);
        boardPanel = new BoardPanel(buttonListener);
        add(boardPanel, BorderLayout.CENTER);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }
}
