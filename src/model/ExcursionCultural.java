package model;

/**
 * Representa una excursión a un lugar
 * cultural o histórico.
 */
public class ExcursionCultural
        extends ServicioTuristico {

    private String lugarHistorico;

    public ExcursionCultural(
            String nombre,
            int duracionHoras,
            String lugarHistorico
    ) {

        super(nombre, duracionHoras);
        setLugarHistorico(lugarHistorico);
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    public void setLugarHistorico(
            String lugarHistorico
    ) {

        if (
                lugarHistorico == null
                        || lugarHistorico.trim().isEmpty()
        ) {

            throw new IllegalArgumentException(
                    "El lugar histórico no puede estar vacío."
            );
        }

        this.lugarHistorico =
                lugarHistorico.trim();
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("=== Excursión Cultural ===");
        System.out.println("Nombre: " + getNombre());

        System.out.println(
                "Duración: "
                        + getDuracionHoras()
                        + " horas"
        );

        System.out.println(
                "Lugar histórico: "
                        + lugarHistorico
        );

        System.out.println();
    }

    @Override
    public String toString() {
        return "ExcursionCultural{" +
                super.toString() +
                ", lugarHistorico='" +
                lugarHistorico + '\'' +
                '}';
    }
}