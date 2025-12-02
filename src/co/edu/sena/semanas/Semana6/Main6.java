package co.edu.sena.semanas.Semana6;

import java.time.LocalDate;
import java.util.List;
import co.edu.sena.semanas.Semana6.abstractas.ProductoAgencia;
import co.edu.sena.semanas.Semana6.implementaciones.PaquetePremium;
import co.edu.sena.semanas.Semana6.implementaciones.ReservaTransporte;
import co.edu.sena.semanas.Semana6.implementaciones.ExcursionGuiada;
import co.edu.sena.semanas.Semana6.implementaciones.SistemaReservas;


public class Main6 {
    public static void main(String[] args) {

        System.out.println("=== Destinos Mágicos — Semana 06: Abstracción e Interfaces ===\n");

        SistemaReservas sistema = new SistemaReservas();

        // Crear productos concretos
        PaquetePremium paquete = new PaquetePremium("Paquete Caribe Premium", 1_200_000, 5);
        ReservaTransporte transporte = new ReservaTransporte("Traslado Isla - Hotel", 80_000, "Lancha");
        ExcursionGuiada excursion = new ExcursionGuiada("Excursión Guatapé", 45_000, "Español", 20);

        // Agregar al catálogo (polimórfico)
        sistema.agregarProducto(paquete);
        sistema.agregarProducto(transporte);
        sistema.agregarProducto(excursion);

        System.out.println();
        sistema.mostrarCatalogo();

        // ===== Demostración de sobrecarga de buscarProducto =====
        System.out.println("\n--- Buscar por nombre: 'Paquete Caribe Premium' ---");
        ProductoAgencia p = sistema.buscarProducto("Paquete Caribe Premium");
        if (p != null) System.out.println(p.obtenerResumen());

        System.out.println("\n--- Buscar por rango de precio (min 30000, max 200000) ---");
        List<ProductoAgencia> rango = sistema.buscarProducto(30_000, 200_000);
        for (ProductoAgencia prod : rango) {
            System.out.println(prod.obtenerResumen());
        }

        // ===== Demostración de Reservable (interfaces) =====
        System.out.println("\n--- Reservas (utilizando referencias de tipo Reservable) ---");
        LocalDate fecha1 = LocalDate.of(2026, 1, 15);
        String codigo1 = sistema.reservar(paquete, "Javier Perez", fecha1); // PaquetePremium implementa Reservable
        String codigo2 = sistema.reservar(transporte, "Laura Gomez", LocalDate.of(2026, 1, 16));
        String codigo3 = sistema.reservar(excursion, "Javier Perez", LocalDate.of(2026, 1, 17));

        System.out.println("\nCódigo reservas: " + codigo1 + ", " + codigo2 + ", " + codigo3);

        // ===== Demostración de múltiples interfaces y uso ====
        System.out.println("\n--- Calificaciones y Descuentos ---");
        // PaquetePremium es Calificable y Descuentable
        paquete.agregarCalificacion(5, "Excelente servicio");
        paquete.agregarCalificacion(4, "Muy bueno");

        System.out.println("Promedio Paquete: " + paquete.obtenerPromedioCalificaciones());

        if (paquete.esElegibleDescuento()) {
            double conDesc = paquete.aplicarDescuento(10); // 10%
            System.out.println("Precio Paquete con 10% descuento: $" + conDesc);
        }

        // Transporte también es Descuentable
        System.out.println("Transporte es elegible descuento? " + transporte.esElegibleDescuento());
        System.out.println("Precio transporte final: $" + transporte.calcularPrecioFinal());

        // ===== Mostrar por tipo (polimorfismo por clase) =====
        System.out.println();
        sistema.mostrarPorTipo(PaquetePremium.class);

        System.out.println("\n=== FIN DEMOSTRACIÓN ===");
    }
}
