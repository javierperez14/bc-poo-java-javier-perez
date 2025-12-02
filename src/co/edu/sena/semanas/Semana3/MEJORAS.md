# Mejoras – Semana 03

## Encapsulación Aplicada

### co.edu.sena.semanas.Semana3.PaqueteTuristico
- Atributos privados: nombrePaquete, precioBase, duracionDias, incluyeHotel
- Validaciones:
    - nombre no vacío
    - precio positivo
    - duración mínima 1 día
- Métodos privados: validarString()

### co.edu.sena.semanas.Semana3.Vendedor
- Atributos privados: nombre, documento, ventasRealizadas, comision
- Validaciones:
    - nombre y documento no vacíos
    - ventas >= 0
    - comisión >= 0
- Métodos privados: validarString(), generarDocumento()

---

## Constructores Sobrecargados

### co.edu.sena.semanas.Semana3.PaqueteTuristico
- Completo
- Precio base + nombre
- Solo nombre

### co.edu.sena.semanas.Semana3.Vendedor
- Completo
- Básico (ventas 0)
- Mínimo (documento autogenerado)

---

## Beneficios Logrados
- Datos protegidos mediante encapsulación
- Código más seguro con validaciones
- Flexibilidad al crear objetos
- Métodos privados que evitan duplicación
- Clases más profesionalmente estructuradas  
