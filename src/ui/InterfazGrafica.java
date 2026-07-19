package ui;

import data.GestorDatos;
import data.GestorEntidades;
import exception.RutInvalidoException;
import model.Cliente;
import model.Direccion;
import model.Reserva;
import model.Tour;
import service.TourService;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * Interfaz gráfica principal de Llanquihue Tour.
 * Permite gestionar clientes, tours y reservas.
 */
public class InterfazGrafica extends JFrame {

    private final GestorEntidades gestorEntidades;
    private final TourService tourService;
    private final ArrayList<Tour> tours;

    private JTextField campoNombre;
    private JTextField campoRut;
    private JTextField campoTelefono;
    private JTextField campoCorreo;
    private JTextField campoCalle;
    private JTextField campoNumero;
    private JTextField campoComuna;
    private JTextArea areaClientes;

    private JTextField campoRutReserva;
    private JTextField campoCantidadPersonas;
    private JComboBox<Tour> comboTours;
    private JTextArea areaReservas;

    private JTextField campoBusquedaTour;
    private JTextArea areaTours;

    private int siguienteNumeroReserva;

    public InterfazGrafica() {

        gestorEntidades = new GestorEntidades();
        tourService = new TourService();
        tours = new GestorDatos().cargarTours();
        siguienteNumeroReserva = 1;

        configurarVentana();
        crearComponentes();
    }

    private void configurarVentana() {

        setTitle("Llanquihue Tour - Sistema de Gestión");
        setSize(900, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void crearComponentes() {

        JPanel panelPrincipal = new JPanel(
                new BorderLayout(10, 10)
        );

        panelPrincipal.setBorder(
                new EmptyBorder(15, 15, 15, 15)
        );

        JLabel titulo = new JLabel(
                "LLANQUIHUE TOUR - SISTEMA DE GESTIÓN",
                SwingConstants.CENTER
        );

        titulo.setFont(
                new Font("Arial", Font.BOLD, 20)
        );

        titulo.setForeground(new Color(16, 48, 105));

        JTabbedPane pestanas = new JTabbedPane();

        pestanas.addTab(
                "Clientes",
                crearPanelClientes()
        );

        pestanas.addTab(
                "Reservas",
                crearPanelReservas()
        );

        pestanas.addTab(
                "Tours",
                crearPanelTours()
        );

        panelPrincipal.add(titulo, BorderLayout.NORTH);
        panelPrincipal.add(pestanas, BorderLayout.CENTER);

        add(panelPrincipal);
    }

    // =========================================================
    // PANEL DE CLIENTES
    // =========================================================

    private JPanel crearPanelClientes() {

        JPanel panel = new JPanel(
                new BorderLayout(10, 10)
        );

        JPanel formulario = new JPanel(
                new GridBagLayout()
        );

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        "Registro de clientes"
                )
        );

        GridBagConstraints gbc =
                crearRestriccionesFormulario();

        campoNombre = new JTextField(18);
        campoRut = new JTextField(18);
        campoTelefono = new JTextField(18);
        campoCorreo = new JTextField(18);
        campoCalle = new JTextField(18);
        campoNumero = new JTextField(18);
        campoComuna = new JTextField(18);

        agregarCampo(
                formulario,
                gbc,
                0,
                "Nombre:",
                campoNombre
        );

        agregarCampo(
                formulario,
                gbc,
                1,
                "RUT:",
                campoRut
        );

        agregarCampo(
                formulario,
                gbc,
                2,
                "Teléfono:",
                campoTelefono
        );

        agregarCampo(
                formulario,
                gbc,
                3,
                "Correo:",
                campoCorreo
        );

        agregarCampo(
                formulario,
                gbc,
                4,
                "Calle:",
                campoCalle
        );

        agregarCampo(
                formulario,
                gbc,
                5,
                "Número:",
                campoNumero
        );

        agregarCampo(
                formulario,
                gbc,
                6,
                "Comuna:",
                campoComuna
        );

        JButton botonGuardar =
                new JButton("Registrar cliente");

        JButton botonBuscar =
                new JButton("Buscar por RUT");

        JButton botonLimpiar =
                new JButton("Limpiar");

        botonGuardar.addActionListener(
                evento -> registrarCliente()
        );

        botonBuscar.addActionListener(
                evento -> buscarCliente()
        );

        botonLimpiar.addActionListener(
                evento -> limpiarCamposCliente()
        );

        JPanel botones = new JPanel();

        botones.add(botonGuardar);
        botones.add(botonBuscar);
        botones.add(botonLimpiar);

        gbc.gridx = 0;
        gbc.gridy = 7;
        gbc.gridwidth = 2;

        formulario.add(botones, gbc);

        areaClientes = crearAreaTexto();

        JScrollPane scroll = new JScrollPane(areaClientes);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Clientes registrados"
                )
        );

        panel.add(formulario, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    private void registrarCliente() {

        try {
            validarCamposCliente();

            Direccion direccion = new Direccion(
                    campoCalle.getText(),
                    campoNumero.getText(),
                    campoComuna.getText()
            );

            Cliente cliente = new Cliente(
                    campoNombre.getText(),
                    campoRut.getText(),
                    campoTelefono.getText(),
                    direccion,
                    campoCorreo.getText()
            );

            gestorEntidades.agregarEntidad(cliente);

            mostrarMensaje(
                    "Cliente registrado correctamente.",
                    "Registro exitoso",
                    JOptionPane.INFORMATION_MESSAGE
            );

            actualizarAreaClientes();
            limpiarCamposCliente();

        } catch (
                RutInvalidoException
                | IllegalArgumentException e
        ) {

            mostrarMensaje(
                    e.getMessage(),
                    "No fue posible registrar",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void buscarCliente() {

        String rut = campoRut.getText().trim();

        if (rut.isEmpty()) {
            mostrarMensaje(
                    "Ingresa un RUT para realizar la búsqueda.",
                    "RUT requerido",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        Cliente cliente =
                gestorEntidades.buscarClientePorRut(rut);

        if (cliente == null) {
            areaClientes.setText(
                    "No se encontró un cliente con el RUT ingresado."
            );

            return;
        }

        areaClientes.setText(
                "CLIENTE ENCONTRADO\n\n"
                        + cliente
        );
    }

    private void actualizarAreaClientes() {

        ArrayList<Cliente> clientes =
                gestorEntidades.filtrarPorTipo(
                        Cliente.class
                );

        if (clientes.isEmpty()) {
            areaClientes.setText(
                    "No existen clientes registrados."
            );

            return;
        }

        StringBuilder texto = new StringBuilder();

        for (Cliente cliente : clientes) {
            texto.append(cliente).append("\n");
        }

        areaClientes.setText(texto.toString());
    }

    private void validarCamposCliente() {

        if (
                campoNombre.getText().trim().isEmpty()
                        || campoRut.getText().trim().isEmpty()
                        || campoTelefono.getText().trim().isEmpty()
                        || campoCorreo.getText().trim().isEmpty()
                        || campoCalle.getText().trim().isEmpty()
                        || campoNumero.getText().trim().isEmpty()
                        || campoComuna.getText().trim().isEmpty()
        ) {

            throw new IllegalArgumentException(
                    "Debes completar todos los datos del cliente."
            );
        }
    }

    private void limpiarCamposCliente() {

        campoNombre.setText("");
        campoRut.setText("");
        campoTelefono.setText("");
        campoCorreo.setText("");
        campoCalle.setText("");
        campoNumero.setText("");
        campoComuna.setText("");
        campoNombre.requestFocus();
    }

    // =========================================================
    // PANEL DE RESERVAS
    // =========================================================

    private JPanel crearPanelReservas() {

        JPanel panel = new JPanel(
                new BorderLayout(10, 10)
        );

        JPanel formulario = new JPanel(
                new GridBagLayout()
        );

        formulario.setBorder(
                BorderFactory.createTitledBorder(
                        "Creación de reservas"
                )
        );

        GridBagConstraints gbc =
                crearRestriccionesFormulario();

        campoRutReserva = new JTextField(20);
        campoCantidadPersonas = new JTextField(20);

        comboTours = new JComboBox<>();

        for (Tour tour : tours) {
            comboTours.addItem(tour);
        }

        agregarCampo(
                formulario,
                gbc,
                0,
                "RUT del cliente:",
                campoRutReserva
        );

        agregarCampo(
                formulario,
                gbc,
                1,
                "Tour:",
                comboTours
        );

        agregarCampo(
                formulario,
                gbc,
                2,
                "Cantidad de personas:",
                campoCantidadPersonas
        );

        JButton botonReservar =
                new JButton("Crear reserva");

        JButton botonUltima =
                new JButton("Mostrar última");

        JButton botonCancelar =
                new JButton("Cancelar última");

        botonReservar.addActionListener(
                evento -> crearReserva()
        );

        botonUltima.addActionListener(
                evento -> mostrarUltimaReserva()
        );

        botonCancelar.addActionListener(
                evento -> cancelarUltimaReserva()
        );

        JPanel botones = new JPanel();

        botones.add(botonReservar);
        botones.add(botonUltima);
        botones.add(botonCancelar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        formulario.add(botones, gbc);

        areaReservas = crearAreaTexto();

        JScrollPane scroll = new JScrollPane(areaReservas);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Reservas registradas"
                )
        );

        panel.add(formulario, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        return panel;
    }

    private void crearReserva() {

        try {
            String rut =
                    campoRutReserva.getText().trim();

            if (rut.isEmpty()) {
                throw new IllegalArgumentException(
                        "Debes ingresar el RUT del cliente."
                );
            }

            Cliente cliente =
                    gestorEntidades.buscarClientePorRut(rut);

            if (cliente == null) {
                throw new IllegalArgumentException(
                        "El cliente no está registrado."
                );
            }

            Tour tour =
                    (Tour) comboTours.getSelectedItem();

            if (tour == null) {
                throw new IllegalArgumentException(
                        "No existen tours disponibles."
                );
            }

            int cantidadPersonas =
                    Integer.parseInt(
                            campoCantidadPersonas
                                    .getText()
                                    .trim()
                    );

            Reserva reserva = new Reserva(
                    siguienteNumeroReserva,
                    cliente,
                    tour,
                    LocalDate.now(),
                    cantidadPersonas
            );

            gestorEntidades.agregarEntidad(reserva);
            siguienteNumeroReserva++;

            mostrarMensaje(
                    "Reserva creada correctamente.\n"
                            + "Total: $"
                            + String.format(
                            "%.0f",
                            reserva.calcularTotal()
                    ),
                    "Reserva exitosa",
                    JOptionPane.INFORMATION_MESSAGE
            );

            actualizarAreaReservas();

            campoRutReserva.setText("");
            campoCantidadPersonas.setText("");

        } catch (NumberFormatException e) {

            mostrarMensaje(
                    "La cantidad de personas debe ser numérica.",
                    "Cantidad incorrecta",
                    JOptionPane.WARNING_MESSAGE
            );

        } catch (IllegalArgumentException e) {

            mostrarMensaje(
                    e.getMessage(),
                    "No fue posible reservar",
                    JOptionPane.WARNING_MESSAGE
            );
        }
    }

    private void actualizarAreaReservas() {

        ArrayList<Reserva> reservas =
                gestorEntidades.filtrarPorTipo(
                        Reserva.class
                );

        if (reservas.isEmpty()) {
            areaReservas.setText(
                    "No existen reservas registradas."
            );

            return;
        }

        StringBuilder texto = new StringBuilder();

        for (Reserva reserva : reservas) {
            texto.append(reserva).append("\n");
        }

        areaReservas.setText(texto.toString());
    }

    private void mostrarUltimaReserva() {

        Reserva ultimaReserva =
                gestorEntidades.obtenerUltimaReserva();

        if (ultimaReserva == null) {
            areaReservas.setText(
                    "No existen reservas registradas."
            );

            return;
        }

        areaReservas.setText(
                "ÚLTIMA RESERVA REGISTRADA\n\n"
                        + ultimaReserva
        );
    }

    private void cancelarUltimaReserva() {

        Reserva ultimaReserva =
                gestorEntidades.obtenerUltimaReserva();

        if (ultimaReserva == null) {
            mostrarMensaje(
                    "No existen reservas para cancelar.",
                    "Sin reservas",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        ultimaReserva.cancelarReserva();
        actualizarAreaReservas();

        mostrarMensaje(
                "La última reserva fue cancelada.",
                "Reserva actualizada",
                JOptionPane.INFORMATION_MESSAGE
        );
    }

    // =========================================================
    // PANEL DE TOURS
    // =========================================================

    private JPanel crearPanelTours() {

        JPanel panel = new JPanel(
                new BorderLayout(10, 10)
        );

        JPanel busqueda = new JPanel();

        busqueda.setBorder(
                BorderFactory.createTitledBorder(
                        "Consulta de tours"
                )
        );

        campoBusquedaTour = new JTextField(18);

        JButton botonMostrar =
                new JButton("Mostrar todos");

        JButton botonBuscarNombre =
                new JButton("Buscar por nombre");

        JButton botonPrecio =
                new JButton("Sobre $60.000");

        JButton botonOrdenar =
                new JButton("Ordenar por precio");

        botonMostrar.addActionListener(
                evento -> mostrarTodosLosTours()
        );

        botonBuscarNombre.addActionListener(
                evento -> buscarTourPorNombre()
        );

        botonPrecio.addActionListener(
                evento -> filtrarToursPorPrecio()
        );

        botonOrdenar.addActionListener(
                evento -> ordenarToursPorPrecio()
        );

        busqueda.add(new JLabel("Nombre:"));
        busqueda.add(campoBusquedaTour);
        busqueda.add(botonBuscarNombre);
        busqueda.add(botonMostrar);
        busqueda.add(botonPrecio);
        busqueda.add(botonOrdenar);

        areaTours = crearAreaTexto();

        JScrollPane scroll = new JScrollPane(areaTours);

        scroll.setBorder(
                BorderFactory.createTitledBorder(
                        "Tours cargados desde resources/tours.txt"
                )
        );

        panel.add(busqueda, BorderLayout.NORTH);
        panel.add(scroll, BorderLayout.CENTER);

        SwingUtilities.invokeLater(
                this::mostrarTodosLosTours
        );

        return panel;
    }

    private void mostrarTodosLosTours() {
        areaTours.setText(
                tourService.convertirToursATexto(tours)
        );
    }

    private void buscarTourPorNombre() {

        String nombre =
                campoBusquedaTour.getText().trim();

        if (nombre.isEmpty()) {
            mostrarMensaje(
                    "Ingresa un nombre o parte del nombre.",
                    "Búsqueda incompleta",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        ArrayList<Tour> resultados =
                tourService.buscarPorNombre(
                        tours,
                        nombre
                );

        areaTours.setText(
                tourService.convertirToursATexto(
                        resultados
                )
        );
    }

    private void filtrarToursPorPrecio() {

        ArrayList<Tour> resultados =
                tourService.filtrarPorPrecioMayorA(
                        tours,
                        60000
                );

        areaTours.setText(
                "TOURS SOBRE $60.000\n\n"
                        + tourService.convertirToursATexto(
                        resultados
                )
        );
    }

    private void ordenarToursPorPrecio() {

        ArrayList<Tour> resultados =
                tourService.ordenarPorPrecio(tours);

        areaTours.setText(
                "TOURS ORDENADOS POR PRECIO\n\n"
                        + tourService.convertirToursATexto(
                        resultados
                )
        );
    }

    // =========================================================
    // MÉTODOS AUXILIARES
    // =========================================================

    private GridBagConstraints crearRestriccionesFormulario() {

        GridBagConstraints gbc =
                new GridBagConstraints();

        gbc.insets = new Insets(5, 8, 5, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        return gbc;
    }

    private void agregarCampo(
            JPanel panel,
            GridBagConstraints gbc,
            int fila,
            String textoEtiqueta,
            Component componente
    ) {

        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.gridwidth = 1;

        panel.add(
                new JLabel(textoEtiqueta),
                gbc
        );

        gbc.gridx = 1;

        panel.add(componente, gbc);
    }

    private JTextArea crearAreaTexto() {

        JTextArea area = new JTextArea();

        area.setEditable(false);
        area.setFont(
                new Font("Monospaced", Font.PLAIN, 13)
        );

        area.setLineWrap(true);
        area.setWrapStyleWord(true);

        return area;
    }

    private void mostrarMensaje(
            String mensaje,
            String titulo,
            int tipo
    ) {

        JOptionPane.showMessageDialog(
                this,
                mensaje,
                titulo,
                tipo
        );
    }
}