package p15_mvc.counter;

import javax.swing.*;

public class CounterPanel extends JPanel {

    private JLabel counterLbl;

    public CounterPanel() {
        counterLbl = new JLabel(" ");
        setCounterLbl(0);
        add(counterLbl);
    }

    public void setCounterLbl(int counter) {
        counterLbl.setText("<html><h1>" + counter + "</h1></html>");
    }
}
