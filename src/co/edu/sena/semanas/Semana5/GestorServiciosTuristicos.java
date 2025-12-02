package co.edu.sena.semanas.Semana5;

import java.util.ArrayList;

public class GestorServiciosTuristicos {

    private ArrayList<ServicioBase> servicios = new ArrayList<>();

    // Polimórfico
    public void agregarServicio(ServicioBase servicio) {
        servicios.add(servicio);
    }

    // Sobrecarga
    public void agregarServicio(String nombre, double precio) {
        servicios.add(new ServicioBase(nombre, precio));
    }

    public void agregarServicio(String nombre, double precio, int noches) {
        servicios.add(new Alojamiento(nombre, precio, noches));
    }

    public void agregarServicio(String nombre, double precio, String tipo) {
        servicios.add(new Transporte(nombre, precio, tipo));
    }

    public void mostrarServicios() {
        System.out.println("=== LISTA DE SERVICIOS ===");
        for (ServicioBase s : servicios) {
            System.out.println(s.obtenerDescripcion() + " | $" + s.getPrecio());
        }
    }
}

