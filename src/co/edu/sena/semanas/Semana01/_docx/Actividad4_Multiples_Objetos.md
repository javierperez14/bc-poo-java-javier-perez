# Actividad 4: Múltiples Objetos (Ejercicio 04)

## Objetivo
Aplicar el concepto de **creación de múltiples objetos** a partir de una misma clase, representando varios paquetes turísticos ofrecidos por una agencia.

---

## Descripción
En esta actividad, se reutiliza la clase `TravelPackage_objetos` creada en la actividad anterior.  
Se crean **cinco objetos** diferentes con información realista de distintos destinos turísticos.  
Cada objeto representa un paquete con su propio nombre, destino, duración y valor.

---

## Código de la clase `TravelPackage_objetos.java`
```java
public class TravelPackage_objetos {
    String nombrePaquete;
    String destino;
    int duracion;
    double valor;

    public TravelPackage_objetos(String nombrePaquete, String destino, int duracion, double valor) {
        this.nombrePaquete = nombrePaquete;
        this.destino = destino;
        this.duracion = duracion;
        this.valor = valor;
    }

    public void mostrarInfo() {
        System.out.println("Paquete: " + nombrePaquete);
        System.out.println("co.edu.sena.semanas.Semana2.Destino: " + destino);
        System.out.println("Duración: " + duracion + " días");
        System.out.println("Valor total: $" + valor);
        System.out.println("--------------------------------");
    }
}
