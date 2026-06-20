package service;

import model.Tour;
import java.util.ArrayList;

public class TourService {

    public void mostrarTours(ArrayList<Tour> tours) {
        System.out.println("=== TODOS LOS TOURS ===");

        for (Tour tour : tours) {
            System.out.println(tour);
        }
    }

    public void mostrarToursCaros(ArrayList<Tour> tours) {
        System.out.println("\n=== TOURS SOBRE $60.000 ===");

        for (Tour tour : tours) {
            if (tour.getPrecio() > 60000) {
                System.out.println(tour);
            }
        }
    }

    public void buscarPorTipo(ArrayList<Tour> tours, String tipoBuscado) {
        System.out.println("\n=== BUSQUEDA POR TIPO: " + tipoBuscado + " ===");

        for (Tour tour : tours) {
            if (tour.getTipo().equalsIgnoreCase(tipoBuscado)) {
                System.out.println(tour);
            }
        }
    }
}
