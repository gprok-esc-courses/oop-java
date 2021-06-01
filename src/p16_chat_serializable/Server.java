package p16_chat_serializable;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.util.ArrayList;

public class Server {
    private ServerSocket serverSocket;
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private PublicKey clientKey;

    private ArrayList<ClientThread> clients;

    public Server() {
        clients = new ArrayList<>();
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();

            serverSocket = new ServerSocket(8076);

            System.out.println("Server started on 8076");
            while(true) {
                Socket socket = serverSocket.accept();
                System.out.println("Connection from " + socket);

                ClientThread clientThread = new ClientThread(socket);
                clientThread.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Server s = new Server();
    }

    class ClientThread extends Thread {
        private Socket socket;
        private ObjectInputStream in;
        private ObjectOutputStream out;
        private PublicKey clientPublicKey;
        private String name;

        public ClientThread(Socket socket) {
            this.socket = socket;
            try {
                in = new ObjectInputStream(socket.getInputStream());
                out = new ObjectOutputStream(socket.getOutputStream());
            } catch (Exception e) {
                e.printStackTrace();
            }

        }

        public void setClientPublicKey(PublicKey clientPublicKey) {
            this.clientPublicKey = clientPublicKey;
        }

        public PublicKey getClientPublicKey() {
            return clientPublicKey;
        }

        public void setClientName(String name) {
            this.name = name;
        }

        public ObjectOutputStream getOut() {
            return out;
        }

        public void broadcast(String msg) throws NoSuchPaddingException, NoSuchAlgorithmException, BadPaddingException, IllegalBlockSizeException, InvalidKeyException, IOException {

            for (ClientThread ct : clients) {
                if(ct != this) {
                    Cipher encryptCipher = Cipher.getInstance("RSA");
                    encryptCipher.init(Cipher.ENCRYPT_MODE, ct.getClientPublicKey());
                    byte[] msgBytes = msg.getBytes(StandardCharsets.UTF_8);
                    byte[] encryptedMsg = encryptCipher.doFinal(msgBytes);
                    Message message = new Message("message", encryptedMsg);
                    ct.getOut().writeObject(message);
                }
            }
        }

        @Override
        public void run() {
            try {
                // 1. Send public key to client
                Message message = new Message("public_key", publicKey);
                out.writeObject(message);

                // 2. Get client's public key
                message = (Message) in.readObject();
                clientPublicKey = (PublicKey) message.getContent();
                System.out.println(clientPublicKey.getEncoded().toString());

                Cipher decryptCipher = Cipher.getInstance("RSA");
                decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

                clients.add(this);
                while(true) {
                    message = (Message) in.readObject();
                    // System.out.println(new String((byte[])message.getContent(), StandardCharsets.UTF_8));
                    byte[] encryptedMsg = (byte[]) message.getContent();
                    byte[] decryptedBytes = decryptCipher.doFinal(encryptedMsg);
                    String msg = new String(decryptedBytes, StandardCharsets.UTF_8);

                    if(msg.equals("close")) {
                        System.out.println("Client closed. " + msg);
                        clients.remove(this);
                        break;
                    }
                    else {
                        System.out.println(message.getType() + ": " + msg);
                        broadcast(msg);
                    }
                }


            } catch (Exception e) {
                clients.remove(this);
                System.out.println(e.getMessage());
            }
        }
    }
}
