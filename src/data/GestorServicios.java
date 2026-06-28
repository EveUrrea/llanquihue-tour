package data;

import model.ExcursionCultural;
import model.PaseoLacustre;
import model.RutaGastronomica;
import model.ServicioTuristico;

public class GestorServicios {

    public ServicioTuristico[] obtenerServicios() {

        ServicioTuristico[] servicios = new ServicioTuristico[6];

        servicios[0] = new RutaGastronomica(
                "Ruta del Chocolate",
                4,
                5);

        servicios[1] = new RutaGastronomica(
                "Sabores del Sur",
                6,
                8);

        servicios[2] = new PaseoLacustre(
                "Lago Llanquihue",
                3,
                "Catamarán");

        servicios[3] = new PaseoLacustre(
                "Todos los Santos",
                5,
                "Lancha");

        servicios[4] = new ExcursionCultural(
                "Museo Colonial Alemán",
                2,
                "Frutillar");

        servicios[5] = new ExcursionCultural(
                "Fuerte San Antonio",
                4,
                "Ancud");

        return servicios;
    }

}
