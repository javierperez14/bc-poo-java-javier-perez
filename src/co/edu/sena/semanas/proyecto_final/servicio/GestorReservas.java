package co.edu.sena.semanas.proyecto_final.servicio;

import co.edu.sena.semanas.proyecto_final.modelo.*;
import co.edu.sena.semanas.proyecto_final.excepciones.*;

import java.time.LocalDate;
import java.util.*;

public class GestorReservas {
    private final List<Reserva> historial;
    private final Map<String, Reserva> reservasPorCodigo;
    private final Map<String, List<Reserva>> reservasPorCliente;

    public GestorReservas() {
        this.historial = new ArrayList<>();
        this.reservasPorCodigo = new HashMap<>();
        this.reservasPorCliente = new HashMap<>();
    }

    // Sobrecarga: agregar por objeto
    public void agregarReserva(Reserva r) throws ReservaInvalidaException {
        Objects.requireNonNull(r, "Reserva no puede ser null");
        if (reservasPorCodigo.containsKey(r.getCodigo())) throw new ReservaInvalidaException("Reserva duplicada: " + r.getCodigo());
        reservasPorCodigo.put(r.getCodigo(), r);
        historial.add(r);
        reservasPorCliente.computeIfAbsent(r.getCliente().getId(), k -> new ArrayList<>()).add(r);
    }

    // Sobrecarga: crear y agregar desde parámetros
    public void agregarReserva(String codigo, Cliente9 cliente, Destino destino, LocalDate fecha) throws ReservaInvalidaException {
        Reserva r = new Reserva(codigo, cliente, destino, fecha);
        agregarReserva(r);
    }

    public Reserva buscarPorCodigo(String codigo) {
        return reservasPorCodigo.get(codigo);
    }

    public List<Reserva> obtenerReservasCliente(String idCliente) {
        return reservasPorCliente.getOrDefault(idCliente, new ArrayList<>());
    }

    public List<Reserva> listarTodas() {
        return new ArrayList<>(historial);
    }

    public Reserva eliminar(String codigo) {
        Reserva r = reservasPorCodigo.remove(codigo);
        if (r != null) {
            historial.remove(r);
            List<Reserva> lista = reservasPorCliente.get(r.getCliente().getId());
            if (lista != null) {
                lista.remove(r);
                if (lista.isEmpty()) reservasPorCliente.remove(r.getCliente().getId());
            }
        }
        return r;
    }

    // Filtrado por precio
    public List<Reserva> filtrarPorPrecio(double min, double max) {
        List<Reserva> res = new ArrayList<>();
        for (Reserva r : historial) if (r.getPrecio() >= min && r.getPrecio() <= max) res.add(r);
        return res;
    }

    // Filtrado por mes/año
    public List<Reserva> filtrarPorMes(int mes, int anio) {
        List<Reserva> res = new ArrayList<>();
        for (Reserva r : historial) if (r.getFecha().getMonthValue() == mes && r.getFecha().getYear() == anio) res.add(r);
        return res;
    }

    // Estadísticas
    public double calcularTotalVentas() {
        double total = 0;
        for (Reserva r : historial) total += r.getPrecio();
        return total;
    }

    public double calcularPromedioPrecio() {
        if (historial.isEmpty()) return 0;
        return calcularTotalVentas() / historial.size();
    }

    public Reserva obtenerReservaMasCara() {
        if (historial.isEmpty()) return null;
        Reserva max = historial.get(0);
        for (Reserva r : historial) if (r.getPrecio() > max.getPrecio()) max = r;
        return max;
    }

    public Map<String, Integer> contarPorTipoDestino() {
        Map<String, Integer> conteo = new HashMap<>();
        for (Reserva r : historial) {
            String tipo = r.getDestino().getClass().getSimpleName();
            conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
        }
        return conteo;
    }
}
