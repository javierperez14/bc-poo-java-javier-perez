package Actividad3_Primera_Clase_Simple;

public class Main_clases {
    public static void main(String[] args) {
        System.out.println("=== Agencia Destinos Mágicos ===");
        System.out.println("Lista de Paquetes Turísticos\n");

        TravelPackage_clases paquete1 = new TravelPackage_clases("Cartagena Todo Incluido", 5, 2500000);
        TravelPackage_clases paquete2 = new TravelPackage_clases("San Andrés Islas", 4, 1800000);
        TravelPackage_clases paquete3 = new TravelPackage_clases("Cancún México", 7, 4500000);

        paquete1.mostrarInfo();
        paquete2.mostrarInfo();
        paquete3.mostrarInfo();
    }
}
