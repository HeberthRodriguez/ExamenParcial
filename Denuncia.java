
public class Denuncia {

    protected String tipo;
    protected String descripcion;
    protected String lugar;
    protected String fecha;
   
    public Denuncia(String tipo, String descripcion, String lugar, String fecha) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    public String toString() {
       
        return "Tipo: " + tipo + "\nDescripción: " + descripcion + "\nLugar: " + lugar + "\nFecha: " + fecha + "\n";

    }
    
    
    public String getTipo() {
        return tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public String getFecha() {
        return fecha;
    }


    public void setTipo(String tipo) {
        this.tipo = tipo;
    }


    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }


    public void setLugar(String lugar) {
        this.lugar = lugar;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

}
