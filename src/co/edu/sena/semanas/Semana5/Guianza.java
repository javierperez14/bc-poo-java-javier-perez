package co.edu.sena.semanas.Semana5;

public class Guianza extends ServicioBase {
    private String idioma;

    public Guianza(String nombre, double precio, String idioma) {
        super(nombre, precio);
        this.idioma = idioma;
    }

    @Override
    public String obtenerDescripcion() {
        return "Guianza en " + idioma + ": " + nombre;
    }
}

