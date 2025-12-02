package co.edu.sena.semanas.Semana6.implementaciones;

import co.edu.sena.semanas.Semana6.abstractas.ProductoAgencia;
import co.edu.sena.semanas.Semana6.interfaces.Reservable;
import co.edu.sena.semanas.Semana6.interfaces.Calificable;
import co.edu.sena.semanas.Semana6.interfaces.Descuentable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class PaquetePremium extends ProductoAgencia implements Reservable, Calificable, Descuentable {

    private int dias;
    private List<Integer> calificaciones;
    private List<String> comentarios;
    private String codigoReserva;
    private List<LocalDate> fechasReservadas;

    public PaquetePremium(String nombre, double precioBase, int dias) {
        super(nombre, precioBase);
        if (dias <= 0) throw new IllegalArgumentException("Días deben ser positivos");
        this.dias = dias;
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
        this.fechasReservadas = new ArrayList<>();
    }

    @Override
    public double calcularPrecioFinal() {
        double recargoPorDia = 120000;
        return precioBase + (dias * recargoPorDia);
    }

    @Override
    public boolean verificarDisponibilidad(LocalDate fecha) {
        return !fechasReservadas.contains(fecha);
    }

    @Override
    public String realizarReserva(String clienteNombre, LocalDate fecha) {
        if (!verificarDisponibilidad(fecha)) {
            throw new IllegalStateException("Fecha no disponible para este paquete");
        }
        codigoReserva = clienteNombre.replaceAll("\\s+", "").toUpperCase()
                + "-" + UUID.randomUUID().toString().substring(0, 6);
        fechasReservadas.add(fecha);
        return codigoReserva;
    }

    @Override
    public String obtenerCodigoReserva() {
        return codigoReserva;
    }

    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        if (estrellas < 1 || estrellas > 5) throw new IllegalArgumentException("Estrellas entre 1 y 5");
        calificaciones.add(estrellas);
        comentarios.add(comentario == null ? "" : comentario);
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        int suma = 0;
        for (int e : calificaciones) suma += e;
        return (double) suma / calificaciones.size();
    }

    @Override
    public boolean esElegibleDescuento() {
        return dias >= 4;
    }

    @Override
    public double aplicarDescuento(double porcentaje) {
        if (porcentaje < 0 || porcentaje > 100) throw new IllegalArgumentException("Porcentaje inválido");
        double total = calcularPrecioFinal();
        return total - (total * (porcentaje / 100.0));
    }

    public int getDias() { return dias; }
}
