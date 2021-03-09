package p03_inheritance.v3;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    public String sound() {
        return "Mieow";
    }

    public String toString() {
        return super.toString() + ", the cat";
    }
}