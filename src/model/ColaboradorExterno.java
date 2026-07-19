package model;

/**
 * Representa a un colaborador externo de la agencia.
 */
public class ColaboradorExterno extends RecursoAgencia {

    private String rol;

    public ColaboradorExterno(String nombre, String rol) {
        super(nombre);
        setRol(rol);
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {

        if (rol == null || rol.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El rol no puede estar vacío."
            );
        }

        this.rol = rol.trim();
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Colaborador: " + getNombre()
                        + " | Rol: " + rol
        );
    }

    @Override
    public String toString() {
        return "ColaboradorExterno{" +
                super.toString() +
                ", rol='" + rol + '\'' +
                '}';
    }
}