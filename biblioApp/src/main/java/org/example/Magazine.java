package org.example;

public class Magazine extends LibraryItem {
    private int issueNumber;

    // Constructeur
    public Magazine(int id, String title, int publicationYear, int issueNumber) {
        super(id, title, publicationYear);
        this.issueNumber = issueNumber;
    }

    @Override
    public String getDetails() {
        return "Magazine : [Titre : " + title + ", Numéro : " + issueNumber + ", Année : " + publicationYear + "]";
    }
}
