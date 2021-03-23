package p05_polymorphism_swing.payroll;

public class Contract extends Worker {
    protected int hoursWorked;
    protected double hourlyRate;

    public Contract(String ssn, String firstName, String lastName, int hoursWorked, double hourlyRate) {
        super(ssn, firstName, lastName);
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
    }

    @Override
    public double payment() {
        return hoursWorked * hourlyRate;
    }
}
