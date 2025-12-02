package co.edu.sena.semanas.Semana2;

import java.util.ArrayList;

public class AgenciaViajes {
    private String nombre;
    private ArrayList<Reserva> reservas;

    public AgenciaViajes(String nombre) {
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public void agregarReserva(Reserva reserva) {
        reservas.add(reserva);
    }

    public void mostrarTodasReservas() {
        System.out.println("=== Reservas Registradas en " + nombre + " ===");
        for (Reserva r : reservas) {
            System.out.println(r.obtenerResumen());
        }
    }

    public int contarReservas() {
        return reservas.size();
    }
}
