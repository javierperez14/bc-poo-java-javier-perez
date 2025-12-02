# Semana 04 - Herencia

**Dominio:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## Descripción

Esta semana trabajamos el concepto de **herencia en Java**, aplicado al dominio real del proyecto: **una agencia de viajes**.

El objetivo fue construir una jerarquía de clases donde exista una clase padre llamada `ServicioTuristico` y varias subclases que especializan su comportamiento.

---

## Objetivos

- Implementar herencia mediante la palabra clave `extends`
- Crear una clase padre con atributos y métodos heredables
- Desarrollar subclases especializadas que sobrescriban comportamientos
- Aplicar polimorfismo en el método `main`
- Demostrar reutilización de código y especialización

---

## Ejercicio 1: Clase Padre – `ServicioTuristico`

Se creó una clase base que representa un servicio turístico genérico dentro de una agencia de viajes.

**Incluye:**

- Atributos `protected`:
    - `nombre`
    - `descripcion`
    - `precioBase`
- Constructor completo
- Métodos heredables:
    - `mostrarInfo()` - Muestra información general del servicio
    - `calcularCosto()` - Calcula el costo (será sobrescrito por subclases)

---

## Ejercicio 2: Subclases

Se implementaron **tres subclases** especializadas:

### 1. `TourCiudad`

Representa un tour guiado por la ciudad.

**Atributos adicionales:**
- `duracionHoras` - Duración del tour
- `costoPorHora` - Tarifa por hora

**Método sobrescrito:**
- `calcularCosto()` - Precio base + (duración × costo por hora)

---

### 2. `PaqueteVacacional`

Representa un paquete de vacaciones con varios días.

**Atributos adicionales:**
- `cantidadDias` - Duración del paquete
- `descuentoPorcentaje` - Descuento aplicable

**Método sobrescrito:**
- `calcularCosto()` - Precio base × días - descuento automático

---

### 3. `TransporteAereo`

Representa un servicio de transporte aéreo.

**Atributos adicionales:**
- `tarifaBase` - Tarifa del vuelo
- `recargoTemporada` - Recargo según temporada alta/baja

**Método sobrescrito:**
- `calcularCosto()` - Tarifa base + recargo por temporada

---

## 🧩 Ejercicio 3: Implementación Correcta

✔ Uso correcto de `extends` para establecer herencia  
✔ Uso adecuado de `super()` en constructores  
✔ Atributos `protected` correctamente aplicados  
✔ Métodos sobrescritos con anotación `@Override`  
✔ Encapsulación mantenida en toda la jerarquía

---

## 🧩 Ejercicio 4: Polimorfismo en `Main.java`

El archivo `Main.java` demuestra:

- **Arreglos polimórficos** - Array de tipo `ServicioTuristico[]` conteniendo diferentes subclases
- **Uso dinámico de métodos sobrescritos** - Llamadas polimórficas a `calcularCosto()`
- **Impresión de costos** - Cálculo según el tipo real del objeto en tiempo de ejecución

**Ejemplo de código:**

``` java 
ServicioTuristico[] servicios = {
    new TourCiudad("Tour Centro Histórico", "...", 50000, 3, 15000),
    new PaqueteVacacional("Vacaciones Caribe", "...", 800000, 5, 10),
    new TransporteAereo("Vuelo Bogotá-Cartagena", "...", 300000, 50000)};

for (ServicioTuristico s : servicios) {
    s.mostrarInfo();
    System.out.println("Costo total: $" + s.calcularCosto());}

```

---

## Estructura Final del Proyecto

```
semana-04/
├── README.md
├── JERARQUIA.md
├── ServicioTuristico.java
├── TourCiudad.java
├── PaqueteVacacional.java
├── TransporteAereo.java
└── Main.java
```

---

## Ejecución Esperada

```
=== Servicios Turísticos - Destinos Mágicos ===

Tour: Tour Centro Histórico
Costo total: $95000.0

Paquete: Vacaciones Caribe
Costo total: $3600000.0

Transporte: Vuelo Bogotá-Cartagena
Costo total: $350000.0
```

---

## onceptos Aplicados

### Herencia
- Reutilización de código mediante la clase padre
- Especialización de comportamiento en subclases
- Jerarquía clara de clases

### Polimorfismo
- Referencias de tipo padre apuntando a objetos hijos
- Ejecución dinámica de métodos sobrescritos
- Flexibilidad en el manejo de colecciones heterogéneas

### Encapsulación
- Atributos `protected` accesibles solo en la jerarquía
- Métodos públicos para interacción externa
- Ocultamiento de implementación interna

---

## Documentación Adicional

Consulta el archivo `JERARQUIA.md` para:
- Diagrama visual de la jerarquía de clases
- Explicación detallada de las relaciones de herencia
- Justificación del diseño implementado

---

## Conclusión

La implementación permite demostrar claramente:

- **Reutilización de código** - Atributos y métodos comunes en la clase padre
- **Especialización mediante herencia** - Cada subclase adapta el comportamiento general
- **Comportamiento polimórfico** - Mismo método, diferentes implementaciones
- **Organización profesional del dominio** - Estructura clara y mantenible

---

## ✔ Estado

**Semana completada** 