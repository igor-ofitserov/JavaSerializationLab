package strategy1;

// Явно імпортуємо НАШІ класи, щоб не було конфліктів
import model.Author;
import model.Book;
import model.Bookshelf;
import model.Reader;
import model.Rental;

// Явно імпортуємо класи для файлів та колекцій
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class MainStrategy1 {
    public static void main(String[] args) {
        System.out.println("--- СТРАТЕГІЯ 1: Усі класи Serializable ---\n");

        // 1. Створення бібліотеки та даних
        Author author1 = new Author("Сергій Жадан");
        Book book1 = new Book("Інтернат", author1);

        Bookshelf shelf = new Bookshelf("Сучасна українська література");
        shelf.addBook(book1);

        // Тепер компілятор точно знає, що це наш model.Reader
        Reader reader1 = new Reader("Олексій", 101);
        Rental rental1 = new Rental(reader1, book1, "2026-04-02");

        // Збираємо все в один список для зручної серіалізації системи
        List<Object> librarySystem = new ArrayList<>();
        librarySystem.add(shelf);
        librarySystem.add(rental1);

        System.out.println("[СТАН ДО СЕРІАЛІЗАЦІЇ]:");
        for (Object obj : librarySystem) {
            System.out.println(obj);
        }

        String filename = "library_strategy1.ser";

        // 2. Серіалізація
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(librarySystem);
            System.out.println("\nУспішно збережено у файл: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка серіалізації: " + e.getMessage());
        }

        // 3. Десеріалізація
        System.out.println("\n[СТАН ПІСЛЯ ДЕСЕРІАЛІЗАЦІЇ]:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<Object> restoredSystem = (List<Object>) ois.readObject();
            for (Object obj : restoredSystem) {
                System.out.println(obj);
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка десеріалізації: " + e.getMessage());
        }
    }
}