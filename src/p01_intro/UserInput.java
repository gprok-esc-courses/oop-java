package p01_intro;

import java.util.Scanner;

public class UserInput {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.print("Type something here: ");
        String input = keyboard.next();
        System.out.println("You typed: " + input);
    }
}
