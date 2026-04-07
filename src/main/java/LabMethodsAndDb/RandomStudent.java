package LabMethodsAndDb;

import java.util.ArrayList;
import java.util.Random;

public class RandomStudent {
    public static void getRandomStudent(ArrayList<String> students){
        Random rand = new Random();
        System.out.println("Random student is " + students.get(rand.nextInt(students.size())));
    }

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("Diana");
        getRandomStudent(students);
    }
}
