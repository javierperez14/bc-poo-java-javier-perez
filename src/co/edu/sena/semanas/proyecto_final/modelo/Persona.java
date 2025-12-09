package co.edu.sena.semanas.proyecto_final.modelo;

public abstract class Persona {
    private String id;      // ejemplo: P001 o C001
    private String nombre;

    public Persona(String id, String nombre) {
        if (id == null || id.trim().isEmpty()) throw new IllegalArgumentException("ID inválido");
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        this.id = id.trim();
        this.nombre = nombre.trim();
    }

    public String getId() { return id; }
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) throw new IllegalArgumentException("Nombre inválido");
        this.nombre = nombre.trim();
    }

    public abstract String obtenerTipo();
}