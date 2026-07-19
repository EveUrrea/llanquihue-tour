package model;

/**
 * Representa una experiencia gastronómica
 * con diferentes paradas.
 */
public class RutaGastronomica
        extends ServicioTuristico {

    private int numeroDeParadas;

    public RutaGastronomica(
            String nombre,
            int duracionHoras,
            int numeroDeParadas
    ) {

        super(nombre, duracionHoras);
        setNumeroDeParadas(numeroDeParadas);
    }

    public int getNumeroDeParadas() {
        return numeroDeParadas;
    }

    public void setNumeroDeParadas(int numeroDeParadas) {

        if (numeroDeParadas <= 0) {
            throw new IllegalArgumentException(
                    "El número de paradas debe ser mayor que cero."
            );
        }

        this.numeroDeParadas = numeroDeParadas;
    }

    @Override
    public void mostrarInformacion() {

        System.out.println("=== Ruta Gastronómica ===");
        System.out.println("Nombre: " + getNombre());

        System.out.println(
                "Duración: "
                        + getDuracionHoras()
                        + " horas"
        );

        System.out.println(
                "Número de paradas: "
                        + numeroDeParadas
        );

        System.out.println();
    }

    @Override
    public String toString() {
        return "RutaGastronomica{" +
                super.toString() +
                ", numeroDeParadas=" +
                numeroDeParadas +
                '}';
    }
}