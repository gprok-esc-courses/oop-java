package p11_sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.Socket;
import java.nio.Buffer;

public class Client {

    private Socket socket;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 8078);

            InputStream inStream = socket.getInputStream();
            InputStreamReader inReader = new InputStreamReader(inStream);
            BufferedReader in = new BufferedReader(inReader);

            String line = in.readLine();
            System.out.println(line);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
    }
}
