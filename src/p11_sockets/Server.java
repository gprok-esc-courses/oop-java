package p11_sockets;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class Server {

    private ServerSocket serverSocket;
    private String [] messages = {
        "Hi, welcome to Jurassic Park",
        "Welcome, hope you brought some pizza",
        "Another one bites the dust",
        "You are on my server, follow my rules",
        "Hello alien, welcome to our tribe",
        "Hey, hope you come in peace"
    };

    public String getRandomMessage() {
        Random random = new Random();
        int r = random.nextInt(messages.length);
        return messages[r];
    }

    public Server() {
        try {
            serverSocket = new ServerSocket(8078);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void run() {
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                System.out.println("New connection " + socket);

                OutputStream outStream = socket.getOutputStream();
                PrintWriter out = new PrintWriter(outStream, true);

                out.println(getRandomMessage());

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Server server = new Server();
        server.run();
    }
}
