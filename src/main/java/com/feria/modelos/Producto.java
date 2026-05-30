package com.feria.modelos;


public class Producto {


    private String nombre;
    private double precio;
    private int stock;
    

    public Producto(String nombre, double precio, int stock) {
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        
    }

    public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public double getPrecio() {
    return precio;
}

public void setPrecio(double precio) {
    this.precio = precio;
}

public int getStock() {
    return stock;
}

public void setStock(int stock) {
    this.stock = stock;
}

    public double valorTotal() {
        return precio * stock;
    }


    public String mostrar() {
        return nombre + " - $" + precio + " (stock: " + stock + ")";
    }


    public boolean hayStockBajo() {
        if (stock < 5) {
            return true;
        }
        return false;
    }


  