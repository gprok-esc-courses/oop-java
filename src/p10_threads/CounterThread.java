package p10_threads;

import java.util.Random;
import java.util.Vector;

public class CounterThread extends Thread {

    private String name;

    public CounterThread(String name) {
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
        Vector<CounterThread> threads = new Vector<>();

        for(int i = 0; i < 5; i++) {
            CounterThread counter = new CounterThread(names[i]);
            counter.start();
            threads.add(counter);
        }
        for (CounterThread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }

}
