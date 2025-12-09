package co.edu.sena.semanas.proyecto_final.modelo;

public class Cliente9 extends Persona {
    private String correo;

    public Cliente9(String id, String nombre, String correo) {
        super(id, nombre);
        setCorreo(correo);
    }

    public String getCorreo() { return correo; }

    public void setCorreo(String correo) {
        if (correo == null || !correo.contains("@")) throw new IllegalArgumentException("Correo inválido");
        this.correo = correo;
    }

    @Override
    public String obtenerTipo() {
        return "Cliente";
    }

    @Override
    public String toString() {
        return getId() + " | " + getNombre() + " | " + correo;
    }
}