package Actividad3_Primera_Clase_Simple;

public class TravelPackage_clases {
    String destino;
    int duracion;
    double precio;

    public TravelPackage_clases(String destino, int duracion, double precio) {
        this.destino = destino;
        this.duracion = duracion;
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.println("Destino: " + destino);
        System.out.println("Duración: " + duracion + " días");
        System.out.println("Precio: $" + precio);
        System.out.println("---------------------------");
    }
}


