package ui;

import data.GestorDatos;
import model.Tour;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();

        ArrayList<Tour> tours = gestor.cargarTours();

        System.out.println("=== TODOS LOS TOURS ===");

        for (Tour tour : tours) {
            System.out.println(tour);
        }

        System.out.println("\n=== TOURS SOBRE $60.000 ===");

        for (Tour tour : tours) {

            if (tour.getPrecio() > 60000) {
                System.out.println(tour);
            }

        }

    }
}