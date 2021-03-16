package p03_inheritance.v3;

public class Frog extends Animal {

    public Frog(String name) {
        super(name);
    }

    public String sound() {
        return "Quax";
    }

    public String toString() {
        return super.toString() + ", the frog";
    }
}
