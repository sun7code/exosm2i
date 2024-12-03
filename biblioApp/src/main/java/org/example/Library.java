package org.example;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<LibraryItem> items;
    private List<BorrowRecord> borrowRecords;

    // Constructeur
    public Library() {
        this.items = new ArrayList<>();
        this.borrowRecords = new ArrayList<>();
    }

    public void addItem(LibraryItem item) {
        items.add(item);
    }

    public void listAvailableItems() {
        System.out.println("Liste des éléments disponibles :");
        for (LibraryItem item : items) {
            System.out.println(item.getDetails());
        }
    }

    public void borrowItem(int itemId, String borrowerName, String borrowDate) {
        for (LibraryItem item : items) {
            if (item.id == itemId) {
                BorrowRecord record = new BorrowRecord(itemId, borrowerName, borrowDate);
                borrowRecords.add(record);
                items.remove(item); // Retirer l'élément de la bibliothèque
                System.out.println("Emprunt d'un élément...");
                System.out.println(record);
                return;
            }
        }
        System.out.println("Élément non trouvé.");
    }

    public void listBorrowedItems() {
        System.out.println("Liste des éléments empruntés :");
        for (BorrowRecord record : borrowRecords) {
            for (LibraryItem item : items) {
                if (item.id == record.itemId) {
                    System.out.println(item.getDetails());
                    break;
                }
            }
        }
    }
}
