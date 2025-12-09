package co.edu.sena.semanas.Semana7;

import co.edu.sena.semanas.Semana7.modelo.*;
import co.edu.sena.semanas.Semana7.servicio.*;
import co.edu.sena.semanas.Semana7.excepciones.*;

public class Main7 {
    public static void main(String[] args) {

        ClienteS7 cliente = new ClienteS7("Javier", "javier@mail.com");
        DestinoS7 destino = new DestinoS7("San Andrés", 1200000, 1);

        GestorReservasS7 gestor = new GestorReservasS7();

        try {
            ReservaS7 reserva = gestor.crearReserva(cliente, destino, true);
            System.out.println("Reserva creada exitosamente:");
            System.out.println("Código: " + reserva.getCodigo());
            System.out.println("Cliente: " + reserva.getCliente().getNombre());
            System.out.println("Destino: " + reserva.getDestino().getNombre());

        } catch (ReservaInvalidaException | DisponibilidadException | PagoRechazadoException e) {
            System.out.println("Error creando la reserva: " + e.getMessage());
        }
    }
}