package p06_tictactoe.refactored.view;

import p06_tictactoe.refactored.model.CellButtonListener;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CellButton extends JButton {
    private int row, col;
    private CellButtonListener cellButtonListener;

    public CellButton(int row, int col, CellButtonListener buttonListener) {
        cellButtonListener = buttonListener;
        setText("-");
        this.row = row;
        this.col = col;
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int v = cellButtonListener.buttonClicked(row, col);
                setText(v == 1 ? "X" : "O");
                setEnabled(false);
            }
        });
    }

    public void reset() {
        setEnabled(true);
        setText("-");
    }
}
