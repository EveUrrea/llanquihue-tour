package model;

public class Vehiculo extends RecursoAgencia {

    private String tipo;

    public Vehiculo(String nombre, String tipo) {
        super(nombre);
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Vehículo: " + getNombre() +
                " | Tipo: " + tipo);
    }
}