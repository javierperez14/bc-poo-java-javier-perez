package co.edu.sena.semanas.proyecto_final.modelo;


public abstract class Destino implements Cotizable {
    private String codigo; // D001
    private String nombre;
    private double precioBase;

    public Destino(String codigo, String nombre, double precioBase) {
        if (codigo == null || !codigo.matches("D\\d{3}")) throw new IllegalArgumentException("Código destino inválido");
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre destino inválido");
        if (precioBase < 0) throw new IllegalArgumentException("Precio base inválido");
        this.codigo = codigo;
        this.nombre = nombre.trim();
        this.precioBase = precioBase;
    }

    public String getCodigo() { return codigo; }
    public String getNombre() { return nombre; }
    public double getPrecioBase() { return precioBase; }

    @Override
    public String toString() {
        return codigo + " - " + nombre + " ($" + String.format("%.2f", precioBase) + ")";
    }
}

