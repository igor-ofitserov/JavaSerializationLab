package model;

import java.io.Serializable;

public class Rental implements Serializable {
    private static final long serialVersionUID = 1L;
    private Reader reader;
    private Book book;
    private String issueDate;

    public Rental() {}

    public Rental(Reader reader, Book book, String issueDate) {
        this.reader = reader;
        this.book = book;
        this.issueDate = issueDate;
    }

    public Reader getReader() { return reader; }
    public void setReader(Reader reader) { this.reader = reader; }
    public Book getBook() { return book; }
    public void setBook(Book book) { this.book = book; }
    public String getIssueDate() { return issueDate; }
    public void setIssueDate(String issueDate) { this.issueDate = issueDate; }

    @Override
    public String toString() {
        return "Прокат: " + book.getTitle() + " видана читачу " + reader.getName() + " (" + issueDate + ")";
    }
}