# Semana 01 – Introducción al Paradigma Orientado a Objetos

**Dominio:** Agencia de Viajes *Destinos Mágicos*  
**Estudiante:** Javier Esteban Perez Aldana  
**Ficha:** 3228973B

---

## Contexto del Dominio: Destinos Mágicos

**Destinos Mágicos** es una agencia de viajes ubicada en la Zona Rosa de Bogotá.

Se especializa en:

- Paquetes turísticos nacionales e internacionales
- Venta de tiquetes aéreos
- Reservas hoteleras
- Asesoría en trámites de visa

La agencia atiende aproximadamente **40 clientes por día** y cuenta con **8 asesores de viaje**.

---

## Objetivos de la Semana

Durante esta semana aprenderás a:

1. Identificar objetos del mundo real en una agencia de viajes
2. Diferenciar programación estructurada vs. programación orientada a objetos
3. Comprender: **clase, objeto, atributo, método**
4. Crear tus primeras clases en Java basadas en el dominio

---

## Actividades Semana 01

### Actividad 1: Identificación de Objetos (Ejercicio 01)

Identifica **5 objetos** del dominio y describe:

- **¿Qué es?**
- **Atributos**
- **Métodos / comportamientos**

**Ejemplo basado en tu dominio:**

**Objeto:** Paquete Turístico

- **¿Qué es?:** Una oferta de viaje con servicios incluidos
- **Atributos:** destino, duración, precio, tipo de paquete
- **Métodos:** mostrar información, calcular valor total

---

### Actividad 2: Comparación de Paradigmas (Ejercicio 02)

Comparación general:

#### **Programación estructurada**

- Datos separados de funciones
- Flujo lineal
- No representa objetos reales

#### **Programación orientada a objetos**

- Agrupa datos + comportamiento en clases
- Modela objetos del mundo real (paquetes, clientes, reservas)
- Reutilizable y modular

Incluye ejemplos basados en *Destinos Mágicos*.

---

### Actividad 3: Primera Clase en Java (Ejercicio 03)

Aquí se reemplaza el ejemplo por tu **clase real**.

#### **Clase creada: `co.edu.sena.semanas.Semana01.TravelPackage_clases`**

```java
public class co.edu.sena.semanas.Semana01.TravelPackage_clases {
    String destino;
    int duracion;
    double precio;

    public co.edu.sena.semanas.Semana01.TravelPackage_clases(String destino, int duracion, double precio) {
        this.destino = destino;
        this.duracion = duracion;
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.println("co.edu.sena.semanas.Semana2.Destino: " + destino);
        System.out.println("Duración: " + duracion + " días");
        System.out.println("Precio: $" + precio);
        System.out.println("---------------------------");
    }
}
```

#### **co.edu.sena.semanas.Semana2.Main2 clases**

```java
import co.edu.sena.semanas.Semana01.TravelPackage_clases;

public class co.edu.sena.semanas.Semana01.

Main_clases {
    public static void main (String[]args){
        System.out.println("=== Agencia Destinos Mágicos ===");
        System.out.println("Lista de Paquetes Turísticos\n");

        TravelPackage_clases paquete1 = new TravelPackage_clases("Cartagena Todo Incluido", 5, 2500000);
        TravelPackage_clases paquete2 = new TravelPackage_clases("San Andrés Islas", 4, 1800000);
        TravelPackage_clases paquete3 = new TravelPackage_clases("Cancún México", 7, 4500000);

        paquete1.mostrarInfo();
        paquete2.mostrarInfo();
        paquete3.mostrarInfo();
    }
}
```

---

### Actividad 4: Múltiples Objetos (Ejercicio 04)

Reemplazado con tu solución real.

#### **Clase: `TravelPackage_objetos`**

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
```

#### **co.edu.sena.semanas.Semana2.Main2 con 5 paquetes turísticos**

```java
public class co.edu.sena.semanas.Semana01.Main_objetos {
    public static void main(String[] args) {
        System.out.println("=== Agencia Destinos Mágicos ===");
        System.out.println("Lista de Paquetes Turísticos\n");

        TravelPackage_objetos p1 = new TravelPackage_objetos("Aventura en Cartagena", "Cartagena", 5, 2500000);
        TravelPackage_objetos p2 = new TravelPackage_objetos("Descubre San Andrés", "San Andrés Islas", 4, 1800000);
        TravelPackage_objetos p3 = new TravelPackage_objetos("Vacaciones en Cancún", "Cancún - México", 7, 4500000);
        TravelPackage_objetos p4 = new TravelPackage_objetos("Tour por Medellín", "Medellín", 3, 1500000);
        TravelPackage_objetos p5 = new TravelPackage_objetos("Experiencia en Eje Cafetero", "Armenia - Quindío", 6, 2200000);

        p1.mostrarInfo();
        p2.mostrarInfo();
        p3.mostrarInfo();
        p4.mostrarInfo();
        p5.mostrarInfo();
    }
}
```

---

