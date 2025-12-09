package co.edu.sena.semanas.proyecto_final.modelo;

public class DestinoNacional extends Destino {
    private String temporada; // baja, media, alta

    public DestinoNacional(String codigo, String nombre, double precioBase, String temporada) {
        super(codigo, nombre, precioBase);
        if (temporada == null || temporada.trim().isEmpty()) throw new IllegalArgumentException("Temporada inválida");
        this.temporada = temporada.trim().toLowerCase();
    }

    public String getTemporada() { return temporada; }

    @Override
    public double calcularPrecio() {
        double recargo = 0;
        if ("alta".equals(temporada)) recargo = getPrecioBase() * 0.2;
        if ("media".equals(temporada)) recargo = getPrecioBase() * 0.1;
        return getPrecioBase() + recargo;
    }
}

