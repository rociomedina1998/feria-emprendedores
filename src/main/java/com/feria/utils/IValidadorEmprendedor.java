package com.feria.utils;

public interface IValidadorEmprendedor {
    boolean validarNombre(String nombre);
    boolean validarEmail(String email);
    boolean validarTelefono(String telefono);
    boolean validarCategoria(String categoria);
}
