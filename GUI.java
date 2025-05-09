import javax.swing.*;
import java.awt.*;

public class GUI extends JFrame {

    public GUI() {

        // aca se configura la ventana
        setTitle("Sistema de Denuncias Ciudadanas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centrar ventana
        setResizable(false);

        // se crea un panel que usa diseño cuadricola
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 1, 10, 10)); // 5 filas, 1 columna, espacios de 10px

        // se crea una etiqueta de bienvenida
        JLabel titulo = new JLabel("Menú Principal", JLabel.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 20));
        panel.add(titulo);

        // estos son los botones del menu 
        JButton btnHacer = new JButton("Hacer denuncia");
        JButton btnBuscar = new JButton("Buscar denuncia");
        JButton btnMostrar = new JButton("Mostrar denuncias");
        JButton btnRetirar = new JButton("Retirar denuncia");

        // aca se agregan botones al panel

        panel.add(btnHacer);
        panel.add(btnBuscar);
        panel.add(btnMostrar);
        panel.add(btnRetirar);

        // Agregar panel a la ventana
        add(panel);

        // Hacer que se vea la ventana
        setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }
}
