package model;

import java.time.LocalDate;

/**
 * Representa una reserva realizada por un cliente.
 * Aplica composición porque contiene objetos Cliente y Tour.
 */
public class Reserva implements Registrable {

    private int numeroReserva;
    private Cliente cliente;
    private Tour tour;
    private LocalDate fechaReserva;
    private int cantidadPersonas;
    private String estado;

    public Reserva(
            int numeroReserva,
            Cliente cliente,
            Tour tour,
            LocalDate fechaReserva,
            int cantidadPersonas
    ) {

        setNumeroReserva(numeroReserva);
        setCliente(cliente);
        setTour(tour);
        setFechaReserva(fechaReserva);
        setCantidadPersonas(cantidadPersonas);
        this.estado = "Confirmada";
    }

    public int getNumeroReserva() {
        return numeroReserva;
    }

    public void setNumeroReserva(int numeroReserva) {

        if (numeroReserva <= 0) {
            throw new IllegalArgumentException(
                    "El número de reserva debe ser mayor que cero."
            );
        }

        this.numeroReserva = numeroReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {

        if (cliente == null) {
            throw new IllegalArgumentException(
                    "La reserva debe tener un cliente."
            );
        }

        this.cliente = cliente;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {

        if (tour == null) {
            throw new IllegalArgumentException(
                    "La reserva debe tener un tour."
            );
        }

        this.tour = tour;
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(LocalDate fechaReserva) {

        if (fechaReserva == null) {
            throw new IllegalArgumentException(
                    "La fecha de la reserva no puede estar vacía."
            );
        }

        this.fechaReserva = fechaReserva;
    }

    public int getCantidadPersonas() {
        return cantidadPersonas;
    }

    public void setCantidadPersonas(int cantidadPersonas) {

        if (cantidadPersonas <= 0) {
            throw new IllegalArgumentException(
                    "La cantidad de personas debe ser mayor que cero."
            );
        }

        if (!tour.permiteCantidadPersonas(cantidadPersonas)) {
            throw new IllegalArgumentException(
                    "La cantidad solicitada supera el cupo máximo del tour."
            );
        }

        this.cantidadPersonas = cantidadPersonas;
    }

    public String getEstado() {
        return estado;
    }

    public void confirmarReserva() {
        estado = "Confirmada";
    }

    public void cancelarReserva() {
        estado = "Cancelada";
    }

    /**
     * Calcula el precio total según el valor del tour
     * y la cantidad de pasajeros.
     */
    public double calcularTotal() {
        return tour.getPrecio() * cantidadPersonas;
    }

    @Override
    public void mostrarResumen() {
        System.out.println(
                "Reserva N.º " + numeroReserva
                        + " | Cliente: " + cliente.getNombre()
                        + " | Tour: " + tour.getNombre()
                        + " | Fecha: " + fechaReserva
                        + " | Personas: " + cantidadPersonas
                        + " | Total: $"
                        + String.format("%.0f", calcularTotal())
                        + " | Estado: " + estado
        );
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "numeroReserva=" + numeroReserva +
                ", cliente=" + cliente.getNombre() +
                ", tour=" + tour.getNombre() +
                ", fechaReserva=" + fechaReserva +
                ", cantidadPersonas=" + cantidadPersonas +
                ", total=" + String.format(
                "%.0f",
                calcularTotal()
        ) +
                ", estado='" + estado + '\'' +
                '}';
    }
}