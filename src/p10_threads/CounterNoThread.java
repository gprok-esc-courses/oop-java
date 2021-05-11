package p10_threads;

import java.util.Random;

public class CounterNoThread {

    private String name;

    public CounterNoThread(String name) {
        this.name = name;
    }

    public void run() {
        Random random = new Random();
        for(int i = 1; i <= 10; i++) {
            System.out.println(name + ": " + i);
            int sleepTime = random.nextInt(5000);
            try {
                Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        String [] names = {"A", "B", "C", "D", "E"};

        for(int i = 0; i < 5; i++) {
            CounterNoThread counter = new CounterNoThread(names[i]);
            counter.run();
        }
        System.out.println("END");
    }

}
