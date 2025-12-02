# Semana 03 – Encapsulación, Validaciones y Constructores

**Dominio:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## Descripción

En esta semana se implementan principios de **encapsulación**, **validaciones** y **sobrecarga de constructores** sobre nuevas clases del dominio de la agencia de viajes *Destinos Mágicos*. Se entregan dos clases nuevas representativas del negocio (PaqueteTuristico y Vendedor), junto con un `Main4` para probar su comportamiento y un documento `MEJORAS.md` que describe las mejoras aplicadas.

---

## Objetivos

- Aplicar encapsulación completa (atributos `private`, getters, setters con validaciones)
- Implementar **múltiples constructores** (sobrecarga) en cada clase
- Añadir validaciones en constructores y setters (strings no nulos, números positivos, rangos válidos)
- Documentar los cambios y beneficios en `MEJORAS.md`

---

## Estructura de la Carpeta `semana-03`

```
semana-03/
├── README.md
├── PaqueteTuristico.java
├── Vendedor.java
├── Main4.java
└── MEJORAS.md
```

---

## Descripción Breve de las Clases

### `PaqueteTuristico.java`

Representa un paquete de viaje ofrecido por la agencia.

**Atributos:**
- `nombrePaquete`
- `precioBase`
- `duracionDias`
- `incluyeHotel`

**Constructores:**
- Completo (todos los atributos)
- Básico (precio + nombre)
- Mínimo (solo nombre)

**Validaciones:**
- Nombre no vacío
- Precio > 0
- Duración > 0

**Método de negocio:**
- `calcularPrecioTotal()` - Aplica recargo si incluye hotel

---

### `Vendedor.java`

Representa a un asesor/vendedor de la agencia.

**Atributos:**
- `nombre`
- `documento`
- `ventasRealizadas`
- `comision`

**Constructores:**
- Completo (todos los atributos)
- Básico (ventas inicializadas en 0)
- Mínimo (documento autogenerado)

**Validaciones:**
- Nombre/documento no vacíos
- Ventas >= 0
- Comisión >= 0

**Método de negocio:**
- `calcularPagoComision()` - Calcula el pago basado en ventas y comisión

---




## Ejecución Esperada
```
salida al ejecutar `Main3`:
```

```
=== Paquetes Turísticos ===
Aventura en San Andrés - Total: 1500000.0
City Tour Bogotá - Total: 350000.0

=== Vendedor ===
Nombre: Carlos Ramírez
Pago por comisiones: 400000.0
```

---
## Conceptos Aplicados

- **Encapsulación:** Protección de datos mediante modificadores de acceso `private`
- **Validación:** Verificación de datos antes de asignarlos a los atributos
- **Sobrecarga de Constructores:** Múltiples formas de crear objetos según las necesidades
- **Cohesión:** Cada clase tiene una responsabilidad clara y bien definida
- **Métodos de Negocio:** Lógica específica del dominio encapsulada en las clases

---

## Documentación Adicional

Consulta el archivo `MEJORAS.md` para conocer en detalle:
- Cambios realizados respecto a semanas anteriores
- Beneficios de la encapsulación aplicada
- Justificación de las validaciones implementadas

---

## Estado

**Semana completada** 