package strategy2;

public class Author {
    private String fullName;

    public Author() {}
    public Author(String fullName) { this.fullName = fullName; }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    @Override
    public String toString() { return "Автор: " + fullName; }
}