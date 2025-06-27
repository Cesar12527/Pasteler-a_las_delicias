package Entidades;

import java.util.Date;

public class ActivoFijo {
    private int id;
    private String nombre;
    private String descripcion;
    private Date fechaAdquisicion;
    private double valorPrecio;
    private String estado;

    public ActivoFijo() {
    }

    public ActivoFijo(int id, String nombre, String descripcion, Date fechaAdquisicion, double valorPrecio, String estado) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fechaAdquisicion = fechaAdquisicion;
        this.valorPrecio = valorPrecio;
        this.estado = estado;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFechaAdquisicion() {
        return fechaAdquisicion;
    }

    public void setFechaAdquisicion(Date fechaAdquisicion) {
        this.fechaAdquisicion = fechaAdquisicion;
    }

    public double getValorPrecio() {
        return valorPrecio;
    }

    public void setValorPrecio(double valorPrecio) {
        this.valorPrecio = valorPrecio;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

   

    // Opcional: método toString()
    @Override
    public String toString() {
        return "ActivoFijo{" +
                "idActivoFijo=" + id+
                ", nombre='" + nombre + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", fechaAdquisicion=" + fechaAdquisicion +
                ", valorPrecio=" + valorPrecio +
                ", estado='" + estado + '\'' +
                '}';
    }
}