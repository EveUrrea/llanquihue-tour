package data;

import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Registrable;
import model.Vehiculo;

import java.util.ArrayList;

public class GestorEntidades {

    private final ArrayList<Registrable> entidades;

    public GestorEntidades() {
        entidades = new ArrayList<>();
    }

    public void agregarEntidad(Registrable entidad) {
        entidades.add(entidad);
    }

    public ArrayList<Registrable> getEntidades() {
        return entidades;
    }

    public void mostrarTodasLasEntidades() {
        for (Registrable entidad : entidades) {
            entidad.mostrarResumen();

            if (entidad instanceof GuiaTuristico guia) {
                System.out.println(
                        "Tipo identificado: Guía turístico | Especialidad: "
                                + guia.getEspecialidad()
                );

            } else if (entidad instanceof Vehiculo vehiculo) {
                System.out.println(
                        "Tipo identificado: Vehículo | Tipo de vehículo: "
                                + vehiculo.getTipo()
                );

            } else if (entidad instanceof ColaboradorExterno colaborador) {
                System.out.println(
                        "Tipo identificado: Colaborador externo | Rol: "
                                + colaborador.getRol()
                );
            }

            System.out.println("--------------------------------");
        }
    }

    public String obtenerResumenDeEntidades() {
        if (entidades.isEmpty()) {
            return "No existen entidades registradas.";
        }

        StringBuilder resumen = new StringBuilder();

        for (Registrable entidad : entidades) {

            if (entidad instanceof GuiaTuristico guia) {
                resumen.append("Guía turístico: ")
                        .append(guia.getNombre())
                        .append(" | Especialidad: ")
                        .append(guia.getEspecialidad());

            } else if (entidad instanceof Vehiculo vehiculo) {
                resumen.append("Vehículo: ")
                        .append(vehiculo.getNombre())
                        .append(" | Tipo: ")
                        .append(vehiculo.getTipo());

            } else if (entidad instanceof ColaboradorExterno colaborador) {
                resumen.append("Colaborador externo: ")
                        .append(colaborador.getNombre())
                        .append(" | Rol: ")
                        .append(colaborador.getRol());
            }

            resumen.append("\n");
        }

        return resumen.toString();
    }
}