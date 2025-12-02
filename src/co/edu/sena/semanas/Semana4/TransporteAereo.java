package co.edu.sena.semanas.Semana4;

public class TransporteAereo extends ServicioTuristico {

    private double recargoTemporada; // en decimal (0.25 = 25%)

    public TransporteAereo(String nombreServicio, String codigo, double costoBase,
                           double recargoTemporada) {
        super(nombreServicio, codigo, costoBase);
        this.recargoTemporada = recargoTemporada;
    }

    @Override
    public double calcularCosto() {
        return costoBase + (costoBase * recargoTemporada);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Recargo por temporada: " + (recargoTemporada * 100) + "%");
    }
}

