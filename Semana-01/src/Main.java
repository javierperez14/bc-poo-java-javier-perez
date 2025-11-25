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


package Actividad4_Multiples_Objetos;

public class Main_objetos {
    public static void main(String[] args) {
        System.out.println("=== Agencia Destinos Mágicos ===");
        System.out.println("Lista de Paquetes Turísticos\n");

        TravelPackage_objetos p1 = new TravelPackage_objetos("Aventura en Cartagena", "Cartagena", 5, 2500000);
        TravelPackage_objetos p2 = new TravelPackage_objetos("Descubre San Andrés", "San Andrés Islas", 4, 1800000);
        TravelPackage_objetos p3 = new TravelPackage_objetos("Vacaciones en Cancún", "Cancún - México", 7, 4500000);
        TravelPackage_objetos p4 = new TravelPackage_objetos("Tour por Medellín", "Medellín", 3, 1500000);
        TravelPackage_objetos p5 = new TravelPackage_objetos("Experiencia en Eje Cafetero", "Armenia - Quindío", 6, 2200000);

        p1.mostrarInfo();
        p2.mostrarInfo();
        p3.mostrarInfo();
        p4.mostrarInfo();
        p5.mostrarInfo();
    }
}