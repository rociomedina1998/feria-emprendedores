package com.feria.utils;

import com.feria.modelos.Emprendedor;

public class Validadores implements IValidadorEmprendedor {

    @Override
    public boolean validarNombre(String nombre) {
        return nombreValido(nombre);
    }

    @Override
    public boolean validarEmail(String email) {
        return emailValido(email);
    }

    @Override
    public boolean validarTelefono(String telefono) {
        return telefonoValido(telefono);
    }

    @Override
    public boolean validarCategoria(String categoria) {
        return categoriaPermitida(categoria);
    }

    public static boolean nombreValido(String nombre) {
        return nombre != null && nombre.length() >= 2;
    }

    public static boolean emailValido(String email) {
        if (email == null) return false;
        if (!email.contains("@")) return false;
        return email.length() >= 5;
    }

    public static boolean telefonoValido(String t) {
        if (t == null) return false;
        return t.length() >= 8;
    }

    public static boolean validarPrecioStock(double precio, int stock) {
        if (precio <= 0) return false;
        return stock >= 0;
    }

    public static boolean categoriaPermitida(String categoria) {
        String[] permitidas = {"comida", "artesanía", "tecnología", "ropa"};
        for (String c : permitidas) {
            if (c.equals(categoria)) return true;
        }
        return false;
    }

    public static boolean validarEmprendedorCompleto(Emprendedor e) {
        if (e == null) return false;
        if (!nombreValido(e.getNombre())) return false;
        if (!emailValido(e.getEmail())) return false;
        if (!telefonoValido(e.getTelefono())) return false;
        return categoriaPermitida(e.getCategoria());
    }
}
