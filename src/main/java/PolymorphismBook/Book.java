package PolymorphismBook;

public class Book {
    private String title;
    private String author;
    private int year;

    public Book(String title, String author, int year){
        this.title = title;
        this.author = author;
        this.year = year;
    }

    @Override
    public String toString() { return this.title + " by " + this.author + "(" + this.year + ")"; }

    @Override
    public boolean equals(Object object){
        if (object == null) return false;
        Book book = (Book) object;
        return year == book.year && title.equals(book.title) && author.equals(book.author);
    }
}
