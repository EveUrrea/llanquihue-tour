package model;

import exception.RutInvalidoException;

/**
 * Representa a un proveedor externo que presta
 * servicios a la agencia Llanquihue Tour.
 */
public class Proveedor extends Persona {

    private String tipoServicio;

    public Proveedor(
            String nombre,
            String rut,
            String telefono,
            Direccion direccion,
            String tipoServicio
    ) throws RutInvalidoException {

        super(nombre, rut, telefono, direccion);
        setTipoServicio(tipoServicio);
    }

    public String getTipoServicio() {
        return tipoServicio;
    }

    public void setTipoServicio(String tipoServicio) {
        if (tipoServicio == null || tipoServicio.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de servicio no puede estar vacío."
            );
        }

        this.tipoServicio = tipoServicio.trim();
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Proveedor: " + getNombre()
                        + " | RUT: " + getRut()
                        + " | Servicio: " + tipoServicio
                        + " | Teléfono: " + getTelefono()
                        + " | Dirección: " + getDireccion()
        );
    }

    @Override
    public String toString() {
        return "Proveedor{" +
                super.toString() +
                ", tipoServicio='" + tipoServicio + '\'' +
                '}';
    }
}
