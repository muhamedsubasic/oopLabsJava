package ObjectsAndEncapsulation;

import java.util.ArrayList;

public class PersonEncap {
    public static class Person{
        private String name;
        private int age;

        public Person(String initialName){
            setName(initialName);
            this.age = 0;
        }

        public Person(String initialName, int initialAge){
            setName(initialName);
            setAge(initialAge);
        }

        public String getName(){
            return this.name;
        }

        public int getAge(){
            return this.age;
        }

        public void setName(String changedName){
            this.name = changedName;
        }

        public void setAge(int changedAge){
            if (changedAge >= 0){
                this.age = changedAge;
            } else {
                System.out.println("Age can't be negative");
            }
        }

        public void printDetails(){
            System.out.println(this.name + " " + this.age);
        }

        public String toString(){
            return "Name: " + this.name + " ,Age: " + this.age;
        }

        public void increaseAge(){
            this.age++;
        }

        public boolean isAdult(){
            return this.age >= 18;
        }
    }

    public static class Group {
        private ArrayList<Person> members;

        public Group(){
            members = new ArrayList<>();
        }

        public void addPerson(Person person){
            members.add(person);
        }

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
        Person person3 = new Person("Jake", 16);

        Group group = new Group();

        person1.setAge(20);
        person1.increaseAge();
        person1.increaseAge();

        //System.out.println(person1);
        //System.out.println(person2);
        //System.out.println(person3);
        //System.out.println(person3.getName() + " adult? " + person3.isAdult());

        group.addPerson(person1);
        group.addPerson(person2);
        group.addPerson(person3);

        group.listPeople();
        group.removePerson("Jake");
        group.listPeople();
    }
}
