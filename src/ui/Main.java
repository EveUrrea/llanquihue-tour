package ui;

import data.GestorDatos;
import data.GestorServicios;
import model.ServicioTuristico;
import model.Tour;
import service.TourService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> tours = gestor.cargarTours();

        TourService servicio = new TourService();

        servicio.mostrarTours(tours);
        servicio.mostrarToursCaros(tours);
        servicio.buscarPorTipo(tours, "Cultural");

        System.out.println("\n===== SERVICIOS TURÍSTICOS SEMANA 6 =====");

        GestorServicios gestorServicios = new GestorServicios();
        ServicioTuristico[] serviciosTuristicos = gestorServicios.obtenerServicios();

        for (ServicioTuristico servicioTuristico : serviciosTuristicos) {
            System.out.println(servicioTuristico);
        }
    }
}