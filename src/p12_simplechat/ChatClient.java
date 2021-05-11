package p12_simplechat;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ChatClient extends Thread {
    private Socket socket;
    private BufferedReader in;
    private PrintWriter out;

    public ChatClient() {
        try {
            socket = new Socket("127.0.0.1", 8090);

            out = new PrintWriter(socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            // Start the thread which will read from keyboard and send to the server
            this.start();

            while(true) {
                try {
                    String line = in.readLine();
                    if(line == null) {
                        System.out.println("Server stopped");
                        break;
                    }
                    System.out.println(line);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        Scanner keyboard = new Scanner(System.in);
        while(true) {
            String line = keyboard.nextLine();
            System.out.println("sending ... " + line);
            out.println(line);
        }
    }

    public static void main(String[] args) {
        ChatClient client = new ChatClient();
    }
}
