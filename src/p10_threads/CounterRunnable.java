package p10_threads;

import java.util.Random;
import java.util.Vector;

public class CounterRunnable implements Runnable {

    private String name;
    private Thread th;

    public CounterRunnable(String name) {
        this.name = name;
    }

    public void start() {
        th = new Thread(this);
        th.start();
    }

    public void join() throws InterruptedException {
        th.join();
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
        Vector<CounterRunnable> threads = new Vector<>();

        for(int i = 0; i < 5; i++) {
            CounterRunnable counter = new CounterRunnable(names[i]);
            counter.start();
            threads.add(counter);
        }
        for (CounterRunnable thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("END");
    }

}
