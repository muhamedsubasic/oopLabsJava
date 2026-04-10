package PolymorphismBook;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Book Demo ===");
        ArrayList<Book> books = new ArrayList<>();
        Book book1 = new Book("1984", "George Orwell", 1949);
        Book book2 = new Book("To Kill a Mockingbird", "Harper Lee", 1960);
        Book book3 = new Book("1984", "George Orwell", 1949); // identical content
        Book book4 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);

        books.add(book1);
        books.add(book2);
        books.add(book3);
        books.add(book4);

        System.out.println("All books:");
        for (Book b : books) {
            System.out.println(b);
        }

        System.out.println("\nEquality checks:");
        System.out.println("book1 equals book3 (same content): " + book1.equals(book3)); // true
        System.out.println("book1 equals book2 (different): " + book1.equals(book2));   // false
        System.out.println("book1 == book3 (different references): " + (book1 == book3)); // false
        System.out.println();
    }
}
