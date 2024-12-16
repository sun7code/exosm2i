package org.example;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        try {
            for (int i = 1; i <= 5; i++) {
                Future<Integer> resultat = executor.submit(new CalculateurCallable(i));
                System.out.println("Le cube de " + i + " est : " + resultat.get());
            }
        } catch (InterruptedException | ExecutionException e) {
            System.err.println("Erreur lors de l'exécution : " + e.getMessage());
        } finally {
            executor.shutdown();
        }
    }
}
