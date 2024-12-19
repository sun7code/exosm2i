package org.example;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        InventoryManager inventoryManager = new InventoryManager();

        // Stock initial
        inventoryManager.addStock("ProduitA", 50);
        inventoryManager.addStock("ProduitB", 30);
        inventoryManager.addStock("ProduitC", 20);

        Runnable purchaserTask = () -> {
            for (int i = 0; i < 10; i++) {
                String product = "Produit" + (char) ('A' + new Random().nextInt(3));
                inventoryManager.purchase(product, 1);
                try {
                    Thread.sleep(new Random().nextInt(200));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " a été interrompu.");
                }
            }
        };

        Runnable restockerTask = () -> {
            for (int i = 0; i < 5; i++) {
                String product = "Produit" + (char) ('A' + new Random().nextInt(3));
                inventoryManager.addStock(product, 10);
                try {
                    Thread.sleep(new Random().nextInt(300));
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + " a été interrompu.");
                }
            }
        };

        Thread purchaser1 = new Thread(purchaserTask, "Acheteur-1");
        Thread purchaser2 = new Thread(purchaserTask, "Acheteur-2");
        Thread restocker = new Thread(restockerTask, "Réapprovisionneur");

        purchaser1.start();
        purchaser2.start();
        restocker.start();

        try {
            purchaser1.join();
            purchaser2.join();
            restocker.join();
        } catch (InterruptedException e) {
            System.out.println("L'exécution principale a été interrompue.");
        }

        System.out.println("Inventaire final : " + inventoryManager.getInventory());
    }
}
