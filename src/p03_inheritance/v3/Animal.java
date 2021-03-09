package p03_inheritance.v3;

public abstract class Animal {
    protected String name;
    protected FlyBehaviour flyBehaviour;

    public Animal(String name) {
        this.name = name;
        flyBehaviour = new FlyNoWay();
    }

    public String toString() {
        return name;
    }

    public abstract String sound();

    public String fly() {
        return flyBehaviour.fly();
    }

    public void setFlyBehaviour(FlyBehaviour flyBehaviour) {
        this.flyBehaviour = flyBehaviour;
    }


    public static void main(String[] args) {
        /*
        Dog d = new Dog("Pluto");
        System.out.println(d);
        System.out.println(d.sound());

        Cat c = new Cat("Sylvester");
        System.out.println(c);
        System.out.println(c.sound());

        Duck du = new Duck("Donald");
        System.out.println(du);
        System.out.println(du.sound());
        System.out.println(du.fly());
        */

        Animal [] animals = new Animal[3];
        animals[0] = new Dog("Pluto");
        animals[1] = new Cat("Sylvester");
        animals[2] = new Duck("Donald");


        for(Animal a : animals) {
            if(a != null) {
                System.out.println(a);
                System.out.println(a.sound());
                System.out.println(a.fly());
            }
        }

        animals[2].setFlyBehaviour(new FlyNoWay());
        animals[1].setFlyBehaviour(new FlyInAirplane());

        for(Animal a : animals) {
            if(a != null) {
                System.out.println(a);
                System.out.println(a.sound());
                System.out.println(a.fly());
            }
        }
    }
}
