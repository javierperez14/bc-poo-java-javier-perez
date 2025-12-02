package co.edu.sena.semanas.Semana5;

public class Main5 {
    public static void main(String[] args) {

            GestorServiciosTuristicos gestor = new GestorServiciosTuristicos();

            // Polimorfismo dinámico
            gestor.agregarServicio(new Alojamiento("Hotel Miramar", 260000, 2));
            gestor.agregarServicio(new Transporte("Traslado Aeropuerto", 95000, "Privado"));
            gestor.agregarServicio(new Guianza("Tour Histórico", 150000, "Inglés"));

            // Sobrecarga
            gestor.agregarServicio("Seguro Básico", 45000);
            gestor.agregarServicio("Cabaña Premium", 350000, 3);
            gestor.agregarServicio("Bus Intermunicipal", 50000, "Bus");

            gestor.mostrarServicios();
        }
    }


