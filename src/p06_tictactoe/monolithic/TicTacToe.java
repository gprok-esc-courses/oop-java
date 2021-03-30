package p06_tictactoe.monolithic;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe {

    private JFrame frame;
    private JLabel scoreLabel, messageLabel;
    private JButton [][] cells;
    private JButton playAgainButton;
    private String player;
    private int scoreX, scoreO;
    private int i, j;

    public TicTacToe() {
        player = "X";
        scoreX = scoreO = 0;

        frame = new JFrame();
        frame.setSize(300, 340);
        frame.setTitle("monolithic.TicTacToe done wrong");

        JPanel topPanel = new JPanel();
        scoreLabel = new JLabel("SCORE - X: 0, O: 0");
        topPanel.add(scoreLabel);
        frame.add(topPanel, BorderLayout.NORTH);

        JPanel bottomPanel = new JPanel();
        messageLabel = new JLabel("X plays");
        bottomPanel.add(messageLabel);
        playAgainButton = new JButton("Play Again");
        playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(i = 0; i < 3; i++) {
                    for (j = 0; j < 3; j++) {
                        cells[i][j].setEnabled(true);
                        cells[i][j].setText("-");
                    }
                }
                messageLabel.setText(player + " plays");
                playAgainButton.setVisible(false);
            }
        });
        bottomPanel.add(playAgainButton);
        playAgainButton.setVisible(false);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3,3));
        cells = new JButton[3][3];
        for(i = 0; i < 3; i++) {
            for(j = 0; j < 3; j++) {
                cells[i][j] = new JButton();
                cells[i][j].setText("-");
                cells[i][j].setName(i + "," + j);
                cells[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        JButton b = (JButton)e.getSource();
                        String name = b.getName();
                        String [] val = name.split(",");
                        int r = Integer.parseInt(val[0]);
                        int c = Integer.parseInt(val[1]);
                        cells[r][c].setText(player);
                        cells[r][c].setEnabled(false);
                        // Check for winner or tie
                        if(hasWinner()) {
                            messageLabel.setText(player + " WINS!");
                            if(player.equals("X")) {
                                scoreX++;
                            }
                            else {
                                scoreO++;
                            }
                            scoreLabel.setText("SCORE - X: " + scoreX + ", O: " + scoreO);
                            disableAll();
                            playAgainButton.setVisible(true);
                        }
                        else if(isTie()) {
                            messageLabel.setText("TIE!");
                            disableAll();
                            playAgainButton.setVisible(true);
                        }
                        else {
                            player = player.equals("X") ? "O" : "X";
                            messageLabel.setText(player + " plays");
                        }
                    }
                });
                centerPanel.add(cells[i][j]);
            }
        }
        frame.add(centerPanel, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }

    public void disableAll() {
        for(i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                cells[i][j].setEnabled(false);
            }
        }
    }

    public boolean hasWinner() {
        String s;
        for(int a = 0; a < 3; a++) {
            // Check row at a
            s = cells[a][0].getText();
            if(s.equals(cells[a][1].getText()) && s.equals(cells[a][2].getText()) && (!s.equals("-"))) {
                return true;
            }
            // Check column at a
            s = cells[0][a].getText();
            if(s.equals(cells[1][a].getText()) && s.equals(cells[2][a].getText()) && (!s.equals("-"))) {
                return true;
            }
        }
        // Check diagonals
        s = cells[1][1].getText();
        if(s.equals(cells[0][0].getText()) && s.equals(cells[2][2].getText()) && (!s.equals("-"))) {
            return true;
        }
        if(s.equals(cells[0][2].getText()) && s.equals(cells[2][0].getText()) && (!s.equals("-"))) {
            return true;
        }
        return false;
    }

    public boolean isTie() {
        for(i = 0; i < 3; i++) {
            for (j = 0; j < 3; j++) {
                if(cells[i][j].getText().equals("-")) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TicTacToe ttt = new TicTacToe();
    }
}
