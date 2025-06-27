package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.ActivoFijo;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionActivoFijo implements ICRUD {

    @Override
    public ArrayList listar() throws Exception {
        ArrayList<ActivoFijo> lista = new ArrayList<>();
        String sql = "SELECT * FROM activofijo";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery()
        ) {
            while (rs.next()) {
                ActivoFijo obj = new ActivoFijo();
                obj.setId(rs.getInt("idActivoFijo"));
                obj.setNombre(rs.getString("nombre"));
                obj.setDescripcion(rs.getString("Descripcion"));
                obj.setFechaAdquisicion(rs.getDate("fechaAdquisicion"));
                obj.setValorPrecio(rs.getDouble("valorPrecio"));
                obj.setEstado(rs.getString("estado"));
                lista.add(obj);
            }
        } catch (Exception e) {
            throw e;
        }
        return lista;
    }

    @Override
    public int crear(Object object) throws SQLException {
        ActivoFijo obj = (ActivoFijo) object;
        int idGenerado = -1;
        String sql = "INSERT INTO activofijo(nombre, Descripcion, fechaAdquisicion, valorPrecio, estado) VALUES(?,?,?,?,?)";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)
        ) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setDate(3, new java.sql.Date(obj.getFechaAdquisicion().getTime()));
            ps.setDouble(4, obj.getValorPrecio());
            ps.setString(5, obj.getEstado());
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
        ActivoFijo obj = (ActivoFijo) object;
        String sql = "UPDATE activofijo SET nombre=?, Descripcion=?, fechaAdquisicion=?, valorPrecio=?, estado=? WHERE idActivoFijo=?";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, obj.getNombre());
            ps.setString(2, obj.getDescripcion());
            ps.setDate(3, new java.sql.Date(obj.getFechaAdquisicion().getTime()));
            ps.setDouble(4, obj.getValorPrecio());
            ps.setString(5, obj.getEstado());
            ps.setInt(6, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM activofijo WHERE idActivoFijo=?";
        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public Object obtener(int id) throws Exception {
        ActivoFijo obj = null;
        String sql = "SELECT * FROM activofijo WHERE idActivoFijo=?";

        try (
            Connection con = Conexion.conectar();
            PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    obj = new ActivoFijo();
                    obj.setId(rs.getInt("idActivoFijo"));
                    obj.setNombre(rs.getString("nombre"));
                    obj.setDescripcion(rs.getString("Descripcion"));
                    obj.setFechaAdquisicion(rs.getDate("fechaAdquisicion"));
                    obj.setValorPrecio(rs.getDouble("valorPrecio"));
                    obj.setEstado(rs.getString("estado"));
                }
            }
        } catch (Exception e) {
            throw e;
        }
        return obj;
    }
}