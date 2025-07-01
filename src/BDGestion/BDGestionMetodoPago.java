
package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.MetodoPago;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionMetodoPago implements ICRUD{

    @Override
    public ArrayList listar() throws Exception {
    ArrayList arrCP = new ArrayList();
    String sql = "SELECT * FROM metodopago";
    
    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ){
        while (rs.next()) {
            MetodoPago objCP = new MetodoPago();
            objCP.setId(rs.getInt("idMetodoPago"));
            objCP.setTipoPago(rs.getString("tipoPago"));
            arrCP.add(objCP);
        }
    } catch (Exception e) {
        throw e;
    }
    return arrCP;
    }

    @Override
    public int crear(Object object) throws SQLException {
        MetodoPago objCP = (MetodoPago) object;
        int idGenerado = -1;
        
        String sql = "INSERT INTO metodopago(idMetodoPago, tipoPago) VALUES(?,?)";
        
        try(
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS) 
            ){      
            ps.setInt(1, objCP.getId());
            ps.setString(2, objCP.getTipoPago());
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
        MetodoPago objCP = (MetodoPago) object;
        String sql = "UPDATE metodopago SET tipoPago=? WHERE idMetodoPago=?";
        try (
           Connection con = Conexion.conectar();
           PreparedStatement ps = con.prepareStatement(sql)
            ){
            ps.setString(1, objCP.getTipoPago());

            ps.setInt(2, id); // ID al final para el WHERE
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } 
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM metodopago WHERE idMetodoPago=?";
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
        MetodoPago objCP = null;
        String sql = "SELECT * FROM metodopago WHERE idMetodoPago= ?";

        try(
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
            ){
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()
                 ){
                if(rs.next()) {
                    objCP = new MetodoPago();
                    objCP.setId(rs.getInt("idMetodoPago"));
                    objCP.setTipoPago(rs.getString("tipoPago")); 
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return objCP;
    }
    
}
