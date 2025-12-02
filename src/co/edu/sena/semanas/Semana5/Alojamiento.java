package co.edu.sena.semanas.Semana5;

public class Alojamiento extends ServicioBase {
    private int noches;

    public Alojamiento(String nombre, double precio, int noches) {
        super(nombre, precio);
        this.noches = noches;
    }

    @Override
    public String obtenerDescripcion() {
        return "Alojamiento: " + nombre + " por " + noches + " noches.";
    }
}

