# Semana 07 – Gestión de Reservas con Excepciones

**Proyecto Formativo:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## Descripción General

En esta semana se implementa un sistema más robusto para manejar reservas, clientes, destinos y un gestor de reservas, integrando **manejo avanzado de excepciones personalizadas**.

Se continúa el proyecto de las semanas anteriores, pero ahora aplicando mejores prácticas de arquitectura, separación por paquetes y control de errores.

---

## Objetivos de la Semana 7

Implementar un sistema de reservas que pueda:

- ✔ Registrar clientes
- ✔ Registrar destinos
- ✔ Crear nuevas reservas
- ✔ Validar disponibilidad
- ✔ Validar datos obligatorios
- ✔ Simular pagos
- ✔ Lanzar excepciones cuando algo falla

---

## Estructura del Proyecto

```
semana-07/
├── README.md
├── src/
│   └── com/
│       └── agencia/
│           ├── modelo/
│           │   ├── Reserva.java
│           │   ├── Cliente.java
│           │   └── Destino.java
│           ├── servicio/
│           │   └── GestorReservas.java
│           ├── excepciones/
│           │   ├── ReservaInvalidaException.java
│           │   ├── DisponibilidadException.java
│           │   └── PagoRechazadoException.java
│           └── Main.java
└── docs/
    └── diagrama-paquetes.png
```

---

## Paquetes y sus Responsabilidades

### 1. Paquete `modelo`

Contiene las clases base del dominio:

| Clase | Descripción |
|-------|-------------|
| `Cliente` | Representa a un cliente con nombre, documento, email |
| `Destino` | Información del destino turístico: ciudad, país, cupos disponibles |
| `Reserva` | Enlaza cliente + destino + fecha + valor |

**Ejemplo: `Cliente.java`**

```java
package com.agencia.modelo;

public class Cliente {
    private String nombre;
    private String documento;
    private String email;
    
    public Cliente(String nombre, String documento, String email) {
        this.nombre = nombre;
        this.documento = documento;
        this.email = email;
    }
    
    // Getters y setters
}
```

**Ejemplo: `Destino.java`**

```java
package com.agencia.modelo;

public class Destino {
    private String ciudad;
    private String pais;
    private int cuposDisponibles;
    private double precioBase;
    
    public Destino(String ciudad, String pais, int cuposDisponibles, double precioBase) {
        this.ciudad = ciudad;
        this.pais = pais;
        this.cuposDisponibles = cuposDisponibles;
        this.precioBase = precioBase;
    }
    
    public boolean hayDisponibilidad(int cantidadPersonas) {
        return cuposDisponibles >= cantidadPersonas;
    }
    
    public void descontarCupos(int cantidad) {
        cuposDisponibles -= cantidad;
    }
    
    // Getters y setters
}
```

**Ejemplo: `Reserva.java`**

```java
package com.agencia.modelo;

import java.time.LocalDate;

public class Reserva {
    private Cliente cliente;
    private Destino destino;
    private LocalDate fechaViaje;
    private int cantidadPersonas;
    private double valorTotal;
    
    public Reserva(Cliente cliente, Destino destino, LocalDate fechaViaje, 
                   int cantidadPersonas) {
        this.cliente = cliente;
        this.destino = destino;
        this.fechaViaje = fechaViaje;
        this.cantidadPersonas = cantidadPersonas;
        this.valorTotal = calcularValorTotal();
    }
    
    private double calcularValorTotal() {
        return destino.getPrecioBase() * cantidadPersonas;
    }
    
    // Getters y setters
}
```

---

### 2. Paquete `servicio`

Incluye la lógica de negocio:

| Clase | Descripción |
|-------|-------------|
| `GestorReservas` | Ejecuta validaciones, verifica disponibilidad y procesa reservas |

**Funciones principales:**

- Validar datos obligatorios
- Descontar cupos del destino
- Procesar pago (simulado)
- Lanzar excepciones según el tipo de fallo

**Ejemplo: `GestorReservas.java`**

```java
package com.agencia.servicio;

import com.agencia.modelo.*;
import com.agencia.excepciones.*;
import java.time.LocalDate;

public class GestorReservas {
    
    public Reserva crearReserva(Cliente cliente, Destino destino, 
                                LocalDate fechaViaje, int cantidadPersonas) 
            throws ReservaInvalidaException, DisponibilidadException, 
                   PagoRechazadoException {
        
        // Validación de datos
        if (cliente == null || destino == null || fechaViaje == null) {
            throw new ReservaInvalidaException("Datos de reserva incompletos");
        }
        
        if (cantidadPersonas <= 0) {
            throw new ReservaInvalidaException("Cantidad de personas debe ser mayor a 0");
        }
        
        // Validación de disponibilidad
        if (!destino.hayDisponibilidad(cantidadPersonas)) {
            throw new DisponibilidadException(
                "No hay cupos disponibles para " + cantidadPersonas + " personas"
            );
        }
        
        // Crear reserva
        Reserva reserva = new Reserva(cliente, destino, fechaViaje, cantidadPersonas);
        
        // Simular procesamiento de pago
        if (!procesarPago(reserva)) {
            throw new PagoRechazadoException("El pago fue rechazado");
        }
        
        // Descontar cupos
        destino.descontarCupos(cantidadPersonas);
        
        return reserva;
    }
    
    private boolean procesarPago(Reserva reserva) {
        // Simulación: 90% de éxito
        return Math.random() > 0.1;
    }
}
```

---

### 3. Paquete `excepciones`

Excepciones personalizadas para controlar errores de negocio:

| Excepción | Cuándo ocurre |
|-----------|---------------|
| `ReservaInvalidaException` | Datos incompletos o reserva incorrecta |
| `DisponibilidadException` | No hay cupos disponibles en el destino |
| `PagoRechazadoException` | Simulación de error en procesamiento de pago |

**Ejemplo: `ReservaInvalidaException.java`**

```java
package com.agencia.excepciones;

public class ReservaInvalidaException extends Exception {
    public ReservaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
```

**Ejemplo: `DisponibilidadException.java`**

```java
package com.agencia.excepciones;

public class DisponibilidadException extends Exception {
    public DisponibilidadException(String mensaje) {
        super(mensaje);
    }
}
```

**Ejemplo: `PagoRechazadoException.java`**

```java
package com.agencia.excepciones;

public class PagoRechazadoException extends Exception {
    public PagoRechazadoException(String mensaje) {
        super(mensaje);
    }
}
```

---

### 4. `Main.java`

Clase de prueba donde se ejecutan casos de ejemplo:

- Crear un cliente
- Crear un destino
- Intentar crear una reserva válida
- Probar excepciones
- Mostrar cómo el sistema se comporta ante errores

**Ejemplo: `Main.java`**

```java
package com.agencia;

import com.agencia.modelo.*;
import com.agencia.servicio.GestorReservas;
import com.agencia.excepciones.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== Sistema de Reservas - Destinos Mágicos ===\n");
        
        GestorReservas gestor = new GestorReservas();
        
        // Crear cliente
        Cliente cliente1 = new Cliente("Javier Pérez", "1234567890", "javier@email.com");
        
        // Crear destino
        Destino cartagena = new Destino("Cartagena", "Colombia", 10, 850000);
        
        // Caso 1: Reserva exitosa
        try {
            Reserva reserva1 = gestor.crearReserva(
                cliente1, 
                cartagena, 
                LocalDate.of(2025, 12, 15), 
                2
            );
            System.out.println("✓ Reserva creada exitosamente");
            System.out.println("Cliente: " + reserva1.getCliente().getNombre());
            System.out.println("Destino: " + reserva1.getDestino().getCiudad());
            System.out.println("Valor total: $" + reserva1.getValorTotal());
            
        } catch (ReservaInvalidaException e) {
            System.err.println("✗ Error: " + e.getMessage());
        } catch (DisponibilidadException e) {
            System.err.println("✗ Error: " + e.getMessage());
        } catch (PagoRechazadoException e) {
            System.err.println("✗ Error: " + e.getMessage());
        }
        
        System.out.println("\n---\n");
        
        // Caso 2: Error de disponibilidad
        try {
            Reserva reserva2 = gestor.crearReserva(
                cliente1, 
                cartagena, 
                LocalDate.of(2025, 12, 20), 
                15 // Más personas de las disponibles
            );
            
        } catch (DisponibilidadException e) {
            System.err.println("✗ Disponibilidad: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("✗ Error: " + e.getMessage());
        }
        
        System.out.println("\nCupos restantes en Cartagena: " + 
                          cartagena.getCuposDisponibles());
    }
}
```

---

## Diagrama de Paquetes

El diagrama UML se encuentra en:

```
docs/diagrama-paquetes.png
```

### Estructura de Relaciones

```
┌────────────────────────────────────────────┐
│              com.agencia                   │
│                                            │
│  ┌──────────────┐  ┌──────────────┐        │
│  │   modelo     │  │  servicio    │        │
│  │              │  │              │        │
│  │ • Cliente    │◄─┤ • GestorReservas      │
│  │ • Destino    │  │              │        │
│  │ • Reserva    │  └──────────────┘        │
│  └──────────────┘         │                │
│         │                 │                │
│         │                 ▼                │
│         │      ┌─────────────────┐         │
│         └─────►│  excepciones    │         │
│                │                 │         │
│                │ • ReservaInvalidaExceptio │
│                │ • DisponibilidadException │
│                │ • PagoRechazadoException  │
│                └─────────────────┘         │
└────────────────────────────────────────────┘
```

---

## Ejecución del Programa

### Desde IntelliJ IDEA

1. Abrir el proyecto `semana-07`
2. Navegar a: `src → com → agencia → Main.java`
3. Ejecutar con **Run → Run 'Main'**

### Desde Línea de Comandos

```bash
# Compilar
javac -d bin src/com/agencia/**/*.java

# Ejecutar
java -cp bin com.agencia.Main
```

---

## Salida Esperada

```
=== Sistema de Reservas - Destinos Mágicos ===

✓ Reserva creada exitosamente
Cliente: Javier Pérez
Destino: Cartagena
Valor total: $1700000.0

---

✗ Disponibilidad: No hay cupos disponibles para 15 personas

Cupos restantes en Cartagena: 8
```

Verás mensajes mostrando:
- Reservas exitosas
- Excepciones capturadas
- Flujo de validación

---

## Conceptos Aplicados esta Semana

### 🔹 Encapsulamiento
- Atributos privados con getters/setters
- Lógica de negocio protegida en métodos privados

### 🔹 Excepciones Personalizadas
- Excepciones checked que extienden `Exception`
- Mensajes descriptivos del error
- Control de flujo mediante try-catch

### 🔹 Validaciones de Negocio
- Verificación de datos obligatorios
- Validación de disponibilidad
- Simulación de procesos externos (pago)

### 🔹 Estructura de Paquetes Profesional
- Separación por capas: modelo, servicio, excepciones
- Organización siguiendo convenciones Java
- Facilita mantenimiento y escalabilidad

### 🔹 Separación de Responsabilidades
- **Modelo:** Solo datos y lógica básica
- **Servicio:** Lógica de negocio compleja
- **Excepciones:** Manejo de errores específicos

### 🔹 Manejo de Errores Controlado
- Propagación de excepciones
- Captura específica por tipo de error
- Mensajes informativos al usuario

---

## ✔ Estado

**Semana completada** - Sistema de reservas con manejo avanzado de excepciones implementado.