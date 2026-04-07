package LabMethodsAndDb;

public class OverloadedMethods {
    public static void printDetails(String name) {
        System.out.println("Hi, My name is " + name);
    }

    public static void printDetails(String name, int age) {
        System.out.println("Hi, My name is " + name + " and I am " + age + " years old");
    }

    public static void printDetails(String name, int age, String city) {
        System.out.println("Hi, My name is " + name + " and I am " + age + " years old and I am coming from " + city);
    }

    public static void main(String[] args) {
        printDetails("Alice");
        printDetails("Bob", 25);
        printDetails("Charlie", 30, "New York");
    }
}
