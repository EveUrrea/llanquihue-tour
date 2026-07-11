package ui;

import data.GestorEntidades;
import model.ColaboradorExterno;
import model.GuiaTuristico;
import model.Vehiculo;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class InterfazGrafica extends JFrame {

    private final GestorEntidades gestorEntidades;

    private JComboBox<String> comboTipoEntidad;
    private JTextField campoNombre;
    private JTextField campoDetalle;
    private JLabel etiquetaDetalle;
    private JTextArea areaRegistros;

    public InterfazGrafica() {

        gestorEntidades = new GestorEntidades();

        configurarVentana();
        crearComponentes();
    }

    private void configurarVentana() {

        setTitle("Llanquihue Tour - Gestión de Entidades");
        setSize(620, 480);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private void crearComponentes() {

        JPanel panelPrincipal = new JPanel(new BorderLayout(10, 10));
        panelPrincipal.setBorder(new EmptyBorder(15, 15, 15, 15));

        JLabel titulo = new JLabel(
                "LLANQUIHUE TOUR - REGISTRO DE ENTIDADES",
                SwingConstants.CENTER
        );

        titulo.setFont(new Font("Arial", Font.BOLD, 18));

        panelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel panelFormulario = crearPanelFormulario();
        panelPrincipal.add(panelFormulario, BorderLayout.CENTER);

        JPanel panelInferior = crearPanelInferior();
        panelPrincipal.add(panelInferior, BorderLayout.SOUTH);

        add(panelPrincipal);
    }

    private JPanel crearPanelFormulario() {

        JPanel panelFormulario = new JPanel(new GridBagLayout());
        panelFormulario.setBorder(
                BorderFactory.createTitledBorder("Ingreso de datos")
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        JLabel etiquetaTipo = new JLabel("Tipo de entidad:");

        comboTipoEntidad = new JComboBox<>(new String[]{
                "Guía turístico",
                "Vehículo",
                "Colaborador externo"
        });

        comboTipoEntidad.addActionListener(
                evento -> actualizarEtiquetaDetalle()
        );

        JLabel etiquetaNombre = new JLabel("Nombre o identificación:");

        campoNombre = new JTextField(20);

        etiquetaDetalle = new JLabel("Especialidad:");

        campoDetalle = new JTextField(20);

        gbc.gridx = 0;
        gbc.gridy = 0;
        panelFormulario.add(etiquetaTipo, gbc);

        gbc.gridx = 1;
        panelFormulario.add(comboTipoEntidad, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        panelFormulario.add(etiquetaNombre, gbc);

        gbc.gridx = 1;
        panelFormulario.add(campoNombre, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        panelFormulario.add(etiquetaDetalle, gbc);

        gbc.gridx = 1;
        panelFormulario.add(campoDetalle, gbc);

        JPanel panelBotones = new JPanel();

        JButton botonGuardar = new JButton("Guardar");
        JButton botonLimpiar = new JButton("Limpiar");
        JButton botonMostrar = new JButton("Mostrar registros");

        botonGuardar.addActionListener(
                evento -> guardarEntidad()
        );

        botonLimpiar.addActionListener(
                evento -> limpiarCampos()
        );

        botonMostrar.addActionListener(
                evento -> mostrarRegistros()
        );

        panelBotones.add(botonGuardar);
        panelBotones.add(botonLimpiar);
        panelBotones.add(botonMostrar);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;

        panelFormulario.add(panelBotones, gbc);

        return panelFormulario;
    }

    private JPanel crearPanelInferior() {

        JPanel panelInferior = new JPanel(new BorderLayout());

        panelInferior.setBorder(
                BorderFactory.createTitledBorder("Entidades registradas")
        );

        areaRegistros = new JTextArea(8, 45);
        areaRegistros.setEditable(false);
        areaRegistros.setLineWrap(true);
        areaRegistros.setWrapStyleWord(true);

        JScrollPane scroll = new JScrollPane(areaRegistros);

        panelInferior.add(scroll, BorderLayout.CENTER);

        return panelInferior;
    }

    private void actualizarEtiquetaDetalle() {

        String tipoSeleccionado =
                (String) comboTipoEntidad.getSelectedItem();

        if ("Guía turístico".equals(tipoSeleccionado)) {
            etiquetaDetalle.setText("Especialidad:");

        } else if ("Vehículo".equals(tipoSeleccionado)) {
            etiquetaDetalle.setText("Tipo de vehículo:");

        } else {
            etiquetaDetalle.setText("Rol:");
        }

        campoDetalle.setText("");
    }

    private void guardarEntidad() {

        String tipoSeleccionado =
                (String) comboTipoEntidad.getSelectedItem();

        String nombre = campoNombre.getText().trim();
        String detalle = campoDetalle.getText().trim();

        if (nombre.isEmpty() || detalle.isEmpty()) {

            JOptionPane.showMessageDialog(
                    this,
                    "Debes completar todos los campos.",
                    "Datos incompletos",
                    JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        if ("Guía turístico".equals(tipoSeleccionado)) {

            GuiaTuristico guia =
                    new GuiaTuristico(nombre, detalle);

            gestorEntidades.agregarEntidad(guia);

        } else if ("Vehículo".equals(tipoSeleccionado)) {

            Vehiculo vehiculo =
                    new Vehiculo(nombre, detalle);

            gestorEntidades.agregarEntidad(vehiculo);

        } else {

            ColaboradorExterno colaborador =
                    new ColaboradorExterno(nombre, detalle);

            gestorEntidades.agregarEntidad(colaborador);
        }

        JOptionPane.showMessageDialog(
                this,
                "Entidad registrada correctamente.",
                "Registro exitoso",
                JOptionPane.INFORMATION_MESSAGE
        );

        mostrarRegistros();
        limpiarCampos();
    }

    private void mostrarRegistros() {

        areaRegistros.setText(
                gestorEntidades.obtenerResumenDeEntidades()
        );
    }

    private void limpiarCampos() {

        campoNombre.setText("");
        campoDetalle.setText("");
        campoNombre.requestFocus();
    }
}