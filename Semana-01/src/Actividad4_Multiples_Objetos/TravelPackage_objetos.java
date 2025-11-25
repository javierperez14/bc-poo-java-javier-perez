package Actividad4_Multiples_Objetos;
public class TravelPackage_objetos {
    String nombrePaquete;
    String destino;
    int duracion;
    double valor;

    public TravelPackage_objetos(String nombrePaquete, String destino, int duracion, double valor) {
        this.nombrePaquete = nombrePaquete;
        this.destino = destino;
        this.duracion = duracion;
        this.valor = valor;
    }

    public void mostrarInfo() {
        System.out.println("Paquete: " + nombrePaquete);
        System.out.println("Destino: " + destino);
        System.out.println("Duración: " + duracion + " días");
        System.out.println("Valor total: $" + valor);
        System.out.println("--------------------------------");
    }
}
