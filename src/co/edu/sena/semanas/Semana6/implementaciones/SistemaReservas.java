
package co.edu.sena.semanas.Semana6.implementaciones ;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import co.edu.sena.semanas.Semana6.abstractas.ProductoAgencia;
import co.edu.sena.semanas.Semana6.interfaces.Reservable;

public class SistemaReservas {

    private List<ProductoAgencia> catalogo;
    private List<String> codigosReservas; // simple ledger de códigos

    public SistemaReservas() {
        this.catalogo = new ArrayList<>();
        this.codigosReservas = new ArrayList<>();
    }

    // Agregar producto (polimórfico)
    public void agregarProducto(ProductoAgencia p) {
        catalogo.add(p);
        System.out.println("Producto agregado: " + p.obtenerInfo());
    }

    // ===== SOBRECARGA: buscarProducto =====
    // 1) Buscar por nombre
    public ProductoAgencia buscarProducto(String nombre) {
        for (ProductoAgencia p : catalogo) {
            if (p.nombre.equalsIgnoreCase(nombre)) return p;
        }
        return null;
    }

    // 2) Buscar por rango de precio
    public List<ProductoAgencia> buscarProducto(double minPrecio, double maxPrecio) {
        List<ProductoAgencia> res = new ArrayList<>();
        for (ProductoAgencia p : catalogo) {
            double precio = p.calcularPrecioFinal();
            if (precio >= minPrecio && precio <= maxPrecio) res.add(p);
        }
        return res;
    }

    // 3) Buscar por tipo (clase)
    public List<ProductoAgencia> buscarProductoPorTipo(Class<?> tipo) {
        List<ProductoAgencia> res = new ArrayList<>();
        for (ProductoAgencia p : catalogo) {
            if (tipo.isInstance(p)) res.add(p);
        }
        return res;
    }

    // ===== Operaciones con Reservable (métodos polimórficos) =====
    public String reservar(Reservable r, String clienteNombre, LocalDate fecha) {
        if (!r.verificarDisponibilidad(fecha)) {
            throw new IllegalStateException("No hay disponibilidad para la fecha indicada");
        }
        String codigo = r.realizarReserva(clienteNombre, fecha);
        codigosReservas.add(codigo);
        System.out.println("Reserva creada: " + codigo + " para " + clienteNombre + " en " + fecha);
        return codigo;
    }

    // Mostrar catálogo
    public void mostrarCatalogo() {
        System.out.println("=== CATÁLOGO DE PRODUCTOS - Destinos Mágicos ===");
        for (ProductoAgencia p : catalogo) {
            System.out.println("- " + p.obtenerResumen());
        }
    }

    // Mostrar productos de un tipo (ejemplo polimórfico)
    public void mostrarPorTipo(Class<?> tipo) {
        System.out.println("=== Productos de tipo: " + tipo.getSimpleName() + " ===");
        for (ProductoAgencia p : buscarProductoPorTipo(tipo)) {
            System.out.println(p.obtenerResumen());
        }
    }
}
