package co.edu.sena.semanas.proyecto_final.modelo;

import java.time.LocalDate;

public class Reserva {
    private String codigo; // R001
    private Cliente9 cliente;
    private Destino destino;
    private LocalDate fecha;
    private double precio;
    private boolean pagada;

    public Reserva(String codigo, Cliente9 cliente, Destino destino, LocalDate fecha) {
        setCodigo(codigo);
        setCliente(cliente);
        setDestino(destino);
        setFecha(fecha);
        this.precio = destino.calcularPrecio();
        this.pagada = false;
    }

    public String getCodigo() { return codigo; }

    public void setCodigo(String codigo) {
        if (codigo == null || !codigo.matches("R\\d{3}")) throw new IllegalArgumentException("Código reserva inválido");
        this.codigo = codigo;
    }

    public Cliente9 getCliente() { return cliente; }

    public void setCliente(Cliente9 cliente) {
        if (cliente == null) throw new IllegalArgumentException("Cliente no puede ser null");
        this.cliente = cliente;
    }

    public Destino getDestino() { return destino; }

    public void setDestino(Destino destino) {
        if (destino == null) throw new IllegalArgumentException("Destino no puede ser null");
        this.destino = destino;
    }

    public LocalDate getFecha() { return fecha; }

    public void setFecha(LocalDate fecha) {
        if (fecha == null) throw new IllegalArgumentException("Fecha inválida");
        this.fecha = fecha;
    }

    public double getPrecio() { return precio; }
    public boolean isPagada() { return pagada; }
    public void setPagada(boolean pagada) { this.pagada = pagada; }

    @Override
    public String toString() {
        return codigo + " | " + cliente.getNombre() + " | " + destino.getNombre() + " | " + fecha + " | $" + String.format("%.2f", precio) + " | Pagada:" + pagada;
    }
}
