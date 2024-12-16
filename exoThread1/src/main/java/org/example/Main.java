package org.example;

public class Main {
    public static void main(String[] args) {
        MonPremierThread thread1 = new MonPremierThread("Thread-1");
        MonPremierThread thread2 = new MonPremierThread("Thread-2");
        MonPremierThread thread3 = new MonPremierThread("Thread-3");

        thread1.start();
        thread2.start();
        thread3.start();
    }
}