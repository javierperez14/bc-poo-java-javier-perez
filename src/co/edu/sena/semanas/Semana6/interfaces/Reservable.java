package co.edu.sena.semanas.Semana6.interfaces ;
import java.time.LocalDate;

public interface Reservable {
    // Verifica si hay disponibilidad en la fecha indicada
    boolean verificarDisponibilidad(LocalDate fecha);

    // Realiza una reserva y devuelve un código único (string)
    String realizarReserva(String clienteNombre, LocalDate fecha);

    // Obtener código de reserva si aplica
    String obtenerCodigoReserva();
}
