package com.feria.modelos;

public class DescuentoEstandar implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(double total, int cantidad) {

        if (cantidad > 10) {
            total *= 0.90;
        }

        if (total > 5000) {
            total *= 0.95;
        }

        return total;
    }
}