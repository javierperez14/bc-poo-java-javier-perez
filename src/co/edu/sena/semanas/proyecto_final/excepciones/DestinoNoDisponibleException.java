package co.edu.sena.semanas.proyecto_final.excepciones;

public class DestinoNoDisponibleException extends Exception {
    public DestinoNoDisponibleException(String mensaje) { super(mensaje); }
    public DestinoNoDisponibleException(String mensaje, Throwable causa) { super(mensaje, causa); }
}

