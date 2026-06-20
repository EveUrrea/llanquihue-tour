# Llanquihue Tour App

Proyecto Java desarrollado para la actividad de la Semana 5 de Desarrollo Orientado a Objetos I.

## Descripción

Llanquihue Tour App es una aplicación desarrollada en Java que permite cargar información de tours turísticos desde un archivo de texto, almacenarla en una colección ArrayList y realizar distintas operaciones sobre los datos.

La aplicación permite:

- Cargar tours desde un archivo externo.
- Mostrar todos los tours registrados.
- Filtrar tours según su precio.
- Buscar tours por tipo.
- Aplicar principios de Programación Orientada a Objetos mediante encapsulamiento y modularización.

## Estructura de carpetas

```
LlanquihueTourApp/
│
├── src/
│   ├── model/
│   │   └── Tour.java
│   │
│   ├── data/
│   │   └── GestorDatos.java
│   │
│   ├── service/
│   │   └── TourService.java
│   │
│   └── ui/
│       └── Main.java
│
├── resources/
│   └── tours.txt
│
└── README.md
```

## Clases implementadas

### Tour.java

Representa un tour turístico.

Contiene:

- nombre
- tipo
- precio

Incluye:

- Constructores
- Getters y Setters
- Método toString()

### GestorDatos.java

Responsable de leer el archivo tours.txt y cargar los datos en una colección ArrayList.

Incluye manejo básico de errores mediante try-catch.

### TourService.java

Contiene la lógica de negocio de la aplicación.

Permite:

- Mostrar todos los tours.
- Filtrar tours sobre un determinado precio.
- Buscar tours por tipo.

### Main.java

Clase principal encargada de ejecutar la aplicación.

## Tecnologías utilizadas

- Java
- IntelliJ IDEA
- GitHub

## Cómo ejecutar

1. Abrir el proyecto en IntelliJ IDEA.
2. Verificar que el archivo `tours.txt` se encuentre dentro de la carpeta `resources`.
3. Ejecutar la clase `Main.java`.
4. Revisar la salida por consola.

## Funcionalidades demostradas

- Lectura de archivos.
- Uso de ArrayList.
- Encapsulamiento.
- Organización en paquetes.
- Filtro de datos.
- Búsqueda de registros.
- Manejo básico de excepciones.