package co.edu.sena.semanas.proyecto_final.modelo;

public class Empleado extends Persona {
    private String cargo;
    private double salarioBase;

    public Empleado(String id, String nombre, String cargo, double salarioBase) {
        super(id, nombre);
        setCargo(cargo);
        setSalarioBase(salarioBase);
    }

    public String getCargo() { return cargo; }
    public double getSalarioBase() { return salarioBase; }

    public void setCargo(String cargo) {
        if (cargo == null || cargo.trim().isEmpty()) throw new IllegalArgumentException("Cargo inválido");
        this.cargo = cargo;
    }

    public void setSalarioBase(double salarioBase) {
        if (salarioBase < 0) throw new IllegalArgumentException("Salario inválido");
        this.salarioBase = salarioBase;
    }

    @Override
    public String obtenerTipo() {
        return "Empleado";
    }
}

