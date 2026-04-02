package strategy3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Rental implements Externalizable {
    private Reader reader;
    private Book book;
    private String issueDate;

    public Rental() {}

    public Rental(Reader reader, Book book, String issueDate) {
        this.reader = reader;
        this.book = book;
        this.issueDate = issueDate;
    }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeObject(reader);
        out.writeObject(book);
        out.writeUTF(issueDate);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        reader = (Reader) in.readObject();
        book = (Book) in.readObject();
        issueDate = in.readUTF();
    }

    @Override
    public String toString() {
        return "Прокат: " + book.getTitle() + " видана читачу " + reader.getName() + " (" + issueDate + ")";
    }
}