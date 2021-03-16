package p04_files;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AnimalReader {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("data.txt");
            BufferedReader reader = new BufferedReader(file);

            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }
        catch(FileNotFoundException e) {
            System.out.println("File not found");
            System.out.println(e.getMessage());
        }
        catch(IOException ioe) {
            System.out.println(ioe.getMessage());
        }

    }
}
