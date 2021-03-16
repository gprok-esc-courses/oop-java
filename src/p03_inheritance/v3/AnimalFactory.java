package p03_inheritance.v3;

public class AnimalFactory {

    public static Animal createAnimal(String type, String name) {
        Animal animal = null;
        if(type.equals("Dog")) {
            animal = new Dog(name);
        }
        else if(type.equals("Cat")) {
            animal = new Cat(name);
        }
        else if(type.equals("Duck")) {
            animal = new Duck(name);
        }
        else if(type.equals("Frog")) {
            animal = new Frog(name);
        }

        return animal;
    }
}
