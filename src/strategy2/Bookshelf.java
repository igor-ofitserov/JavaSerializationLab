package strategy2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Bookshelf implements Serializable {
    private static final long serialVersionUID = 2L;

    private String category; // Це збережеться автоматично
    private transient List<Book> books; // transient - ігнорується автоматом

    public Bookshelf() { this.books = new ArrayList<>(); }
    public Bookshelf(String category) {
        this.category = category;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) { books.add(book); }
    public String getCategory() { return category; }
    public List<Book> getBooks() { return books; }

    // РУЧНЕ ЗБЕРЕЖЕННЯ
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject(); // Зберігаємо звичайні поля (category)

        // Вручну зберігаємо дані про книги
        oos.writeInt(books.size());
        for (Book b : books) {
            oos.writeUTF(b.getTitle());
            oos.writeUTF(b.getAuthor().getFullName());
        }
    }

    // РУЧНЕ ВІДНОВЛЕННЯ
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject(); // Відновлюємо category

        // Вручну збираємо книги назад
        int size = ois.readInt();
        books = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            String title = ois.readUTF();
            String authorName = ois.readUTF();
            books.add(new Book(title, new Author(authorName)));
        }
    }

    @Override
    public String toString() { return "Шафа '" + category + "', містить книг: " + books.size(); }
}