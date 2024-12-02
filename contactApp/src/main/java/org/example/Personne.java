package org.example;

public class Personne {
    private String nom;
    private String numero;

    // Constructeur
    public Personne(String nom, String numero) {
        this.nom = nom;
        this.numero = numero;
    }

    // Getters et Setters
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Nom : " + nom + ", Numéro : " + numero;
    }
}
