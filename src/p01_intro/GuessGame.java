package p01_intro;

import java.util.Random;
import java.util.Scanner;

public class GuessGame {
    public static void main(String[] args) {
        int secret;
        int guess = 0;
        int counter = 0;

        Random rnd = new Random();
        secret = rnd.nextInt(100) + 1;
        Scanner keyb = new Scanner(System.in);

        do {
            System.out.print("Guess: ");
            guess = keyb.nextInt();
            counter++;
            if(guess > secret) {
                System.out.println("Go down");
            }
            else if(guess < secret) {
                System.out.println("Go up");
            }
            else {
                System.out.println("Found in " + counter + " steps");
            }
        } while(guess != secret);
    }
}
