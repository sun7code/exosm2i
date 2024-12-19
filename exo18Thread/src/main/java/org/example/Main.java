package org.example;

import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> listePartagee = new CopyOnWriteArrayList<>();

        Runnable ajouterProduits = () -> {
            String threadName = Thread.currentThread().getName();
            for (int i = 0; i < 10; i++) {
                String produit = threadName + "-Produit-" + i;
                listePartagee.add(produit);
                System.out.println(produit + " ajouté à la liste.");
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(threadName + " a été interrompu.");
                }
            }
        };

        Thread thread1 = new Thread(ajouterProduits, "Thread-1");
        Thread thread2 = new Thread(ajouterProduits, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("L'exécution principale a été interrompue.");
        }

        System.out.println("Liste finale des produits : " + listePartagee);
    }
}
