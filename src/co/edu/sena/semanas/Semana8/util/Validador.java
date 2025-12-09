package co.edu.sena.semanas.Semana8.util;

public final class Validador {

    private Validador() {}

    public static void validarStringNoVacio(String valor, String nombreCampo) {
        if (valor == null || valor.trim().isEmpty()) {
            throw new IllegalArgumentException(nombreCampo + " no puede ser vacío");
        }
    }

    public static void validarPrecioPositivo(double precio, String nombreCampo) {
        if (precio < 0) {
            throw new IllegalArgumentException(nombreCampo + " no puede ser negativo");
        }
    }
}