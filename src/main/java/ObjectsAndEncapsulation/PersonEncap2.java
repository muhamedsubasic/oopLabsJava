package ObjectsAndEncapsulation;

import java.util.ArrayList;

public class PersonEncap2 {
    public static class Person{
        private String name;
        private int age;

        public Person(String name){
            this.name = name;
            this.age = 0;
        }

        public Person(String name, int age){
            this.name = name;
            this.age = age;
        }

        public String getName(){ return this.name; }
        public int getAge(){ return this.age; }
        public void setName(String name){ this.name = name;}
        public void setAge(int age){
            if(age > 0){
                this.age = age;
            } else {
                System.out.println("Age can't be negative");
            }
        }

        public String toString(){ return "Name: " + this.name + " ,Age: " + this.age;}
        public void increaseAge(){ this.age++; }
        public boolean isAdult() { return this.age >= 18; }

        public static class Group{
            private ArrayList<Person> members;

            public Group(){
                members = new ArrayList<>();
            }

            public void addPerson(Person person){ members.add(person); }
            public void listPeople(){
                for (Person person : members){
                    System.out.println(person);
                }
            }

            public void removePerson(String name){
                members.removeIf(person -> person.getName().equals(name));
            }
        }
        public static void main(String[] args) {
            Person person1 = new Person("John");
            Person person2 = new Person("Jane", 25);
            Group group = new Group();

            System.out.println(person1);
            System.out.println(person2);
            person1.increaseAge();
            person1.increaseAge();
            System.out.println(person1);
            System.out.println("John is adult? " + person1.isAdult());

            group.addPerson(person1);
            group.addPerson(person2);
            System.out.println("skndalndjsabdkjsa");
            group.listPeople();
            group.removePerson("Jane");
            System.out.println("khadhasdhkbasd");
            group.listPeople();
        }

    }
}
