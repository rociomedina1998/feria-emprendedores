package com.feria.modelos;

public class Venta {

    private String id;
    private String emprendedorId;
    private String productoNombre;
    private int cantidad;
    private double precioUnitario;
    private String fecha;
    private boolean pagoRealizado;

    private EstrategiaDescuento estrategiaDescuento;

    public Venta(String id, String emprendedorId, String productoNombre,
                 int cantidad, double precioUnitario, String fecha) {

        this.id = id;
        this.emprendedorId = emprendedorId;
        this.productoNombre = productoNombre;
        this.cantidad = cantidad;
        this.precioUnitario = precioUnitario;
        this.fecha = fecha;
        this.pagoRealizado = false;

        this.estrategiaDescuento = new DescuentoEstandar();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmprendedorId() {
        return emprendedorId;
    }

    public void setEmprendedorId(String emprendedorId) {
        this.emprendedorId = emprendedorId;
    }

    public String getProductoNombre() {
        return productoNombre;
    }

    public void setProductoNombre(String productoNombre) {
        this.productoNombre = productoNombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public boolean isPagoRealizado() {
        return pagoRealizado;
    }

    public void setPagoRealizado(boolean pagoRealizado) {
        this.pagoRealizado = pagoRealizado;
    }

    public void setEstrategiaDescuento(EstrategiaDescuento estrategiaDescuento) {
        this.estrategiaDescuento = estrategiaDescuento;
    }

    public double calcularTotalConDescuento() {
        double total = cantidad * precioUnitario;
        return estrategiaDescuento.calcularDescuento(total, cantidad);
    }

    public void registrarPago(Producto p) {
        this.pagoRealizado = true;
        System.out.println("Pago registrado");
    }

    public void actualizarStock(Producto p) {
        if (p != null) {
            p.setStock(p.getStock() - this.cantidad);
            System.out.println("Stock actualizado: " + p.getStock());
        }
    }

    public String generarRecibo() {
        String recibo = "=== RECIBO DE VENTA ===\n";
        recibo += "Venta ID: " + id + "\n";
        recibo += "Fecha: " + fecha + "\n";
        recibo += "Producto: " + productoNombre + "\n";
        recibo += "Cantidad: " + cantidad + "\n";
        recibo += "Precio unitario: $" + precioUnitario + "\n";
        recibo += "Total con descuentos: $" + calcularTotalConDescuento() + "\n";
        recibo += "Pago: " + (pagoRealizado ? "Realizado" : "Pendiente") + "\n";
        return recibo;
    }
}