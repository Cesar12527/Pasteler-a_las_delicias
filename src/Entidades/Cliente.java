
package Entidades;

public class Cliente {
    private int id;
    private String nombre, apellidos, dni, telefono;

    public Cliente() {

    }

    public Cliente(int id, String nombre, String apellidos, String dni, String telefono) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.telefono = telefono;
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



    @Override
    public String toString() {
        return (nombre != null) ? nombre : "Sin cliente";
    }
    
    public String verDatos() {
            return "Apellidos: " + apellidos + "\n"+
                "Nombre: " + nombre  + "\n" +
                "Dni: " + dni +"\n" +
                "Telefono: " + telefono +"\n";
    }
    
}
