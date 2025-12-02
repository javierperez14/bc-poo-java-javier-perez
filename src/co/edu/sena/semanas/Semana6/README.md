# Semana 06 – Abstracción e Interfaces
**Dominio:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## Objetivo
Refactorizar y expandir el sistema usando **clases abstractas** e **interfaces**, aplicando principios SOLID.

---

## Estructura del Proyecto

```
semana-06/
├── README.md
├── abstractas/
│   └── ProductoAgencia.java
├── interfaces/
│   ├── Reservable.java
│   ├── Calificable.java
│   └── Descuentable.java
├── implementaciones/
│   ├── PaquetePremium.java
│   ├── ReservaTransporte.java
│   ├── ExcursionGuiada.java
│   └── SistemaReservas.java
├── Main.java
└── ANALISIS.md
```

---

## Qué se Implementó

### Clase Abstracta
- **`ProductoAgencia`**: Clase base con atributos protegidos (nombre, precioBase), método abstracto `calcularPrecioFinal()` y método concreto `obtenerInfo()`.

### Interfaces
- **`Reservable`**: Gestión de reservas (verificar disponibilidad, realizar reserva, obtener código).
- **`Calificable`**: Sistema de calificaciones (agregar calificación, obtener promedio).
- **`Descuentable`**: Lógica de descuentos (verificar elegibilidad, aplicar descuento).

### Clases Concretas
- **`PaquetePremium`**: Implementa `Reservable`, `Calificable`, `Descuentable`
- **`ReservaTransporte`**: Implementa `Reservable`, `Descuentable`
- **`ExcursionGuiada`**: Implementa `Reservable`, `Calificable`

### Clase Gestora
- **`SistemaReservas`**: Gestiona el catálogo de productos con métodos polimórficos y 3 sobrecargas para búsqueda.

---

## Características Principales

### Polimorfismo
- El sistema trabaja con referencias de tipo `ProductoAgencia` que apuntan a objetos de tipos concretos.
- Los métodos `calcularPrecioFinal()` se resuelven dinámicamente según el tipo real del objeto.

### Implementación Múltiple
- `PaquetePremium` implementa las 3 interfaces disponibles.
- Otras clases implementan subconjuntos según su funcionalidad específica.

### Sobrecarga de Métodos
- `SistemaReservas` incluye 3 versiones sobrecargadas del método de búsqueda.

### Principios SOLID
- **SRP**: Cada clase tiene una responsabilidad única y bien definida.
- **OCP**: El sistema es extensible sin modificar código existente.
- **LSP**: Las subclases pueden sustituir a la clase abstracta sin problemas.
- **ISP**: Las interfaces son pequeñas y específicas.
- **DIP**: Las dependencias apuntan a abstracciones, no a implementaciones concretas.

---

## Ejemplo de Uso

``` java
// Crear productos
ProductoAgencia paquete = new PaquetePremium("Caribe Todo Incluido", 2500.0, 7);
ProductoAgencia transporte = new ReservaTransporte("Traslado Aeropuerto", 150.0, "SUV");
ProductoAgencia excursion = new ExcursionGuiada("Tour Ciudad Perdida", 450.0, "Sierra Nevada");

// Agregar al sistema
SistemaReservas sistema = new SistemaReservas();
sistema.agregarProducto(paquete);
sistema.agregarProducto(transporte);
sistema.agregarProducto(excursion);

// Realizar reservas
if (paquete instanceof Reservable) {
    ((Reservable) paquete).realizarReserva(LocalDate.now());
}

// Agregar calificaciones
if (paquete instanceof Calificable) {
    ((Calificable) paquete).agregarCalificacion(5);
}

// Aplicar descuentos
if (paquete instanceof Descuentable) {
    ((Descuentable) paquete).aplicarDescuento(10.0);
}
```

---

## Documentación Adicional

Para un análisis técnico detallado del diseño, incluyendo:
- Identificación de abstracciones
- Justificación de decisiones de diseño
- Aplicación de principios SOLID
- Diagramas de clases
- Desafíos y soluciones

Consulta el archivo **`ANALISIS.md`** en este mismo directorio.

---

## Estado

**Semana completada**
