package co.edu.sena.semanas.proyecto_final.servicio;


import co.edu.sena.semanas.proyecto_final.modelo.Destino;
import co.edu.sena.semanas.proyecto_final.excepciones.DestinoNoDisponibleException;

import java.util.*;

/**
 * Gestor de destinos; usa Map para búsqueda por código y List para catálogo.
 */
public class GestorDestinos {
    private final Map<String, Destino> destinosPorCodigo;
    private final List<Destino> catalogo;

    public GestorDestinos() {
        this.destinosPorCodigo = new HashMap<>();
        this.catalogo = new ArrayList<>();
    }

    public void agregarDestino(Destino d) {
        Objects.requireNonNull(d, "Destino no puede ser null");
        if (destinosPorCodigo.containsKey(d.getCodigo())) throw new IllegalArgumentException("Destino ya existe: " + d.getCodigo());
        destinosPorCodigo.put(d.getCodigo(), d);
        catalogo.add(d);
    }

    public Destino buscarPorCodigo(String codigo) {
        return destinosPorCodigo.get(codigo);
    }

    public List<Destino> listarTodos() {
        return new ArrayList<>(catalogo);
    }

    // Método de ejemplo que simula disponibilidad (puedes adaptar a cupos si lo deseas)
    public void verificarDisponibilidad(String codigo) throws DestinoNoDisponibleException {
        Destino d = destinosPorCodigo.get(codigo);
        if (d == null) throw new DestinoNoDisponibleException("Destino no existe: " + codigo);
        // aquí podrías chequear cupos; por ahora asumimos disponible
    }

    public Destino eliminar(String codigo) {
        Destino d = destinosPorCodigo.remove(codigo);
        if (d != null) catalogo.remove(d);
        return d;
    }
}

