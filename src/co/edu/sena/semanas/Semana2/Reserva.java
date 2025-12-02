package co.edu.sena.semanas.Semana2;

public class Reserva {
    private Cliente cliente;
    private Destino destino;
    private String fechaViaje;
    private int numeroPasajeros;

    public Reserva(Cliente cliente, Destino destino, String fechaViaje, int numeroPasajeros) {
        this.cliente = cliente;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.numeroPasajeros = numeroPasajeros;
    }

    public double calcularTotal() {
        return destino.getCostoPromedio() * numeroPasajeros;
    }

    public String obtenerResumen() {
        return cliente.getNombre() + " reservó viaje a " + destino.getCiudad() +
                " el día " + fechaViaje + " para " + numeroPasajeros +
                " pasajeros. Total: $" + calcularTotal();
    }

    // Getters
    public Cliente getCliente() {
        return cliente;
    }

    public Destino getDestino() {
        return destino;
    }
}
