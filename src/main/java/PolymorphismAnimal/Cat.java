package PolymorphismAnimal;

public class Cat extends Animal{
    public Cat(String name) {
        super(name);
    }

    @Override
    public void speak() {
        System.out.println(this.name + " says: Meow!");
    }

    public void scratchSofa() {
        System.out.println(this.name + " is scratching the sofa!");
    }
}
