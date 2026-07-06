package model;

public class ExcursionCultural extends ServicioTuristico {

    private String lugarHistorico;

    public ExcursionCultural(String nombre, int duracionHoras, String lugarHistorico) {
        super(nombre, duracionHoras);

        if (lugarHistorico == null || lugarHistorico.trim().isEmpty()) {
            throw new IllegalArgumentException("El lugar histórico no puede estar vacío.");
        }

        this.lugarHistorico = lugarHistorico;
    }

    public String getLugarHistorico() {
        return lugarHistorico;
    }

    @Override
    public void mostrarInformacion() {
        System.out.println("=== Excursión Cultural ===");
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duración: " + getDuracionHoras() + " horas");
        System.out.println("Lugar histórico: " + lugarHistorico);
        System.out.println();
    }
}