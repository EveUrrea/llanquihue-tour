package model;

/**
 * Representa un tour ofrecido por la agencia.
 */
public class Tour {

    private String nombre;
    private String tipo;
    private double precio;
    private int cupoMaximo;

    public Tour() {
        this.cupoMaximo = 20;
    }

    public Tour(String nombre, String tipo, double precio) {
        this(nombre, tipo, precio, 20);
    }

    /**
     * Constructor sobrecargado que permite indicar el cupo máximo.
     */
    public Tour(
            String nombre,
            String tipo,
            double precio,
            int cupoMaximo
    ) {

        setNombre(nombre);
        setTipo(tipo);
        setPrecio(precio);
        setCupoMaximo(cupoMaximo);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre del tour no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de tour no puede estar vacío."
            );
        }

        this.tipo = tipo.trim();
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            throw new IllegalArgumentException(
                    "El precio debe ser mayor que cero."
            );
        }

        this.precio = precio;
    }

    public int getCupoMaximo() {
        return cupoMaximo;
    }

    public void setCupoMaximo(int cupoMaximo) {
        if (cupoMaximo <= 0) {
            throw new IllegalArgumentException(
                    "El cupo máximo debe ser mayor que cero."
            );
        }

        this.cupoMaximo = cupoMaximo;
    }

    public boolean permiteCantidadPersonas(int cantidadPersonas) {
        return cantidadPersonas > 0
                && cantidadPersonas <= cupoMaximo;
    }

    @Override
    public String toString() {
        return nombre
                + " | Tipo: " + tipo
                + " | Precio: $" + String.format("%.0f", precio)
                + " | Cupo máximo: " + cupoMaximo;
    }
}
