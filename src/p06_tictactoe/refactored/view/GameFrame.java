package p06_tictactoe.refactored.view;

import p06_tictactoe.refactored.model.CellButtonListener;
import p06_tictactoe.refactored.model.GameListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GameFrame extends JFrame implements GameListener {

    private ScorePanel scorePanel;
    private BoardPanel boardPanel;
    private JButton playAgainBtn;

    public GameFrame(CellButtonListener buttonListener) {

        setSize(300, 340);
        setTitle("TicTacToe done right");

        scorePanel = new ScorePanel();
        add(scorePanel, BorderLayout.NORTH);
        boardPanel = new BoardPanel(buttonListener);
        add(boardPanel, BorderLayout.CENTER);

        playAgainBtn = new JButton("Play Again");
        playAgainBtn.setEnabled(false);
        playAgainBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buttonListener.playAgain();
                boardPanel.enableAll();
            }
        });
        add(playAgainBtn, BorderLayout.SOUTH);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    @Override
    public void win(int value, int scoreX, int scoreO) {
        System.out.println("Winner is " + value);
        scorePanel.setScoreLabel(scoreX, scoreO);
        boardPanel.disableAll();
        playAgainBtn.setEnabled(true);
    }

    @Override
    public void tie() {
        System.out.println("TIE");
        playAgainBtn.setEnabled(true);
    }
}
