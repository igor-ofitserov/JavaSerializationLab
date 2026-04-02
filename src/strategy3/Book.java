package strategy3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Book implements Externalizable {
    private String title;
    private Author author;

    public Book() {}

    public Book(String title, Author author) {
        this.title = title;
        this.author = author;
    }

    public String getTitle() { return title; }
    public Author getAuthor() { return author; }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(title);
        out.writeObject(author); // Записуємо цілий об'єкт, бо він теж Externalizable
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        title = in.readUTF();
        author = (Author) in.readObject();
    }

    @Override
    public String toString() { return "Книга: '" + title + "' (" + author.getFullName() + ")"; }
}