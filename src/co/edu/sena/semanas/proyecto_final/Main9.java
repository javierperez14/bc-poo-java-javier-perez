package co.edu.sena.semanas.proyecto_final;

import co.edu.sena.semanas.proyecto_final.modelo.*;
import co.edu.sena.semanas.proyecto_final.servicio.*;
import co.edu.sena.semanas.proyecto_final.excepciones.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main9 {
    private static final Scanner sc = new Scanner(System.in);
    private static final GestorClientes gestorClientes = new GestorClientes();
    private static final GestorDestinos gestorDestinos = new GestorDestinos();
    private static final GestorReservas gestorReservas = new GestorReservas();

    public static void main(String[] args) {
        System.out.println("=== Destinos Mágicos - Proyecto Final (Semana 09) ===");
        seedData();

        int opcion;
        do {
            mostrarMenu();
            opcion = leerInt();
            switch (opcion) {
                case 1: agregarCliente(); break;
                case 2: agregarDestino(); break;
                case 3: crearReserva(); break;
                case 4: buscarReserva(); break;
                case 5: listarReservas(); break;
                case 6: actualizarCliente(); break;
                case 7: eliminarReserva(); break;
                case 8: filtrarYEstadisticas(); break;
                case 9: generarReporte(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENU ===");
        System.out.println("1. Agregar Cliente");
        System.out.println("2. Agregar Destino");
        System.out.println("3. Crear Reserva");
        System.out.println("4. Buscar Reserva por código");
        System.out.println("5. Listar todas las reservas");
        System.out.println("6. Actualizar correo cliente");
        System.out.println("7. Eliminar reserva");
        System.out.println("8. Filtrar y ver estadísticas");
        System.out.println("9. Generar reporte (listado por cliente)");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    // --- Implementaciones de opciones (con manejo de excepciones)
    private static void agregarCliente() {
        try {
            System.out.print("ID cliente (C###): "); String id = sc.nextLine().trim();
            System.out.print("Nombre: "); String nombre = sc.nextLine().trim();
            System.out.print("Correo: "); String correo = sc.nextLine().trim();
            Cliente9 c = new Cliente9(id, nombre, correo);
            gestorClientes.agregarCliente(c);
            System.out.println("Cliente agregado: " + c);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void agregarDestino() {
        try {
            System.out.print("Código destino (D###): "); String cod = sc.nextLine().trim();
            System.out.print("Nombre destino: "); String nom = sc.nextLine().trim();
            System.out.print("Tipo (Nacional/Internacional): "); String tipo = sc.nextLine().trim();
            System.out.print("Precio base: "); double precio = Double.parseDouble(sc.nextLine().trim());
            Destino d;
            if ("Nacional".equalsIgnoreCase(tipo)) {
                System.out.print("Temporada (baja/media/alta): "); String temporada = sc.nextLine().trim();
                d = new DestinoNacional(cod, nom, precio, temporada);
            } else {
                System.out.print("Impuesto (ej. 0.15): "); double imp = Double.parseDouble(sc.nextLine().trim());
                d = new DestinoInternacional(cod, nom, precio, imp);
            }
            gestorDestinos.agregarDestino(d);
            System.out.println("Destino agregado: " + d);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void crearReserva() {
        try {
            System.out.print("Código reserva (R###): "); String rc = sc.nextLine().trim();
            System.out.print("ID cliente (C###): "); String id = sc.nextLine().trim();
            System.out.print("Código destino (D###): "); String cd = sc.nextLine().trim();
            System.out.print("Fecha (YYYY-MM-DD): "); LocalDate fecha = LocalDate.parse(sc.nextLine().trim());
            Cliente9 c = gestorClientes.buscarPorId(id);
            Destino d = gestorDestinos.buscarPorCodigo(cd);
            if (d == null) throw new ReservaInvalidaException("Destino no existe: " + cd);
            gestorReservas.agregarReserva(rc, c, d, fecha);
            System.out.println("Reserva creada: " + rc);
        } catch (ClienteNoEncontradoException e) {
            System.err.println("Cliente no encontrado: " + e.getMessage());
        } catch (ReservaInvalidaException e) {
            System.err.println("Reserva inválida: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error creando reserva: " + e.getMessage());
        }
    }

    private static void buscarReserva() {
        System.out.print("Código reserva: ");
        String codigo = sc.nextLine().trim();
        Reserva r = gestorReservas.buscarPorCodigo(codigo);
        if (r != null) System.out.println("Encontrada: " + r);
        else System.out.println("No existe reserva con código: " + codigo);
    }

    private static void listarReservas() {
        List<Reserva> lista = gestorReservas.listarTodas();
        if (lista.isEmpty()) System.out.println("No hay reservas");
        else lista.forEach(System.out::println);
    }

    private static void actualizarCliente() {
        try {
            System.out.print("ID cliente a actualizar: "); String id = sc.nextLine().trim();
            System.out.print("Nuevo correo: "); String correo = sc.nextLine().trim();
            gestorClientes.actualizarCorreo(id, correo);
            System.out.println("Correo actualizado.");
        } catch (ClienteNoEncontradoException e) {
            System.err.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void eliminarReserva() {
        System.out.print("Código reserva a eliminar: ");
        String codigo = sc.nextLine().trim();
        Reserva r = gestorReservas.eliminar(codigo);
        if (r != null) System.out.println("Eliminada: " + r.getCodigo());
        else System.out.println("No se encontró: " + codigo);
    }

    private static void filtrarYEstadisticas() {
        try {
            System.out.println("--- Filtrar por precio ---");
            System.out.print("Min: "); double min = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Max: "); double max = Double.parseDouble(sc.nextLine().trim());
            List<Reserva> filtradas = gestorReservas.filtrarPorPrecio(min, max);
            filtradas.forEach(System.out::println);

            System.out.println("\n--- Estadísticas ---");
            System.out.println("Total ventas: $" + gestorReservas.calcularTotalVentas());
            System.out.println("Promedio: $" + gestorReservas.calcularPromedioPrecio());
            Reserva masCara = gestorReservas.obtenerReservaMasCara();
            if (masCara != null) System.out.println("Más cara: " + masCara);
            System.out.println("\nConteo por tipo de destino:");
            Map<String, Integer> conteo = gestorReservas.contarPorTipoDestino();
            conteo.forEach((k,v) -> System.out.println(k + ": " + v));
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void generarReporte() {
        System.out.print("ID cliente para reporte (C###): ");
        String id = sc.nextLine().trim();
        List<Reserva> listas = gestorReservas.obtenerReservasCliente(id);
        if (listas.isEmpty()) System.out.println("No hay reservas para: " + id);
        else {
            System.out.println("Reservas del cliente " + id + ":");
            listas.forEach(System.out::println);
        }
    }

    // Seed inicial
    private static void seedData() {
        try {
            gestorClientes.agregarCliente(new Cliente9("C001", "Ana García", "ana@mail.com"));
            gestorClientes.agregarCliente(new Cliente9("C002", "Luis Perez", "luis@mail.com"));

            gestorDestinos.agregarDestino(new DestinoNacional("D001", "Cartagena", 450000, "alta"));
            gestorDestinos.agregarDestino(new DestinoInternacional("D002", "Cancún", 1500000, 0.12));

            gestorReservas.agregarReserva("R001", gestorClientes.buscarPorId("C001"), gestorDestinos.buscarPorCodigo("D001"), LocalDate.of(2026,1,15));
        } catch (Exception e) {
            System.err.println("Seed error: " + e.getMessage());
        }
    }

    private static int leerInt() {
        try { return Integer.parseInt(sc.nextLine().trim()); }
        catch (Exception e) { return -1; }
    }
}
