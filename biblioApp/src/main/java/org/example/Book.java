package org.example;

public class Book extends LibraryItem {
    private String author;
    private String genre;

    // Constructeur
    public Book(int id, String title, int publicationYear, String author, String genre) {
        super(id, title, publicationYear);
        this.author = author;
        this.genre = genre;
    }

    @Override
    public String getDetails() {
        return "Livre : [Titre : " + title + ", Auteur : " + author + ", Genre : " + genre + ", Année : " + publicationYear + "]";
    }
}
