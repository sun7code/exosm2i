package org.example;

import java.util.ArrayList;
import java.util.List;

class SharedResource {
    private final List<Integer> listePartagee = new ArrayList<>();

    public void ajouter(int element) {
        synchronized (listePartagee) {
            listePartagee.add(element);
            System.out.println(Thread.currentThread().getName() + " a ajouté " + element);
        }
    }

    public void supprimer() {
        synchronized (listePartagee) {
            if (!listePartagee.isEmpty()) {
                int element = listePartagee.remove(0);
                System.out.println(Thread.currentThread().getName() + " a supprimé " + element);
            } else {
                System.out.println(Thread.currentThread().getName() + " n'a rien à supprimer.");
            }
        }
    }

    public List<Integer> getListePartagee() {
        synchronized (listePartagee) {
            return new ArrayList<>(listePartagee);
        }
    }
}