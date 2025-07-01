
package Entidades;
public class CategoriaProducto {
    private int id;
    private String nombrecat,descripcion;

    public CategoriaProducto() {
        
        
    }

    public CategoriaProducto(String nombrecat, String descripcionCategoria) {
        this.nombrecat=nombrecat;
        this.descripcion=descripcionCategoria;
    }


    public CategoriaProducto(int id, String nombrecat, String descripcion) {
        this.id = id;
        this.nombrecat = nombrecat;
        this.descripcion = descripcion;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombrecat() {
        return nombrecat;
    }

    public void setNombrecat(String nombre) {
        this.nombrecat = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return this.nombrecat ;
    }
    
}
