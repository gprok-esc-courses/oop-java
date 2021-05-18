package p13_chat.server;

import p13_chat.model.Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class ChatServer {

    private ServerSocket serverSocket;
    private int port;
    private Vector<Client> clients;

    public ChatServer() {
        try {
            clients = new Vector<>();
            port = 8091;
            serverSocket = new ServerSocket(port);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        System.out.println("Starting server at port " + port);
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New connection from " + socket);

                BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            socket.getInputStream()
                    )
                );
                String name = in.readLine();

                System.out.println(name + " is the new client");

                PrintWriter out = new PrintWriter(
                        socket.getOutputStream(), true
                );

                out.println("Welcome " + name);

                // Start new thread to read from the current client
                Client client = new Client(socket);
                client.setName(name);
                clients.add(client);
                ChatServerThread thread = new ChatServerThread(client, in);
                thread.start();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    class ChatServerThread extends Thread {
        private BufferedReader in;
        private Client client;

        public ChatServerThread(Client client, BufferedReader in) {
            this.in = in;
            this.client = client;
        }

        @Override
        public void run() {
            while(true) {
                try {
                    String message = in.readLine();
                    System.out.println(client.getName() + ": " + message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static void main(String[] args) {
        ChatServer server = new ChatServer();
        server.run();
    }

}
