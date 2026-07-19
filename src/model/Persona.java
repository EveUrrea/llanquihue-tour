package model;

import exception.RutInvalidoException;
import utils.ValidadorRut;

/**
 * Clase base para los distintos tipos de personas
 * relacionadas con la agencia de turismo.
 */
public abstract class Persona implements Registrable {

    private String nombre;
    private String rut;
    private String telefono;
    private Direccion direccion;

    public Persona(
            String nombre,
            String rut,
            String telefono,
            Direccion direccion
    ) throws RutInvalidoException {

        setNombre(nombre);
        setRut(rut);
        setTelefono(telefono);
        setDireccion(direccion);
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

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) throws RutInvalidoException {
        ValidadorRut.validar(rut);
        this.rut = ValidadorRut.formatear(rut);
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        if (telefono == null || telefono.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El teléfono no puede estar vacío."
            );
        }

        this.telefono = telefono.trim();
    }

    public Direccion getDireccion() {
        return direccion;
    }

    public void setDireccion(Direccion direccion) {
        if (direccion == null) {
            throw new IllegalArgumentException(
                    "La dirección no puede ser nula."
            );
        }

        this.direccion = direccion;
    }

    @Override
    public abstract void mostrarResumen();

    @Override
    public String toString() {
        return "nombre='" + nombre + '\'' +
                ", rut='" + rut + '\'' +
                ", telefono='" + telefono + '\'' +
                ", direccion=" + direccion;
    }
}
