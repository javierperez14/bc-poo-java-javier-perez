package co.edu.sena.semanas.Semana4;

class TourCiudad extends ServicioTuristico {

    private int horasDuracion;
    private double costoPorHora;

    public TourCiudad(String nombreServicio, String codigo, double costoBase,
                      int horasDuracion, double costoPorHora) {
        super(nombreServicio, codigo, costoBase);
        this.horasDuracion = horasDuracion;
        this.costoPorHora = costoPorHora;
    }

    @Override
    public double calcularCosto() {
        return costoBase + (horasDuracion * costoPorHora);
    }

    @Override
    public void mostrarInfo() {
        super.mostrarInfo();
        System.out.println("Duración (horas): " + horasDuracion);
        System.out.println("Costo por hora: $" + costoPorHora);
    }
}


