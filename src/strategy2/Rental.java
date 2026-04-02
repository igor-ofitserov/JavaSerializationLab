package strategy2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Rental implements Serializable {
    private static final long serialVersionUID = 2L;

    private String issueDate;
    private transient Reader reader;
    private transient Book book;

    public Rental() {}
    public Rental(Reader reader, Book book, String issueDate) {
        this.reader = reader;
        this.book = book;
        this.issueDate = issueDate;
    }

    // РУЧНЕ ЗБЕРЕЖЕННЯ
    private void writeObject(ObjectOutputStream oos) throws IOException {
        oos.defaultWriteObject();
        // Розбираємо об'єкти на прості типи
        oos.writeUTF(reader.getName());
        oos.writeInt(reader.getLibraryCardNumber());
        oos.writeUTF(book.getTitle());
        oos.writeUTF(book.getAuthor().getFullName());
    }

    // РУЧНЕ ВІДНОВЛЕННЯ
    private void readObject(ObjectInputStream ois) throws IOException, ClassNotFoundException {
        ois.defaultReadObject();
        // Збираємо об'єкти назад
        String rName = ois.readUTF();
        int rCard = ois.readInt();
        this.reader = new Reader(rName, rCard);

        String bTitle = ois.readUTF();
        String aName = ois.readUTF();
        this.book = new Book(bTitle, new Author(aName));
    }

    @Override
    public String toString() {
        return "Прокат: " + book.getTitle() + " видана читачу " + reader.getName() + " (" + issueDate + ")";
    }
}