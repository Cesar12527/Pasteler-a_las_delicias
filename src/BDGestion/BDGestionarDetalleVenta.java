package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.DetalleVenta;
import Entidades.Producto;
import Entidades.Venta;
import java.sql.*;
import java.util.ArrayList;

public class BDGestionarDetalleVenta implements ICRUD {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<DetalleVenta> listar() throws Exception {
        ArrayList<DetalleVenta> lista = new ArrayList<>();
        String sql = "SELECT * FROM detalleventa";
        try {
            con = Conexion.conectar();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                DetalleVenta d = new DetalleVenta();
                d.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setSubTotal(rs.getFloat("subTotal"));
                // Puedes agregar más detalles si haces JOINs con producto/venta
                lista.add(d);
            }
        } finally {
            if (ps != null) ps.close();
            if (rs != null) rs.close();
            if (con != null) con.close();
        }
        return lista;
    }

    @Override
    public int crear(Object object) throws SQLException {
        DetalleVenta d = (DetalleVenta) object;
        String sql = "INSERT INTO detalleventa (idVenta, idProducto, cantidad, subTotal) VALUES (?, ?, ?, ?)";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, d.getVenta().getIdVenta());
            ps.setInt(2, d.getProducto().getId());
            ps.setInt(3, d.getCantidad());
            ps.setFloat(4, d.getSubTotal());
            return ps.executeUpdate();
        }
    }

    @Override
    public void actualizar(int id, Object object) throws Exception {
        throw new UnsupportedOperationException("Actualizar no es aplicable para detalle de venta.");
    }

    @Override
    public void eliminar(int id) throws Exception {
        String sql = "DELETE FROM detalleventa WHERE idDetalleVenta=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        }
    }

    @Override
    public Object obtener(int id) throws Exception {
        DetalleVenta d = null;
        String sql = "SELECT * FROM detalleventa WHERE idDetalleVenta=?";
        try (Connection con = Conexion.conectar();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                d = new DetalleVenta();
                d.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
                d.setCantidad(rs.getInt("cantidad"));
                d.setSubTotal(rs.getFloat("subTotal"));
            }
        }
        return d;
    }
}
