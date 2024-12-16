package org.example;

import java.util.concurrent.*;

class CalculateurCallable implements Callable<Integer> {
    private final int nombre;

    public CalculateurCallable(int nombre) {
        this.nombre = nombre;
    }

    @Override
    public Integer call() {
        return nombre * nombre * nombre; // Formule calcul cube
    }
}