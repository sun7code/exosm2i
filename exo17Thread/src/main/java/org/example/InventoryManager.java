package org.example;

import java.util.concurrent.*;
import java.util.*;

class InventoryManager {
    private final ConcurrentHashMap<String, Integer> inventory = new ConcurrentHashMap<>();

    public void addStock(String product, int quantity) {
        inventory.merge(product, quantity, Integer::sum);
        System.out.println(Thread.currentThread().getName() + " a réapprovisionné " + quantity + " unités de " + product);
    }

    public void purchase(String product, int quantity) {
        inventory.compute(product, (key, stock) -> {
            if (stock == null || stock < quantity) {
                System.out.println(Thread.currentThread().getName() + " n'a pas pu acheter " + quantity + " unités de " + product);
                return stock;
            }
            System.out.println(Thread.currentThread().getName() + " a acheté " + quantity + " unité(s) de " + product);
            return stock - quantity;
        });
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }
}