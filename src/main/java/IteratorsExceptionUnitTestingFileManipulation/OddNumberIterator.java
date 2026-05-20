package IteratorsExceptionUnitTestingFileManipulation;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class OddNumberIterator implements Iterator<Integer> {
    private int[] numbers;
    private int currentIndex;
    private Integer nextValue;  // stores the next valid positive odd number, or null if none

    public OddNumberIterator(int[] numbers) {
        this.numbers = numbers;
        this.currentIndex = 0;
        this.nextValue = null;   // will be filled by hasNext()
    }

    @Override
    public boolean hasNext() {
        if (nextValue != null) {
            return true;
        }
        while (currentIndex < numbers.length) {
            int value = numbers[currentIndex];
            currentIndex++;
            if (value > 0 && value % 2 != 0) {  // positive and odd
                nextValue = value;
                return true;
            }
        }
        return false;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more positive odd numbers.");
        }
        Integer result = nextValue;
        nextValue = null;
        return result;
    }

    public static void main(String[] args) {
        int[] data = {1, -3, 2, 5, 0, 8, 7, -9, 11, 14};
        OddNumberIterator iterator = new OddNumberIterator(data);

        System.out.println("Positive Odd numbers:");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}