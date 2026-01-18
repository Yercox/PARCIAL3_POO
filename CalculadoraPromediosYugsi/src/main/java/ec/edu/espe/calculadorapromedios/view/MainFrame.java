package ec.edu.espe.calculadorapromedios.view;

import javax.swing.*;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {

    private JTextField txtNota1;
    private JTextField txtNota2;
    private JTextField txtNota3;
    private JTextField txtResultado;
    private JButton btnCalcular;

    public MainFrame() {
        setTitle("Calculadora de Promedios");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        JLabel lbl1 = new JLabel("Nota 1:");
        lbl1.setBounds(30, 30, 80, 25);
        add(lbl1);

        txtNota1 = new JTextField();
        txtNota1.setBounds(120, 30, 150, 25);
        add(txtNota1);

        JLabel lbl2 = new JLabel("Nota 2:");
        lbl2.setBounds(30, 70, 80, 25);
        add(lbl2);

        txtNota2 = new JTextField();
        txtNota2.setBounds(120, 70, 150, 25);
        add(txtNota2);

        JLabel lbl3 = new JLabel("Nota 3:");
        lbl3.setBounds(30, 110, 80, 25);
        add(lbl3);

        txtNota3 = new JTextField();
        txtNota3.setBounds(120, 110, 150, 25);
        add(txtNota3);

        btnCalcular = new JButton("Calcular");
        btnCalcular.setBounds(30, 150, 100, 30);
        add(btnCalcular);

        txtResultado = new JTextField();
        txtResultado.setBounds(150, 150, 120, 30);
        txtResultado.setEditable(false);
        add(txtResultado);
    }

    public double getNota1() {
        return Double.parseDouble(txtNota1.getText());
    }

    public double getNota2() {
        return Double.parseDouble(txtNota2.getText());
    }

    public double getNota3() {
        return Double.parseDouble(txtNota3.getText());
    }

    public void setResultado(double resultado) {
        txtResultado.setText(String.format("%.2f", resultado));
    }

    public void addCalcularListener(ActionListener listener) {
        btnCalcular.addActionListener(listener);
    }

    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
    }
    public void mostrarEstado(String estado) {
        JOptionPane.showMessageDialog(this, "Estado: " + estado);
    }
}