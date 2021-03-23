package p05_polymorphism_swing.payroll;

public class Manager extends Worker {
    protected double salary;
    protected double bonus;

    public Manager(String ssn, String firstName, String lastName, double salary, double bonus) {
        super(ssn, firstName, lastName);
        this.salary = salary;
        this.bonus = bonus;
    }

    @Override
    public double payment() {
        return salary + bonus;
    }
}
