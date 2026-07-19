package model;

/**
 * Representa un vehículo utilizado en los tours.
 */
public class Vehiculo extends RecursoAgencia {

    private String tipo;

    public Vehiculo(String nombre, String tipo) {
        super(nombre);
        setTipo(tipo);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {

        if (tipo == null || tipo.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "El tipo de vehículo no puede estar vacío."
            );
        }

        this.tipo = tipo.trim();
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Vehículo: " + getNombre()
                        + " | Tipo: " + tipo
        );
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                super.toString() +
                ", tipo='" + tipo + '\'' +
                '}';
    }
}