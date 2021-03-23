package p05_polymorphism_swing.payroll;

public abstract class Worker {
    protected String firstName;
    protected String lastName;
    protected String ssn;

    public Worker(String ssn, String firstName, String lastName) {
        this.ssn = ssn;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String toString() {
        return lastName + ", " + firstName + " $" + payment();
    }

    public abstract double payment();
}
