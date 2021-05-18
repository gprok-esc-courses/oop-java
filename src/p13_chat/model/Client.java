package p13_chat.model;

import java.net.Socket;

public class Client {
    private Socket socket;
    private String name;

    public Client(Socket socket) {
        this.socket = socket;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Socket getSocket() {
        return socket;
    }

    public String getName() {
        return name;
    }
}
