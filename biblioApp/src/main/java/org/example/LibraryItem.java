package org.example;

public abstract class LibraryItem {
    protected int id;
    protected String title;
    protected int publicationYear;

    // Constructeur
    public LibraryItem(int id, String title, int publicationYear) {
        this.id = id;
        this.title = title;
        this.publicationYear = publicationYear;
    }

    public abstract String getDetails();
}
