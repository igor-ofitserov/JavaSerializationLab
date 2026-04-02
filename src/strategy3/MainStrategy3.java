package strategy3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class MainStrategy3 {
    public static void main(String[] args) {
        System.out.println("--- СТРАТЕГІЯ 3: Повний контроль через Externalizable ---\n");

        Author author = new Author("Валер'ян Підмогильний");
        Book book = new Book("Місто", author);

        Bookshelf shelf = new Bookshelf("Український модернізм");
        shelf.addBook(book);

        Reader reader = new Reader("Олена", 777);
        Rental rental = new Rental(reader, book, "2026-04-02");

        List<Object> librarySystem = new ArrayList<>();
        librarySystem.add(shelf);
        librarySystem.add(rental);

        System.out.println("[СТАН ДО СЕРІАЛІЗАЦІЇ]:");
        for (Object obj : librarySystem) {
            System.out.println(obj);
            if (obj instanceof Bookshelf) {
                System.out.println("   Деталі шафи: " + ((Bookshelf) obj).getBooks());
            }
        }

        String filename = "library_strategy3.ser";

        // Серіалізація
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(librarySystem);
            System.out.println("\nУспішно збережено у файл: " + filename);
        } catch (IOException e) {
            System.err.println("Помилка серіалізації: " + e.getMessage());
        }

        // Десеріалізація
        System.out.println("\n[СТАН ПІСЛЯ ДЕСЕРІАЛІЗАЦІЇ]:");
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            @SuppressWarnings("unchecked")
            List<Object> restoredSystem = (List<Object>) ois.readObject();
            for (Object obj : restoredSystem) {
                System.out.println(obj);
                if (obj instanceof Bookshelf) {
                    System.out.println("   Деталі шафи: " + ((Bookshelf) obj).getBooks());
                }
            }
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Помилка десеріалізації: " + e.getMessage());
        }
    }
}