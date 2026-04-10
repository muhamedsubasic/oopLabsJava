package PolymorphismAnimal;

public class Dog extends Animal{
    public Dog(String name){
        super(name);
    }

    @Override
    public void speak(){
        System.out.println("Woof");
    }

    public void fetchBall(){
        System.out.println( this.name + " is fetching a ball" );
    }
}
