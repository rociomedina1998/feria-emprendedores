package com.feria.servicios;

import com.feria.modelos.*;
import com.feria.utils.IValidadorEmprendedor;
import com.feria.utils.Validadores;
import java.util.ArrayList;
import java.util.List;

public class GestorFeria {

    private final IValidadorEmprendedor validador;
    private List<Emprendedor> emprendedores;
    private List<Producto> productos;
    private List<Venta> ventas;

    public GestorFeria(IValidadorEmprendedor validador) {
        this.validador = validador;
        emprendedores = new ArrayList<>();
        productos = new ArrayList<>();
        ventas = new ArrayList<>();
    }

    public GestorFeria() {
        this(new Validadores());
    }

    public List<Emprendedor> getEmprendedores() {
    return emprendedores;
}

public void setEmprendedores(List<Emprendedor> emprendedores) {
    this.emprendedores = emprendedores;
}

public List<Producto> getProductos() {
    return productos;
}

public void setProductos(List<Producto> productos) {
    this.productos = productos;
}

public List<Venta> getVentas() {
    return ventas;
}

public void setVentas(List<Venta> ventas) {
    this.ventas = ventas;
}

    public void registrarEmprendedorConProductos(String nombre, String id, String telefono,
                                                   String email, String categoria, 
                                                   List<String> nombresProductos, 
                                                   List<Double> precios, 
                                                   List<Integer> stocks) {

        Emprendedor e = new Emprendedor(nombre, id, telefono, email, categoria);

        if (!validador.validarNombre(nombre)) {
            System.out.println("Error: nombre inválido");
            return;
        }
        if (!validador.validarEmail(email)) {
            System.out.println("Error: email inválido");
            return;
        }

        for (int i = 0; i < nombresProductos.size(); i++) {
            Producto p = new Producto(nombresProductos.get(i), precios.get(i), stocks.get(i), e);
            e.agregarProducto(p);
            productos.add(p);
        }

        emprendedores.add(e);
        System.out.println("Emprendedor registrado con " + nombresProductos.size() + " productos");
    }

    public void registrarVenta(String idVenta, String empId, String prodNombre, int cantidad, double precio, String fecha) {

        Producto productoEncontrado = null;
        for (Producto p : productos) {
            if (p.getNombre().equals(prodNombre) && p.getEmprendedor().getId().equals(empId)) {
                productoEncontrado = p;
                break;
            }
        }

        if (productoEncontrado == null) {
            System.out.println("Producto no encontrado");
            return;
        }

        if (productoEncontrado.getStock() < cantidad) {
            System.out.println("Stock insuficiente");
            return;
        }

        Venta v = new Venta(idVenta, empId, prodNombre, cantidad, precio, fecha);
        ventas.add(v);

        productoEncontrado.setStock(productoEncontrado.getStock() - cantidad);

        System.out.println("Venta registrada. Nuevo stock: " + productoEncontrado.getStock());
    }

    public List<Emprendedor> getEmprendedoresConStockBajo() {
        List<Emprendedor> resultado = new ArrayList<>();
        for (Emprendedor e : emprendedores) {
            for (Producto p : e.getProductos()) {
                if (p.hayStockBajo()) {
                    resultado.add(e);
                    break;
                }
            }
        }
        return resultado;
    }

    public void procesarVentasPendientesYCobrar() {
        double totalRecaudado = 0;
        for (Venta v : ventas) {
            if (!v.isPagoRealizado()) {
                double monto = v.calcularTotalConDescuento();
                totalRecaudado += monto;
                v.setPagoRealizado(true);
                System.out.println("Cobrada venta " + v.getIdVenta() + " por $" + monto);
            }
        }
        System.out.println("Total recaudado: $" + totalRecaudado);
    }
}