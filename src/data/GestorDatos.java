package data;

import model.Tour;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class GestorDatos {

    public ArrayList<Tour> cargarTours() {

        ArrayList<Tour> tours = new ArrayList<>();

        try {

            BufferedReader br = new BufferedReader(
                    new FileReader("resources/tours.txt"));

            String linea;

            while ((linea = br.readLine()) != null) {

                String[] datos = linea.split(";");

                String nombre = datos[0];
                String tipo = datos[1];
                double precio = Double.parseDouble(datos[2]);

                Tour tour = new Tour(nombre, tipo, precio);

                tours.add(tour);
            }

            br.close();

        } catch (Exception e) {

            System.out.println("Error al leer archivo: "
                    + e.getMessage());

        }

        return tours;
    }
}
