package model;

import java.io.Serializable;

public class Reader implements Serializable {
    private static final long serialVersionUID = 1L;
    private String name;
    private int libraryCardNumber;

    public Reader() {}

    public Reader(String name, int libraryCardNumber) {
        this.name = name;
        this.libraryCardNumber = libraryCardNumber;
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getLibraryCardNumber() { return libraryCardNumber; }
    public void setLibraryCardNumber(int libraryCardNumber) { this.libraryCardNumber = libraryCardNumber; }

    @Override
    public String toString() {
        return "Читач: " + name + " [Квиток №" + libraryCardNumber + "]";
    }
}