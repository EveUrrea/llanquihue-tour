package model;

/**
 * Representa un paseo realizado en una embarcación.
 */
public class PaseoLacustre
        extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(
            String nombre,
            int duracionHoras,
            String tipoEmbarcacion
    ) {

        super(nombre, duracionHoras);
        setTipoEmbarcacion(tipoEmbarcacion);
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    public void setTipoEmbarcacion(
            String tipoEmbarcacion
    ) {

        if (
                tipoEmbarcacion == null
                        || tipoEmbarcacion.trim().isEmpty()
        ) {

            throw new IllegalArgumentException(
                    "El tipo de embarcación no puede estar vacío."
            );
        }

        this.tipoEmbarcacion =
                tipoEmbarcacion.trim();
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("=== Paseo Lacustre ===");
        System.out.println("Nombre: " + getNombre());

        System.out.println(
                "Duración: "
                        + getDuracionHoras()
                        + " horas"
        );

        System.out.println(
                "Tipo de embarcación: "
                        + tipoEmbarcacion
        );

        System.out.println();
    }

    @Override
    public String toString() {
        return "PaseoLacustre{" +
                super.toString() +
                ", tipoEmbarcacion='" +
                tipoEmbarcacion + '\'' +
                '}';
    }
}