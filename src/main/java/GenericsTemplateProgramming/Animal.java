package GenericsTemplateProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class Animal {
    private String name;
    private int age;

    public Animal(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){ return this.name; }
    public int getAge(){ return this.age; }

    public abstract void speak();
}

class Lion extends Animal implements Comparable<Lion>{
    public Lion(String name, int age){
        super(name, age);
    }

    @Override
    public void speak(){
        System.out.println(this.getName() + " Roars!");
    }

    @Override
    public int compareTo(Lion other){
        return Integer.compare(this.getAge(), other.getAge());
    }
}

class Elephant extends Animal implements Comparable<Elephant>{
    public Elephant(String name, int age){
        super(name, age);
    }

    @Override
    public void speak(){
        System.out.println(this.getName() + " BRRRR!");
    }

    @Override
    public int compareTo(Elephant other){
        return Integer.compare(this.getAge(), other.getAge());
    }
}

class AnimalCage<T extends Animal & Comparable<T>>{
    private List<T> animals;

    public AnimalCage(){
        animals = new ArrayList<>();
    }

    public void addAnimal(T animal){
        animals.add(animal);
    }

    public void sortAnimals(){
        Collections.sort(animals);
    }

    public void printAllAnimals(){
        for (T animal: animals){
            System.out.println(animal.getName() + " Age: " + animal.getAge());
            animal.speak();
        }
    }
}

class ZooTest{
    public static void main(String[] args) {
        // Lion Cage
        AnimalCage<Lion> lionCage = new AnimalCage<>();
        lionCage.addAnimal(new Lion("Simba", 5));
        lionCage.addAnimal(new Lion("Mufasa", 8));
        lionCage.addAnimal(new Lion("Nala", 3));

        System.out.println("=== Lions (before sorting) ===");
        lionCage.printAllAnimals();

        lionCage.sortAnimals();
        System.out.println("\n=== Lions (sorted by age) ===");
        lionCage.printAllAnimals();

        // Elephant Cage
        AnimalCage<Elephant> elephantCage = new AnimalCage<>();
        elephantCage.addAnimal(new Elephant("Dumbo", 4));
        elephantCage.addAnimal(new Elephant("Babar", 12));
        elephantCage.addAnimal(new Elephant("Ellie", 7));

        System.out.println("\n=== Elephants (before sorting) ===");
        elephantCage.printAllAnimals();

        elephantCage.sortAnimals();
        System.out.println("\n=== Elephants (sorted by age) ===");
        elephantCage.printAllAnimals();
    }
}