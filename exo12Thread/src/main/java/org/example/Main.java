package org.example;

public class Main {
    public static void main(String[] args) {
        SharedResource resource = new SharedResource();

        Runnable ajouterTache = () -> {
            for (int i = 0; i < 5; i++) {
                resource.ajouter(i);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " a été interrompu.");
                }
            }
        };

        Runnable supprimerTache = () -> {
            for (int i = 0; i < 5; i++) {
                resource.supprimer();
                try {
                    Thread.sleep(150);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " a été interrompu.");
                }
            }
        };

        Thread thread1 = new Thread(ajouterTache, "Thread-1");
        Thread thread2 = new Thread(supprimerTache, "Thread-2");

        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        } catch (InterruptedException e) {
            System.out.println("L'exécution principale a été interrompue.");
        }

        System.out.println("État final de la liste : " + resource.getListePartagee());
    }
}