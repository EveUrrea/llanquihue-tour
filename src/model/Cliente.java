package model;

import exception.RutInvalidoException;

/**
 * Representa a un cliente que puede contratar tours
 * y realizar reservas en la agencia.
 */
public class Cliente extends Persona {

    private String correo;

    public Cliente(
            String nombre,
            String rut,
            String telefono,
            Direccion direccion,
            String correo
    ) throws RutInvalidoException {

        super(nombre, rut, telefono, direccion);
        setCorreo(correo);
    }

    /**
     * Constructor sobrecargado para clientes sin correo informado.
     */
    public Cliente(
            String nombre,
            String rut,
            String telefono,
            Direccion direccion
    ) throws RutInvalidoException {

        this(nombre, rut, telefono, direccion, "No informado");
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        if (correo == null || correo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El correo no puede estar vacío."
            );
        }

        this.correo = correo.trim();
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Cliente: " + getNombre()
                        + " | RUT: " + getRut()
                        + " | Teléfono: " + getTelefono()
                        + " | Correo: " + correo
                        + " | Dirección: " + getDireccion()
        );
    }

    @Override
    public String toString() {
        return "Cliente{" +
                super.toString() +
                ", correo='" + correo + '\'' +
                '}';
    }
}
