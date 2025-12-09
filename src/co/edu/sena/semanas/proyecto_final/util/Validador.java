package co.edu.sena.semanas.proyecto_final.util;

public final class Validador {
    private Validador() {}

    public static void validarString(String valor, String nombre) {
        if (valor == null || valor.trim().isEmpty()) throw new IllegalArgumentException(nombre + " inválido");
    }

    public static void validarPrecio(double precio, String nombre) {
        if (precio < 0) throw new IllegalArgumentException(nombre + " no puede ser negativo");
    }
}

