package co.edu.sena.semanas.Semana8.servicio;

import co.edu.sena.semanas.Semana8.modelo.*;
import co.edu.sena.semanas.Semana8.excepciones.*;
import co.edu.sena.semanas.Semana8.util.*;

import java.util.*;

public class GestorDatosS8 {

    private final agenciaS8 agencia;
    private final List<paqueteS8> historialPaquetes;
    private final Map<String, paqueteS8> paquetesPorCodigo;
    private final Map<String, List<paqueteS8>> paquetesPorTipo;

    public GestorDatosS8(agenciaS8 agencia) {
        this.agencia = Objects.requireNonNull(agencia, "Agencia no puede ser null");
        this.historialPaquetes = new ArrayList<>();
        this.paquetesPorCodigo = new HashMap<>();
        this.paquetesPorTipo = new HashMap<>();
    }

    // ----------------------
    // CRUD básico
    // ----------------------
    public void agregarPaquete(paqueteS8 p) {
        Objects.requireNonNull(p, "Paquete no puede ser null");
        String cod = p.getCodigo();
        if (paquetesPorCodigo.containsKey(cod)) {
            throw new IllegalArgumentException("Ya existe paquete con código: " + cod);
        }
        paquetesPorCodigo.put(cod, p);
        historialPaquetes.add(p);
        paquetesPorTipo.computeIfAbsent(p.getTipo(), k -> new ArrayList<>()).add(p);
    }

    public paqueteS8 buscarPorCodigo(String codigo) {
        return paquetesPorCodigo.get(codigo);
    }

    public boolean existePaquete(String codigo) {
        return paquetesPorCodigo.containsKey(codigo);
    }

    public paqueteS8 eliminarPorCodigo(String codigo) {
        paqueteS8 p = paquetesPorCodigo.remove(codigo);
        if (p != null) {
            historialPaquetes.remove(p);
            List<paqueteS8> porTipo = paquetesPorTipo.get(p.getTipo());
            if (porTipo != null) {
                porTipo.remove(p);
                if (porTipo.isEmpty()) paquetesPorTipo.remove(p.getTipo());
            }
        }
        return p;
    }

    public List<paqueteS8> listarTodos() {
        return new ArrayList<>(historialPaquetes);
    }

    // ----------------------
    // Filtrado
    // ----------------------
    public List<paqueteS8> filtrarPorPrecio(double min, double max) {
        List<paqueteS8> res = new ArrayList<>();
        for (paqueteS8 p : historialPaquetes) {
            if (p.getPrecioBase() >= min && p.getPrecioBase() <= max) res.add(p);
        }
        return res;
    }

    public List<paqueteS8> filtrarPorTipo(String tipo) {
        if (tipo == null) return new ArrayList<>();
        return new ArrayList<>(paquetesPorTipo.getOrDefault(tipo, new ArrayList<>()));
    }

    // ----------------------
    // Estadísticas
    // ----------------------
    public double calcularTotalPrecio() {
        double total = 0.0;
        for (paqueteS8 p : historialPaquetes) total += p.getPrecioBase();
        return total;
    }

    public double calcularPromedioPrecio() {
        if (historialPaquetes.isEmpty()) return 0.0;
        return calcularTotalPrecio() / historialPaquetes.size();
    }

    public paqueteS8 obtenerPaqueteMasCaro() {
        if (historialPaquetes.isEmpty()) return null;
        paqueteS8 maxima = historialPaquetes.get(0);
        for (paqueteS8 p : historialPaquetes) {
            if (p.getPrecioBase() > maxima.getPrecioBase()) maxima = p;
        }
        return maxima;
    }

    public Map<String, Integer> contarPorTipo() {
        Map<String, Integer> conteo = new HashMap<>();
        for (paqueteS8 p : historialPaquetes) {
            String tipo = p.getTipo();
            conteo.put(tipo, conteo.getOrDefault(tipo, 0) + 1);
        }
        return conteo;
    }

    // ----------------------
    // Ejemplo de método que lanza exception custom
    // ----------------------
    public paqueteS8 obtenerObligatorio(String codigo) throws DatosNoEncontradosException {
        paqueteS8 p = paquetesPorCodigo.get(codigo);
        if (p == null) throw new DatosNoEncontradosException("Paquete no encontrado: " + codigo);
        return p;
    }

    // Getter para agencia (info)
    public agenciaS8 getAgencia() { return agencia; }
}