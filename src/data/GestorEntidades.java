package data;

import model.Cliente;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Proveedor;
import model.Registrable;
import model.Reserva;
import model.Vehiculo;
import utils.ValidadorRut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

/**
 * Gestiona las entidades registrables de la agencia
 * mediante distintas colecciones.
 */
public class GestorEntidades {

    private final ArrayList<Registrable> entidades;
    private final HashMap<String, Cliente> clientesPorRut;
    private final Stack<Reserva> historialReservas;

    public GestorEntidades() {
        entidades = new ArrayList<>();
        clientesPorRut = new HashMap<>();
        historialReservas = new Stack<>();
    }

    /**
     * Agrega cualquier objeto que implemente Registrable.
     */
    public void agregarEntidad(Registrable entidad) {

        if (entidad == null) {
            throw new IllegalArgumentException(
                    "La entidad no puede ser nula."
            );
        }

        if (entidad instanceof Cliente cliente) {

            String rutLimpio = ValidadorRut.limpiarRut(
                    cliente.getRut()
            );

            if (clientesPorRut.containsKey(rutLimpio)) {
                throw new IllegalArgumentException(
                        "Ya existe un cliente registrado con ese RUT."
                );
            }

            clientesPorRut.put(rutLimpio, cliente);
        }

        if (entidad instanceof Reserva reserva) {
            historialReservas.push(reserva);
        }

        entidades.add(entidad);
        entidad.registrar();
    }

    public ArrayList<Registrable> getEntidades() {
        return new ArrayList<>(entidades);
    }

    public HashMap<String, Cliente> getClientesPorRut() {
        return new HashMap<>(clientesPorRut);
    }

    public Stack<Reserva> getHistorialReservas() {
        return new Stack<>() {{
            addAll(historialReservas);
        }};
    }

    /**
     * Busca rápidamente un cliente mediante su RUT.
     */
    public Cliente buscarClientePorRut(String rut) {
        String rutLimpio = ValidadorRut.limpiarRut(rut);
        return clientesPorRut.get(rutLimpio);
    }

    /**
     * Retorna la reserva registrada más recientemente.
     */
    public Reserva obtenerUltimaReserva() {

        if (historialReservas.isEmpty()) {
            return null;
        }

        return historialReservas.peek();
    }

    /**
     * Filtra objetos por su clase utilizando genéricos e instanceof.
     */
    public <T extends Registrable> ArrayList<T> filtrarPorTipo(
            Class<T> tipo
    ) {

        ArrayList<T> resultados = new ArrayList<>();

        for (Registrable entidad : entidades) {
            if (tipo.isInstance(entidad)) {
                resultados.add(tipo.cast(entidad));
            }
        }

        return resultados;
    }

    public void mostrarTodasLasEntidades() {

        for (Registrable entidad : entidades) {

            entidad.mostrarResumen();

            System.out.println(
                    "Tipo identificado: "
                            + entidad.obtenerTipoRegistro()
            );

            System.out.println("--------------------------------");
        }
    }

    /**
     * Genera el texto utilizado por la interfaz gráfica.
     */
    public String obtenerResumenDeEntidades() {

        if (entidades.isEmpty()) {
            return "No existen entidades registradas.";
        }

        StringBuilder resumen = new StringBuilder();

        for (Registrable entidad : entidades) {

            if (entidad instanceof Cliente cliente) {
                resumen.append("Cliente: ")
                        .append(cliente.getNombre())
                        .append(" | RUT: ")
                        .append(cliente.getRut())
                        .append(" | Correo: ")
                        .append(cliente.getCorreo());

            } else if (entidad instanceof Proveedor proveedor) {
                resumen.append("Proveedor: ")
                        .append(proveedor.getNombre())
                        .append(" | Servicio: ")
                        .append(proveedor.getTipoServicio());

            } else if (entidad instanceof Reserva reserva) {
                resumen.append("Reserva N.º ")
                        .append(reserva.getNumeroReserva())
                        .append(" | Cliente: ")
                        .append(reserva.getCliente().getNombre())
                        .append(" | Tour: ")
                        .append(reserva.getTour().getNombre())
                        .append(" | Total: $")
                        .append(String.format("%.0f", reserva.calcularTotal()))
                        .append(" | Estado: ")
                        .append(reserva.getEstado());

            } else if (entidad instanceof GuiaTuristico guia) {
                resumen.append("Guía turístico: ")
                        .append(guia.getNombre())
                        .append(" | Especialidad: ")
                        .append(guia.getEspecialidad());

            } else if (entidad instanceof Vehiculo vehiculo) {
                resumen.append("Vehículo: ")
                        .append(vehiculo.getNombre())
                        .append(" | Tipo: ")
                        .append(vehiculo.getTipo());

            } else if (entidad instanceof ColaboradorExterno colaborador) {
                resumen.append("Colaborador externo: ")
                        .append(colaborador.getNombre())
                        .append(" | Rol: ")
                        .append(colaborador.getRol());
            }

            resumen.append("\n");
        }

        return resumen.toString();
    }
}