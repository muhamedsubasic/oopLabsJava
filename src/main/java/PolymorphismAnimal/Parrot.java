package PolymorphismAnimal;

public class Parrot extends Animal{
    public Parrot(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(this.name + " says: Polly wants a cracker!");
    }

    public void flyAround() {
        System.out.println(this.name + " is flying around!");
    }
}
