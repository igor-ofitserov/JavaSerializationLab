package strategy3;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

public class Reader implements Externalizable {
    private String name;
    private int libraryCardNumber;

    public Reader() {}

    public Reader(String name, int libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getName() { return name; }
    public int getLibraryCardNumber() { return libraryCardNumber; }

    @Override
    public void writeExternal(ObjectOutput out) throws IOException {
        out.writeUTF(name);
        out.writeInt(libraryCardNumber);
    }

    @Override
    public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
        name = in.readUTF();
        libraryCardNumber = in.readInt();
    }

    @Override
    public String toString() { return "Читач: " + name + " [Квиток №" + libraryCardNumber + "]"; }
}