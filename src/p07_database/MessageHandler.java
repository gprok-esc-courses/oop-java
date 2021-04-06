package p07_database;

import java.sql.*;
import java.util.Scanner;

public class MessageHandler {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            // 1. Connect to the DB
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/java",
                    "root",
                    "root"
            );
            Statement statement = con.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM messages");

            while(rs.next()) {
                System.out.println(rs.getInt("id") + ". " + rs.getString("sender") + " to " +
                        rs.getString("receiver") + " message:" + rs.getString("content"));
            }

            System.out.print("Sender: ");
            String sender = in.nextLine();
            System.out.print("Receiver: ");
            String receiver = in.nextLine();
            System.out.print("Message: ");
            String message = in.nextLine();

            statement.execute("INSERT INTO messages (sender, receiver, content) VALUES " +
                    "('" + sender + "','" + receiver + "','" + message + "')");

        }
        catch(ClassNotFoundException cnfe) {
            System.out.println("MySQL Driver not found");
        }
        catch(SQLException se) {
            System.out.println("Cannot connect to the database");
            System.out.println(se.getMessage());
        }

    }

}
