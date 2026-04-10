package PolymorphismAnimal;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Animal Demo ===");
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Buddy"));
        animals.add(new Dog("Max"));
        animals.add(new Cat("Luna"));
        animals.add(new Cat("Milo"));
        animals.add(new Parrot("Rio"));
        animals.add(new Parrot("Coco"));

        for (Animal a : animals) {
            a.speak(); // dynamic dispatch
            if (a instanceof Dog) {
                ((Dog) a).fetchBall();
            } else if (a instanceof Cat) {
                ((Cat) a).scratchSofa();
            } else if (a instanceof Parrot) {
                ((Parrot) a).flyAround();
            }
            System.out.println();
        }
    }
}
