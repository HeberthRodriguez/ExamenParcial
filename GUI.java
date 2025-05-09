import javax.swing.JComboBox;
import javax.swing.JFrame;

public class GUI extends JFrame {

    private JComboBox<String> comboBox; // Declarando el cuadro combinado en tipo cadena
    
   public GUI() {

    // Configuracion de la ventana   
   
    setTitle("LI");
    setSize(700,700);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLayout(null); // aca hay que usar otro diseño de ventana para agregar botones ect...

  
    // Se inicia el cuadro combinado con elementos que serian las opciones
  
    String[] opciones = {"ROBO", "VIOLENCIA", "DROGAS", "HOMICIDIOS", "MALTRATO INFANTIL", "MALTRATO ANIMAL", "ACTITUDES IRREGULARES EN FUNCIONARIOS PUBLICOS"};
    comboBox = new JComboBox<>(opciones);

    comboBox.setBounds(70, 70, 700, 50); // Solo se usa si no hay diseño 

     // se añade el cuadro combinado a la ventana osea al JFrame
     add(comboBox);

     // Mostrar lo anterior en la ventana
     setVisible(true);

   }

   public static void main(String[] args) {
    new GUI();
}

}
