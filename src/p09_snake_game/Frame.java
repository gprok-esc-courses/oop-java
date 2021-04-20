package p09_snake_game;

import javax.swing.*;

public class Frame extends JFrame {
    private Board board;

    public Frame() {
        board = new Board();
        add(board);

        setResizable(false);
        pack();

        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Frame frame = new Frame();
            frame.setVisible(true);
        });
    }
}
