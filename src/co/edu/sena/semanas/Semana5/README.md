# Semana 05 – Sobrecarga, Sobrescritura y Polimorfismo

**Dominio:** Servicios Turísticos - Agencia "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## Descripción

Esta semana desarrollamos un sistema especializado en la gestión de servicios turísticos, aplicando conceptos avanzados de Programación Orientada a Objetos.

**Conceptos aplicados:**

- ✔ Herencia entre clases
- ✔ Sobrescritura de métodos (@Override)
- ✔ Sobrecarga (overloading)
- ✔ Polimorfismo dinámico
- ✔ Colecciones polimórficas (`ArrayList<ServicioBase>`)
- ✔ Clase Gestora (`GestorServiciosTuristicos`)
- ✔ Documento de análisis (`POLIMORFISMO.md`)

---

## Objetivos

- Implementar herencia con una clase base y múltiples subclases
- Aplicar sobrescritura de métodos con `@Override`
- Crear métodos sobrecargados en la clase gestora
- Demostrar polimorfismo dinámico en colecciones
- Documentar los conceptos aplicados en un archivo dedicado

---

## Estructura del Proyecto

```
semana-05/
├── README.md
├── ServicioBase.java
├── Alojamiento.java
├── Transporte.java
├── Guianza.java
├── GestorServiciosTuristicos.java
├── Main.java
└── POLIMORFISMO.md
```

---

## Descripción de las Clases

### `ServicioBase.java` (Clase Padre)

Clase abstracta o base que representa un servicio turístico genérico.

**Atributos:**
- `protected String nombre`
- `protected double precio`

**Métodos:**
- `obtenerDescripcion()` - Método para sobrescribir en subclases
- `calcularPrecioFinal()` - Lógica base de cálculo
- Getters y setters

---

### `Alojamiento.java` (Subclase)

Representa servicios de hospedaje.

**Atributos específicos:**
- `int cantidadNoches` - Número de noches de estadía

**Método sobrescrito:**
- `obtenerDescripcion()` - Incluye información sobre las noches

---

### `Transporte.java` (Subclase)

Representa servicios de transporte.

**Atributos específicos:**
- `String tipoTransporte` - Tipo de vehículo (bus, avión, taxi, etc.)

**Método sobrescrito:**
- `obtenerDescripcion()` - Incluye el tipo de transporte

---

### `Guianza.java` (Subclase)

Representa servicios de guía turístico.

**Atributos específicos:**
- `String idioma` - Idioma en que se ofrece el tour

**Método sobrescrito:**
- `obtenerDescripcion()` - Incluye el idioma del servicio

---

### `GestorServiciosTuristicos.java` (Clase Gestora)

Administra una colección de servicios turísticos.

**Atributos:**
- `ArrayList<ServicioBase> servicios` - Lista polimórfica de servicios

**Métodos sobrecargados:**
- `agregarServicio(String nombre, double precio)` - Servicio básico
- `agregarServicio(String nombre, double precio, int noches)` - Alojamiento
- `agregarServicio(String nombre, double precio, String detalle)` - Transporte o Guianza

**Otros métodos:**
- `listarServicios()` - Muestra todos los servicios
- `calcularTotal()` - Suma el costo de todos los servicios
- `contarServicios()` - Retorna la cantidad de servicios

---

### `Main5.java`

Programa principal que demuestra:
- Creación de servicios de diferentes tipos
- Uso de sobrecarga en el gestor
- Polimorfismo en la lista de servicios
- Ejecución dinámica de métodos sobrescritos

---

---

## Salida Esperada

```
=== Gestor de Servicios Turísticos - Destinos Mágicos ===

Servicio: Hotel Caribe Plaza
Descripción: Alojamiento por 3 noches
Precio: $450000.0

Servicio: Vuelo Bogotá-Cartagena
Descripción: Transporte tipo: Avión
Precio: $320000.0

Servicio: Tour Centro Histórico
Descripción: Guianza en idioma: Español
Precio: $80000.0

------------------------------------------
Total de servicios: 3
Costo total: $850000.0
```

El programa lista los servicios turísticos demostrando **polimorfismo dinámico** y el uso correcto de **sobrecarga**.

---

## Conceptos Técnicos Aplicados

### 1. Herencia
- `ServicioBase` como clase padre
- Tres subclases especializadas que heredan comportamiento común

### 2. Sobrecarga (Overloading)
- Múltiples versiones de `agregarServicio()` con diferentes parámetros
- Permite agregar servicios de forma flexible sin instanciar manualmente

### 3. Sobrescritura (Overriding)
- Método `obtenerDescripcion()` personalizado en cada subclase
- Uso de `@Override` para validación en tiempo de compilación

### 4. Polimorfismo Dinámico
- Lista `ArrayList<ServicioBase>` conteniendo diferentes tipos
- Ejecución del método correcto según el tipo real del objeto
- Dynamic binding en tiempo de ejecución

### 5. Encapsulación
- Atributos `protected` accesibles en la jerarquía
- Métodos públicos para interacción externa

---

## Documentación Adicional

Consulta el archivo **`POLIMORFISMO.md`** para un análisis detallado de:
- Sobrecarga vs Sobrescritura
- Ejemplos de polimorfismo dinámico
- Tabla comparativa de métodos sobrescritos
- Beneficios del diseño implementado

---

## Estado

**Semana completada** 