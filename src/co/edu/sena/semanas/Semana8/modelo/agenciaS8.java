package co.edu.sena.semanas.Semana8.modelo;

import java.util.Objects;

public class agenciaS8 {
    private String nombre;
    private String ciudad;

    public agenciaS8(String nombre, String ciudad) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre agencia inválido");
        if (ciudad == null || ciudad.trim().isEmpty()) throw new IllegalArgumentException("Ciudad inválida");
        this.nombre = nombre.trim();
        this.ciudad = ciudad.trim();
    }

    public String getNombre() { return nombre; }
    public String getCiudad() { return ciudad; }

    @Override
    public String toString() {
        return nombre + " (" + ciudad + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof agenciaS8)) return false;
        agenciaS8 a = (agenciaS8) o;
        return nombre.equalsIgnoreCase(a.nombre) && ciudad.equalsIgnoreCase(a.ciudad);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre.toLowerCase(), ciudad.toLowerCase());
    }
}