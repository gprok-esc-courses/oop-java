package p15_mvc.counter;

import java.util.Random;

public class Model {
    private int counter;
    private CounterChangedListener monitor;

    public Model(CounterChangedListener monitor) {
        counter = 0;
        this.monitor = monitor;
        RandomGenerator generator = new RandomGenerator();
        generator.start();
    }

    public int getCounter() {
        return counter;
    }

    public void increase() {
        counter++;
    }

    public void decrease() {
        counter--;
    }

    class RandomGenerator extends Thread {
        @Override
        public void run() {
            Random rnd = new Random();
            while(true) {
                try {
                    sleep(rnd.nextInt(5000) + 1000);
                    counter = rnd.nextInt(100);
                    monitor.counterHasNewValue(counter);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
