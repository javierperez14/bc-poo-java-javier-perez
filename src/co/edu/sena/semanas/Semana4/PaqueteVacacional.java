package co.edu.sena.semanas.Semana4;

public class PaqueteVacacional extends ServicioTuristico {

    private int dias;
    private double descuento; // porcentaje en decimal (0.10 = 10%)

    public PaqueteVacacional(String nombreServicio, String codigo, double costoBase,
                             int dias, double descuento) {
        super(nombreServicio, codigo, costoBase);
        this.dias = dias;
        this.descuento = descuento;
    }

    @Override
    public double calcularCosto() {
        double costo = costoBase * dias;

        if (dias >= 5) {
            costo -= costo * descuento;
        }

        return costo;
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Días: " + dias);
        System.out.println("Descuento aplicado: " + (descuento * 100) + "%");
    }
}
