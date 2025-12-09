package co.edu.sena.semanas.Semana8.modelo;

public class paqueteS8 {
    private String codigo;      // P001
    private String nombre;
    private String tipo;        // "Paquete", "Tour", "Hotel", "Vuelo"
    private double precioBase;

    public paqueteS8(String codigo, String nombre, String tipo, double precioBase) {
        if (codigo == null || !codigo.matches("P\\d{3}")) throw new IllegalArgumentException("Código paquete inválido (P###)");
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        if (tipo == null || tipo.trim().isEmpty()) throw new IllegalArgumentException("Tipo inválido");
        if (precioBase < 0) throw new IllegalArgumentException("Precio base no puede ser negativo");

        this.codigo = codigo;
        this.nombre = nombre.trim();
        this.tipo = tipo.trim();
        this.precioBase = precioBase;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public String getTipo() { return tipo; }
    public double getPrecioBase() { return precioBase; }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " [" + tipo + "] $" + String.format("%.2f", precioBase);
    }
}
