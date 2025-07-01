
package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.CategoriaProducto;
import java.sql.*;
import java.util.ArrayList;

public class BDComboboxCategoriaProducto implements ICRUD{

    @Override
    public ArrayList listar() throws Exception {
    ArrayList arrCP = new ArrayList();
    String sql = "SELECT * FROM categoriaproducto";
    
    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ){
        while (rs.next()) {
            CategoriaProducto objCP = new CategoriaProducto();
            objCP.setId(rs.getInt("idCategoria"));
            objCP.setNombrecat(rs.getString("nombreCategoria"));
            objCP.setDescripcion(rs.getString("descripcionCategoria"));
            arrCP.add(objCP);
        }
    } catch (Exception e) {
        throw e;
    }
    return arrCP;
    }

    @Override
    public int crear(Object object) throws SQLException {
        CategoriaProducto objCP = (CategoriaProducto) object;
        int idGenerado = -1;
        
        String sql = "INSERT INTO categoriaproducto(idCategoria, nombreCategoria,descripcionCategoria) VALUES(?,?,?)";
        
        try(
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) 
            ){      
            ps.setInt(1, objCP.getId());
            ps.setString(2, objCP.getNombrecat());
            ps.setString(3, objCP.getDescripcion());
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
        CategoriaProducto objCP = (CategoriaProducto) object;
        String sql = "UPDATE categoriaproducto SET nombreDescripcion=?, descripcionCategoria=? WHERE idCategoria=?";
        try (
           Connection con = Conexion.conectar();
           PreparedStatement ps = con.prepareStatement(sql)
            ){
            ps.setString(1, objCP.getNombrecat());
            ps.setString(2, objCP.getDescripcion());
            ps.setInt(3, id); // ID al final para el WHERE
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } 
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM categoriaproducto WHERE idCategoria=?";
        try (Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
            ){
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        } 
    }

    @Override
    public Object obtener(int id) throws Exception {
        CategoriaProducto objCP = null;
        String sql = "SELECT * FROM categoriaproducto WHERE idCategoria= ?";

        try(
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
            ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()
                 ){
                if(rs.next()) {
                    objCP = new CategoriaProducto();
                    objCP.setId(rs.getInt("idCategoria"));
                    objCP.setNombrecat(rs.getString("nombreCategoria"));
                    objCP.setDescripcion(rs.getString("descripcionCategoria"));    
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return objCP;
    }
    
}
