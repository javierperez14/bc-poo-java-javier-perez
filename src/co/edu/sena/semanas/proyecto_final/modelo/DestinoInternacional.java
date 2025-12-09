package co.edu.sena.semanas.proyecto_final.modelo;

public class DestinoInternacional extends Destino {
    private double impuesto; // porcentaje en decimal (ej. 0.15)

    public DestinoInternacional(String codigo, String nombre, double precioBase, double impuesto) {
        super(codigo, nombre, precioBase);
        if (impuesto < 0) throw new IllegalArgumentException("Impuesto inválido");
        this.impuesto = impuesto;
    }

    public double getImpuesto() { return impuesto; }

    @Override
    public double calcularPrecio() {
        return getPrecioBase() * (1 + impuesto);
    }
}

