package p15_mvc.counter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class CounterFrame extends JFrame {

    private JButton incrBtn, decrBtn;
    private CounterPanel counterPanel;

    public CounterFrame(ActionListener controller) {
        setSize(300, 300);
        setTitle("Counter");

        counterPanel = new CounterPanel();
        add(counterPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        incrBtn = new JButton("Increase");
        incrBtn.setActionCommand("increase");
        incrBtn.addActionListener(controller);
        decrBtn = new JButton("Decrease");
        decrBtn.setActionCommand("decrease");
        decrBtn.addActionListener(controller);
        buttonPanel.add(incrBtn);
        buttonPanel.add(decrBtn);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void counterChanged(int newValue) {
        counterPanel.setCounterLbl(newValue);
    }

}
