package co.edu.sena.semanas.Semana6.implementaciones ;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import co.edu.sena.semanas.Semana6.abstractas.ProductoAgencia;
import co.edu.sena.semanas.Semana6.interfaces.Reservable;
import co.edu.sena.semanas.Semana6.interfaces.Descuentable;

public class ReservaTransporte extends ProductoAgencia implements Reservable, Descuentable {

    private String tipoVehiculo; // ej. "Bus", "Lancha", "Van"
    private List<LocalDate> fechasReservadas;
    private String codigoReserva;

    public ReservaTransporte(String nombre, double precioBase, String tipoVehiculo) {
        super(nombre, precioBase);
        if (tipoVehiculo == null || tipoVehiculo.trim().isEmpty()) throw new IllegalArgumentException("Tipo inválido");
        this.tipoVehiculo = tipoVehiculo;
        this.fechasReservadas = new ArrayList<>();
    }

    @Override
    public double calcularPrecioFinal() {
        // Ejemplo: recargo por tipo especial
        double recargo = 0;
        if (tipoVehiculo.equalsIgnoreCase("Lancha")) recargo = precioBase * 0.20;
        if (tipoVehiculo.equalsIgnoreCase("Privado")) recargo = precioBase * 0.15;
        return precioBase + recargo;
    }

    // --- Reservable ---
    @Override
    public boolean verificarDisponibilidad(LocalDate fecha) {
        return !fechasReservadas.contains(fecha);
    }

    @Override
    public String realizarReserva(String clienteNombre, LocalDate fecha) {
        if (!verificarDisponibilidad(fecha)) throw new IllegalStateException("Fecha no disponible");
        codigoReserva = "TR-" + UUID.randomUUID().toString().substring(0, 6);
        fechasReservadas.add(fecha);
        return codigoReserva;
    }

    @Override
    public String obtenerCodigoReserva() {
        return codigoReserva;
    }

    // --- Descuentable ---
    @Override
    public boolean esElegibleDescuento() {
        // Ejemplo: transporte privado > cierto precio
        return calcularPrecioFinal() > 100_000;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        if (!esElegibleDescuento()) return calcularPrecioFinal();
        double total = calcularPrecioFinal();
        return total - (total * (porcentaje / 100.0));
    }

    // Extras
    public String getTipoVehiculo() { return tipoVehiculo; }
}
