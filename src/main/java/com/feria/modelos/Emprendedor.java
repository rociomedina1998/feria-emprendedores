package com.feria.modelos;

import java.util.ArrayList;
import java.util.List;


public class Emprendedor {

    private String nombre;      
    private String id;
    private String telefono;    
    private String email;
    private String categoria;   

    private List<Producto> productos;


    public Emprendedor(String nombre, String id, String telefono, String email, String categoria) {
        this.nombre = nombre;
        this.id = id;
        this.telefono = telefono;
        this.email = email;
        this.categoria = categoria;
        this.productos = new ArrayList<>();
    }

    public String getNombre() {
    return nombre;
}

public void setNombre(String nombre) {
    this.nombre = nombre;
}

public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getTelefono() {
    return telefono;
}

public void setTelefono(String telefono) {
    this.telefono = telefono;
}

public String getEmail() {
    return email;
}

public void setEmail(String email) {
    this.email = email;
}

public String getCategoria() {
    return categoria;
}

public void setCategoria(String categoria) {
    this.categoria = categoria;
}

public List<Producto> getProductos() {
    return productos;
}

public void setProductos(List<Producto> productos) {
    this.productos = productos;
}

   public String mostrarInfo() {
    String info = "Emprendedor: " + nombre + "\n";
    info += "ID: " + id + "\n";
    info += "Contacto: " + telefono + " | " + email + "\n";
    info += "Categoría: " + categoria + "\n";

    if (!validarCompleto()) {
        info += "⚠️ Datos inválidos\n";
    }

    info += "Productos:\n";
    for (Producto p : productos) {
        info += "  - " + p.nombre + " ($" + p.precio + ")\n";
    }

    return info;
}


    public boolean validarCompleto() {
        boolean valido = true;
        if (nombre == null || nombre.length() < 2) valido = false;
        if (email == null || !email.contains("@")) valido = false;
        if (categoria == null || (!categoria.equals("comida") && !categoria.equals("artesania") && 
                           !categoria.equals("tecnologia") && !categoria.equals("ropa"))) valido = false;
        return valido;
    }


    public String getNombre() {
        return nombre;
    }

    public void agregarProducto(Producto p) {
        productos.add(p);
    }


    public int calcularValorTotalStock() {
        int total = 0;
        for (Producto p : productos) {
            total += p.precio * p.stock;
        }
        return total;
    }
}