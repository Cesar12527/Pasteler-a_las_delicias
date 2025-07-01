package Entidades;


public class Venta {
     private int idVenta;
    private float total;
    private Cliente cliente;
    private Empleado empleado;
    private MetodoPago metodoPago;

    public Venta() {
    }

    public Venta(int idVenta, float total, Cliente cliente, Empleado empleado, MetodoPago metodoPago) {
        this.idVenta = idVenta;
        this.total = total;
        this.cliente = cliente;
        this.empleado = empleado;
        this.metodoPago = metodoPago;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public MetodoPago getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(MetodoPago metodoPago) {
        this.metodoPago = metodoPago;
    }
    
    @Override
    public String toString() {
        return null;
    }
    
}
