package co.edu.sena.semanas.proyecto_final.excepciones;

public class ReservaInvalidaException extends Exception {
    public ReservaInvalidaException(String mensaje) { super(mensaje); }
    public ReservaInvalidaException(String mensaje, Throwable causa) { super(mensaje, causa); }
}
