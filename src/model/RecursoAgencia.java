package model;

public abstract class RecursoAgencia implements Registrable {

    private String nombre;

    public RecursoAgencia(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}