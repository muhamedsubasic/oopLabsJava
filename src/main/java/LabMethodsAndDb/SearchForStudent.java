package LabMethodsAndDb;

import java.util.ArrayList;

public class SearchForStudent {
    public static boolean searchStudent(ArrayList<String> list, String name) {
        return list.contains(name);
    }

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Alice");
        students.add("Bob");
        students.add("Charlie");
        students.add("Diana");

        String searchName = "Charlie";
        if (searchStudent(students, searchName)) {
            System.out.println(searchName + " found in the list.");
        } else {
            System.out.println(searchName + " not found.");
        }

        searchName = "Eve";
        if (searchStudent(students, searchName)) {
            System.out.println(searchName + " found in the list.");
        } else {
            System.out.println(searchName + " not found.");
        }
    }
}
