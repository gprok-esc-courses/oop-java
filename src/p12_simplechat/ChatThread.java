package p12_simplechat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Vector;

public class ChatThread extends Thread {
    private Socket socket;
    private Vector<Socket> clients;

    public ChatThread(Socket socket, Vector<Socket> clients) {
        this.socket = socket;
        this.clients = clients;
    }

    public void run() {
        System.out.println("Thread listening to " + socket);
        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

            while (true) {

                String line = in.readLine();
                System.out.println(line);
                for (Socket socket : clients) {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(line);
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
