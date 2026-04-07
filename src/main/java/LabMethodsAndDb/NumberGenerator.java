package LabMethodsAndDb;

import java.util.ArrayList;

public class NumberGenerator {
    public static void generateNumbers(int n) {
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }
        System.out.println(numbers);
    }

    public static void main(String[] args) {
        generateNumbers(6);
    }
}