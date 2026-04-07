package LabMethodsAndDb;

import java.util.ArrayList;
import java.util.Collections;

public class AlphabeticalStudent {
    public static void sortStudents(ArrayList<String> students){
        Collections.sort(students);
        for (String name : students) {
            System.out.println(name);
        }
    }

    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();
        students.add("Mehemed");
        students.add("Bakir");
        students.add("Salim");
        students.add("Latif");
        sortStudents(students);
    }
}

