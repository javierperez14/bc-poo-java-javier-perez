package co.edu.sena.semanas.Semana6.implementaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import co.edu.sena.semanas.Semana6.abstractas.ProductoAgencia;
import co.edu.sena.semanas.Semana6.interfaces.Reservable;
import co.edu.sena.semanas.Semana6.interfaces.Calificable;


public class ExcursionGuiada extends ProductoAgencia implements Reservable, Calificable {

    private String idioma;
    private int maxParticipantes;
    private List<LocalDate> fechasReservadas;
    private String codigoReserva;
    private List<Integer> calificaciones;
    private List<String> comentarios;

    public ExcursionGuiada(String nombre, double precioBase, String idioma, int maxParticipantes) {
        super(nombre, precioBase);
        if (idioma == null || idioma.trim().isEmpty()) throw new IllegalArgumentException("Idioma inválido");
        if (maxParticipantes <= 0) throw new IllegalArgumentException("Max participantes inválido");
        this.idioma = idioma;
        this.maxParticipantes = maxParticipantes;
        this.fechasReservadas = new ArrayList<>();
        this.calificaciones = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    @Override
    public double calcularPrecioFinal() {
        // ejemplo simple: precio por persona (ya está precioBase)
        return precioBase;
    }

    // Reservable
    @Override
    public boolean verificarDisponibilidad(LocalDate fecha) {
        return !fechasReservadas.contains(fecha);
    }

    @Override
    public String realizarReserva(String clienteNombre, LocalDate fecha) {
        if (!verificarDisponibilidad(fecha)) throw new IllegalStateException("Fecha no disponible");
        codigoReserva = "EX-" + UUID.randomUUID().toString().substring(0, 6);
        fechasReservadas.add(fecha);
        return codigoReserva;
    }

    @Override
    public String obtenerCodigoReserva() {
        return codigoReserva;
    }

    // Calificable
    @Override
    public void agregarCalificacion(int estrellas, String comentario) {
        if (estrellas < 1 || estrellas > 5) throw new IllegalArgumentException("Estrellas inválidas");
        calificaciones.add(estrellas);
        comentarios.add(comentario == null ? "" : comentario);
    }

    @Override
    public double obtenerPromedioCalificaciones() {
        if (calificaciones.isEmpty()) return 0.0;
        int s = 0;
        for (int e : calificaciones) s += e;
        return (double) s / calificaciones.size();
    }

    public String getIdioma() { return idioma; }
    public int getMaxParticipantes() { return maxParticipantes; }
}
