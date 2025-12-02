package co.edu.sena.semanas.Semana3;

public class Main3 {
    public static void main(String[] args) {

        // Crear paquete turístico
        PaqueteTuristico paquete1 = new PaqueteTuristico("Aventura en San Andrés", 1200000, 5, true);
        PaqueteTuristico paquete2 = new PaqueteTuristico("City Tour Bogotá", 350000);

        // Crear vendedor
        Vendedor vendedor1 = new Vendedor("Carlos Ramírez", "1020457896", 8, 50000);

        // Mostrar datos
        System.out.println("=== Paquetes Turísticos ===");
        System.out.println(paquete1.getNombrePaquete() + " - Total: " + paquete1.calcularPrecioTotal());
        System.out.println(paquete2.getNombrePaquete() + " - Total: " + paquete2.calcularPrecioTotal());

        System.out.println("\n=== Vendedor ===");
        System.out.println("Nombre: " + vendedor1.getNombre());
        System.out.println("Pago por comisiones: " + vendedor1.calcularPagoComision());
    }
}
