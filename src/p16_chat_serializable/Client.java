package p16_chat_serializable;

import javax.crypto.Cipher;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Scanner;

public class Client {
    private PublicKey publicKey;
    private PrivateKey privateKey;
    private PublicKey serverKey;
    Socket socket;
    ObjectOutputStream out;
    ObjectInputStream in;

    public Client() {
        try {
            socket = new Socket("127.0.0.1", 8076);

            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            KeyPair keyPair = keyPairGenerator.generateKeyPair();
            publicKey = keyPair.getPublic();
            privateKey = keyPair.getPrivate();

            out = new ObjectOutputStream(socket.getOutputStream());
            in = new ObjectInputStream(socket.getInputStream());

            // 1. Get server's public key
            Message message = (Message) in.readObject();
            serverKey = (PublicKey) message.getContent();

            // 2. Send public key to server
            message = new Message("public_key", publicKey);
            out.writeObject(message);

            // 3. Send messages, terminate with "close"
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, serverKey);

            ClientThread thread = new ClientThread();
            thread.start();
            while(true) {
                Scanner keyb = new Scanner(System.in);
                String msg = keyb.nextLine();
                byte[] msgBytes = msg.getBytes(StandardCharsets.UTF_8);
                byte[] encryptedMsg = encryptCipher.doFinal(msgBytes);

                if(msg.equals("close")) {
                    message = new Message("close", encryptedMsg);
                    break;
                }
                else {
                    message = new Message("message", encryptedMsg);
                }
                out.writeObject(message);
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    class ClientThread extends Thread {
        @Override
        public void run() {
            try {
                Cipher decryptCipher = Cipher.getInstance("RSA");
                decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);
                while(true) {
                    Message serverMessage = (Message) in.readObject();
                    byte[] encryptedMsg = (byte[]) serverMessage.getContent();
                    byte[] decryptedBytes = decryptCipher.doFinal(encryptedMsg);
                    String msg = new String(decryptedBytes, StandardCharsets.UTF_8);
                    switch(serverMessage.getType()) {
                        case "message":
                            System.out.println("Message: " + msg);
                            break;
                        case "new_user":
                            break;
                        case "user_leaves":
                            break;
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        Client c = new Client();
    }
}
