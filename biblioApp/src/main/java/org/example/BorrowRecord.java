package org.example;

public class BorrowRecord {
    int itemId;
    private String borrowerName;
    private String borrowDate;

    // Constructeur
    public BorrowRecord(int itemId, String borrowerName, String borrowDate) {
        this.itemId = itemId;
        this.borrowerName = borrowerName;
        this.borrowDate = borrowDate;
    }

    @Override
    public String toString() {
        return "BorrowRecord[itemId=" + itemId + ", borrowerName=" + borrowerName + ", borrowDate=" + borrowDate + "]";
    }
}
