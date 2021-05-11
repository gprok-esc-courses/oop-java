package p12_simplechat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {
    private ServerSocket serverSocket;
    private Vector<Socket> clients;

    public ChatServer() {
        try {
            clients = new Vector<>();
            serverSocket = new ServerSocket(8090);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("Server started on port 8090");
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                clients.add(socket);
                System.out.println("Connection from " + socket);

                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                out.println("Welcome. Start typing your messages");

                // Start thread that will read from this client and broadcast to all clients
                ChatThread thread = new ChatThread(socket, clients);
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.run();
    }
}
