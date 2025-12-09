# Semana 08 – Colecciones y Programación Genérica

**Dominio:** Agencia de Viajes "Destinos Mágicos"  
**Estudiante:** Javier Esteban Pérez Aldana  
**Ficha:** 3228973B  
**Semana:** 08

---

##  Resumen

Esta entrega añade funcionalidades avanzadas de colección y programación genérica al sistema de la agencia de viajes:

-  Migración completa a `ArrayList<E>` (sin arrays primitivos)
-  Búsqueda rápida con `HashMap<K,V>`
-  Agrupamiento con `Map<K,List<V>>`
-  Operaciones de filtrado y estadísticas
-  Menú interactivo en `MainS8`

Las clases nuevas tienen sufijo `S8` para evitar colisiones con semanas anteriores y mantener compatibilidad.

---

##  Objetivos de la Semana

- Dominar el uso de colecciones del framework de Java
- Implementar programación genérica con `<T>` y wildcards
- Aplicar operaciones de búsqueda, filtrado y agrupación
- Eliminar completamente el uso de arrays primitivos
- Crear un sistema robusto con manejo de excepciones

---

## Estructura del Proyecto

```
semana-08/
├── README.md
└── src/
    └── com/
        └── agencia/
            └── sem08/
                ├── modelo/
                │   ├── PaqueteS8.java
                │   └── AgenciaS8.java
                ├── servicio/
                │   └── GestorDatosS8.java
                ├── excepciones/
                │   └── DatosNoEncontradosException.java
                ├── util/
                │   └── Validador.java
                └── MainS8.java
```

---

## Descripción de Componentes

### Paquete `modelo`

#### `PaqueteS8.java`

Representa un paquete turístico con todas sus características.

``` java
package com.agencia.sem08.modelo;

public class PaqueteS8 {
    private String codigo;
    private String nombre;
    private String destino;
    private int duracionDias;
    private double precio;
    private String categoria; // "economico", "premium", "lujo"
    
    public PaqueteS8(String codigo, String nombre, String destino, 
                     int duracionDias, double precio, String categoria) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.destino = destino;
        this.duracionDias = duracionDias;
        this.precio = precio;
        this.categoria = categoria;
    }
    
    // Getters y setters
    
    @Override
    public String toString() {
        return String.format("[%s] %s - %s (%d días) - $%.2f - Cat: %s",
            codigo, nombre, destino, duracionDias, precio, categoria);
    }
}
```

---

#### `AgenciaS8.java`

Gestiona colecciones de paquetes usando `ArrayList`.

``` java
package com.agencia.sem08.modelo;

import java.util.ArrayList;
import java.util.List;

public class AgenciaS8 {
    private String nombre;
    private List<PaqueteS8> paquetes;
    
    public AgenciaS8(String nombre) {
        this.nombre = nombre;
        this.paquetes = new ArrayList<>();
    }
    
    public void agregarPaquete(PaqueteS8 paquete) {
        paquetes.add(paquete);
    }
    
    public boolean eliminarPaquete(String codigo) {
        return paquetes.removeIf(p -> p.getCodigo().equals(codigo));
    }
    
    public List<PaqueteS8> obtenerTodos() {
        return new ArrayList<>(paquetes); // Copia defensiva
    }
    
    public int contarPaquetes() {
        return paquetes.size();
    }
    
```

---

###  Paquete `servicio`

#### `GestorDatosS8.java`

Clase genérica que proporciona operaciones avanzadas con colecciones.

``` java
package com.agencia.sem08.servicio;

import com.agencia.sem08.modelo.PaqueteS8;
import com.agencia.sem08.excepciones.DatosNoEncontradosException;
import java.util.*;
import java.util.stream.Collectors;

public class GestorDatosS8<T> {
    
    // ============== OPERACIONES CON HASHMAP ==============
    
    private Map<String, PaqueteS8> cachePaquetes = new HashMap<>();
    
    /**
     * Indexa paquetes por código para búsqueda rápida O(1)
     */
    public void indexarPaquetes(List<PaqueteS8> paquetes) {
        cachePaquetes.clear();
        for (PaqueteS8 paquete : paquetes) {
            cachePaquetes.put(paquete.getCodigo(), paquete);
        }
        System.out.println("✓ Indexados " + paquetes.size() + " paquetes");
    }
    
    /**
     * Busca un paquete por código en O(1)
     */
    public PaqueteS8 buscarPorCodigo(String codigo) 
            throws DatosNoEncontradosException {
        PaqueteS8 paquete = cachePaquetes.get(codigo);
        if (paquete == null) {
            throw new DatosNoEncontradosException(
                "No se encontró paquete con código: " + codigo
            );
        }
        return paquete;
    }
    
    // ============== FILTRADO Y BÚSQUEDA ==============
    
    /**
     * Filtra paquetes por rango de precio
     */
    public List<PaqueteS8> filtrarPorPrecio(List<PaqueteS8> paquetes, 
                                             double precioMin, 
                                             double precioMax) {
        List<PaqueteS8> resultado = new ArrayList<>();
        for (PaqueteS8 p : paquetes) {
            if (p.getPrecio() >= precioMin && p.getPrecio() <= precioMax) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    /**
     * Busca paquetes por destino (búsqueda parcial)
     */
    public List<PaqueteS8> buscarPorDestino(List<PaqueteS8> paquetes, 
                                             String destinoBuscado) {
        List<PaqueteS8> resultado = new ArrayList<>();
        for (PaqueteS8 p : paquetes) {
            if (p.getDestino().toLowerCase()
                    .contains(destinoBuscado.toLowerCase())) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    /**
     * Filtra por categoría exacta
     */
    public List<PaqueteS8> filtrarPorCategoria(List<PaqueteS8> paquetes, 
                                                String categoria) {
        List<PaqueteS8> resultado = new ArrayList<>();
        for (PaqueteS8 p : paquetes) {
            if (p.getCategoria().equalsIgnoreCase(categoria)) {
                resultado.add(p);
            }
        }
        return resultado;
    }
    
    // ============== AGRUPAMIENTO ==============
    
    /**
     * Agrupa paquetes por destino
     * Retorna Map<Destino, List<PaqueteS8>>
     */
    public Map<String, List<PaqueteS8>> agruparPorDestino(
            List<PaqueteS8> paquetes) {
        Map<String, List<PaqueteS8>> grupos = new HashMap<>();
        
        for (PaqueteS8 paquete : paquetes) {
            String destino = paquete.getDestino();
            
            // Si no existe el destino, crear nueva lista
            if (!grupos.containsKey(destino)) {
                grupos.put(destino, new ArrayList<>());
            }
            
            // Agregar paquete al grupo
            grupos.get(destino).add(paquete);
        }
        
        return grupos;
    }
    
    /**
     * Agrupa paquetes por categoría
     */
    public Map<String, List<PaqueteS8>> agruparPorCategoria(
            List<PaqueteS8> paquetes) {
        Map<String, List<PaqueteS8>> grupos = new HashMap<>();
        
        for (PaqueteS8 paquete : paquetes) {
            String categoria = paquete.getCategoria();
            grupos.computeIfAbsent(categoria, k -> new ArrayList<>())
                  .add(paquete);
        }
        
        return grupos;
    }
    
    // ============== ESTADÍSTICAS ==============
    
    /**
     * Calcula el precio promedio
     */
    public double calcularPrecioPromedio(List<PaqueteS8> paquetes) {
        if (paquetes.isEmpty()) return 0.0;
        
        double suma = 0;
        for (PaqueteS8 p : paquetes) {
            suma += p.getPrecio();
        }
        return suma / paquetes.size();
    }
    
    /**
     * Encuentra el paquete más caro
     */
    public PaqueteS8 encontrarMasCaro(List<PaqueteS8> paquetes) 
            throws DatosNoEncontradosException {
        if (paquetes.isEmpty()) {
            throw new DatosNoEncontradosException("Lista de paquetes vacía");
        }
        
        PaqueteS8 masCaro = paquetes.get(0);
        for (PaqueteS8 p : paquetes) {
            if (p.getPrecio() > masCaro.getPrecio()) {
                masCaro = p;
            }
        }
        return masCaro;
    }
    
    /**
     * Encuentra el paquete más económico
     */
    public PaqueteS8 encontrarMasEconomico(List<PaqueteS8> paquetes) 
            throws DatosNoEncontradosException {
        if (paquetes.isEmpty()) {
            throw new DatosNoEncontradosException("Lista de paquetes vacía");
        }
        
        PaqueteS8 masEconomico = paquetes.get(0);
        for (PaqueteS8 p : paquetes) {
            if (p.getPrecio() < masEconomico.getPrecio()) {
                masEconomico = p;
            }
        }
        return masEconomico;
    }
    
    /**
     * Cuenta paquetes por categoría
     */
    public Map<String, Integer> contarPorCategoria(List<PaqueteS8> paquetes) {
        Map<String, Integer> conteo = new HashMap<>();
        
        for (PaqueteS8 p : paquetes) {
            String cat = p.getCategoria();
            conteo.put(cat, conteo.getOrDefault(cat, 0) + 1);
        }
        
        return conteo;
    }
}
```

---

###  Paquete `excepciones`

#### `DatosNoEncontradosException.java`

``` java
package com.agencia.sem08.excepciones;

public class DatosNoEncontradosException extends Exception {
    public DatosNoEncontradosException(String mensaje) {
        super(mensaje);
    }
}
```

---

###  Paquete `util`

#### `Validador.java`

``` java
package com.agencia.sem08.util;

public class Validador {
    
    public static boolean validarCodigo(String codigo) {
        return codigo != null && !codigo.trim().isEmpty() && 
               codigo.matches("[A-Z]{2}\\d{3}");
    }
    
    public static boolean validarPrecio(double precio) {
        return precio > 0;
    }
    
    public static boolean validarDuracion(int dias) {
        return dias > 0 && dias <= 365;
    }
    
    public static boolean validarCategoria(String categoria) {
        return categoria != null && 
               (categoria.equalsIgnoreCase("economico") ||
                categoria.equalsIgnoreCase("premium") ||
                categoria.equalsIgnoreCase("lujo"));
    }
}
```

---

###  `MainS8.java`

``` java
package com.agencia.sem08;

import com.agencia.sem08.modelo.*;
import com.agencia.sem08.servicio.GestorDatosS8;
import com.agencia.sem08.excepciones.DatosNoEncontradosException;
import java.util.*;

public class MainS8 {
    public static void main(String[] args) {
        System.out.println("=== Agencia Destinos Mágicos - Semana 08 ===");
        System.out.println("Colecciones y Programación Genérica\n");
        
        // Crear agencia
        AgenciaS8 agencia = new AgenciaS8("Destinos Mágicos");
        
        // Crear paquetes de prueba
        crearPaquetesPrueba(agencia);
        
        // Crear gestor
        GestorDatosS8<PaqueteS8> gestor = new GestorDatosS8<>();
        
        // Menú interactivo
        Scanner sc = new Scanner(System.in);
        int opcion;
        
        do {
            mostrarMenu();
            opcion = sc.nextInt();
            sc.nextLine(); // Consumir salto de línea
            
            procesarOpcion(opcion, agencia, gestor, sc);
            
        } while (opcion != 0);
        
        System.out.println("\n¡Hasta pronto!");
        sc.close();
    }
    
    private static void mostrarMenu() {
        System.out.println("\n=== MENÚ PRINCIPAL ===");
        System.out.println("1. Listar todos los paquetes");
        System.out.println("2. Buscar por código (HashMap)");
        System.out.println("3. Filtrar por rango de precio");
        System.out.println("4. Buscar por destino");
        System.out.println("5. Agrupar por destino");
        System.out.println("6. Agrupar por categoría");
        System.out.println("7. Ver estadísticas");
        System.out.println("0. Salir");
        System.out.print("Opción: ");
    }
    
    private static void procesarOpcion(int opcion, AgenciaS8 agencia, 
                                       GestorDatosS8<PaqueteS8> gestor, 
                                       Scanner sc) {
        List<PaqueteS8> paquetes = agencia.obtenerTodos();
        
        try {
            switch (opcion) {
                case 1:
                    listarPaquetes(paquetes);
                    break;
                case 2:
                    buscarPorCodigo(gestor, paquetes, sc);
                    break;
                case 3:
                    filtrarPorPrecio(gestor, paquetes, sc);
                    break;
                case 4:
                    buscarPorDestino(gestor, paquetes, sc);
                    break;
                case 5:
                    agruparPorDestino(gestor, paquetes);
                    break;
                case 6:
                    agruparPorCategoria(gestor, paquetes);
                    break;
                case 7:
                    mostrarEstadisticas(gestor, paquetes);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("✗ Opción inválida");
            }
        } catch (DatosNoEncontradosException e) {
            System.out.println("✗ Error: " + e.getMessage());
        }
    }
    

---

##  Funcionalidades Implementadas

### 1. Gestión con ArrayList
- Agregar/eliminar paquetes dinámicamente
- Búsqueda lineal O(n)
- Copia defensiva para seguridad

### 2. Indexación con HashMap
- Búsqueda por código en O(1)
- Cache de paquetes para acceso rápido
- Manejo de colisiones automático

### 3. Filtrado Avanzado
- Por rango de precio
- Por destino (búsqueda parcial)
- Por categoría exacta

### 4. Agrupamiento
- Por destino: `Map<String, List<PaqueteS8>>`
- Por categoría: `Map<String, List<PaqueteS8>>`
- Conteo por categoría: `Map<String, Integer>`

### 5. Estadísticas
- Precio promedio
- Paquete más caro
- Paquete más económico
- Distribución por categoría

---

---

## ✔ Estado

**Semana completada** - Sistema robusto con colecciones y programación genérica implementado.