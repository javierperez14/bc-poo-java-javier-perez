package co.edu.sena.semanas.Semana2;

public class Main2 {
    public static void main(String[] args) {

        // Crear Clientes
        Cliente cliente1 = new Cliente("Javier Esteban Perez", "javier@email.com", "3100000000");
        Cliente cliente2 = new Cliente("Laura Gómez", "laura@gmail.com", "3115552233");

        // Crear Destinos
        Destino cartagena = new Destino("Cartagena", "Colombia", 850000, "Verano");
        Destino cancun = new Destino("Cancún", "México", 4500000, "Todo el año");

        // Crear Reservas (Relaciones)
        Reserva reserva1 = new Reserva(cliente1, cartagena, "2025-12-15", 2);
        Reserva reserva2 = new Reserva(cliente2, cancun, "2026-01-10", 3);

        // Clase Gestora
        AgenciaViajes agencia = new AgenciaViajes("Destinos Mágicos");

        agencia.agregarReserva(reserva1);
        agencia.agregarReserva(reserva2);

        // Mostrar resultados
        agencia.mostrarTodasReservas();
        System.out.println("Total Reservas: " + agencia.contarReservas());
    }
}
