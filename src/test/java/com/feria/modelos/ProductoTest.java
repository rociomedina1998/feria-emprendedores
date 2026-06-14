package com.feria.modelos;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ProductoTest {

    @Test
    void deberiaCalcularValorTotalCorrectamente() {

        Emprendedor emp =
                new Emprendedor("Ana","1","12345678",
                        "ana@mail.com","comida");

        Producto producto =
                new Producto("Empanadas",500,10,emp);

        assertEquals(5000, producto.valorTotal());
    }

    @Test
    void deberiaDetectarStockBajo() {

        Emprendedor emp =
                new Emprendedor("Ana","1","12345678",
                        "ana@mail.com","comida");

        Producto producto =
                new Producto("Empanadas",500,4,emp);

        assertTrue(producto.hayStockBajo());
    }

    @Test
    void deberiaValidarStockDisponible() {

        Emprendedor emp =
                new Emprendedor("Ana","1","12345678",
                        "ana@mail.com","comida");

        Producto producto =
                new Producto("Empanadas",500,20,emp);

        assertTrue(producto.tieneStockSuficiente(15));
    }
}
