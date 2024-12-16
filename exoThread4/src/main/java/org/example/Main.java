package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        try {
            for (int i = 1; i <= 10; i++) {
                executor.submit(new Tache(i));
            }
        } finally {
            executor.shutdown();
        }

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                System.out.println("Le pool de threads n'a pas terminé dans le délai imparti.");
            }
        } catch (InterruptedException e) {
            System.err.println("L'attente de terminaison a été interrompue.");
        }
    }
}