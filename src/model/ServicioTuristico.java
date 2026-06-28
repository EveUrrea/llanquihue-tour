package model;

public class ServicioTuristico {

    private String nombre;
    private int duracionHoras;

    public ServicioTuristico(String nombre, int duracionHoras) {

        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }

        if (duracionHoras <= 0) {
            throw new IllegalArgumentException("La duración debe ser mayor que cero.");
        }

        this.nombre = nombre;
        this.duracionHoras = duracionHoras;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDuracionHoras() {
        return duracionHoras;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre +
                ", Duración: " + duracionHoras + " horas";
    }
}