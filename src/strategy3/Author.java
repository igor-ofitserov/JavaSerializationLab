package strategy3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Author implements Externalizable {
    private String fullName;

    // Обов'язковий конструктор для Externalizable!
    public Author() {}

    public Author(String fullName) { this.fullName = fullName; }
    public String getFullName() { return fullName; }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(fullName);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        fullName = in.readUTF();
    }

    @Override
    public String toString() { return "Автор: " + fullName; }
}