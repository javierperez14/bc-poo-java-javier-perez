package co.edu.sena.semanas.Semana2;

public class Cliente {
    private String nombre;
    private String correo;
    private String telefono;

    public Cliente(String nombre, String correo, String telefono) {
        this.nombre = nombre;
        this.correo = correo;
        this.telefono = telefono;
    }

    public String obtenerInformacion() {
        return "co.edu.sena.semanas.Semana2.Cliente: " + nombre + " | Correo: " + correo + " | Teléfono: " + telefono;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
