package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

import java.util.ArrayList;
import java.util.List;

public class GestorServicios {

    private List<ServicioTuristico> servicios;

    public GestorServicios() {
        servicios = new ArrayList<>();
        cargarServicios();
    }

    private void cargarServicios() {

        servicios.add(new RutaGastronomica(
                "Ruta del Chocolate",
                4,
                5));

        servicios.add(new RutaGastronomica(
                "Sabores del Sur",
                6,
                8));

        servicios.add(new PaseoLacustre(
                "Lago Llanquihue",
                3,
                "Catamarán"));

        servicios.add(new PaseoLacustre(
                "Todos los Santos",
                5,
                "Lancha"));

        servicios.add(new ExcursionCultural(
                "Museo Colonial Alemán",
                2,
                "Frutillar"));

        servicios.add(new ExcursionCultural(
                "Fuerte San Antonio",
                4,
                "Ancud"));
    }

    public List<ServicioTuristico> obtenerServicios() {
        return servicios;
    }
}
