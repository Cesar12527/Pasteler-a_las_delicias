package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.Cliente;
import Entidades.Empleado;
import Entidades.MetodoPago;
import Entidades.Venta;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionarVenta implements ICRUD {

    @Override
    public ArrayList<Venta> listar() throws Exception {
        ArrayList<Venta> lista = new ArrayList<>();
        String sql = "SELECT * FROM venta";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                Venta v = new Venta();
                v.setIdVenta(rs.getInt("idVenta"));
                v.setTotal(rs.getFloat("total"));
                Cliente c = new Cliente();
                c.setId(rs.getInt("idCliente"));
                v.setCliente(c);
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmpleado"));
                v.setEmpleado(e);
                MetodoPago mp = new MetodoPago();
                mp.setId(rs.getInt("idMetodoPago"));
                v.setMetodoPago(mp);
                lista.add(v);
            }
        }
        return lista;
    }

    @Override
    public int crear(Object object) throws SQLException {
        Venta venta = (Venta) object;
         int idGenerado = -1;
    String sql = "INSERT INTO venta (total, idEmpleado, idMetodoPago, idCliente) VALUES (?, ?, ?, ?)";

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        ps.setFloat(1, venta.getTotal());
        ps.setInt(2, venta.getEmpleado().getIdEmpleado());
        ps.setInt(3, venta.getMetodoPago().getId());

        // cliente puede ser null
        if (venta.getCliente() != null) {
            ps.setInt(4, venta.getCliente().getId());
        } else {
            ps.setNull(4, java.sql.Types.INTEGER);
        }

        ps.executeUpdate();

        // Obtener ID generado
        try (ResultSet rs = ps.getGeneratedKeys()) {
            if (rs.next()) {
                idGenerado = rs.getInt(1);
            }
        }
    }

    return idGenerado;
    }

    @Override
    public void actualizar(int id, Object object) throws Exception {
        String sql = "UPDATE venta SET total = ?, idCliente = ?, idEmpleado = ?, idMetodoPago = ? WHERE id = ?";
        Venta v = (Venta) object;
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setFloat(1, v.getTotal());
            ps.setInt(2, v.getCliente().getId());
            ps.setInt(3, v.getEmpleado().getIdEmpleado());
            ps.setInt(4, v.getMetodoPago().getId());
            ps.setInt(5, id);
            ps.executeUpdate();
        }
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM venta WHERE idVenta = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Object obtener(int id) throws Exception {
        Venta v = null;
        String sql = "SELECT * FROM venta WHERE idVenta = ?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                v = new Venta();
                v.setIdVenta(rs.getInt("id"));
                v.setTotal(rs.getFloat("total"));
                Cliente c = new Cliente();
                c.setId(rs.getInt("idCliente"));
                v.setCliente(c);
                Empleado e = new Empleado();
                e.setIdEmpleado(rs.getInt("idEmmpleado"));
                v.setEmpleado(e);
                MetodoPago mp = new MetodoPago();
                mp.setId(rs.getInt("idMetodoPago"));
                v.setMetodoPago(mp);
            }
        }
        return v;
    }
    public ArrayList<Venta> listarPorEmpleado(int idEmpleado) throws Exception {
    ArrayList<Venta> lista = new ArrayList<>();
    String sql = """
        SELECT v.idVenta, v.fecha, v.total,
               c.idCliente AS idCliente, c.nombreCliente AS nombreCliente, c.apellidos AS apellidos
        FROM venta v
        LEFT JOIN cliente c ON v.idCliente = c.idCliente
        WHERE v.idEmpleado = ?
        """;

    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql)) {
        ps.setInt(1, idEmpleado);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {
            Venta v = new Venta();
            v.setIdVenta(rs.getInt("idVenta"));
            v.setFecha(rs.getString("fecha"));
            v.setTotal(rs.getFloat("total"));

            Cliente c = new Cliente();
            c.setId(rs.getInt("idCliente"));
            c.setNombre(rs.getString("nombreCliente"));
            c.setApellidos(rs.getString("apellidos"));
            v.setCliente(c);

            lista.add(v);
        }
    } catch (Exception e) {
        throw new Exception("Error al listar ventas por empleado: " + e.getMessage());
    }
    return lista;
}
}
