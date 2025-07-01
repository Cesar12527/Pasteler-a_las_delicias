
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
                int id = rs.getInt("idCliente");
                String nombres = rs.getString("nombreCliente");
                String apellidos = rs.getString("apellidos");
                String dni = rs.getString("documento");
                String telefono = rs.getString("telefono");
                
                Cliente objC = new Cliente(id,nombres,apellidos,dni,telefono);
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
            String sql = "INSERT INTO cliente(nombreCliente, apellidos,documento,telefono) VALUES(?,?,?,?)";
            ps = this.con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS );
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getApellidos());
            ps.setString(3, objC.getDni());
            ps.setString(4, objC.getTelefono());
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
            String sql = "UPDATE cliente SET nombreCliente=?, apellidos=?, documento=?, telefono=? WHERE idCliente=?";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, objC.getNombre());
            ps.setString(2, objC.getApellidos());
            ps.setString(3, objC.getDni());
            ps.setString(4, objC.getTelefono());
            ps.setInt(5, id); // ID al final para el WHERE
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

        // 1. Obtener todas las ventas del cliente
        String sqlVentasIds = "SELECT idVenta FROM venta WHERE idCliente=?";
        ps = this.con.prepareStatement(sqlVentasIds);
        ps.setInt(1, id);
        rs = ps.executeQuery();

        ArrayList<Integer> ventasIds = new ArrayList<>();
        while (rs.next()) {
            ventasIds.add(rs.getInt("idVenta"));
        }

        // 2. Eliminar los detalles de cada venta
        for (Integer idVenta : ventasIds) {
            String sqlDelDetalle = "DELETE FROM detalleventa WHERE idVenta=?";
            ps = this.con.prepareStatement(sqlDelDetalle);
            ps.setInt(1, idVenta);
            ps.executeUpdate();
        }

        // 3. Eliminar las ventas del cliente
        String sqlDelVentas = "DELETE FROM venta WHERE idCliente=?";
        ps = this.con.prepareStatement(sqlDelVentas);
        ps.setInt(1, id);
        ps.executeUpdate();

        // 4. Eliminar el cliente
        String sqlDelCliente = "DELETE FROM cliente WHERE idCliente=?";
        ps = this.con.prepareStatement(sqlDelCliente);
        ps.setInt(1, id);
        ps.executeUpdate();

        this.con.commit();//confirma la transacción
    } catch (Exception e) {
        if (this.con != null) this.con.rollback();
        throw e;
    } finally {
        if (ps != null) ps.close();
        if (rs != null) rs.close();
        if (con != null) con.close();
    }
} 

    @Override
     public Object obtener(int id) throws Exception{
        return null;
    }
     
    public Object obtenerCliente(String nombre) throws Exception {
        Cliente objC = new Cliente();
        ResultSet rs = null;
        PreparedStatement ps = null;
        try {
            this.con = Conexion.conectar();
            String sql = "SELECT * FROM cliente WHERE nombreCliente= ?";
            ps = this.con.prepareStatement(sql);
            ps.setString(1, nombre);
            rs = ps.executeQuery();   
            if(rs.next()) {                
                objC.setId(rs.getInt("idCliente"));
                objC.setNombre(rs.getString("nombreCliente"));
                objC.setApellidos(rs.getString("apellidos"));
                objC.setDni(rs.getString("documento"));
                objC.setTelefono(rs.getString("telefono"));     
            }else{
                objC = null;        
            }
        } catch (Exception e) {
            throw e;
        }
        return objC;
       
    }
    public Cliente obtenerPorNombre(String nombre) throws Exception {
    Cliente c = null;
    String sql = "SELECT * FROM cliente WHERE nombreCliente = ?";
    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setString(1, nombre);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            c = new Cliente();
            c.setId(rs.getInt("idCliente")); // o rs.getInt("id_cliente")
            c.setNombre(rs.getString("nombreCliente"));
        }
    }
    return c;
}

}
