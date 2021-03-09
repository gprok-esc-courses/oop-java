package p03_inheritance.v3;

public class FlyNoWay implements FlyBehaviour {

    @Override
    public String fly() {
        return "cannot fly";
    }
}
