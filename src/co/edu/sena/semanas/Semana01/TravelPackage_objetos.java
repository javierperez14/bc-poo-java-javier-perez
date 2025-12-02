package co.edu.sena.semanas.Semana01 ;

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
        System.out.println("co.edu.sena.semanas.Semana2.Destino: " + destino);
        System.out.println("Duración: " + duracion + " días");
        System.out.println("Valor total: $" + valor);
        System.out.println("--------------------------------");
    }
}
