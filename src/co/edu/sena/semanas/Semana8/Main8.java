package co.edu.sena.semanas.Semana8;

import co.edu.sena.semanas.Semana8.modelo.*;
import co.edu.sena.semanas.Semana8.excepciones.*;
import co.edu.sena.semanas.Semana8.util.*;
import co.edu.sena.semanas.Semana8.servicio.*;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Main8 {

    private static final Scanner sc = new Scanner(System.in);
    private static GestorDatosS8 gestor;

    public static void main(String[] args) {
        System.out.println("=== Destinos Mágicos — Semana 08 (Colecciones y Generics) ===");

        // inicializar
        agenciaS8 agencia = new agenciaS8("Destinos Mágicos", "Bogotá");
        gestor = new GestorDatosS8(agencia);

        seedDatos();

        int op;
        do {
            mostrarMenu();
            op = leerInt();
            switch (op) {
                case 1: agregarPaquete(); break;
                case 2: buscarPorCodigo(); break;
                case 3: listarTodos(); break;
                case 4: filtrarPorPrecio(); break;
                case 5: mostrarEstadisticas(); break;
                case 6: eliminarPaquete(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción inválida");
            }
        } while (op != 0);

        sc.close();
    }

    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ ===");
        System.out.println("1. Agregar paquete");
        System.out.println("2. Buscar por código (HashMap O(1))");
        System.out.println("3. Listar todos");
        System.out.println("4. Filtrar por precio");
        System.out.println("5. Ver estadísticas");
        System.out.println("6. Eliminar paquete por código");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }

    private static void agregarPaquete() {
        try {
            System.out.print("Código (P###): ");
            String c = sc.nextLine().trim();
            System.out.print("Nombre: ");
            String n = sc.nextLine().trim();
            System.out.print("Tipo: ");
            String t = sc.nextLine().trim();
            System.out.print("Precio: ");
            double p = Double.parseDouble(sc.nextLine().trim());

            paqueteS8 pack = new paqueteS8(c, n, t, p);
            gestor.agregarPaquete(pack);
            System.out.println("✅ Paquete agregado: " + pack.getCodigo());
        } catch (Exception e) {
            System.err.println("❌ Error al agregar: " + e.getMessage());
        }
    }

    private static void buscarPorCodigo() {
        System.out.print("Código a buscar: ");
        String c = sc.nextLine().trim();
        paqueteS8 p = gestor.buscarPorCodigo(c);
        if (p != null) System.out.println("Encontrado: " + p);
        else System.out.println("No encontrado: " + c);
    }

    private static void listarTodos() {
        List<paqueteS8> lista = gestor.listarTodos();
        if (lista.isEmpty()) System.out.println("No hay paquetes.");
        else {
            System.out.println("=== Paquetes ===");
            lista.forEach(System.out::println);
        }
    }

    private static void filtrarPorPrecio() {
        try {
            System.out.print("Mínimo: ");
            double min = Double.parseDouble(sc.nextLine().trim());
            System.out.print("Máximo: ");
            double max = Double.parseDouble(sc.nextLine().trim());
            List<paqueteS8> res = gestor.filtrarPorPrecio(min, max);
            if (res.isEmpty()) System.out.println("Sin resultados.");
            else res.forEach(System.out::println);
        } catch (Exception e) {
            System.err.println("❌ Error en filtro: " + e.getMessage());
        }
    }

    private static void mostrarEstadisticas() {
        System.out.println("Total paquetes: " + gestor.listarTodos().size());
        System.out.println("Total precios: $" + String.format("%.2f", gestor.calcularTotalPrecio()));
        System.out.println("Promedio precio: $" + String.format("%.2f", gestor.calcularPromedioPrecio()));
        paqueteS8 caro = gestor.obtenerPaqueteMasCaro();
        if (caro != null) System.out.println("Más caro: " + caro);
        System.out.println("\nConteo por tipo:");
        Map<String,Integer> conteo = gestor.contarPorTipo();
        for (Map.Entry<String,Integer> e : conteo.entrySet()) {
            System.out.println("  " + e.getKey() + ": " + e.getValue());
        }
    }

    private static void eliminarPaquete() {
        System.out.print("Código a eliminar: ");
        String c = sc.nextLine().trim();
        paqueteS8 r = gestor.eliminarPorCodigo(c);
        if (r != null) System.out.println("Eliminado: " + r.getCodigo());
        else System.out.println("No se encontró: " + c);
    }

    private static int leerInt() {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (Exception e) {
            return -1;
        }
    }

    private static void seedDatos() {
        try {
            gestor.agregarPaquete(new paqueteS8("P001","Cartagena Todo Incluido","Paquete", 2500000));
            gestor.agregarPaquete(new paqueteS8("P002","San Andrés Escapada","Tour", 1800000));
            gestor.agregarPaquete(new paqueteS8("P003","Eje Cafetero Escape","Paquete", 950000));
        } catch (Exception e) {
            System.err.println("Seed error: " + e.getMessage());
        }
    }
}
