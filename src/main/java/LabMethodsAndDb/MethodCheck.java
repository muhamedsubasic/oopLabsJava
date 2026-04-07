package LabMethodsAndDb;

public class MethodCheck {
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static int multiply(int a, int b) {
        return a * b;
    }

    public static boolean isEven(int num) {
        return num % 2 == 0;
    }

    public static void main(String[] args) {
        printMessage("Hello, World!");
        System.out.println("5 * 3 = " + multiply(5, 3));
        System.out.println("Is 4 even? " + isEven(4));
        System.out.println("Is 7 even? " + isEven(7));
    }
}

