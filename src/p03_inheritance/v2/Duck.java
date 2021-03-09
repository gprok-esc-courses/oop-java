package p03_inheritance.v2;

public class Duck extends Animal {

    public Duck(String name) {
        super(name);
    }

    public String sound() {
        return "Quack";
    }

    public String fly() {
        return "flying";
    }

    public String toString() {
        return super.toString() + ", the duck";
    }
}