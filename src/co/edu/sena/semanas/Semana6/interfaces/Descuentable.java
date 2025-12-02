package co.edu.sena.semanas.Semana6.interfaces ;
public interface Descuentable {
    // Determina si el producto es elegible para descuento
    boolean esElegibleDescuento();

    // Aplica un porcentaje de descuento sobre el precio final y devuelve el nuevo total
    double aplicarDescuento(double porcentaje);
}
