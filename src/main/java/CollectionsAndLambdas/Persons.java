package CollectionsAndLambdas;

record Person(String name, int age, int height){
    static Person createAnonymous(){
        return new Person("Anonymous", 0, 0);
    }
}

public class Persons {
    public static void main(String[] args) {
        Person alice = new Person("Alice", 25, 165);
        Person bob = new Person("Bob", 30, 175);
        Person anonymous = Person.createAnonymous();

        System.out.println(alice);
        System.out.println(bob);
        System.out.println(anonymous);

        System.out.println("alice equals bob? " + alice.equals(bob));
        System.out.println("Alice's height: " + alice.height());
        System.out.println("Anonymous name: " + anonymous.name());
    }
}
