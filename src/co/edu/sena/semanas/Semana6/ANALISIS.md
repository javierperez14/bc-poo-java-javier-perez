# Análisis de Diseño - Semana 06: ProductoAgencia (Destinos Mágicos)

**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B

---

## 1. Resumen ejecutivo
En la semana 06 se refactorizó y extendió el sistema de la agencia **Destinos Mágicos** para aplicar **abstracción** mediante una clase abstracta (`ProductoAgencia`) y **contratos** mediante interfaces (`Reservable`, `Calificable`, `Descuentable`). El objetivo fue mejorar la cohesión, permitir múltiples implementaciones de comportamientos transversales y preparar el sistema para extenderse sin modificar su núcleo (principio Open/Closed).

---

## 2. Identificación de abstracciones

### Clase abstracta: `ProductoAgencia`
**Descripción:** representa el concepto general de cualquier producto o servicio que ofrece la agencia (paquetes, traslados, excursiones, etc.).  
**Atributos principales (protegidos):**
- `nombre : String`
- `precioBase : double`

**Por qué es abstracta:**
- Comparte estado común (nombre y precioBase) entre todos los productos.
- Tiene comportamiento reutilizable (`obtenerInfo()`), pero requiere que cada subclase defina cómo calcular su precio final (`calcularPrecioFinal()`), por eso ese método es abstracto.
- Permite agrupar distintas implementaciones bajo una referencia común para explotar polimorfismo.

**Métodos:**
- `public String obtenerInfo()` — método concreto reutilizable para mostrar información base.
- `public abstract double calcularPrecioFinal()` — método abstracto que obliga a las subclases a implementar su lógica de precio.

**Subclases concretas implementadas:**
- `PaquetePremium` — paquete que incluye varios servicios, días y recargos.
- `ReservaTransporte` — traslado/vehículo (lancha, bus, privado) con recargos por tipo.
- `ExcursionGuiada` — tour guiado con idioma, cupo y precio por persona.

---

## 3. Interfaces diseñadas

### `Reservable`
**Capacidad:** gestionar disponibilidad y reservas por fecha.  
**Métodos:**
- `boolean verificarDisponibilidad(LocalDate fecha)`
- `String realizarReserva(String clienteNombre, LocalDate fecha)`
- `String obtenerCodigoReserva()`

**Clases que implementan:** `PaquetePremium`, `ReservaTransporte`, `ExcursionGuiada`

**Razonamiento:** la reserva es una capacidad que puede aplicar a diferentes tipos de producto; por tanto se modela como interfaz para permitir implementación múltiple.

---

### `Calificable`
**Capacidad:** almacenar y promediar calificaciones y comentarios.  
**Métodos:**
- `void agregarCalificacion(int estrellas, String comentario)`
- `double obtenerPromedioCalificaciones()`

**Clases que implementan:** `PaquetePremium`, `ExcursionGuiada`

**Razonamiento:** la calificación es una responsabilidad transversal (no todas las clases la necesitan), por eso es interfaz.

---

### `Descuentable`
**Capacidad:** validar elegibilidad a descuento y aplicar porcentajes.  
**Métodos:**
- `boolean esElegibleDescuento()`
- `double aplicarDescuento(double porcentaje)`

**Clases que implementan:** `PaquetePremium`, `ReservaTransporte`

**Razonamiento:** el descuento depende de reglas de negocio particulares; modelarlo por interfaz facilita aplicar la capacidad solo donde tenga sentido.

---

## 4. Decisiones de diseño (Clase abstracta vs Interface)
- **Clase abstracta (`ProductoAgencia`)** se eligió para compartir estado (atributos) y lógica concreta (`obtenerInfo()`), además de forzar la implementación de `calcularPrecioFinal()` en las subclases. Es adecuada cuando existe una relación "es-un" y se comparte estado.
- **Interfaces** se eligieron para modelar capacidades independientes de la jerarquía (reservar, calificar, aplicar descuento). Esto permite la **implementación múltiple** y evita forzar la jerarquía cuando sólo se necesita un contrato.

---

## 5. Principios SOLID aplicados

### Single Responsibility Principle (SRP)
- Cada clase tiene una única responsabilidad: `ProductoAgencia` define estado/contrato base; `PaquetePremium` gestiona lógica de paquete, reservas y calificaciones; `SistemaReservas` gestiona catálogo y búsquedas.

### Open/Closed Principle (OCP)
- El sistema está abierto a extensión (añadir `Crucero`, `AlquilerVehiculo`) sin modificar `SistemaReservas` ni `ProductoAgencia` — sólo se crean nuevas subclases que implementen métodos abstractos e interfaces.

### Liskov Substitution Principle (LSP)
- Las subclases (`PaquetePremium`, `ReservaTransporte`, `ExcursionGuiada`) pueden sustituir a `ProductoAgencia` sin alterar el comportamiento esperado (por ejemplo, `calcularPrecioFinal()` siempre devuelve un número válido).

### Interface Segregation Principle (ISP)
- Se definieron interfaces pequeñas y específicas (Reservable, Calificable, Descuentable) evitando una interfaz monolítica que obligue a implementar métodos innecesarios.

### Dependency Inversion Principle (DIP)
- `SistemaReservas` depende de la abstracción (`ProductoAgencia`, `Reservable`) y no de implementaciones concretas, lo que facilita pruebas y extensiones.

---

## 6. Análisis de requisitos funcionales y no funcionales (breve)
**Funcionales cubiertos en esta semana:**
- Gestión polimórfica del catálogo de productos.
- Reservas vía interfaz `Reservable`.
- Registro y cálculo de calificaciones.
- Aplicación de descuentos según reglas.

**No funcionales:**
- Diseño modular y extensible.
- Código con validaciones básicas en constructores.
- Facilidad para pruebas unitarias (clases pequeñas y desacopladas).

---

## 7. Implementación técnica (qué se entregó)
- `abstractas/ProductoAgencia.java` — clase abstracta con método concreto y abstracto.
- `interfaces/Reservable.java`, `Calificable.java`, `Descuentable.java` — contratos de capacidades.
- `implementaciones/PaquetePremium.java`, `ReservaTransporte.java`, `ExcursionGuiada.java` — implementaciones concretas; `PaquetePremium` implementa múltiples interfaces.
- `implementaciones/SistemaReservas.java` — gestor con métodos sobrecargados (buscar por nombre, rango precio, tipo) y métodos polimórficos (`reservar(Reservable...)`), además de mostrar catálogo.
- `Main.java` — demostración de polimorfismo, sobrecarga, reservas, calificaciones y descuentos.

---

## 8. Ejemplos de uso y comportamiento esperado
- Añadir productos al catálogo (polimorfismo): `agregarProducto(ProductoAgencia p)`.
- Buscar con sobrecarga:
    - `buscarProducto(String nombre)`
    - `buscarProducto(double min, double max)`
    - `buscarProductoPorTipo(Class<?> tipo)`
- Reservar a través de la interfaz `Reservable` (método polimórfico):
    - `reservar(Reservable r, String cliente, LocalDate fecha)`
- Calificar y aplicar descuento en objetos que implementen las interfaces correspondientes.

Salida esperada (resumen): el `Main` imprime el catálogo, realiza reservas mostrando códigos, muestra calificaciones promedio y aplica descuentos cuando corresponde.

---

## 9. Desafíos enfrentados y soluciones
**Desafío:** modelar reservas sin persistencia.  
**Solución:** uso de colecciones en memoria (`List<LocalDate> fechasReservadas`) y generación de códigos con UUID para ejemplificar el proceso.

**Desafío:** decidir qué comportamiento pertenece a la clase base vs interfaz.  
**Solución:** estado común y comportamiento reutilizable en la clase abstracta; capacidades independientes (reserva, calificación, descuento) en interfaces.

---

## 10. Pruebas realizadas (manuales)
- Compilar: `javac abstractas/*.java interfaces/*.java implementaciones/*.java Main.java`
- Ejecutar: `java Main`
- Verificar:
    - Catálogo muestra productos y precio final por cada tipo.
    - Reservas devuelven códigos únicos y bloquean la fecha reservada.
    - Calificaciones actualizan promedio.
    - Descuentos aplican sólo cuando la regla de elegibilidad se cumple.

---

## 11. Limitaciones y posibles mejoras
- **Persistencia:** usar base de datos o ficheros para guardar reservas y calificaciones.
- **Concurrencia:** control de reservas simultáneas (locking) para entornos reales.
- **Validaciones más ricas:** control por cliente, límites por fecha y capacidad real por fecha.
- **Separación de responsabilidades adicionales:** extraer la lógica de facturación a un servicio específico (ej. `Facturador`).
- **Tests automatizados:** añadir suite de JUnit para cubrir casos críticos.

---

## 12. Próximos pasos (priorizados)
1. Persistencia básica (archivo JSON o DB ligera).
2. Añadir control de cupos por fecha y por producto.
3. Interfaz de usuario simple (CLI o web) para crear reservas.
4. Refactor para inyección de dependencias (facilita testeo y DIP).
5. Documentación técnica adicional (API, contratos, ejemplos).

---

## 13. Conclusión
El refactor aplicado en la semana 06 sitúa al proyecto en un estado mucho más modular y preparado para crecer. Las decisiones de usar una clase abstracta para el estado común y las interfaces para capacidades transversales permiten añadir nuevos productos y comportamientos con mínima modificación del código existente, cumpliendo los objetivos pedagógicos de la semana y los principios SOLID.

---
