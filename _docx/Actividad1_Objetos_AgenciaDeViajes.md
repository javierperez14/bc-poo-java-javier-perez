##  Identificación de Objetos

### 1. Paquete Turístico
- **¿Qué es?**  
  Es un conjunto de servicios ofrecidos como un solo producto, que puede incluir transporte, hospedaje, alimentación y actividades turísticas.
- **Atributos:**  
  destino, duración, precio, tipo de alojamiento, servicios incluidos.
- **Comportamientos:**  
  calcular precio total, agregar servicios adicionales, mostrar información del paquete.

---

### 2. Cliente
- **¿Qué es?**  
  Persona que contrata o reserva los servicios ofrecidos por la agencia.
- **Atributos:**  
  nombre, número de documento, correo electrónico, teléfono, nacionalidad.
- **Comportamientos:**  
  reservar paquete, cancelar reserva, realizar pago.

---

### 3. Asesor de Viaje
- **¿Qué es?**  
  Empleado encargado de orientar y gestionar las solicitudes de los clientes.
- **Atributos:**  
  nombre, código de empleado, especialidad (nacional o internacional), número de ventas realizadas.
- **Comportamientos:**  
  atender cliente, ofrecer paquete, generar cotización personalizada.

---

### 4. Reserva
- **¿Qué es?**  
  Registro de la compra o solicitud de un paquete turístico por parte del cliente.
- **Atributos:**  
  número de reserva, fecha, cliente, paquete reservado, estado (confirmada, pendiente, cancelada).
- **Comportamientos:**  
  confirmar reserva, cancelar reserva, modificar datos de la reserva.

---

### 5. Vuelo
- **¿Qué es?**  
  Servicio aéreo contratado como parte del paquete turístico.
- **Atributos:**  
  aerolínea, número de vuelo, fecha, hora de salida, hora de llegada.
- **Comportamientos:**  
  verificar disponibilidad, actualizar horario, mostrar detalles del vuelo
