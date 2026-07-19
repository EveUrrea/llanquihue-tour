# Llanquihue Tour App

## Descripción general

Llanquihue Tour App es un prototipo de software desarrollado en Java para apoyar la digitalización de una agencia de turismo ubicada en la Región de Los Lagos.

El sistema permite registrar clientes, consultar tours disponibles, crear reservas y administrar diferentes entidades relacionadas con la agencia. El proyecto aplica los principales fundamentos de la Programación Orientada a Objetos y utiliza una interfaz gráfica desarrollada con Java Swing.

## Problemática abordada

La agencia Llanquihue Tour administra parte de su información mediante procesos manuales, lo que puede provocar datos duplicados, errores en las reservas y dificultades para consultar sus servicios.

Este prototipo permite:

- Organizar clientes y recursos de la agencia.
- Validar los datos ingresados.
- Consultar tours almacenados en un archivo externo.
- Crear reservas asociadas a clientes y tours.
- Calcular automáticamente el total de una reserva.
- Buscar, filtrar y ordenar la información.
- Evitar reservas que superen el cupo máximo del tour.

## Funcionalidades principales

### Gestión de clientes

- Registro de clientes mediante una interfaz gráfica.
- Validación de campos obligatorios.
- Validación del RUT chileno y su dígito verificador.
- Prevención de clientes duplicados.
- Búsqueda rápida de clientes por RUT.
- Asociación de una dirección a cada cliente.

### Gestión de tours

- Carga de tours desde el archivo externo `resources/tours.txt`.
- Visualización de todos los tours disponibles.
- Búsqueda de tours por nombre.
- Filtrado de tours con precio superior a $60.000.
- Ordenamiento de tours de menor a mayor precio.
- Control del cupo máximo de cada tour.

### Gestión de reservas

- Creación de reservas asociadas a un cliente registrado.
- Selección de tours cargados desde el archivo de datos.
- Validación de la cantidad de pasajeros.
- Cálculo automático del valor total.
- Consulta de la última reserva mediante una estructura `Stack`.
- Cancelación de la última reserva registrada.

## Principios de Programación Orientada a Objetos

El proyecto incorpora los siguientes principios:

- **Encapsulamiento:** los atributos son privados y se accede a ellos mediante métodos públicos.
- **Herencia:** se implementan jerarquías como `Persona → Cliente` y `Persona → Proveedor`.
- **Abstracción:** se utilizan las clases abstractas `Persona`, `RecursoAgencia` y `ServicioTuristico`.
- **Polimorfismo:** diferentes objetos son gestionados mediante la interfaz `Registrable`.
- **Interfaces:** `Registrable` define operaciones comunes para las entidades.
- **Composición:** una persona contiene una dirección y una reserva contiene un cliente y un tour.
- **Sobrescritura:** se utiliza `@Override` en métodos como `mostrarResumen()` y `toString()`.
- **Sobrecarga:** las clases `Cliente` y `Tour` poseen diferentes constructores.
- **Excepciones:** se utiliza `RutInvalidoException` para validar el RUT.
- **Genéricos:** el gestor permite filtrar entidades mediante un método genérico.

## Colecciones utilizadas

- `ArrayList<Registrable>` para almacenar entidades de manera polimórfica.
- `ArrayList<Tour>` para gestionar los tours cargados desde el archivo.
- `HashMap<String, Cliente>` para buscar clientes rápidamente por RUT.
- `Stack<Reserva>` para mantener el historial y consultar la última reserva.

## Estructura del proyecto

```text
LlanquihueTourApp
├── resources
│   └── tours.txt
├── src
│   ├── data
│   │   ├── GestorDatos.java
│   │   ├── GestorEntidades.java
│   │   └── GestorServicios.java
│   ├── exception
│   │   └── RutInvalidoException.java
│   ├── model
│   │   ├── Cliente.java
│   │   ├── ColaboradorExterno.java
│   │   ├── Direccion.java
│   │   ├── ExcursionCultural.java
│   │   ├── GuiaTuristico.java
│   │   ├── PaseoLacustre.java
│   │   ├── Persona.java
│   │   ├── Proveedor.java
│   │   ├── RecursoAgencia.java
│   │   ├── Registrable.java
│   │   ├── Reserva.java
│   │   ├── RutaGastronomica.java
│   │   ├── ServicioTuristico.java
│   │   ├── Tour.java
│   │   └── Vehiculo.java
│   ├── service
│   │   └── TourService.java
│   ├── ui
│   │   ├── InterfazGrafica.java
│   │   └── Main.java
│   └── utils
│       └── ValidadorRut.java
├── .gitignore
├── LlanquihueTourApp.iml
└── README.md
```

## Organización por paquetes

| Paquete | Responsabilidad |
|---|---|
| `model` | Contiene las entidades, jerarquías y relaciones del dominio. |
| `data` | Gestiona las colecciones y la lectura de archivos externos. |
| `service` | Contiene las operaciones de búsqueda, filtrado y ordenamiento. |
| `ui` | Contiene la interfaz gráfica y el punto de inicio del programa. |
| `utils` | Contiene herramientas reutilizables, como la validación de RUT. |
| `exception` | Contiene las excepciones personalizadas del sistema. |

## Formato del archivo de tours

Los tours se almacenan en `resources/tours.txt` utilizando el siguiente formato:

```text
nombre;tipo;precio;cupoMaximo
```

Ejemplo:

```text
Ruta de los Volcanes;Aventura;85000;15
```

## Requisitos

- Java 17 o una versión posterior.
- IntelliJ IDEA u otro entorno compatible con Java.
- Archivo `resources/tours.txt` incluido en la raíz del proyecto.

## Instrucciones para clonar y ejecutar

1. Clonar el repositorio:

```bash
git clone https://github.com/EveUrrea/llanquihue-tour.git
```

2. Abrir la carpeta `LlanquihueTourApp` en IntelliJ IDEA.
3. Esperar a que IntelliJ reconozca el proyecto y configure el JDK.
4. Verificar que exista el archivo `resources/tours.txt`.
5. Abrir la clase:

```text
src/ui/Main.java
```

6. Ejecutar el método `main`.
7. Utilizar las pestañas Clientes, Reservas y Tours.

## Datos de prueba

Para probar el sistema se puede registrar el siguiente cliente:

```text
Nombre: Camila Soto
RUT: 12.345.678-5
Teléfono: 987654321
Correo: camila.soto@gmail.com
Calle: Los Volcanes
Número: 125
Comuna: Llanquihue
```

Después de registrar el cliente, se puede utilizar el mismo RUT para crear una reserva.

## Autor

**Evelyn Urrea**  
Analista Programador Computacional  
Duoc UC