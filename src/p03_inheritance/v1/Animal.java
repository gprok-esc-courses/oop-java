package p03_inheritance.v1;

public class Animal {

    private String name;
    private String type;
    private boolean canFly;

    public Animal(String name, String type) {
        this.name = name;
        this.type = type;
        if(type.equals("dog")) {
            canFly = false;
        }
        else if(type.equals("cat")) {
            canFly = false;
        }
        else if(type.equals("duck")) {
            canFly = true;
        }
    }

    public String sound() {
        if(type.equals("dog")) {
            return "Woof";
        }
        else if(type.equals("cat")) {
            return "Mieow";
        }
        else if(type.equals("duck")) {
            return "Quack";
        }
        else {
            return "N/A";
        }
    }

    public String toString() {
        return name + ", the " + type;
    }

    public String fly() {
        if(canFly) {
            return "flying";
        }
        else {
            return type + " cannot fly";
        }
    }



    public static void main(String[] args) {
        Animal [] animals = new Animal[3];
        animals[0] = new Animal("Pluto", "dog");
        animals[1] = new Animal("Garfield", "cat");
        animals[2] = new Animal("Donald", "duck");

        for(Animal a : animals) {
            System.out.println(a);
            System.out.println(a.sound());
            System.out.println(a.fly());
        }
    }

}
