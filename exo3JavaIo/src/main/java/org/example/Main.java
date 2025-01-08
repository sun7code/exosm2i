package org.example;

import java.io.*;

public class Main {
    private static final String FILE_PATH = "book.ser";

    public static void main(String[] args) {
        Book book = new Book("Harry Potter", "J. K. Rowling");

        serializeBook(book);

        Book deserializedBook = deserializeBook();

        if (deserializedBook != null) {
            System.out.println("Objet désérialisé : " + deserializedBook);
        }
    }

    private static void serializeBook(Book book) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            out.writeObject(book);
            System.out.println("Objet sérialisé avec succès dans : " + FILE_PATH);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sérialisation : " + e.getMessage());
        }
    }

    private static Book deserializeBook() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
            return (Book) in.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Erreur lors de la désérialisation : " + e.getMessage());
        }
        return null;
    }
}
