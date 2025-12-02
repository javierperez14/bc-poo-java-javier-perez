# POLIMORFISMO – Semana 05

**Dominio:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## 1. ¿Qué es el Polimorfismo?

El **polimorfismo** es la capacidad que tiene Java para permitir que **una misma referencia apunte a objetos de diferentes tipos**, siempre que estos compartan una relación de herencia.

### Ejemplo Conceptual

``` java
ServicioDeReserva servicio = new ReservaVuelo();
servicio = new ReservaHotel();
```

La referencia es del tipo `ServicioDeReserva`, pero puede recibir cualquier objeto que herede de esa clase.

### Ventaja Principal

Permite tratar objetos de diferentes tipos de manera uniforme, facilitando el diseño de sistemas flexibles y escalables.

---

## 2. Herencia Utilizada en el Proyecto

### Clase Padre

Creamos una clase padre genérica:

**✔ `ServicioDeReserva.java`**

Representa cualquier tipo de servicio reservable (vuelo, hotel, tour).

``` java
public class ServicioDeReserva {
    protected String nombre;
    protected double precioBase;
    
    public ServicioDeReserva(String nombre, double precioBase) {
        this.nombre = nombre;
        this.precioBase = precioBase;
    }
    
    public double calcularPrecio() {
        return precioBase;
    }
    
    public String obtenerInformacion() {
        return "Servicio: " + nombre + " - Precio: $" + calcularPrecio();
    }
}
```

---

### Subclases Especializadas

Luego creamos subclases especializadas que heredan de la clase padre:

#### **`ReservaVuelo.java`**

``` java
public class ReservaVuelo extends ServicioDeReserva {
    private String aerolinea;
    private double impuestoAeroportuario;
    
    @Override
    public double calcularPrecio() {
        return precioBase + impuestoAeroportuario;
    }
}
```

#### **`ReservaHotel.java`**

``` java
public class ReservaHotel extends ServicioDeReserva {
    private int cantidadNoches;
    private double tarifaPorNoche;
    
    @Override
    public double calcularPrecio() {
        return cantidadNoches * tarifaPorNoche;
    }
}
```

#### **`ReservaTour.java`**

``` java
public class ReservaTour extends ServicioDeReserva {
    private int cantidadPersonas;
    private double precioPorPersona;
    
    @Override
    public double calcularPrecio() {
        return cantidadPersonas * precioPorPersona;
    }
}
```

Todas heredan de la clase padre y sobrescriben (`@Override`) el método `calcularPrecio()`.

---

## 3. Sobrescritura de Métodos (@Override)

Cada subclase implementa su propia versión del método `calcularPrecio()`:

### En la Clase Padre

``` java
public double calcularPrecio() {
    return precioBase; // Implementación genérica
}
```

### En las Subclases

``` java
@Override
public double calcularPrecio() {
    return precioBase + impuesto; // Implementación específica
}
```

### Tabla Comparativa

| Clase | Lógica de Cálculo | Ejemplo |
|-------|-------------------|---------|
| **ServicioDeReserva** | `precioBase` | $100,000 |
| **ReservaVuelo** | `precioBase + impuestoAeroportuario` | $100,000 + $30,000 = $130,000 |
| **ReservaHotel** | `cantidadNoches * tarifaPorNoche` | 3 noches × $150,000 = $450,000 |
| **ReservaTour** | `cantidadPersonas * precioPorPersona` | 4 personas × $80,000 = $320,000 |

### Beneficio

Esto permite que **cada servicio se calcule de forma distinta**, aunque todos compartan el mismo método.

---

## 4. Polimorfismo en el Proyecto

### ArrayList Polimórfico

Creamos un `ArrayList` que puede contener diferentes tipos de reservas:

``` java
ArrayList<ServicioDeReserva> reservas = new ArrayList<>();
```

El mismo `ArrayList` puede contener:
- ✈️ Reservas de vuelos
- 🏨 Reservas de hotel
- 🗺️ Reservas de tours

### Ejemplo de Uso

``` java
// Agregamos diferentes tipos de servicios a la misma lista
reservas.add(new ReservaVuelo("Vuelo Bogotá-Cartagena", 300000, "Avianca", 30000));
reservas.add(new ReservaHotel("Hotel Caribe", 150000, 3, 150000));
reservas.add(new ReservaTour("Tour Ciudad Perdida", 80000, 4, 80000));
```

### Ventaja del Polimorfismo

Todos los objetos se manejan bajo el mismo tipo (`ServicioDeReserva`), simplificando el código y permitiendo procesamiento uniforme.

---

## 5. Ejecución Polimórfica

Al recorrer la lista, **Java decide automáticamente qué versión del método usar** según el tipo real del objeto:

``` java
for (ServicioDeReserva servicio : reservas) {
    System.out.println(servicio.obtenerInformacion());
    System.out.println("Precio calculado: $" + servicio.calcularPrecio());
    System.out.println("---");
}
```

### Resultado

```
Servicio: Vuelo Bogotá-Cartagena - Precio: $330000.0
Precio calculado: $330000.0
---
Servicio: Hotel Caribe - Precio: $450000.0
Precio calculado: $450000.0
---
Servicio: Tour Ciudad Perdida - Precio: $320000.0
Precio calculado: $320000.0
---
```

### ¿Cómo Funciona?

Aunque el **tipo de la lista es el mismo** (`ServicioDeReserva`), el **método ejecutado depende del objeto real** (ReservaVuelo, ReservaHotel o ReservaTour).

Este proceso se conoce como **dynamic method dispatch** o **late binding**.

---

## 6. Sobrecarga de Métodos en `SistemaDePagos.java`

Se incluyen métodos **sobrecargados** para diferentes formas de pago:

### Implementación

``` java
public class SistemaDePagos {
    
    // Versión 1: Pago simple
    public void pagar(ServicioDeReserva reserva) {
        double total = reserva.calcularPrecio();
        System.out.println("Pagado: $" + total);
    }
    
    // Versión 2: Pago con descuento
    public void pagar(ServicioDeReserva reserva, double descuento) {
        double total = reserva.calcularPrecio() - descuento;
        System.out.println("Pagado con descuento: $" + total);
    }
    
    // Versión 3: Pago con cupón
    public void pagar(ServicioDeReserva reserva, String cupon) {
        double descuento = validarCupon(cupon);
        double total = reserva.calcularPrecio() - descuento;
        System.out.println("Pagado con cupón '" + cupon + "': $" + total);
    }
    
    private double validarCupon(String cupon) {
        // Lógica de validación de cupón
        return 50000; // Descuento fijo por simplicidad
    }
}
```

### Ejemplo de Uso

``` java
SistemaDePagos sistema = new SistemaDePagos();
ServicioDeReserva vuelo = new ReservaVuelo("Vuelo", 300000, "Avianca", 30000);

sistema.pagar(vuelo);                    // Versión 1
sistema.pagar(vuelo, 50000);             // Versión 2
sistema.pagar(vuelo, "PROMO2025");       // Versión 3
```

### Concepto

La **sobrecarga** permite tener **mismos métodos con diferentes parámetros**, proporcionando flexibilidad al usuario del código.

---

## 7. Conclusiones

### Herencia

Se aplicó **herencia** para:
- Reutilizar código común
- Representar un dominio real de agencia de viajes
- Establecer una jerarquía clara de clases

### Sobrescritura

Se aplicó **sobrescritura** para:
- Que cada tipo de reserva tenga su propio comportamiento
- Personalizar el cálculo de precios según el servicio
- Mantener una interfaz común con implementaciones específicas

### Polimorfismo

Se aplicó **polimorfismo** para:
- Manejar vuelos, hoteles y tours bajo un mismo tipo
- Simplificar el manejo de colecciones heterogéneas
- Permitir ejecución dinámica de métodos

### Sobrecarga

Se aplicó **sobrecarga** para:
- Manejar diferentes formas de pago en el sistema
- Proporcionar flexibilidad sin cambiar nombres de métodos
- Mejorar la experiencia del usuario del código

### Escalabilidad

El diseño permite:
- Agregar nuevos tipos de servicio sin modificar el sistema general
- Extender funcionalidad fácilmente
- Mantener código limpio y organizado

---

## 8. UML Simplificado

### Diagrama de Clases

```
┌─────────────────────────────┐
│   ServicioDeReserva         │
├─────────────────────────────┤
│ - nombre: String            │
│ - precioBase: double        │
├─────────────────────────────┤
│ + calcularPrecio(): double  │
│ + obtenerInformacion(): String │
└─────────────────────────────┘
           △
           │
    ┌──────┴──────┬──────────────┐
    │             │              │
┌───┴────┐   ┌───┴────┐   ┌────┴─────┐
│ReservaV│   │ReservaH│   │ReservaT  │
│uelo    │   │otel    │   │our       │
└────────┘   └────────┘   └──────────┘


┌─────────────────────────────┐
│   SistemaDePagos            │
├─────────────────────────────┤
│ + pagar(reserva)            │
│ + pagar(reserva, descuento) │
│ + pagar(reserva, cupon)     │
└─────────────────────────────┘
```

### Relaciones

- **Herencia (△):** ReservaVuelo, ReservaHotel y ReservaTour extienden ServicioDeReserva
- **Asociación:** SistemaDePagos utiliza ServicioDeReserva para procesar pagos

---

## Comparación: Sobrecarga vs Sobrescritura

| Aspecto | Sobrecarga | Sobrescritura |
|---------|------------|---------------|
| **Nombre del método** | Igual | Igual |
| **Parámetros** | Diferentes | Idénticos |
| **Clase** | Misma clase o subclase | Subclase diferente |
| **Binding** | Compile-time (estático) | Runtime (dinámico) |
| **Palabra clave** | No requiere | `@Override` |
| **Ejemplo en proyecto** | `pagar(reserva)` vs `pagar(reserva, descuento)` | `calcularPrecio()` en cada subclase |
---
## Estado

**Análisis completado**