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
    public void mostrarInformacion() {
        System.out.println("=== Paseo Lacustre ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duración: " + getDuracionHoras() + " horas");
        System.out.println("Tipo de embarcación: " + tipoEmbarcacion);
        System.out.println();
    }
}