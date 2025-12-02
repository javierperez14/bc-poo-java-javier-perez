# Semana 02 - Clases, Objetos y Relaciones

**Dominio:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez  
**Ficha:** 3228973B  
**Repositorio:** bc-poo-java-3228973B-perez

---

## Descripción General

En esta semana se ampliaron las bases del paradigma orientado a objetos creando nuevas clases, estableciendo relaciones entre ellas (composición y agregación) y utilizando estructuras de datos como `ArrayList` para gestionar colecciones de objetos.

Todo el desarrollo está basado en el dominio asignado:  
**Agencia de Viajes – Destinos Mágicos**, ubicada en Bogotá y dedicada a ofrecer paquetes turísticos, reservas y asesorías.

---

## Objetivos de la Semana

- Crear nuevas clases relacionadas con el dominio
- Implementar constructores, getters y setters
- Establecer relaciones entre objetos (co.edu.sena.semanas.Semana2.Cliente → co.edu.sena.semanas.Semana2.Reserva → co.edu.sena.semanas.Semana2.Destino)
- Utilizar `ArrayList` dentro de una clase gestora
- Construir una clase `co.edu.sena.semanas.Semana2.Main2` funcional que integre todas las piezas del sistema

---

## Ejercicio 1 — Nuevas Clases

Se crearon dos nuevas clases:

### Clase `co.edu.sena.semanas.Semana2.Cliente`

Contiene información básica del usuario que realiza reservas:

- `nombre`
- `correo`
- `telefono`

Incluye:

- Constructor
- Getters y setters
- Método de negocio: `obtenerInformacion()`

---

### Clase `co.edu.sena.semanas.Semana2.Destino`

Representa un destino turístico ofrecido por la agencia:

- `ciudad`
- `pais`
- `costoPromedio`
- `temporada`

Incluye:

- Constructor
- Getters y setters
- Método de negocio: `informacionDestino()`

---

## Ejercicio 2 — Relaciones entre Objetos

Se creó la clase `co.edu.sena.semanas.Semana2.Reserva`, que relaciona un **co.edu.sena.semanas.Semana2.Cliente** con un **co.edu.sena.semanas.Semana2.Destino**.

Incluye:

- co.edu.sena.semanas.Semana2.Cliente asociado
- co.edu.sena.semanas.Semana2.Destino seleccionado
- Fecha de viaje
- Número de pasajeros
- Método de negocio: `calcularTotal()`
- Método `obtenerResumen()` para mostrar información formateada

---

## Ejercicio 3 — Uso de ArrayList

Se implementó la clase gestora `co.edu.sena.semanas.Semana2.AgenciaViajes`, que maneja una lista de reservas:

**Métodos principales:**

- `agregarReserva(co.edu.sena.semanas.Semana2.Reserva r)`
- `mostrarTodasReservas()`
- `contarReservas()`

Esta clase permite a la agencia administrar múltiples reservas durante la ejecución del programa.

---

## Ejercicio 4 — Clase co.edu.sena.semanas.Semana2.Main2

En `co.edu.sena.semanas.Semana2.Main2.java` se instancian:

- 2 clientes
- 2 destinos
- 2 reservas
- 1 agencia

Luego se agregan las reservas a la agencia y se imprimen todos los resultados en consola.

---

## Estructura del Proyecto

```
semana-02/
├── README.md
├── co.edu.sena.semanas.Semana2.Cliente.java
├── co.edu.sena.semanas.Semana2.Destino.java
├── co.edu.sena.semanas.Semana2.Reserva.java
├── co.edu.sena.semanas.Semana2.AgenciaViajes.java
└── co.edu.sena.semanas.Semana2.Main2.java
```

---

## Ejecución Esperada

Al ejecutar `co.edu.sena.semanas.Semana2.Main2.java`, la salida aproximada será:

```
=== Reservas Registradas en Destinos Mágicos ===

Javier Esteban Perez reservó viaje a Cartagena el día 2025-12-15 para 2 pasajeros.
Total: $1700000.0

Laura Gómez reservó viaje a Cancún el día 2026-01-10 para 3 pasajeros.
Total: $13500000.0

Total Reservas: 2
```

---

## Nota del Estudiante

Este ejercicio fortalece la comprensión de:

- Cómo modelar un dominio real usando POO
- Cómo conectar objetos entre sí
- Cómo manejar colecciones dinámicas como ArrayList
- Cómo dividir un proyecto en múltiples clases organizadas

---

## Estado

**Semana completada.**


