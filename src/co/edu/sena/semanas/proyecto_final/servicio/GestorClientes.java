package co.edu.sena.semanas.proyecto_final.servicio;

import co.edu.sena.semanas.proyecto_final.modelo.Cliente9;
import co.edu.sena.semanas.proyecto_final.excepciones.ClienteNoEncontradoException;

import java.util.*;

public class GestorClientes {
    private final Map<String, Cliente9> clientes;

    public GestorClientes() {
        this.clientes = new HashMap<>();
    }

    public void agregarCliente(Cliente9 c) {
        Objects.requireNonNull(c, "Cliente no puede ser null");
        if (clientes.containsKey(c.getId())) throw new IllegalArgumentException("Cliente ya existe: " + c.getId());
        clientes.put(c.getId(), c);
    }

    public Cliente9 buscarPorId(String id) throws ClienteNoEncontradoException {
        Cliente9 c = clientes.get(id);
        if (c == null) throw new ClienteNoEncontradoException("Cliente no encontrado: " + id);
        return c;
    }

    public List<Cliente9> listarTodos() {
        return new ArrayList<>(clientes.values());
    }

    public void actualizarCorreo(String id, String nuevoCorreo) throws ClienteNoEncontradoException {
        Cliente9 c = buscarPorId(id);
        c.setCorreo(nuevoCorreo);
    }

    public Cliente9 eliminar(String id) throws ClienteNoEncontradoException {
        Cliente9 c = buscarPorId(id);
        clientes.remove(id);
        return c;
    }
}

