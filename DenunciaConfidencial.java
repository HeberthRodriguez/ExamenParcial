public class DenunciaConfidencial extends Denuncia {

    public DenunciaConfidencial(String tipo, String descripcion, String lugar, String fecha) {
        super(tipo, descripcion, lugar, fecha);
    }

    @Override
    public String toString() {
        return "Tipo: " + tipo + "\nDescripción: " + descripcion + "\nLugar: " + lugar +
               "\nFecha: " + fecha + "\n[Confidencial]";
    }
    
}

