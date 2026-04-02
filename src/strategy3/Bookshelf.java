package strategy3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.ArrayList;
import java.util.List;

public class Bookshelf implements Externalizable {
    private String category;
    private List<Book> books;

    public Bookshelf() { this.books = new ArrayList<>(); }

    public Bookshelf(String category) {
        this.category = category;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public List<Book> getBooks() { return books; }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(category);
        out.writeInt(books.size());
        for (Book b : books) {
            out.writeObject(b);
        }
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        category = in.readUTF();
        int size = in.readInt();
        books = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            books.add((Book) in.readObject());
        }
    }

    @Override
    public String toString() { return "Шафа '" + category + "', містить книг: " + books.size(); }
}