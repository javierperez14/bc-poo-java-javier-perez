package co.edu.sena.semanas.Semana8.excepciones;

public class DatosNoEncontradosException extends Exception {
    public DatosNoEncontradosException(String mensaje) {
        super(mensaje);
    }

    public DatosNoEncontradosException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
