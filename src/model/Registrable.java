package model;

/**
 * Define las operaciones comunes para las entidades
 * que pueden ser registradas dentro del sistema.
 */
public interface Registrable {

    void mostrarResumen();

    default void registrar() {
        System.out.println(
                "Registro almacenado: "
                        + getClass().getSimpleName()
        );
    }

    default String obtenerTipoRegistro() {
        return getClass().getSimpleName();
    }
}