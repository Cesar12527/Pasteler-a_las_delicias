
package Entidades;

public class Producto {
    private int id;
    private String nombre;
    private double precioUnitario;
    private int stock;
    private String unidadMedida;
    private CategoriaProducto categoriaProducto;
    
    public Producto() {
    }

    public Producto(String nombre, double precioUnitario, int stock, String unidadMedida,CategoriaProducto categoriaProducto) {
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.stock = stock;
        this.unidadMedida = unidadMedida;
        this.categoriaProducto = categoriaProducto;
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

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public CategoriaProducto getCategoriaProducto() {
        return categoriaProducto;
    }

    public void setCategoriaProducto(CategoriaProducto categoriaProducto) {
        this.categoriaProducto = categoriaProducto;
    }
    
    

    @Override
    public String toString() {
        return "Producto{" + "id=" + id + ", nombre=" + nombre + ", precioUnitario=" + precioUnitario + ", stock=" + stock + ", unidadMedida=" + unidadMedida + ", categoriaProducto=" + categoriaProducto + '}';
    }
    
  
    public String verDatos() {
            return  "Nombre: " + nombre  + "\n" +
                    "Telefono: " + precioUnitario +"\n" +   
                    "Direccion: " + stock +"\n";
    }
   
}
