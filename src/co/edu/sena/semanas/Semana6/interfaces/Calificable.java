package co.edu.sena.semanas.Semana6.interfaces ;
public interface Calificable {
    // Agrega una calificación numérica (1-5) y comentario
    void agregarCalificacion(int estrellas, String comentario);

    // Calcula y retorna el promedio de calificaciones
    double obtenerPromedioCalificaciones();
}
