
package Entidades;
public class CategoriaProducto {
    private int id;
    private String nombre,descripcion;

    public CategoriaProducto() {
        
    }

    public CategoriaProducto(String nombreCategoria, String descripcionCategoria) {
    }

    public CategoriaProducto(int id, String nombre, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
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

    @Override
    public String toString() {
        return this.nombre ;
    }
    
public String verDatos() {
            return "Nombre: " + nombre + "\n"+
                "Descripción: " + descripcion+ "\n" ;
    }
}
