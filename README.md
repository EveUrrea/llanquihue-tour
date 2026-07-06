# LlanquihueTourApp

Proyecto desarrollado para la asignatura **Desarrollo Orientado a Objetos I** de Duoc UC.

Esta aplicación simula un sistema para la agencia turística **Llanquihue Tour**, aplicando los principios de Programación Orientada a Objetos vistos durante las semanas 6 y 7.

---

# Funcionalidades implementadas

## Semana 6

- Lectura de información desde el archivo `tours.txt`.
- Uso de `ArrayList` para almacenar tours.
- Encapsulamiento.
- Herencia simple.
- Uso de `super()` en los constructores.
- Validación de datos.
- Organización del proyecto mediante paquetes.
- Búsqueda de tours por tipo.
- Visualización de tours.
- Visualización de tours con valor superior a un monto determinado.

---

## Semana 7

Se incorporó una jerarquía de servicios turísticos utilizando polimorfismo.

### Clases implementadas

- ServicioTuristico
- RutaGastronomica
- PaseoLacustre
- ExcursionCultural

### Funcionalidades agregadas

- Implementación del método `mostrarInformacion()`.
- Sobrescritura de métodos mediante `@Override`.
- Uso de una colección `List<ServicioTuristico>`.
- Gestión de distintos tipos de servicios turísticos en una misma colección.
- Recorrido de la colección utilizando un bucle **for-each**.
- Aplicación de polimorfismo invocando el método `mostrarInformacion()` desde referencias de la superclase.

---

# Estructura del proyecto

```
src
│
├── data
│   ├── GestorDatos
│   └── GestorServicios
│
├── model
│   ├── Tour
│   ├── ServicioTuristico
│   ├── RutaGastronomica
│   ├── PaseoLacustre
│   └── ExcursionCultural
│
├── service
│   └── TourService
│
└── ui
    └── Main
```

---

# Requisitos

- Java JDK 17 o superior.
- IntelliJ IDEA (recomendado).

---

# Cómo ejecutar

1. Clonar o descargar el proyecto.
2. Verificar que el archivo **tours.txt** se encuentre dentro de la carpeta **resources**.
3. Ejecutar la clase **Main.java**.
4. Revisar la salida por consola.

---

# Conceptos aplicados

- Programación Orientada a Objetos.
- Encapsulamiento.
- Herencia.
- Polimorfismo.
- Sobrescritura de métodos.
- Colecciones (`List` y `ArrayList`).
- Organización por paquetes.
- Validación de datos.
- Manejo básico de excepciones.

---

# Autor

**Evelyn Urrea**

Actividad Semanas 6 y 7 – Desarrollo Orientado a Objetos I

Duoc UC