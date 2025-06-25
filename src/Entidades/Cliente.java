
package Entidades;

public class Cliente {
    private int id;
    private String nombre, apellidos, dni, telefono, direccion, correo;

    public Cliente() {

    }

    public Cliente(int id, String nombre, String apellidos, String dni, String telefono, String direccion, String correo) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return  this.apellidos + " " + this.nombre + " - " + this.dni;
    }
    
    public String verDatos() {
            return "Apellidos: " + apellidos + "\n"+
                "Nombre: " + nombre  + "\n" +
                "Dni: " + dni +"\n" +
                "Telefono: " + telefono +"\n" +   
                "Direccion: " + direccion +"\n";
    }
    
}
