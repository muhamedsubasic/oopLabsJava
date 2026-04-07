package InheritanceLibrary;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<LibraryItem> items = new ArrayList<>();

        items.add(new Book("B001", "The Great Gatsby", 1925, "F. Scott Fitzgerald", "Classic"));
        items.add(new DVD("D001", "Inception", 2010, "Christopher Nolan", 148));
        items.add(new Magazine("M001", "National Geographic", 2023, 247, "July"));
        items.add(new Book("B002", "1984", 1949, "George Orwell", "Dystopian"));
        items.add(new DVD("D002", "The Matrix", 1999, "Lana Wachowski", 136));

        System.out.println("=== Library Catalog ===");
        for (LibraryItem item : items) {
            System.out.println(item.getSummary());
            System.out.println("--------------------------");
        }
    }
}