package p14_encryption;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.*;
import java.util.Scanner;
import java.util.Vector;

public class TestEncryptionWithFile {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Type something: ");
        String message = in.nextLine();
        ObjectOutputStream output = null;

        try {
            // Generate keys
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair pair = generator.generateKeyPair();

            PublicKey publicKey = pair.getPublic();
            PrivateKey privateKey = pair.getPrivate();

            // Store the public key to a file
            System.out.println("PUBLIC KEY");
            System.out.println(publicKey.getEncoded().toString());
            FileOutputStream file = new FileOutputStream("src/p14_encryption/public.key");
            BufferedOutputStream buffer = new BufferedOutputStream(file);
            output = new ObjectOutputStream(buffer);
            output.writeObject(publicKey);
            output.close();


            // Retrieve public key from file
            FileInputStream publicKeyFile = new FileInputStream("src/p14_encryption/public.key");
            ObjectInputStream input = new ObjectInputStream(publicKeyFile);
            publicKey = (PublicKey) input.readObject();

            // Encrypt message and print encrypted
            Cipher encryptCipher = Cipher.getInstance("RSA");
            encryptCipher.init(Cipher.ENCRYPT_MODE, publicKey);

            byte[] messageBytes = message.getBytes(StandardCharsets.UTF_8);
            byte[] encryptedBytes = encryptCipher.doFinal(messageBytes);
            //String encryptedText = Base64.getEncoder().encodeToString(encryptedBytes);
            String encryptedText = new String(encryptedBytes, StandardCharsets.UTF_8);
            System.out.println(encryptedText);

            // Decrypt message and print to verify correctness
            Cipher decryptCipher = Cipher.getInstance("RSA");
            decryptCipher.init(Cipher.DECRYPT_MODE, privateKey);

            byte[] decryptedBytes = decryptCipher.doFinal(encryptedBytes);
            String originalMessage = new String(decryptedBytes, StandardCharsets.UTF_8);

            System.out.println(originalMessage);

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
