import javax.swing.JOptionPane;

public class DenunciaConfidencial extends Denuncia {

    public DenunciaConfidencial(String tipo, String descripcion, String lugar, String fecha) {
        super(tipo, descripcion, lugar, fecha); // Llamamos al constructor de la clase padre 
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + "\nDescripción: " + descripcion + "\nLugar: " + lugar +
               "\nFecha: " + fecha + "\n[Confidencial]";
    }

    @Override
    public void procesarDenuncia() {
       
        String mensaje = "Procesando denuncia CONFIDENCIAL...\n"
                   + "Enviando a autoridades SIN datos del denunciante.";
   
                   JOptionPane.showMessageDialog(null, mensaje, "Procesar Denuncia", JOptionPane.INFORMATION_MESSAGE);
        
    }



}

