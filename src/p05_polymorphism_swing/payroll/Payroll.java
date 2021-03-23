package p05_polymorphism_swing.payroll;

import java.util.ArrayList;

public class Payroll {
    public static void main(String[] args) {
        ArrayList<Worker> workers = new ArrayList<>();
        workers.add(new Employee("1", "John", "Doe", 750));
        workers.add(new Manager("2", "Mary", "Doe", 3500, 7000));
        workers.add(new Contract("3", "Jim", "Poor", 30, 5));

        for (Worker worker : workers) {
            System.out.println(worker);
        }
    }
}
