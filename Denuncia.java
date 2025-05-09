
public abstract class Denuncia {

    // atributos protegidos ya que no pueden ser privados por que ocupamos que se hereden a las subclases ....
    protected String tipo;
    protected String descripcion;
    protected String lugar;
    protected String fecha;
   
    // constructor
    public Denuncia(String tipo, String descripcion, String lugar, String fecha) {
        this.tipo = tipo;
        this.descripcion = descripcion;
        this.lugar = lugar;
        this.fecha = fecha;
    }

    // aca definimos un metodo abstracto
    public abstract String toString();

    // para ver que tipo de denuncia es
    public abstract void procesarDenuncia();


    // gets y sets
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
