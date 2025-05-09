public class Cliente {

    //1. tenemos atributos privados (encapsulados)
    private String nombre;
    private String cedula;
    private String telefono;

    // el constructor 
    public Cliente(String nombre, String cedula, String telefono) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
    }

    //2. el metodo toString que lo usamos para devolver los valores de los atributos de cliente
    public String toString() {
        return "Nombre: " + nombre + "\nCédula: " + cedula + "\nTeléfono: " + telefono;
    }


    //3. los gets y sets para acceder y modificar datos
    public String getNombre() {
        return nombre;
    }

    public String getCedula() {
        return cedula;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

}