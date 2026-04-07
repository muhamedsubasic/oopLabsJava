package LabMethodsAndDb;

import java.util.ArrayList;

public class StudentList {
    public static void processStudentList() {
        ArrayList<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("Diana");
        students.add("Eve");

        students.remove("Charlie");

        System.out.println("Using for loop:");
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }

        System.out.println("\nUsing for-each loop:");
        for (String name : students) {
            System.out.println(name);
        }

        System.out.println("\nUsing while loop:");
        int index = 0;
        while (index < students.size()) {
            System.out.println(students.get(index));
            index++;
        }
    }

    public static void main(String[] args) {
        processStudentList();
    }
}
