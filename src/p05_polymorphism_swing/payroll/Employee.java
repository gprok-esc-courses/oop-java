package p05_polymorphism_swing.payroll;

public class Employee extends Worker {

    protected double salary;

    public Employee(String ssn, String firstName, String lastName, double salary) {
        super(ssn, firstName, lastName);
        this.salary = salary;
    }

    @Override
    public double payment() {
        return salary;
    }
}
