import javax.swing.JOptionPane;

public class DenunciaConIdentidad extends Denuncia {
    private Cliente cliente;  // aca hacemos una relacion de composicion ya que la clase DenunciaConIdentidad usa como atributo a Cliente 

    // Constructor ...
    public DenunciaConIdentidad(String tipo, String descripcion, String lugar, String fecha, Cliente cliente) {
        super(tipo, descripcion, lugar, fecha);  // Llamamos al constructor de la clase padre
        this.cliente = cliente;
    }

    // Getter para cliente
    public Cliente getCliente() {
        return cliente;
    }

    // Setter para cliente
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    // Sobrescribir el metodo toString para incluir los detalles del cliente
    @Override
    public String toString() {
        return "Tipo de Denuncia: " + getTipo() + "\nDescripción: " + getDescripcion() +
               "\nLugar: " + getLugar() + "\nFecha: " + getFecha() + 
               "\nCliente: " + cliente.toString();  // Usamos el toString del cliente
    }

    @Override
    public void procesarDenuncia() {
       
        String mensaje = "Procesando denuncia CON IDENTIDAD...\n"
                   + "Nombre del denunciante: " + cliente.getNombre() + "\n"
                   + "Cédula: " + cliente.getCedula() + "\n"
                   + "Teléfono: " + cliente.getTelefono() + "\n"
                   + "Enviando a autoridades CON datos del denunciante.";
                JOptionPane.showMessageDialog(null, mensaje, "Procesar Denuncia", JOptionPane.INFORMATION_MESSAGE);
        
    }


}

    