package IteratorsExceptionUnitTestingFileManipulation;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SafeFileReader {

    // Prints only the first line of the file
    public void printFirstLine(String filePath) {
        try {
            if (filePath == null) {
                throw new NullPointerException("File path is null.");
            }
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String firstLine = reader.readLine();
                if (firstLine != null) {
                    System.out.println(firstLine);
                } else {
                    System.out.println("File exists but is empty.");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("File path cannot be null.");
        }
    }

    // Prints all lines with line numbers
    public void printAllLines(String filePath) {
        try {
            if (filePath == null) {
                throw new NullPointerException("File path is null.");
            }
            boolean hasContent = false;
            int lineNumber = 1;
            try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(lineNumber + ". " + line);
                    lineNumber++;
                    hasContent = true;
                }
            }
            if (!hasContent) {
                System.out.println("File is empty.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + filePath);
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        } catch (NullPointerException e) {
            System.out.println("File path cannot be null.");
        }
    }

    // Prints the number of characters in the string
    public void printLength(String input) {
        if (input == null) {
            System.out.println("Cannot calculate length of null input.");
        } else {
            System.out.println(input.length());
        }
    }

    // Prints the number of words in the string (non‑space tokens)
    public void printWordCount(String input) {
        if (input == null || input.trim().isEmpty()) {
            System.out.println(0);
        } else {
            String[] words = input.trim().split("\\s+");
            System.out.println(words.length);
        }
    }

    // Main method for testing
    public static void main(String[] args) {
        SafeFileReader reader = new SafeFileReader();

        // Prepare sample.txt (in real execution we assume it exists with the given content)
        // For completeness, we can create it programmatically, but the problem states to
        // create the file manually. We'll just assume it's present.

        System.out.println("--- Testing printFirstLine with valid file ---");
        reader.printFirstLine("sample.txt");

        System.out.println("\n--- Testing printAllLines with valid file ---");
        reader.printAllLines("sample.txt");

        System.out.println("\n--- Testing printFirstLine with missing file ---");
        reader.printFirstLine("missing.txt");

        System.out.println("\n--- Testing printAllLines with missing file ---");
        reader.printAllLines("missing.txt");

        System.out.println("\n--- Testing printFirstLine with null path ---");
        reader.printFirstLine(null);

        System.out.println("\n--- Testing printAllLines with null path ---");
        reader.printAllLines(null);

        System.out.println("\n--- Testing printLength ---");
        reader.printLength("Hello World");
        reader.printLength("");
        reader.printLength(null);

        System.out.println("\n--- Testing printWordCount ---");
        reader.printWordCount("Java file handling is important.");
        reader.printWordCount("");
        reader.printWordCount("   ");
        reader.printWordCount(null);
    }
}