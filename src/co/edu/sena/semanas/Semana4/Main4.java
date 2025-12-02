package co.edu.sena.semanas.Semana4 ;
public class Main4 {
    public static void main(String[] args) {

        ServicioTuristico[] servicios = new ServicioTuristico[3];

        servicios[0] = new TourCiudad(
                "Tour por el Centro Histórico",
                "T001",
                50000,
                4,
                15000
        );

        servicios[1] = new PaqueteVacacional(
                "Paquete San Andrés",
                "P002",
                180000,
                6,
                0.10
        );

        servicios[2] = new TransporteAereo(
                "Vuelo Bogotá - Medellín",
                "A003",
                350000,
                0.25
        );

        System.out.println("=== SERVICIOS TURÍSTICOS ===");

        for (ServicioTuristico s : servicios) {
            s.mostrarInfo();
            System.out.println("Costo Final: $" + s.calcularCosto());
            System.out.println("----------------------------");
        }
    }
}
