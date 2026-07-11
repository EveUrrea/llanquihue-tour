package model;

public class ColaboradorExterno extends RecursoAgencia {

    private String rol;

    public ColaboradorExterno(String nombre, String rol) {
        super(nombre);
        this.rol = rol;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    @Override
    public void mostrarResumen() {
        System.out.println("Colaborador: " + getNombre() +
                " | Rol: " + rol);
    }
}