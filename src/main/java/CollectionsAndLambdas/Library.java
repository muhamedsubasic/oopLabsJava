package CollectionsAndLambdas;
import java.util.HashMap;
import java.util.Optional;

record Book(String title, String author, int year) {}

public class Library {
    private final HashMap<String, Book> books = new HashMap<>();

    private String clean(String input) {
        return input.trim().toLowerCase();
    }

    void addBook(Book book) {
        String key = clean(book.title());
        books.put(key, book);
    }

    void removeBook(String title) {
        String key = clean(title);
        books.remove(key);
    }

    Optional<Book> findByExactTitle(String title) {
        String key = clean(title);
        return Optional.ofNullable(books.get(key));
    }

    Optional<Book> findByTitleStart(String prefix) {
        String cleanedPrefix = clean(prefix);
        return books.entrySet().stream()
                .filter(entry -> entry.getKey().startsWith(cleanedPrefix))
                .map(HashMap.Entry::getValue)
                .findFirst();
    }
}

class Main {
    public static void main(String[] args) {
        Library library = new Library();
        library.addBook(new Book("The Hobbit", "J.R.R. Tolkien", 1937));
        library.addBook(new Book("Harry Potter and the Sorcerer's Stone  ", "J.K. Rowling", 1997));
        library.addBook(new Book("1984", "George Orwell", 1949));

        // Exact search
        System.out.println("Exact search '1984': " + library.findByExactTitle("1984"));
        System.out.println("Exact search 'The Hobbit': " + library.findByExactTitle("The Hobbit"));

        // Partial title search
        System.out.println("Partial search 'harry': " + library.findByTitleStart("harry"));

        // Remove a book
        library.removeBook("The Hobbit");
        System.out.println("After removal, exact search 'The Hobbit': " + library.findByExactTitle("The Hobbit"));
    }
}