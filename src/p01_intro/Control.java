package p01_intro;

public class Control {
    public static void main(String[] args) {
        int a = 10;

        if(a > 10) {
            System.out.println("Greater than 10");
        }
        else if(a < 10) {
            System.out.println("Less than 10");
        }
        else {
            System.out.println("Equals 10");
        }

        int month = 5;

        switch(month) {
            case 1:
                System.out.println("JAN");
                break;
            case 2:
                System.out.println("FEB");
                break;
            case 3:
                System.out.println("MAR");
                break;
            case 4:
                System.out.println("APR");
                break;
            case 5:
                System.out.println("MAY");
                break;
            // etc etc etc
            default:
                System.out.println("Not a month");
                break;
        }

        int counter = 0;

        System.out.println("While loop");
        while(counter < 10) {
            System.out.println("counter: " + counter);
            counter++;
        }

        System.out.println("Do-while loop");
        do {
            System.out.println("counter: " + counter);
            counter--;
        } while(counter > 0);

        System.out.println("For loop");
        for(counter = 0; counter < 10; counter++) {
            System.out.println("counter: " + counter);
        }

        System.out.println("For-each loop");
        String names[] = {"James", "Steve", "Bill", "Guido", "Linus"};
        for(String name : names) {
            System.out.println(name);
        }

        System.out.println("Break loop - Stops when 5 is encountered");
        for(counter = 0; counter < 10; counter++) {
            if(counter == 5) {
                break;
            }
            System.out.println("counter: " + counter);
        }

        System.out.println("Continue loop - Skips when even number is encountered");
        for(counter = 0; counter < 10; counter++) {
            if(counter % 2 == 0) {
                continue;
            }
            System.out.println("counter: " + counter);
        }
    }
}
