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
    public String toString() {
        return "Excursión Cultural | " +
                super.toString() +
                ", Lugar histórico: " + lugarHistorico;
    }
}