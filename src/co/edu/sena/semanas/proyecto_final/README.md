# Proyecto Final: Sistema Agencia de Viajes - Destinos Mágicos

## Información del Estudiante
- **Nombre:** Javier Esteban Pérez Aldana
- **Ficha:** 3228973B
- **Dominio:** Agencia de Viajes "Destinos Mágicos"
- **Fecha de entrega:** [DD/MM/YYYY]

---

## Descripción del Sistema
Sistema de gestión para una agencia de viajes que permite administrar clientes, destinos y reservas.  
Incluye registro, búsqueda rápida por código (HashMap), listados, actualización y eliminación.  
Aplica principios de POO: encapsulación, herencia, abstracción, polimorfismo, excepciones y colecciones genéricas.

---

## Arquitectura del Proyecto

Paquete base: `co.edu.sena.semanas`

- `modelo/` → Entidades: `Persona`, `Cliente`, `Empleado`, `Destino` (abstracta), `DestinoNacional`, `DestinoInternacional`, `Reserva`, `Cotizable` (interface)
- `servicio/` → `GestorClientes`, `GestorDestinos`, `GestorReservas` (colecciones + HashMap)
- `excepciones/` → `ClienteNoEncontradoException`, `DestinoNoDisponibleException`, `ReservaInvalidaException`
- `util/` → `Validador`
- `Main.java` → Punto de entrada con menú interactivo

### Diagrama de Clases
`docs/diagrama-clases.svg`

---

## Aplicación de Conceptos POO

### Encapsulación
- Todos los atributos `private`.
- Validaciones en setters y constructores (mínimo 5 validaciones en el proyecto).

### Herencia
- Clase padre: `Persona`
- Hijos: `Cliente`, `Empleado`
- Uso de `super()` en constructores.

### Polimorfismo
- Clase abstracta `Destino` con método abstracto `calcularPrecio()`.
- Subclases sobrescriben `calcularPrecio()` con `@Override`.
- Ejemplo de sobrecarga: `GestorReservas.buscar(...)` métodos con diferentes firmas.

### Abstracción
- `Destino` es abstracta; `Cotizable` es una interfaz.

### Excepciones Personalizadas
1. `ClienteNoEncontradoException`: cuando se busca un cliente inexistente.
2. `DestinoNoDisponibleException`: cuando no hay cupos disponibles.
3. `ReservaInvalidaException`: datos de reserva inválidos.

### Colecciones
- `HashMap<String, Reserva>`: búsqueda por código O(1).
- `ArrayList<Reserva>`: historial y orden.
- `Map<String, List<Reserva>>`: agrupación por cliente.

---


