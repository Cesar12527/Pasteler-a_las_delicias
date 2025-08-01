
package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.TipoRol;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionTipoRol implements ICRUD {

    @Override
    public ArrayList listar() throws Exception {
    ArrayList arrTR = new ArrayList();
    String sql = "SELECT * FROM rol";
    
    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ){
        while (rs.next()) {
            TipoRol objTP = new TipoRol();
            objTP.setId(rs.getInt("idRol"));
            objTP.setNombre(rs.getString("nombreRol"));
            arrTR.add(objTP);
        }
    } catch (Exception e) {
        throw e;
    }
    return arrTR;
    }

    @Override
    public int crear(Object object) throws SQLException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void actualizar(int id, Object object) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminar(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Object obtener(int id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    public TipoRol obtenerPorId(int id) throws Exception {
    TipoRol rol = null;
    String sql = "SELECT * FROM rol WHERE idRol = ?";

    try (
        Connection con = Conexion.conectar();
        PreparedStatement ps = con.prepareStatement(sql)
    ) {
        ps.setInt(1, id);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                rol = new TipoRol();
                rol.setId(rs.getInt("idRol"));
                rol.setNombre(rs.getString("nombreRol"));
            }
        }
    } catch (Exception e) {
        throw new Exception("Error al obtener rol: " + e.getMessage());
    }

    return rol;
}
}