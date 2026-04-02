package strategy2;

public class Reader {
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
    public String toString() { return "Читач: " + name + " [Квиток №" + libraryCardNumber + "]"; }
}