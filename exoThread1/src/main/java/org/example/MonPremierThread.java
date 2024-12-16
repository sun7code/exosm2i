package org.example;

class MonPremierThread extends Thread {
    private String nomDuThread;

    public MonPremierThread(String nomDuThread) {
        this.nomDuThread = nomDuThread;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println(nomDuThread + " - Compteur : " + i);
            try {
                Thread.sleep(500); // Pause de 500ms
            } catch (InterruptedException e) {
                System.out.println(nomDuThread + " a été interrompu.");
            }
        }
    }
}