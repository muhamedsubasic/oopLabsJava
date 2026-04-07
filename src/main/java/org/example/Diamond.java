package org.example;

public class Diamond {

    public static void printDiamond(int n) {
        // Check if n is odd
        if (n % 2 == 0) {
            System.out.println("Please provide an odd number.");
            return;
        }

        int spaces = n / 2;  // Number of spaces before first star
        int stars = 1;        // Number of stars in first row

        // Upper half of diamond (including middle row)
        for (int i = 0; i < n / 2 + 1; i++) {
            // Print spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            System.out.println();  // New line

            spaces--;  // Decrease spaces for next row
            stars += 2; // Increase stars for next row
        }

        // Reset for lower half
        spaces = 1;
        stars = n - 2;

        // Lower half of diamond (excluding middle row)
        for (int i = 0; i < n / 2; i++) {
            // Print spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }

            // Print stars
            for (int j = 0; j < stars; j++) {
                System.out.print("*");
            }

            System.out.println();  // New line

            spaces++;  // Increase spaces for next row
            stars -= 2; // Decrease stars for next row
        }
    }

    public static void main(String[] args) {
        System.out.println("Diamond pattern for n = 5:");
        printDiamond(5);

        System.out.println("\nDiamond pattern for n = 7:");
        printDiamond(7);

        System.out.println("\nTrying with even number n = 6:");
        printDiamond(6);
    }
}