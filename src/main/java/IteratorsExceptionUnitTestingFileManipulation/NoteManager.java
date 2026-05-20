package IteratorsExceptionUnitTestingFileManipulation;

import java.io.*;

public class NoteManager {
    private static final String FILE_NAME = "notes.txt";

    private boolean isValidNote(String note) {
        if (note == null) return false;
        String trimmed = note.trim();
        return trimmed.length() >= 3 && trimmed.length() <= 100;
    }

    public void saveNote(String note) {
        if (!isValidNote(note)) return;
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(note);
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Error saving note: " + e.getMessage());
        }
    }

    public void saveAllNotes(String[] notes) {
        if (notes == null) {
            System.out.println("Cannot save: notes array is null.");
            return;
        }

        // Overwrite mode: 'false' or no append flag
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, false))) {
            for (String note : notes) {
                if (isValidNote(note)) {
                    writer.write(note);
                    writer.newLine();
                }
                // Invalid notes are simply skipped (no return)
            }
        } catch (IOException e) {
            System.err.println("Error saving notes: " + e.getMessage());
        }
    }

    public void printAllNotes() {
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            int lineNumber = 1;
            while ((line = reader.readLine()) != null) {
                System.out.println(lineNumber + ". " + line);
                lineNumber++;
            }
        } catch (FileNotFoundException e) {
            System.out.println("No notes file found.");
        } catch (IOException e) {
            System.err.println("Error reading notes: " + e.getMessage());
        }
    }

    public int countNotes() {
        int count = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            while (reader.readLine() != null) {
                count++;
            }
        } catch (FileNotFoundException e) {
            return 0;
        } catch (IOException e) {
            System.err.println("Error counting notes: " + e.getMessage());
        }
        return count;
    }

    public static void main(String[] args) {
        NoteManager manager = new NoteManager();

        System.out.println("--- Saving single notes ---");
        manager.saveNote("Hello World");      // valid
        manager.saveNote("");                 // invalid – skipped
        manager.saveNote("   ");              // invalid – skipped
        manager.saveNote("Hi");               // invalid – skipped

        System.out.println("\n--- Saving multiple notes (overwrite) ---");
        String[] notes = {
                "Study Java iterators",               // valid
                "",                                   // invalid – skipped
                null,                                 // invalid – skipped
                "Read file manipulation chapter",     // valid
                "  ",                                 // invalid – skipped
                "Prepare JUnit tests"                 // valid
        };
        manager.saveAllNotes(notes);

        System.out.println("\n--- All notes ---");
        manager.printAllNotes();

        System.out.println("\n--- Total notes count ---");
        System.out.println("Number of saved notes: " + manager.countNotes());
    }
}