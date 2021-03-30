package p06_tictactoe.refactored.view;

import p06_tictactoe.refactored.model.CellButtonListener;

import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private CellButton [][] buttons;

    public BoardPanel(CellButtonListener buttonListener) {
        setLayout(new GridLayout(3,3));
        buttons = new CellButton[3][3];
        for(int i = 0; i < 3; i++) {
            for(int j = 0; j < 3; j++) {
                buttons[i][j] = new CellButton(i, j, buttonListener);
                add(buttons[i][j]);
            }
        }
    }
}
