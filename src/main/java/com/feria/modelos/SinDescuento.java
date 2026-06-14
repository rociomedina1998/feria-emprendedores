public class SinDescuento implements EstrategiaDescuento {

    @Override
    public double calcularDescuento(double total, int cantidad) {
        return total;
    }
}