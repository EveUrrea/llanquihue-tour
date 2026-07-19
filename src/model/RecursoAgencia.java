package model;

/**
 * Clase base para los recursos utilizados por la agencia.
 */
public abstract class RecursoAgencia implements Registrable {

    private String nombre;

    public RecursoAgencia(String nombre) {
        setNombre(nombre);
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

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'';
    }
}