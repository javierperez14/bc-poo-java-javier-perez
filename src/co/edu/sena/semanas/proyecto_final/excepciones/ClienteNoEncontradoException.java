package co.edu.sena.semanas.proyecto_final.excepciones;

public class ClienteNoEncontradoException extends Exception {
    public ClienteNoEncontradoException(String mensaje) { super(mensaje); }
    public ClienteNoEncontradoException(String mensaje, Throwable causa) { super(mensaje, causa); }
}
