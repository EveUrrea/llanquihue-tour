# Llanquihue Tour App

Proyecto Java desarrollado para las actividades de las Semanas 5 y 6 de Desarrollo Orientado a Objetos I.

---

## Descripción

Llanquihue Tour App es una aplicación desarrollada en Java para gestionar información de tours y servicios turísticos de la agencia Llanquihue Tour.

Durante la Semana 5 se implementó la carga de tours desde un archivo de texto utilizando ArrayList, lectura de archivos y encapsulamiento.

Durante la Semana 6 se incorporó una jerarquía de clases mediante herencia simple para representar distintos tipos de servicios turísticos, reutilizando código y aplicando Programación Orientada a Objetos.

---

## Objetivo Semana 6

Implementar una jerarquía de clases utilizando herencia simple para representar distintos servicios turísticos de la agencia Llanquihue Tour, aplicando reutilización de código, sobrescritura del método `toString()` y uso de `super()` en los constructores.

---

## Estructura del proyecto

```
LlanquihueTourApp/

├── src/
│
├── model/
│   ├── Tour.java
│   ├── ServicioTuristico.java
│   ├── RutaGastronomica.java
│   ├── PaseoLacustre.java
│   └── ExcursionCultural.java
│
├── data/
│   ├── GestorDatos.java
│   └── GestorServicios.java
│
├── service/
│   └── TourService.java
│
├── ui/
│   └── Main.java
│
├── resources/
│   └── tours.txt
│
└── README.md
```

---

# Clases implementadas

## Tour.java

Representa un tour turístico.

Contiene:

- nombre
- tipo
- precio

Incluye:

- Constructor
- Getters y Setters
- Método `toString()`

---

## GestorDatos.java

Responsable de leer el archivo `tours.txt` y cargar los datos en un `ArrayList`.

Incluye manejo básico de excepciones mediante `try-catch`.

---

## TourService.java

Contiene la lógica de negocio de la aplicación.

Permite:

- Mostrar todos los tours.
- Filtrar tours por precio.
- Buscar tours por tipo.

---

## ServicioTuristico.java

Clase base de la jerarquía de servicios turísticos.

Contiene:

- nombre
- duracionHoras

Incluye:

- Constructor con validaciones.
- Getters.
- Método `toString()`.

---

## RutaGastronomica.java

Hereda de `ServicioTuristico`.

Atributo adicional:

- numeroDeParadas

Sobrescribe el método `toString()`.

---

## PaseoLacustre.java

Hereda de `ServicioTuristico`.

Atributo adicional:

- tipoEmbarcacion

Sobrescribe el método `toString()`.

---

## ExcursionCultural.java

Hereda de `ServicioTuristico`.

Atributo adicional:

- lugarHistorico

Sobrescribe el método `toString()`.

---

## GestorServicios.java

Clase encargada de crear las instancias de prueba de los servicios turísticos utilizados en la Semana 6.

---

## Main.java

Clase principal encargada de ejecutar la aplicación y mostrar los resultados por consola.

---

# Tecnologías utilizadas

- Java
- IntelliJ IDEA
- Git
- GitHub

---

# Cómo ejecutar

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el archivo `tours.txt` se encuentre dentro de la carpeta `resources`.
3. Ejecutar la clase `Main.java`.
4. Revisar la salida por consola.

---

# Funcionalidades demostradas

- Lectura de archivos.
- Uso de `ArrayList`.
- Encapsulamiento.
- Organización en paquetes.
- Herencia simple.
- Sobrescritura del método `toString()`.
- Uso de `super()` en los constructores.
- Validación de datos de entrada.
- Creación de objetos mediante una jerarquía de clases.
- Búsqueda y filtrado de información.
- Manejo básico de excepciones.

---

# Autor

**Evelyn Urrea**

Actividad Semana 6 – Desarrollo Orientado a Objetos I

Duoc UC