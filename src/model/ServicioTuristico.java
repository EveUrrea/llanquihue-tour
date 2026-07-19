package model;

/**
 * Clase base para los servicios turísticos
 * ofrecidos por Llanquihue Tour.
 */
public abstract class ServicioTuristico {

    private String nombre;
    private int duracionHoras;

    public ServicioTuristico(
            String nombre,
            int duracionHoras
    ) {

        setNombre(nombre);
        setDuracionHoras(duracionHoras);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El nombre no puede estar vacío."
            );
        }

        this.nombre = nombre.trim();
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    public void setDuracionHoras(int duracionHoras) {

        if (duracionHoras <= 0) {
            throw new IllegalArgumentException(
                    "La duración debe ser mayor que cero."
            );
        }

        this.duracionHoras = duracionHoras;
    }

    /**
     * Cada subclase debe implementar su propia forma
     * de mostrar la información.
     */
    public abstract void mostrarInformacion();

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", duracionHoras=" + duracionHoras;
    }
}