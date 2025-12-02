package co.edu.sena.semanas.Semana3;

public class PaqueteTuristico {

    private String nombrePaquete;
    private double precioBase;
    private int duracionDias;
    private boolean incluyeHotel;

    // Constructor completo
    public PaqueteTuristico(String nombrePaquete, double precioBase, int duracionDias, boolean incluyeHotel) {
        setNombrePaquete(nombrePaquete);
        setPrecioBase(precioBase);
        setDuracionDias(duracionDias);
        this.incluyeHotel = incluyeHotel;
    }

    // Constructor básico
    public PaqueteTuristico(String nombrePaquete, double precioBase) {
        this(nombrePaquete, precioBase, 3, false);
    }

    // Constructor mínimo
    public PaqueteTuristico(String nombrePaquete) {
        this(nombrePaquete, 500000);
    }

    // Getters
    public String getNombrePaquete() { return nombrePaquete; }
    public double getPrecioBase() { return precioBase; }
    public int getDuracionDias() { return duracionDias; }
    public boolean isIncluyeHotel() { return incluyeHotel; }

    // Setters con validación
    public void setNombrePaquete(String nombrePaquete) {
        validarString(nombrePaquete, "Nombre del paquete");
        this.nombrePaquete = nombrePaquete;
    }

    public void setPrecioBase(double precioBase) {
        if (precioBase <= 0) {
            throw new IllegalArgumentException("El precio base debe ser positivo.");
        }
        this.precioBase = precioBase;
    }

    public void setDuracionDias(int dias) {
        if (dias <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor a 0 días.");
        }
        this.duracionDias = dias;
    }

    // Método privado auxiliar
    private void validarString(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
    }

    // Método de negocio
    public double calcularPrecioTotal() {
        return incluyeHotel ? precioBase * 1.25 : precioBase;
    }
}
