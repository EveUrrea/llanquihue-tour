package model;

/**
 * Representa a un guía turístico de la agencia.
 */
public class GuiaTuristico extends RecursoAgencia {

    private String especialidad;

    public GuiaTuristico(
            String nombre,
            String especialidad
    ) {

        super(nombre);
        setEspecialidad(especialidad);
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {

        if (
                especialidad == null
                        || especialidad.trim().isEmpty()
        ) {

            throw new IllegalArgumentException(
                    "La especialidad no puede estar vacía."
            );
        }

        this.especialidad = especialidad.trim();
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Guía: " + getNombre()
                        + " | Especialidad: "
                        + especialidad
        );
    }

    @Override
    public String toString() {
        return "GuiaTuristico{" +
                super.toString() +
                ", especialidad='" + especialidad + '\'' +
                '}';
    }
}