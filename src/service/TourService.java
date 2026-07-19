package service;

import model.Tour;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Contiene las operaciones relacionadas con los tours.
 */
public class TourService {

    /**
     * Recorre y muestra todos los tours.
     */
    public void mostrarTours(List<Tour> tours) {

        System.out.println("=== TODOS LOS TOURS ===");

        if (tours.isEmpty()) {
            System.out.println("No existen tours disponibles.");
            return;
        }

        for (Tour tour : tours) {
            System.out.println(tour);
        }
    }

    /**
     * Retorna los tours cuyo precio supera el valor indicado.
     */
    public ArrayList<Tour> filtrarPorPrecioMayorA(
            List<Tour> tours,
            double precioMinimo
    ) {

        ArrayList<Tour> resultados = new ArrayList<>();

        for (Tour tour : tours) {
            if (tour.getPrecio() > precioMinimo) {
                resultados.add(tour);
            }
        }

        return resultados;
    }

    /**
     * Busca tours según su categoría.
     */
    public ArrayList<Tour> buscarPorTipo(
            List<Tour> tours,
            String tipoBuscado
    ) {

        ArrayList<Tour> resultados = new ArrayList<>();

        if (tipoBuscado == null) {
            return resultados;
        }

        for (Tour tour : tours) {
            if (
                    tour.getTipo().equalsIgnoreCase(
                            tipoBuscado.trim()
                    )
            ) {
                resultados.add(tour);
            }
        }

        return resultados;
    }

    /**
     * Busca un tour utilizando una parte de su nombre.
     */
    public ArrayList<Tour> buscarPorNombre(
            List<Tour> tours,
            String nombreBuscado
    ) {

        ArrayList<Tour> resultados = new ArrayList<>();

        if (nombreBuscado == null) {
            return resultados;
        }

        String textoBuscado =
                nombreBuscado.trim().toLowerCase();

        for (Tour tour : tours) {
            if (
                    tour.getNombre()
                            .toLowerCase()
                            .contains(textoBuscado)
            ) {
                resultados.add(tour);
            }
        }

        return resultados;
    }

    /**
     * Retorna una nueva lista ordenada de menor a mayor precio.
     */
    public ArrayList<Tour> ordenarPorPrecio(
            List<Tour> tours
    ) {

        ArrayList<Tour> toursOrdenados =
                new ArrayList<>(tours);

        toursOrdenados.sort(
                Comparator.comparingDouble(Tour::getPrecio)
        );

        return toursOrdenados;
    }

    /**
     * Transforma una colección de tours en texto
     * para mostrarla en la interfaz gráfica.
     */
    public String convertirToursATexto(List<Tour> tours) {

        if (tours.isEmpty()) {
            return "No se encontraron tours.";
        }

        StringBuilder texto = new StringBuilder();

        for (Tour tour : tours) {
            texto.append(tour).append("\n");
        }

        return texto.toString();
    }
}
