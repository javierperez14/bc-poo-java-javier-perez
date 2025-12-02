package co.edu.sena.semanas.Semana2;

public class Destino {
    private String ciudad;
    private String pais;
    private double costoPromedio;
    private String temporada;

    public Destino(String ciudad, String pais, double costoPromedio, String temporada) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.costoPromedio = costoPromedio;
        this.temporada = temporada;
    }

    public String informacionDestino() {
        return ciudad + ", " + pais + " | Temporada: " + temporada + " | Costo Promedio: $" + costoPromedio;
    }

    // Getters y Setters
    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getCostoPromedio() {
        return costoPromedio;
    }

    public void setCostoPromedio(double costoPromedio) {
        this.costoPromedio = costoPromedio;
    }

    public String getTemporada() {
        return temporada;
    }

    public void setTemporada(String temporada) {
        this.temporada = temporada;
    }
}
