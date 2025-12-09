package co.edu.sena.semanas.Semana7.servicio;

import co.edu.sena.semanas.Semana7.excepciones.*;
import co.edu.sena.semanas.Semana7.modelo.*;

import java.util.ArrayList;
import java.util.List;

public class GestorReservasS7 {

    private List<ReservaS7> historial = new ArrayList<>();

    public ReservaS7 crearReserva(ClienteS7 cliente, DestinoS7 destino, boolean pagoExitoso)
            throws ReservaInvalidaException, DisponibilidadException, PagoRechazadoException {

        if (cliente == null || destino == null) {
            throw new ReservaInvalidaException("Cliente o destino inválido.");
        }

        if (destino.getCupos() <= 0) {
            throw new DisponibilidadException("No hay cupos disponibles para este destino.");
        }

        if (!pagoExitoso) {
            throw new PagoRechazadoException("El pago fue rechazado por el sistema.");
        }

        destino.reducirCupo();

        ReservaS7 reserva = new ReservaS7(cliente, destino, "RSV-" + System.currentTimeMillis());
        historial.add(reserva);

        return reserva;
    }

    public List<ReservaS7> getHistorial() {
        return historial;
    }
}

