package Entidades;

public class Empleado {
    private int idEmpleado;
    private String nombreEmpleado;
    private String apellidos;
    private String correo;
    private String estado;
    private Usuario usuario; // Relación con Usuario

    // Constructores
    public Empleado() {
    }

    public Empleado(String nombreEmpleado, String apellidos, String correo, String estado, Usuario usuario) {
        this.nombreEmpleado = nombreEmpleado;
        this.apellidos = apellidos;
        this.correo = correo;
        this.estado = estado;
        this.usuario = usuario;
    }

    // Getters y Setters
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public String toString() {
        return nombreEmpleado;
    }
}