package co.edu.sena.semanas.Semana7.modelo;

public class ClienteS7 {
    private String nombre;
    private String correo;

    public ClienteS7(String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getCorreo() {
        return correo;
    }
}
