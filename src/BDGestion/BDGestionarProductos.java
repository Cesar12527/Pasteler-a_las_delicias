
package BDGestion;

import BaseDatos.ICRUD;
import BaseDatos.Conexion;
import Entidades.CategoriaProducto;
import Entidades.Producto;
import java.sql.*;

import java.util.ArrayList;

public class BDGestionarProductos implements ICRUD{
private Connection con = null;
    @Override
    public ArrayList listar() throws Exception {
        
        ArrayList arrProd = new ArrayList();
        String sql = """
                SELECT p.idProducto, p.nombreProducto, p.precioUnitario, p.stock, p.unidadMedida, p.id_tipo_categoria,
                          cp.nombreCategoria , cp.descripcionCategoria
                FROM producto AS p
                INNER JOIN categoriaproducto AS cp ON p.id_tipo_categoria = cp.idCategoria
                     """;
        try (        
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
            ){
            Producto objP = null;
            CategoriaProducto cat_Producto = null;
            //objP.setCategoriaProducto(new CategoriaProducto());
            while (rs.next()) {                
                int id = rs.getInt("idProducto");
                String nombre = rs.getString("nombreProducto");
                Double precio = rs.getDouble("precioUnitario");
                int stock = rs.getInt("stock");
                String unidadMedida = rs.getString("unidadMedida");
                
                String nombreCategoria = rs.getString("nombreCategoria");
                String descripcionCategoria = rs.getString("descripcionCategoria");
                
                cat_Producto = new CategoriaProducto(nombreCategoria, descripcionCategoria);
                objP = new Producto(nombre, precio, stock, unidadMedida,cat_Producto);
                objP.setId(id);
                arrProd.add(objP);
            }   
        } catch (Exception e) {
            throw e;
           
        }
        
        return arrProd;
    }

    @Override
    public int crear(Object object) throws SQLException {
        Producto objP = (Producto) object;
        int idGenerado = -1;
        
        String sql = "INSERT INTO producto(nombreProducto, precioUnitario, stock, unidadMedida, id_tipo_categoria)" +
                     " VALUES(?,?,?,?,?)";
        
        try(
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) 
            ){      
            ps.setString(1, objP.getNombre());
            ps.setDouble(2, objP.getPrecioUnitario());
            ps.setInt(3, objP.getStock());
            ps.setString(4, objP.getUnidadMedida());
            ps.setInt(5, objP.getCategoriaProducto().getId());
            ps.executeUpdate();
            
            try( ResultSet rs = ps.getGeneratedKeys()
                ){
                if(rs.next()){
                    idGenerado = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            throw e;
        }
        return idGenerado;
    }

    @Override
    public void actualizar(int id, Object object) throws Exception {
        Producto objP = (Producto) object;
        String sql ="UPDATE producto SET nombreProducto=?, precioUnitario=?, stock=?, unidadMedida=?, id_tipo_categoria= ? WHERE idProducto=?";
        try (
           Connection con = Conexion.conectar();
           PreparedStatement ps = con.prepareStatement(sql)
            ){
            ps.setString(1, objP.getNombre());
            ps.setDouble(2, objP.getPrecioUnitario());
            ps.setInt(3, objP.getStock());
            ps.setString(4, objP.getUnidadMedida());
            ps.setInt(5, objP.getCategoriaProducto().getId());

            ps.setInt(6, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } 
    }

    @Override
    public void eliminar(int id) throws Exception {
        PreparedStatement ps = null;
        try{
            con = Conexion.conectar();
            String sql = "DELETE FROM producto WHERE idProducto = ?";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            
            int filasAfectadas = ps.executeUpdate();

            if (filasAfectadas > 0) {
                System.out.println("Producto con ID " + id + " fue marcado como inactivo.");
            } else {
                System.out.println("No se encontró el Producto con ID " + id + " para marcarlo como inactivo.");
            }
            
        }catch(Exception e){
            throw e;
        }finally{
            con = null;
            ps = null;
        }
    }

    @Override
    public Object obtener(int id) throws Exception {
        Producto objC = new Producto();
        String sql = "SELECT * FROM producto WHERE idProducto= ?";

        try(
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
            ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()
                 ){

                if(rs.next()) {
                    objC = new Producto();
                    objC.setId(rs.getInt("idProducto"));
                    objC.setNombre(rs.getString("nombreProducto"));
                    objC.setPrecioUnitario(rs.getDouble("precioUnitario"));
                    objC.setStock(rs.getInt("stock"));
                    objC.setUnidadMedida(rs.getString("unidadMedida"));

                } else {
                objC = null;
            }
            }
        } catch (Exception e) {
            throw e;
        }
        return objC;
    }
    
}
