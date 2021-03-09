package p03_inheritance.v3;

public class Duck extends Animal {

    public Duck(String name) {
        super(name);
        flyBehaviour = new FlyAsBird();
    }

    public String sound() {
        return "Quack";
    }

    public String toString() {
        return super.toString() + ", the duck";
    }
}