package co.edu.sena.semanas.Semana6.abstractas ;
import java.text.DecimalFormat;

public abstract class ProductoAgencia {
    public String nombre;
    protected double precioBase;

    public ProductoAgencia(String nombre, double precioBase) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        if (precioBase < 0) throw new IllegalArgumentException("Precio base inválido");
        this.nombre = nombre;
        this.precioBase = precioBase;
    }

    // Método concreto reutilizable
    public String obtenerInfo() {
        DecimalFormat df = new DecimalFormat("#,###.00");
        return nombre + " | Precio base: $" + df.format(precioBase);
    }

    // Método abstracto que cada subclase debe implementar
    public abstract double calcularPrecioFinal();

    // Para mostrar resumen
    public String obtenerResumen() {
        return obtenerInfo() + " | Precio final: $" + String.format("%.2f", calcularPrecioFinal());
    }
}
