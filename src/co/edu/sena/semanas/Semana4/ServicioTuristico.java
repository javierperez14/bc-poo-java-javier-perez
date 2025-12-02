package co.edu.sena.semanas.Semana4;

public class ServicioTuristico {
    protected String nombreServicio;
    protected String codigo;
    protected double costoBase;

    public ServicioTuristico(String nombreServicio, String codigo, double costoBase) {
        this.nombreServicio = nombreServicio;
        this.codigo = codigo;
        this.costoBase = costoBase;
    }

    public void mostrarInfo() {
        System.out.println("Servicio: " + nombreServicio);
        System.out.println("Código: " + codigo);
        System.out.println("Costo base: $" + costoBase);
    }

    public double calcularCosto() {
        return costoBase;
    }
}


