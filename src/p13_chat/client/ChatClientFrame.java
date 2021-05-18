package p13_chat.client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ChatClientFrame extends JFrame {

    private JTextField messageField;
    private JButton sendBtn;
    private ConnectAction connectAction;
    private SendAction sendAction;
    private Socket socket;
    private PrintWriter out;

    public ChatClientFrame() {
        setSize(500, 800);

        JPanel southPanel = new JPanel();

        messageField = new JTextField(20);

        sendBtn = new JButton("Connect");
        connectAction = new ConnectAction();
        sendBtn.addActionListener(connectAction);

        southPanel.add(messageField);
        southPanel.add(sendBtn);
        add(southPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        ChatClientFrame chatClient = new ChatClientFrame();
    }

    class ConnectAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String name = messageField.getText();
            if(name.length() == 0) {
                JOptionPane.showMessageDialog(ChatClientFrame.this, "Please type your name",
                        "Error", JOptionPane.ERROR_MESSAGE);
            }
            else {
                try {
                    socket = new Socket("127.0.0.1", 8091);

                    out = new PrintWriter(
                            socket.getOutputStream(), true
                    );

                    out.println(name);

                    BufferedReader in = new BufferedReader(
                            new InputStreamReader(
                                    socket.getInputStream()
                            )
                    );
                    String message = in.readLine();

                    System.out.println(message);

                    // Change button behaviour and label
                    sendBtn.setText("SEND");
                    messageField.setText("");
                    sendBtn.removeActionListener(this);
                    sendAction = new SendAction();
                    sendBtn.addActionListener(sendAction);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }

            }
        }
    }

    class SendAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String message = messageField.getText();
            if(message.length() == 0) {
                // do nothing
            }
            else {
                System.out.println(message);
                out.println(message);
                messageField.setText("");
            }
        }
    }

}
