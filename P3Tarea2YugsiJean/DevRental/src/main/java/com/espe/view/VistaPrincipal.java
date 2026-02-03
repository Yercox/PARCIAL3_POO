package com.espe.view;

import com.espe.controller.AlquilerController;
import com.espe.repository.MongoVehiculoRepository;
import com.espe.service.VehiculoService;
import com.espe.model.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class VistaPrincipal extends JFrame {
    private VehiculoService vehiculoService;
    private AlquilerController controller;

    private JTextField txtPlaca, txtMarca, txtModelo, txtPrecio;
    private JButton btnRegistrar, btnLimpiar;
    private JTextArea txtConsola;

    public VistaPrincipal() {
        MongoVehiculoRepository repository = new MongoVehiculoRepository();

        this.vehiculoService = new VehiculoService(repository);

        this.controller = new AlquilerController(vehiculoService);

        setTitle("DevRental - Sistema con DIP");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLocationRelativeTo(null);

        initComponents();

        organizeComponents();
    }

    private void initComponents() {

        txtPlaca = new JTextField(15);
        txtMarca = new JTextField(15);
        txtModelo = new JTextField(5);
        txtPrecio = new JTextField(8);

        txtConsola = new JTextArea(10, 40);
        txtConsola.setEditable(false);
        txtConsola.setFont(new Font("Monospaced", Font.PLAIN, 12));
        txtConsola.setBackground(new Color(240, 240, 240));

        btnRegistrar = new JButton("Registrar Vehículo");
        btnRegistrar.setActionCommand("REGISTRAR_VEHICULO");

        btnLimpiar = new JButton("Limpiar");

        btnRegistrar.addActionListener(e -> registrarVehiculo());
        btnLimpiar.addActionListener(e -> limpiarFormulario());

        btnRegistrar.addActionListener(controller);
    }

    private void organizeComponents() {
        setLayout(new BorderLayout(10, 10));

        JPanel panelTitulo = new JPanel();
        JLabel lblTitulo = new JLabel("REGISTRO DE VEHÍCULOS - DIP IMPLEMENTADO");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        panelTitulo.add(lblTitulo);
        add(panelTitulo, BorderLayout.NORTH);

        JPanel panelFormulario = new JPanel(new GridLayout(4, 2, 10, 10));
        panelFormulario.setBorder(BorderFactory.createTitledBorder("Datos del Vehículo"));
        panelFormulario.add(new JLabel("Placa:"));
        panelFormulario.add(txtPlaca);
        panelFormulario.add(new JLabel("Marca:"));
        panelFormulario.add(txtMarca);
        panelFormulario.add(new JLabel("Modelo:"));
        panelFormulario.add(txtModelo);
        panelFormulario.add(new JLabel("Precio por Día:"));
        panelFormulario.add(txtPrecio);

        JScrollPane scrollConsola = new JScrollPane(txtConsola);
        scrollConsola.setBorder(BorderFactory.createTitledBorder("Consola del Sistema"));

        JPanel panelCentro = new JPanel(new BorderLayout(10, 10));
        panelCentro.add(panelFormulario, BorderLayout.NORTH);
        panelCentro.add(scrollConsola, BorderLayout.CENTER);

        JPanel panelBotones = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        panelBotones.add(btnRegistrar);
        panelBotones.add(btnLimpiar);

        add(panelCentro, BorderLayout.CENTER);
        add(panelBotones, BorderLayout.SOUTH);
    }

    private void registrarVehiculo() {
        try {

            if (txtPlaca.getText().trim().isEmpty() || txtMarca.getText().trim().isEmpty()) {
                JOptionPane.showMessageDialog(this,
                        "Placa y Marca son campos obligatorios",
                        "Error de Validación", JOptionPane.ERROR_MESSAGE);
                return;
            }

            String placa = txtPlaca.getText().trim();
            String marca = txtMarca.getText().trim();
            int modelo = Integer.parseInt(txtModelo.getText().trim());
            double precio = Double.parseDouble(txtPrecio.getText().trim());

            controller.registrarVehiculo(placa, marca, modelo, precio);

            txtConsola.append("Vehículo registrado: " + placa + "\n");
            txtConsola.append("Procesado a través de: Controlador -> Servicio -> Repositorio\n");
            txtConsola.append("==========================================\n");
            txtConsola.append("Vehículo registrado exitosamente\n" +
                    "Placa: " + placa + "\n" +
                    "Marca: " + marca + "\n" +
                    "Modelo: " + modelo + "\n" +
                    "Precio: $" + precio + "/día");

            JOptionPane.showMessageDialog(this,
                    "Vehículo registrado exitosamente\n" +
                            "Placa: " + placa + "\n" +
                            "Marca: " + marca + "\n" +
                            "Modelo: " + modelo + "\n" +
                            "Precio: $" + precio + "/día",
                    "Registro Exitoso", JOptionPane.INFORMATION_MESSAGE);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Modelo y Precio deben ser números válidos",
                    "Error de Formato", JOptionPane.ERROR_MESSAGE);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this,
                    "Error al registrar vehículo: " + e.getMessage(),
                    "Error del Sistema", JOptionPane.ERROR_MESSAGE);
            txtConsola.append("ERROR: " + e.getMessage() + "\n");
        }
    }

    private void limpiarFormulario() {
        txtPlaca.setText("");
        txtMarca.setText("");
        txtModelo.setText("");
        txtPrecio.setText("");
        txtConsola.setText("");
    }
}