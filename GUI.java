import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

public class GUI extends JFrame {

    private ArrayList<DenunciaConIdentidad> denunciasConIdentidad = new ArrayList<>();
    private HashMap<String, DenunciaConfidencial> denunciasConfidenciales = new HashMap<>();

    public GUI() {
        setTitle("Sistema de Denuncias Ciudadanas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(5, 1, 10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titulo = new JLabel("Menú Principal", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        JButton btnHacer = new JButton("Hacer denuncia");
        JButton btnBuscar = new JButton("Buscar denuncia");
        JButton btnMostrar = new JButton("Mostrar denuncias");
        JButton btnRetirar = new JButton("Retirar denuncia");

        btnHacer.addActionListener(e -> mostrarOpcionesHacer());
        btnBuscar.addActionListener(e -> mostrarOpcionesBuscar());
        btnMostrar.addActionListener(e -> mostrarOpcionesMostrar());
        btnRetirar.addActionListener(e -> mostrarOpcionesRetirar());

        panel.add(btnHacer);
        panel.add(btnBuscar);
        panel.add(btnMostrar);
        panel.add(btnRetirar);

        add(panel);
        setVisible(true);
    }

    private void mostrarOpcionesHacer() {
        String[] opciones = {"Denuncia Confidencial", "Denuncia con Identidad"};
        int eleccion = JOptionPane.showOptionDialog(this, "Seleccione tipo de denuncia:",
                "Hacer Denuncia", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opciones, opciones[0]);

        if (eleccion == 0) {
            JTextArea descripcion = new JTextArea(5, 20);
            JScrollPane scroll = new JScrollPane(descripcion);
            int input = JOptionPane.showConfirmDialog(this, scroll, "Describa los hechos:", JOptionPane.OK_CANCEL_OPTION);
            if (input == JOptionPane.OK_OPTION) {
                String codigo = UUID.randomUUID().toString().substring(0, 8);
                DenunciaConfidencial denuncia = new DenunciaConfidencial("Confidencial", descripcion.getText(), "Lugar no revelado", "Fecha no revelada");
                denunciasConfidenciales.put(codigo, denuncia);
                JOptionPane.showMessageDialog(this, "Denuncia enviada. Código: " + codigo);
            }
        } else if (eleccion == 1) {
            JFrame formulario = new JFrame("Denuncia con Identidad");
            formulario.setSize(400, 500);
            formulario.setLocationRelativeTo(null);
            formulario.setLayout(new BorderLayout());

            JPanel panelCampos = new JPanel(new GridLayout(7, 2, 5, 5));
            panelCampos.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

            JTextField campoTipo = new JTextField();
            JTextField campoDescripcion = new JTextField();
            JTextField campoLugar = new JTextField();
            JTextField campoFecha = new JTextField();
            JTextField campoNombre = new JTextField();
            JTextField campoCedula = new JTextField();
            JTextField campoTelefono = new JTextField();

            panelCampos.add(new JLabel("Tipo de denuncia:"));
            panelCampos.add(campoTipo);
            panelCampos.add(new JLabel("Descripción:"));
            panelCampos.add(campoDescripcion);
            panelCampos.add(new JLabel("Lugar:"));
            panelCampos.add(campoLugar);
            panelCampos.add(new JLabel("Fecha de los hechos:"));
            panelCampos.add(campoFecha);
            panelCampos.add(new JLabel("Nombre completo:"));
            panelCampos.add(campoNombre);
            panelCampos.add(new JLabel("Número de cédula:"));
            panelCampos.add(campoCedula);
            panelCampos.add(new JLabel("Teléfono:"));
            panelCampos.add(campoTelefono);

            JButton botonEnviar = new JButton("Enviar denuncia");
            botonEnviar.addActionListener(e -> {
                String tipo = campoTipo.getText().trim();
                String descripcion = campoDescripcion.getText().trim();
                String lugar = campoLugar.getText().trim();
                String fecha = campoFecha.getText().trim();
                String nombre = campoNombre.getText().trim();
                String cedula = campoCedula.getText().trim();
                String telefono = campoTelefono.getText().trim();

                if (tipo.isEmpty() || descripcion.isEmpty() || lugar.isEmpty() || fecha.isEmpty() || nombre.isEmpty() || cedula.isEmpty() || telefono.isEmpty()) {
                    JOptionPane.showMessageDialog(formulario, "Por favor complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Cliente cliente = new Cliente(nombre, cedula, telefono);
                DenunciaConIdentidad denuncia = new DenunciaConIdentidad(tipo, descripcion, lugar, fecha, cliente);
                denunciasConIdentidad.add(denuncia);

                JOptionPane.showMessageDialog(formulario, "Denuncia con identidad enviada con éxito.", "Confirmación", JOptionPane.INFORMATION_MESSAGE);
                formulario.dispose();
            });

            formulario.add(panelCampos, BorderLayout.CENTER);
            formulario.add(botonEnviar, BorderLayout.SOUTH);
            formulario.setVisible(true);
        }
    }

    private void mostrarOpcionesBuscar() {
        String[] opciones = {"Denuncias Confidenciales", "Denuncias con Identidad"};
        int eleccion = JOptionPane.showOptionDialog(this, "Buscar por:",
                "Buscar Denuncia", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opciones, opciones[0]);

        if (eleccion == 0) {
            String codigo = JOptionPane.showInputDialog(this, "Ingrese el código de la denuncia confidencial:");
            if (codigo != null && denunciasConfidenciales.containsKey(codigo)) {
                JOptionPane.showMessageDialog(this, denunciasConfidenciales.get(codigo).toString());
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la denuncia.");
            }
        } else if (eleccion == 1) {
            String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula del denunciante:");
            for (DenunciaConIdentidad d : denunciasConIdentidad) {
                if (d.getCliente().getCedula().equals(cedula)) {
                    JOptionPane.showMessageDialog(this, d.toString());
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "No se encontró la denuncia.");
        }
    }

    private void mostrarOpcionesMostrar() {
        String[] opciones = {"Denuncias Confidenciales", "Denuncias con Identidad"};
        int eleccion = JOptionPane.showOptionDialog(this, "Mostrar:",
                "Mostrar Denuncias", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opciones, opciones[0]);

        if (eleccion == 0) {
            StringBuilder sb = new StringBuilder();
            for (String key : denunciasConfidenciales.keySet()) {
                sb.append("Código: ").append(key).append("\n").append(denunciasConfidenciales.get(key).toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No hay denuncias confidenciales.");
        } else if (eleccion == 1) {
            StringBuilder sb = new StringBuilder();
            for (DenunciaConIdentidad d : denunciasConIdentidad) {
                sb.append(d.toString()).append("\n\n");
            }
            JOptionPane.showMessageDialog(this, sb.length() > 0 ? sb.toString() : "No hay denuncias con identidad.");
        }
    }

    private void mostrarOpcionesRetirar() {
        String[] opciones = {"Denuncias Confidenciales", "Denuncias con Identidad"};
        int eleccion = JOptionPane.showOptionDialog(this, "Retirar:",
                "Retirar Denuncia", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE,
                null, opciones, opciones[0]);

        if (eleccion == 0) {
            String codigo = JOptionPane.showInputDialog(this, "Ingrese el código de la denuncia a eliminar:");
            if (codigo != null && denunciasConfidenciales.containsKey(codigo)) {
                denunciasConfidenciales.remove(codigo);
                JOptionPane.showMessageDialog(this, "Denuncia confidencial eliminada.");
            } else {
                JOptionPane.showMessageDialog(this, "No se encontró la denuncia.");
            }
        } else if (eleccion == 1) {
            String cedula = JOptionPane.showInputDialog(this, "Ingrese la cédula:");
            for (int i = 0; i < denunciasConIdentidad.size(); i++) {
                if (denunciasConIdentidad.get(i).getCliente().getCedula().equals(cedula)) {
                    denunciasConIdentidad.remove(i);
                    JOptionPane.showMessageDialog(this, "Denuncia con identidad eliminada.");
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "No se encontró la denuncia.");
        }
    }

    public void agregarDenunciaConIdentidad(DenunciaConIdentidad denuncia) {
        denunciasConIdentidad.add(denuncia);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
