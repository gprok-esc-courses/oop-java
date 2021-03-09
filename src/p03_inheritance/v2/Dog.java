package p03_inheritance.v2;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    public String sound() {
        return "Woof";
    }

    public String toString() {
        return super.toString() + ", the dog";
    }
}
