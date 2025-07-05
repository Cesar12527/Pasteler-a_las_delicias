package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.Empleado;
import Entidades.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionEmpleados implements ICRUD {

    @Override
    public ArrayList listar() throws Exception {
        ArrayList<Empleado> lista = new ArrayList<>();
        String sql = """
            SELECT e.idEmpleado, e.nombreEmpleado, e.apellidos, e.dni, e.telefono, e.correo, e.estado, 
                   u.id, u.usuario, u.clave
            FROM empleado e
            INNER JOIN usuario u ON e.id_usuario = u.id
        """;

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
        ) {
            while (rs.next()) {
                // Crear usuario
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setClaveHash(rs.getString("clave"));

                // Crear empleado
                Empleado emp = new Empleado();
                emp.setIdEmpleado(rs.getInt("idEmpleado"));
                emp.setNombreEmpleado(rs.getString("nombreEmpleado"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setDni(rs.getString("dni"));
                emp.setTelefono(rs.getString("telefono")); 
                emp.setCorreo(rs.getString("correo"));
                emp.setEstado(rs.getString("estado"));
                emp.setUsuario(u);

                lista.add(emp);
            }
        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    @Override
    public int crear(Object object) throws SQLException {
        Empleado emp = (Empleado) object;
        int idGenerado = -1;

        String sql = """
            INSERT INTO empleado(nombreEmpleado, apellidos, dni, telefono, correo, estado, id_usuario)
            VALUES (?, ?, ?, ?, ?,?,?)
        """;

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ) {
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidos());
            ps.setString(3, emp.getDni());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo());
            ps.setString(6, emp.getEstado());
            ps.setInt(7, emp.getUsuario().getId());
            ps.executeUpdate();

            try (ResultSet rs = ps.getGeneratedKeys()) {
                if (rs.next()) {
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
        Empleado emp = (Empleado) object;

        String sql = """
            UPDATE empleado
            SET nombreEmpleado = ?, apellidos = ?,dni = ?, telefono=?, correo = ?, estado = ?, id_usuario = ?
            WHERE idEmpleado = ?
        """;

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setString(1, emp.getNombreEmpleado());
            ps.setString(2, emp.getApellidos());
            ps.setString(3, emp.getDni());
            ps.setString(4, emp.getTelefono());
            ps.setString(5, emp.getCorreo());
            ps.setString(6, emp.getEstado());
            ps.setInt(7, emp.getUsuario().getId());
            ps.setInt(8, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM empleado WHERE idEmpleado = ?";
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Object obtener(int id) throws Exception {
        Empleado emp = null;

        String sql = """
    SELECT e.idEmpleado, e.nombreEmpleado, e.apellidos, e.dni, e.telefono, e.correo, e.estado,
           u.id AS id, u.usuario, u.clave
    FROM empleado e
    INNER JOIN usuario u ON e.id_usuario = u.id
    WHERE e.idEmpleado = ?
""";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
        ) {
            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
    Usuario u = new Usuario();
    u.setId(rs.getInt("id"));
    u.setUsuario(rs.getString("usuario"));
    u.setClaveHash(rs.getString("clave"));

    emp = new Empleado();
    emp.setIdEmpleado(rs.getInt("idEmpleado"));
    emp.setNombreEmpleado(rs.getString("nombreEmpleado"));
    emp.setApellidos(rs.getString("apellidos"));
    emp.setDni(rs.getString("dni"));
    emp.setTelefono(rs.getString("telefono"));
    emp.setCorreo(rs.getString("correo"));
    emp.setEstado(rs.getString("estado"));
    emp.setUsuario(u);
            }
            }
        } catch (Exception e) {
            throw e;
        }

        return emp;
    }
    public Empleado obtenerPorNombre(String nombre) throws Exception {
     Empleado emp = null;
    String sql = "SELECT * FROM empleado WHERE nombreEmpleado = ?";
    
    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        
        ps.setString(1, nombre);
        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                emp = new Empleado();
                emp.setIdEmpleado(rs.getInt("idEmpleado"));
                emp.setNombreEmpleado(rs.getString("nombreEmpleado"));
                emp.setApellidos(rs.getString("apellidos"));
                emp.setDni(rs.getString("dni"));
                emp.setTelefono(rs.getString("telefono"));

                // Aquí se obtiene el ID del usuario y se lo carga completo
                int idUsuario = rs.getInt("id_usuario");
                BDGestionUsuario daoUsuario = new BDGestionUsuario();
                Usuario u = daoUsuario.obtenerPorId(idUsuario); // ⚠️ Este método debe existir
                emp.setUsuario(u);
            }
        }
    } catch (Exception e) {
        throw new Exception("Error al obtener empleado por nombre: " + e.getMessage());
    }

    return emp;
}

}