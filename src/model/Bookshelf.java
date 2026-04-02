package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bookshelf implements Serializable {
    private static final long serialVersionUID = 1L;
    private String category;
    private List<Book> books;

    public Bookshelf() {
        this.books = new ArrayList<>();
    }

    public Bookshelf(String category) {
        this.category = category;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }
    public List<Book> getBooks() { return books; }
    public void setBooks(List<Book> books) { this.books = books; }

    @Override
    public String toString() {
        return "Шафа '" + category + "', містить книг: " + books.size();
    }
}