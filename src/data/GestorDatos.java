package data;

import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase utilitaria encargada de leer los tours
 * almacenados en un archivo de texto externo.
 */
public class GestorDatos {

    private static final String RUTA_TOURS =
            "resources/tours.txt";

    public ArrayList<Tour> cargarTours() {

        ArrayList<Tour> tours = new ArrayList<>();

        try (
                BufferedReader lector = new BufferedReader(
                        new FileReader(RUTA_TOURS)
                )
        ) {

            String linea;
            int numeroLinea = 0;

            while ((linea = lector.readLine()) != null) {

                numeroLinea++;

                if (linea.trim().isEmpty()) {
                    continue;
                }

                try {
                    Tour tour = convertirLineaATour(linea);
                    tours.add(tour);

                } catch (IllegalArgumentException e) {
                    System.out.println(
                            "Línea " + numeroLinea
                                    + " omitida: "
                                    + e.getMessage()
                    );
                }
            }

            System.out.println(
                    "Tours cargados correctamente: "
                            + tours.size()
            );

        } catch (IOException e) {
            System.out.println(
                    "Error al leer el archivo de tours: "
                            + e.getMessage()
            );
        }

        return tours;
    }

    /**
     * Convierte una línea del archivo en un objeto Tour.
     */
    private Tour convertirLineaATour(String linea) {

        String[] datos = linea.split(";");

        if (datos.length < 3 || datos.length > 4) {
            throw new IllegalArgumentException(
                    "La línea no posee el formato esperado."
            );
        }

        String nombre = datos[0].trim();
        String tipo = datos[1].trim();
        double precio;

        try {
            precio = Double.parseDouble(datos[2].trim());

        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(
                    "El precio no es numérico."
            );
        }

        if (datos.length == 4) {

            try {
                int cupoMaximo =
                        Integer.parseInt(datos[3].trim());

                return new Tour(
                        nombre,
                        tipo,
                        precio,
                        cupoMaximo
                );

            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "El cupo máximo no es numérico."
                );
            }
        }

        return new Tour(nombre, tipo, precio);
    }
}
