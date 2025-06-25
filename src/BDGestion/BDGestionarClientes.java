
package BDGestion;

import BaseDatos.ICRUD;
import BaseDatos.Conexion;
import Entidades.Cliente;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionarClientes implements ICRUD{
    private Connection con = null;
    private PreparedStatement  ps = null ;
    private ResultSet rs = null;

    @Override
    public ArrayList listar() throws Exception {
        ArrayList arrClientes = new ArrayList();
        try {
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM cliente";
    
            ps = this.con.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {                
                int id = rs.getInt("id");
                String nombres = rs.getString("nombres");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("dni");
                String telefono = rs.getString("telefono");
                String direccion = rs.getString("direccion");
                String correo = rs.getString("correo");
                
                Cliente objC = new Cliente(id,nombres,apellidos,dni,telefono,direccion,correo);
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
            Cliente objC = (Cliente) object;
        int idGenerado = 0;
        
        try {
            this.con  = Conexion.conectar();
            String sql = "INSERT INTO cliente(nombres, apellidos,dni,telefono,direccion,correo) VALUES(?,?,?,?,?,?)";
            ps = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getApellidos());
            ps.setString(3, objC.getDni());
            ps.setString(4, objC.getTelefono());
            ps.setString(5, objC.getDireccion());
            ps.setString(6, objC.getCorreo());
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
        Cliente objC = (Cliente) object;
    
        try {
            this.con = Conexion.conectar();
            String sql = "UPDATE cliente SET nombre=?, apellidos=?, dni=?, telefono=?, direccion=?, correo=? WHERE id=?";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getApellidos());
            ps.setString(3, objC.getDni());
            ps.setString(4, objC.getTelefono());
            ps.setString(5, objC.getDireccion());
            ps.setString(6, objC.getCorreo());
            ps.setInt(7, id); // ID al final para el WHERE
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } 
    }

    @Override
    public void eliminar(int id) throws Exception {
        try {
            this.con = Conexion.conectar();
            String sql = "DELETE FROM cliente WHERE id=?";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();

        } catch (Exception e) {
            throw e;
        } 
    }

    @Override
    public Object obtener(int id) throws Exception {
        Cliente objC = new Cliente();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM cliente WHERE id= ?";
            ps = this.con.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();   
            if(rs.next()) {                
                objC.setId(rs.getInt("id"));
                objC.setNombre(rs.getString("nombres"));
                objC.setApellidos(rs.getString("apellidos"));
                objC.setDni(rs.getString("dni"));
                objC.setTelefono(rs.getString("telefono"));
                objC.setCorreo(rs.getString("correo"));
                objC.setDireccion(rs.getString("direccion"));     
            }else{
                objC = null;        
            }
        } catch (Exception e) {
            throw e;
        }
        return objC;
       
    }
    
}
