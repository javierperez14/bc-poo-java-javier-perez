## Diferencia entre Programación Estructurada y Programación Orientada a Objetos 
La **Programación Estructurada** y La **Programación Orientada a Objetos (POO)** son dos paradigmas de software que organizan el código de formas diferentes.

### Programación Estructurada 
Es un paradigma que organiza el código en **bloques o funciones*.
Se centra en **la secuencia de instrucciones** que debe seguir el programa para resolver un problema.

**Características principales:**
- Divide el programa en **procedimientos o funciones**
- Se enfoca en la **Lógica y el flujo de control**
- Usa variables globales o locales para almacenar datos
- Es ideal para **programas pequeños y lineales**
- Los datos y las funciones **están separados**


### Programación Orientada a Objetos (POO)
La POO se basa en **modelar objetos del mundo real**.
Cada objeto tiene **atributos** (datos) y **métodos** (acciones).
El código se organiza en **clases**, que son moldes para crear objetos. 

**Características principales:**
- Los datos y las funciones están **agrupados en clases**.
- Usa **encapsulamientos, herencia y polimotfismo**.
- Permite crear sistemas **modulares, reutilizables y escalables**.
- Cada entidad del mundo real puede representarse como un objeto.

  ## Ejemplos conceptuales: Manejo de un Paquete Turístico

  A continuación se muestran dos formas diferentes de representar la información de un **paquete turístico**, aplicando los dos paradigma de programación: **estructurada** y **orientada a objetos**.

---

### 1. Programación Estructurada (usando variables sueltas y funciones)
En este enfoque, se utilizan **variables independientes** para los datos y **funciones** para realizar acciones.  
Los datos y las funciones están separados, lo que puede dificultar la organización cuando el programa crece.

```java
String destino = "Cartagena";
int duracion = 5;
double precio = 2500000;


void mostrarPaquete(String d, int du, double p) {
    System.out.println("Destino: " + d);
    System.out.println("Duración: " + du + " días");
    System.out.println("Precio: $" + p);
}

mostrarPaquete(destino, duracion, precio);

```


### 2. Programación Orientada a Objetos (usando una clase)

En este paradigma, los datos y las funciones se agrupan dentro de una **clase**, que representa un objeto del mundo real.  
Cada paquete turístico es un objeto con sus propios atributos y comportamientos.

```java
public class PaqueteTuristico {
    String destino;
    int duracion;
    double precio;

    public PaqueteTuristico(String destino, int duracion, double precio) {
        this.destino = destino;
        this.duracion = duracion;
        this.precio = precio;
    }

    public void mostrarInfo() {
        System.out.println("Destino: " + destino);
        System.out.println("Duración: " + duracion + " días");
        System.out.println("Precio: $" + precio);
    }
}

public class Main_objetos {
    public static void main(String[] args) {
        PaqueteTuristico paquete1 = new PaqueteTuristico("Cartagena", 5, 2500000);
        paquete1.mostrarInfo();
    }
}

  
