# Jerarquía de Clases - Semana 04

**Dominio:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## Diagrama General

```
                    ServicioTuristico
                   (Clase Padre - Base)
                            |
           +----------------+----------------+
           |                |                |
      TourCiudad   PaqueteVacacional  TransporteAereo
     (Subclase)      (Subclase)        (Subclase)
```

---

## Justificación del Diseño

Se seleccionó esta jerarquía porque en una **agencia de viajes** existen múltiples tipos de servicios turísticos que comparten información en común:

- Nombre del servicio
- Código interno
- Costo base
- Descripción general

Sin embargo, **cada servicio calcula su costo final de una manera distinta**, lo cual hace que la herencia y el polimorfismo sean ideales para este caso.

### ¿Por qué usar Herencia?

1. **Evita duplicación de código** - Los atributos comunes se definen una sola vez
2. **Facilita el mantenimiento** - Los cambios en la clase padre se propagan automáticamente
3. **Representa la realidad** - Todos los servicios turísticos comparten características base
4. **Permite extensibilidad** - Agregar nuevos servicios es sencillo

---

## Atributos Heredados desde `ServicioTuristico`

Todos los servicios turísticos heredan estos atributos:

``` java
protected String nombreServicio;
protected String codigo;
protected double costoBase;
protected String descripcion;
```

**Modificador `protected`:**
- Permite que las subclases accedan directamente a estos atributos
- Mantiene encapsulación frente a otras clases externas
- Facilita la implementación de métodos específicos en subclases

---

## Métodos Sobrescritos

### `calcularCosto()`

Cada subclase aplica su propia regla de negocio para calcular el costo final:

---

### TourCiudad

**Modelo de negocio:** Cobra por horas de duración del tour

**Fórmula:**
``` java
costoTotal = costoBase + (duracionHoras * costoPorHora)
```

**Atributos específicos:**
- `int duracionHoras` - Duración del recorrido
- `double costoPorHora` - Tarifa por hora de guía

**Ejemplo:**
- Tour de 3 horas con costo base de $50,000 y $15,000 por hora
- Costo total: $50,000 + (3 × $15,000) = **$95,000**

---

### PaqueteVacacional

**Modelo de negocio:** Cobra por días y aplica descuentos por reservas largas

**Fórmula:**
``` java
costoTotal = (costoBase * cantidadDias) - descuento
```

**Atributos específicos:**
- `int cantidadDias` - Duración del paquete
- `double descuentoPorcentaje` - Porcentaje de descuento aplicable

**Ejemplo:**
- Paquete de 5 días a $800,000 por día con 10% de descuento
- Costo total: (5 × $800,000) - 10% = **$3,600,000**

---

### TransporteAereo

**Modelo de negocio:** Cobra recargos según temporada alta/baja

**Fórmula:**
``` java
costoTotal = tarifaBase + recargoTemporada
```

**Atributos específicos:**
- `double tarifaBase` - Precio base del tiquete
- `double recargoTemporada` - Recargo adicional por temporada

**Ejemplo:**
- Vuelo con tarifa base de $300,000 y recargo de $50,000
- Costo total: $300,000 + $50,000 = **$350,000**

---

## Polimorfismo en Acción

Este diseño demuestra **polimorfismo** efectivo:

``` java
// Array polimórfico - todos son ServicioTuristico
ServicioTuristico[] servicios = {
    new TourCiudad(...),
    new PaqueteVacacional(...),
    new TransporteAereo(...)
};

// Cada objeto ejecuta su propia implementación de calcularCosto()
for (ServicioTuristico servicio : servicios) {
    System.out.println("Costo: " + servicio.calcularCosto());
    // ↑ Llamada polimórfica - cada clase usa su propia lógica
}
```

**Ventaja:** El mismo método `calcularCosto()` produce resultados diferentes según el tipo real del objeto, pese a compartir la misma interfaz.

---

## ✔ Beneficios de esta Jerarquía

### 1. Código Organizado y Reutilizable
- Atributos comunes definidos una sola vez
- Lógica compartida en la clase padre
- Reducción de código duplicado

### 2. Fácil de Extender
Agregar un nuevo servicio turístico es simple:

``` java
public class ExcursionAventura extends ServicioTuristico {
    @Override
    public double calcularCosto() {
        // Lógica específica para excursiones
    }
}
```

### 3. Permite Polimorfismo
- Colecciones heterogéneas de servicios
- Procesamiento uniforme de diferentes tipos
- Flexibilidad en el diseño del sistema

### 4. Modelo Profesional
- Basado en un dominio real de negocio
- Representa fielmente la estructura de una agencia de viajes
- Escalable y mantenible a largo plazo

---

## Posibles Extensiones Futuras

Esta jerarquía puede expandirse fácilmente con:

- `Crucero` - Servicios de cruceros marítimos
- `SeguroViaje` - Seguros de viaje opcionales
- `AlquilerVehiculo` - Renta de autos o motos
- `GuiaTuristico` - Servicio de guía personalizado
- `ActividadAcuatica` - Deportes y actividades en el agua

Cada nueva clase solo necesita:
1. Extender `ServicioTuristico`
2. Definir atributos específicos
3. Sobrescribir `calcularCosto()` con su lógica propia

---

## Comparación de Cálculos

| Servicio | Costo Base | Factor Variable | Costo Final |
|----------|------------|-----------------|-------------|
| TourCiudad | $50,000 | 3 horas × $15,000 | $95,000 |
| PaqueteVacacional | $800,000 | 5 días - 10% | $3,600,000 |
| TransporteAereo | $300,000 | + $50,000 recargo | $350,000 |

---

## Conclusión

Esta jerarquía de clases demuestra cómo aplicar herencia y polimorfismo de manera efectiva en un contexto real. El diseño es:

- ✅ **Mantenible** - Fácil de modificar y actualizar
- ✅ **Escalable** - Soporta crecimiento futuro
- ✅ **Profesional** - Refleja buenas prácticas de POO
- ✅ **Práctico** - Aplicable a un negocio real