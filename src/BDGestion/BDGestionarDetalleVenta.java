package BDGestion;

import BaseDatos.Conexion;
import BaseDatos.ICRUD;
import Entidades.Cliente;
import Entidades.DetalleVenta;
import Entidades.Empleado;
import Entidades.MetodoPago;
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
    String sql = """
        SELECT 
            dv.idDetalleVenta,
            dv.cantidad,
            dv.subTotal,
            p.idProducto, p.nombreProducto,
            c.idCliente, c.nombreCliente,
            e.idEmpleado, e.nombreEmpleado,
            v.idVenta,
            v.fecha,
            m.idMetodoPago, m.tipoPago
        FROM detalleventa dv
        LEFT JOIN producto p ON dv.idProducto = p.idProducto
        LEFT JOIN venta v ON dv.idVenta = v.idVenta 
        LEFT JOIN cliente c ON v.idCliente = c.idCliente
        LEFT JOIN empleado e ON v.idEmpleado = e.idEmpleado
        LEFT JOIN metodopago m ON v.idMetodoPago = m.idMetodoPago
        ORDER BY v.idVenta;
    """;
    try (Connection con = Conexion.conectar();
         PreparedStatement ps = con.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {
        while (rs.next()) {
            // Producto
            Producto producto = new Producto();
            producto.setId(rs.getInt("idProducto"));
            producto.setNombre(rs.getString("nombreProducto"));
            // Cliente
            Cliente cliente = new Cliente();
            cliente.setId(rs.getInt("idCliente"));
            cliente.setNombre(rs.getString("nombreCliente"));
            // Empleado
            Empleado empleado = new Empleado();
            empleado.setIdEmpleado(rs.getInt("idEmpleado"));
            empleado.setNombreEmpleado(rs.getString("nombreEmpleado"));
            // Método de pago
            MetodoPago metodoPago = new MetodoPago();
            metodoPago.setId(rs.getInt("idMetodoPago"));
            metodoPago.setTipoPago(rs.getString("tipoPago"));
            // Venta
            Venta venta = new Venta();
            venta.setIdVenta(rs.getInt("idVenta"));
            venta.setCliente(cliente);
            venta.setEmpleado(empleado);
            venta.setFecha(rs.getString("fecha"));
            venta.setMetodoPago(metodoPago);
            // DetalleVenta
            DetalleVenta detalle = new DetalleVenta();
            detalle.setIdDetalleVenta(rs.getInt("idDetalleVenta"));
            detalle.setCantidad(rs.getInt("cantidad"));
            detalle.setSubTotal(rs.getFloat("subTotal"));
            detalle.setProducto(producto);
            detalle.setVenta(venta);
            lista.add(detalle);
        }
    }
    return lista;
}

    @Override
    public int crear(Object object) throws SQLException {
        DetalleVenta d = (DetalleVenta) object;
        
        String sql =  "INSERT INTO detalleventa (idVenta, idProducto, cantidad, subTotal) VALUES (?, ?, ?, ?)";
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
