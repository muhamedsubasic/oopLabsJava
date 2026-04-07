package LabMethodsAndDb;

import java.util.ArrayList;
import java.util.Collections;

public class AscendingOrder {

    public static void sortNumbers(ArrayList<Integer> numbers){
        Collections.sort(numbers);
        numbers.removeIf(n -> n% 2 == 0);
        System.out.println("Numbers: " + numbers);
    }

    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(5);
        numbers.add(4);
        numbers.add(3);
        numbers.add(2);
        numbers.add(1);
        sortNumbers(numbers);
    }
}
