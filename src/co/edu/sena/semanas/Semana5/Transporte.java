package co.edu.sena.semanas.Semana5;

public class Transporte extends ServicioBase {
    private String tipo;

    public Transporte(String nombre, double precio, String tipo) {
        super(nombre, precio);
        this.tipo = tipo;
    }

    @Override
    public String obtenerDescripcion() {
        return "Transporte " + tipo + ": " + nombre;
    }
}

