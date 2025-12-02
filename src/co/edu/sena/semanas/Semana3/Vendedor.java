package co.edu.sena.semanas.Semana3;

public class Vendedor {

    private String nombre;
    private String documento;
    private int ventasRealizadas;
    private double comision;

    // Constructor completo
    public Vendedor(String nombre, String documento, int ventasRealizadas, double comision) {
        setNombre(nombre);
        setDocumento(documento);
        setVentasRealizadas(ventasRealizadas);
        setComision(comision);
    }

    // Constructor básico
    public Vendedor(String nombre, String documento) {
        this(nombre, documento, 0, 0.0);
    }

    // Constructor mínimo
    public Vendedor(String nombre) {
        this(nombre, generarDocumento(nombre));
    }

    // Getters
    public String getNombre() { return nombre; }
    public String getDocumento() { return documento; }
    public int getVentasRealizadas() { return ventasRealizadas; }
    public double getComision() { return comision; }

    // Setters con validación
    public void setNombre(String nombre) {
        validarString(nombre, "Nombre");
        this.nombre = nombre;
    }

    public void setDocumento(String documento) {
        validarString(documento, "Documento");
        this.documento = documento;
    }

    public void setVentasRealizadas(int ventas) {
        if (ventas < 0) {
            throw new IllegalArgumentException("Las ventas realizadas no pueden ser negativas.");
        }
        this.ventasRealizadas = ventas;
    }

    public void setComision(double comision) {
        if (comision < 0) {
            throw new IllegalArgumentException("La comisión no puede ser negativa.");
        }
        this.comision = comision;
    }

    // Métodos privados auxiliares
    private void validarString(String valor, String campo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(campo + " no puede estar vacío.");
        }
    }

    private static String generarDocumento(String nombre) {
        return ("ID-" + nombre.replace(" ", "").toUpperCase());
    }

    // Método de negocio
    public double calcularPagoComision() {
        return ventasRealizadas * comision;
    }
}

