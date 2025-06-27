
package BDGestion;

import BaseDatos.ICRUD;
import BaseDatos.Conexion;
import Entidades.CategoriaProducto;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionTipoProductos implements ICRUD{
    private Connection con = null;
    private PreparedStatement  ps = null ;
    private ResultSet rs = null;

    @Override
    public ArrayList listar() throws Exception {
        ArrayList arrClientes = new ArrayList();
        try {
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM categoriaproducto";
    
            ps = this.con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("idCategoria");
                String nombre = rs.getString("nombreCategoria");
                String descripcion = rs.getString("descripcionCategoria");
        
                
                CategoriaProducto objC = new CategoriaProducto(id,nombre,descripcion);
                arrClientes.add(objC);
            }
            
        } catch (Exception e) {
           throw e;
        }finally{    
        }
        return arrClientes;
        
    }

    @Override
    public int crear(Object object) throws SQLException {
            CategoriaProducto objC = (CategoriaProducto) object;
        int idGenerado = 0;
        
        try {
            this.con  = Conexion.conectar();
            String sql = "INSERT INTO categoriaproducto(nombreCategoria, descripcionCategoria) VALUES(?,?)";
            ps = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getDescripcion());            
            ps.executeUpdate();
            
            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idGenerado = rs.getInt(1);
            }
        } catch (SQLException e) {
            throw e;
        }
        return idGenerado;
 
    }

    @Override
    public void actualizar(int id, Object object) throws Exception {
        CategoriaProducto objC = (CategoriaProducto) object;
    
        try {
            this.con = Conexion.conectar();
            String sql = "UPDATE categoriaproducto SET nombreCategoria=?, descripcionCategoria=? WHERE idCategoria=?";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getDescripcion());
            ps.setInt(3, id); // ID al final para el WHERE
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } 
    }

@Override
public void eliminar(int id) throws Exception {
    try {
        this.con = Conexion.conectar();
        this.con.setAutoCommit(false); // Iniciar transacción

        // 1. Eliminar los productos que dependen de esta categoría
        String sqlDelProductos = "DELETE FROM producto WHERE id_tipo_categoria=?";
        ps = this.con.prepareStatement(sqlDelProductos);
        ps.setInt(1, id);
        ps.executeUpdate();

        // 2. Eliminar la categoría
        String sqlDelCategoria = "DELETE FROM categoriaproducto WHERE idCategoria=?";
        ps = this.con.prepareStatement(sqlDelCategoria);
        ps.setInt(1, id);
        ps.executeUpdate();

        this.con.commit(); // Confirmar la transacción
    } catch (Exception e) {
        if (this.con != null) this.con.rollback(); // Revertir si hay error
        throw e;
    } finally {
        if (ps != null) ps.close();
        if (con != null) con.close();
    }
}

    @Override
    public Object obtener(int id) throws Exception {
        CategoriaProducto objC = new CategoriaProducto();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM categoriaproducto WHERE idCategoria= ?";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();   
            if(rs.next()) {                
                objC.setId(rs.getInt("idCategoria"));
                objC.setNombre(rs.getString("nombreCategoria"));
                objC.setDescripcion(rs.getString("descripcionCategoria"));
            }else{
                objC = null;        
            }
        } catch (Exception e) {
            throw e;
        }
        return objC;
       
    }
    
}
