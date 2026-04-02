package strategy2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainStrategy2 {
    public static void main(String[] args) {
        System.out.println("--- СТРАТЕГІЯ 2: Часткова серіалізація (transient) ---\n");

        Author author = new Author("Ліна Костенко");
        Book book = new Book("Маруся Чурай", author);

        Bookshelf shelf = new Bookshelf("Класика");
        shelf.addBook(book);

        Reader reader = new Reader("Ігор", 999);
        Rental rental = new Rental(reader, book, "2026-04-02");

        List<Object> librarySystem = new ArrayList<>();
        librarySystem.add(shelf);
        librarySystem.add(rental);

        System.out.println("[СТАН ДО СЕРІАЛІЗАЦІЇ]:");
        for (Object obj : librarySystem) {
            System.out.println(obj);
            // Перевіряємо, чи є доступ до внутрішніх даних (чи живі книги)
            if (obj instanceof Bookshelf) {
                System.out.println("   Деталі шафи: " + ((Bookshelf) obj).getBooks());
            }
        }

        String filename = "library_strategy2.ser";

        // Серіалізація
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(librarySystem);
            System.out.println("\nУспішно збережено у файл: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        // Десеріалізація
        System.out.println("\n[СТАН ПІСЛЯ ДЕСЕРІАЛІЗАЦІЇ]:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<Object> restoredSystem = (List<Object>) ois.readObject();
            for (Object obj : restoredSystem) {
                System.out.println(obj);
                // Перевіряємо, чи правильно відновилися книги (ті самі, що були transient)
                if (obj instanceof Bookshelf) {
                    System.out.println("   Деталі шафи: " + ((Bookshelf) obj).getBooks());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка: " + e.getMessage());
        }
    }
}