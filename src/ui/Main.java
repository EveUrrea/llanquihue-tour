package ui;

import data.GestorDatos;
import data.GestorServicios;
import model.ServicioTuristico;
import model.Tour;
import service.TourService;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        // ===== FUNCIONALIDADES DE SEMANA 6 =====
        GestorDatos gestor = new GestorDatos();
        ArrayList<Tour> tours = gestor.cargarTours();

        TourService servicio = new TourService();

        servicio.mostrarTours(tours);
        servicio.mostrarToursCaros(tours);
        servicio.buscarPorTipo(tours, "Cultural");

        // ===== FUNCIONALIDADES DE SEMANA 7 =====
        System.out.println("\n===== SERVICIOS TURÍSTICOS - SEMANA 7 =====");

        GestorServicios gestorServicios = new GestorServicios();

        for (ServicioTuristico servicioTuristico : gestorServicios.obtenerServicios()) {
            servicioTuristico.mostrarInformacion();
        }
    }
}