package org.example;
import java.util.ArrayList;
import java.util.List;

public class Annuaire {
    private List<Personne> contacts;

    public Annuaire() {
        this.contacts = new ArrayList<>();
    }

    public void ajouterContact(Personne personne) {
        contacts.add(personne);
    }

    public void listerContacts() {
        if (contacts.isEmpty()) {
            System.out.println("Aucun contact dans l'annuaire.");
        } else {
            for (Personne contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public Personne rechercherContactParNom(String nom) {
        for (Personne contact : contacts) {
            if (contact.getNom().equalsIgnoreCase(nom)) {
                return contact;
            }
        }
        return null;
    }
}
