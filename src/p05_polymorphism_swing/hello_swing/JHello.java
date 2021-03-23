package p05_polymorphism_swing.hello_swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JHello {
    private JFrame frame;
    private JTextField textField;
    private JButton button;
    private JLabel label;

    public JHello() {
        frame = new JFrame();
        frame.setTitle("Hello Swing");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JPanel panel = new JPanel();

        textField = new JTextField(10);
        button = new JButton("SUBMIT");
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                label.setText("Hello " + name);
            }
        });
        label = new JLabel("Type your name");

        panel.add(textField);
        panel.add(button);
        panel.add(label);
        frame.add(panel, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        JHello hello = new JHello();
    }
}
