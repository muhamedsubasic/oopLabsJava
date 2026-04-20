package Abstraction;

import java.util.ArrayList;

abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void makeSound();

    public String getName() {
        return name;
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Woof!");
    }

    public void fetch() {
        System.out.println(getName() + " is fetching the ball!");
    }
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public void makeSound() {
        System.out.println("Meow!");
    }

    public void purr() {
        System.out.println(getName() + " is purring.");
    }
}

class AnimalTest {
    public static void main(String[] args) {
        ArrayList<Animal> animals = new ArrayList<>();
        animals.add(new Dog("Buddy"));
        animals.add(new Cat("Whiskers"));

        for (Animal a : animals) {
            System.out.print(a.getName() + " says: ");
            a.makeSound();

            if (a instanceof Dog) {
                ((Dog) a).fetch();
            } else if (a instanceof Cat) {
                ((Cat) a).purr();
            }
        }
    }
}
