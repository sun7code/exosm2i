package org.example;

class Tache implements Runnable {
    private final int id;

    public Tache(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        System.out.println("Tâche " + id + " exécutée par " + Thread.currentThread().getName());
    }
}