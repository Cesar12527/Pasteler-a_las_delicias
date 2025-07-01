
package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.Seguridad;
import Entidades.Usuario;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionUsuario {
    public ArrayList<Usuario> listar() throws Exception {
        ArrayList<Usuario> lista = new ArrayList<>();
        String sql = "SELECT * FROM usuario";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Usuario u = new Usuario();
                u.setId(rs.getInt("id"));
                u.setUsuario(rs.getString("usuario"));
                u.setClaveHash(rs.getString("clave"));
                lista.add(u);
            }

        } catch (Exception e) {
            throw e;
        }

        return lista;
    }

    public boolean crearUsuario(Usuario usuario) throws Exception {
        String sql = "INSERT INTO usuario (usuario, clave) VALUES (?, ?)";

        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {

            // Cifrar la contraseña ANTES de insertarla
            String hash = Seguridad.hashearContraseña(usuario.getClaveHash());
            ps.setString(1, usuario.getUsuario());
            ps.setString(2, hash);

            int filas = ps.executeUpdate();
            return filas > 0;
        }
    }
     
    public Usuario validarLogin(String usuario, String claveIngresada, String rol) throws Exception {
    String sql = "SELECT u.id, u.usuario, u.clave, r.idRol, r.nombreRol " +
                 "FROM usuario AS u " +
                 "INNER JOIN rol AS r ON u.id_tipo_rol = r.idRol " +
                 "WHERE u.usuario = ? AND r.nombreRol = ?";

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {

        ps.setString(1, usuario);
        ps.setString(2, rol);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                String hashBD = rs.getString("clave");

                if (Seguridad.verificarContraseña(claveIngresada, hashBD)) {
                    Usuario u = new Usuario();
                    u.setId(rs.getInt("id"));
                    u.setUsuario(rs.getString("usuario"));
                    u.setClaveHash(hashBD);

                    Entidades.TipoRol tipoRol = new Entidades.TipoRol();
                    tipoRol.setId(rs.getInt("idRol"));
                    tipoRol.setNombre(rs.getString("nombreRol"));

                    u.setTiporol(tipoRol);

                    return u;
                }
            }
        }
    } catch (SQLException e) {
        throw new Exception("Error al validar login: " + e.getMessage());
    }

    return null; // usuario no encontrado o contraseña incorrecta
}

 
}
