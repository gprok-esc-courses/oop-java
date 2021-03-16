package p04_files;

import java.io.*;

public class FileClone {
    public static void main(String[] args) {
        if(args.length != 2) {
            System.out.println("Syntax: FileClone <origin> <destination>");
        }
        else {
            try {
                FileReader file = new FileReader(args[0]);
                BufferedReader reader = new BufferedReader(file);
                String line;
                FileWriter writer = new FileWriter(args[1]);

                while((line = reader.readLine()) != null) {
                    writer.write(line + "\n");
                }
                writer.close();
            }
            catch(FileNotFoundException e) {
                System.out.println(e.getMessage());
            }
            catch(IOException ioe) {
                System.out.println(ioe.getMessage());
            }
        }
    }
}
