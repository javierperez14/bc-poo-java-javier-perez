package co.edu.sena.semanas.Semana7.modelo;

public class DestinoS7 {
    private String nombre;
    private double precio;
    private int cupos;

    public DestinoS7(String nombre, double precio, int cupos) {
        this.nombre = nombre;
        this.precio = precio;
        this.cupos = cupos;
    }

    public String getNombre() {
        return nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCupos() {
        return cupos;
    }

    public void reducirCupo() {
        this.cupos--;
    }
}

