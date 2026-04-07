package Inheritance;

import java.util.ArrayList;

public class Person {
    private String name;
    private String email;
    private int birthYear;

    public Person(String name, String email, int birthYear) {
        this.name = name;
        this.email = email;
        this.birthYear = birthYear;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public int getAge(int currentYear) {
        return currentYear - this.birthYear;
    }

    public String getInfo(int currentYear) {
        return "Name: " + this.name + " Email: " + this.email + " Age: " + this.getAge(currentYear);
    }

        public static void main(String[] args) {
            int currentYear = 2026;
            ArrayList<Person> people = new ArrayList<>();

            people.add(new Student("Alice Johnson", "alice@university.edu", 2002, "S1001", "Computer Science"));
            people.add(new Professor("Dr. Robert Smith", "robert.smith@university.edu", 1975, "F452", "Physics"));
            people.add(new Student("Bob Williams", "bob.williams@university.edu", 2003, "S1002", "Mathematics"));
            people.add(new Professor("Dr. Emily Davis", "emily.davis@university.edu", 1980, "F789", "Biology"));

            System.out.println("--- People Information ---");
            for (Person person : people) {
                System.out.println(person.getInfo(currentYear));
                System.out.println("--------------------------");
            }
        }
    }


