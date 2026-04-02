package model;

import java.io.Serializable;

public class Author implements Serializable {
    private static final long serialVersionUID = 1L;
    private String fullName;

    public Author() {}

    public Author(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() { return fullName; }
    public void setFullName(String fullName) { this.fullName = fullName; }

    @Override
    public String toString() {
        return "Автор: " + fullName;
    }
}