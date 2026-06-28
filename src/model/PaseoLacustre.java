package model;

public class PaseoLacustre extends ServicioTuristico {

    private String tipoEmbarcacion;

    public PaseoLacustre(String nombre, int duracionHoras, String tipoEmbarcacion) {
        super(nombre, duracionHoras);

        if (tipoEmbarcacion == null || tipoEmbarcacion.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de embarcación no puede estar vacío.");
        }

        this.tipoEmbarcacion = tipoEmbarcacion;
    }

    public String getTipoEmbarcacion() {
        return tipoEmbarcacion;
    }

    @Override
    public String toString() {
        return "Paseo Lacustre | " +
                super.toString() +
                ", Tipo de embarcación: " + tipoEmbarcacion;
    }
}