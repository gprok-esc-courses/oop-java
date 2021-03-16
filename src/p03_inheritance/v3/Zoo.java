package p03_inheritance.v3;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class Zoo {
    public static void main(String[] args) {

        ArrayList<Animal> animals = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        String answer = "";

        do {
            System.out.println("1. Add animal");
            System.out.println("2. Animals sound");
            System.out.println("0. Exit");
            answer = in.next();

            switch (answer) {
                case "1":
                    System.out.print("Animal type: ");
                    String type = in.next();
                    System.out.print("Name: ");
                    String name = in.next();
                    Animal animal = AnimalFactory.createAnimal(type, name);

                    if (animal != null) {
                        animals.add(animal);
                    }
                    break;
                case "2":
                    for (Animal a : animals) {
                        System.out.println(a.sound());
                    }
                    break;
                case "0":
                    break;
                default:
                    System.out.println("Invalid choice");
                    break;
            }

        } while(!answer.equals("0"));
    }
}
