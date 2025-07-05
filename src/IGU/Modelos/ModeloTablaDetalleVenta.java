
package IGU.Modelos;

import Entidades.DetalleVenta;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaDetalleVenta extends AbstractTableModel{
    private ArrayList<DetalleVenta> listadoEmpleado = null;

    public ArrayList<DetalleVenta> getListadoProducto() {
        return listadoEmpleado;
    }

    public void setListadoProducto(ArrayList<DetalleVenta> listadoEmpleado) {
        this.listadoEmpleado = listadoEmpleado;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
         int cantFilas = 0;
        if(this.listadoEmpleado != null){
           cantFilas = this.listadoEmpleado.size();
        }  
        return cantFilas;
    }
    
    @Override
    public int getColumnCount() {
        return 8;    
    }
        public String getColumnName (int column){
        String nombreCol = "";
        
        switch (column) {
            case 0 : nombreCol = "ID"; break; 
            case 1 : nombreCol = "Producto"; break;
            case 2 : nombreCol = "Cantidad"; break;
            case 3 : nombreCol = "Cliente"; break;
            case 4 : nombreCol = "Empleado"; break;
            case 5 : nombreCol = "Metodo de pago"; break;
            case 6 : nombreCol = "Total a pagar"; break;
            case 7 : nombreCol = "Fecha"; break;
            default:
                throw new AssertionError();
        }  
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object celda = "";
        DetalleVenta objP = null;
        
      try{
        if(this.listadoEmpleado != null){
          objP =  this.listadoEmpleado.get(rowIndex);
        switch (columnIndex) {
            
            case 0 : celda = objP.getVenta().getIdVenta(); break;
            case 1 : celda = objP.getProducto().getNombre(); break;
            case 2 : celda = objP.getCantidad(); break;
            case 3 : celda = objP.getVenta().getCliente().getNombre(); break;
            case 4 : celda = objP.getVenta().getEmpleado().getNombreEmpleado(); break;
            case 5 : celda = objP.getVenta().getMetodoPago().getTipoPago(); break;
            case 6 : celda = objP.getSubTotal(); break;
            case 7 : celda = objP.getVenta().getFecha(); break;
            
            default:
                throw new AssertionError();
        }}
        } catch(Exception ex){
                ex.printStackTrace();
                
      }
      return celda;
    }
    


    
    public void addEmpleado(DetalleVenta p) {
    if (this.listadoEmpleado == null) {
        this.listadoEmpleado = new ArrayList<>();
    }
    this.listadoEmpleado.add(p);
    fireTableDataChanged();  // Notifica a la tabla que el modelo cambió
}


    public DetalleVenta getEmpleado(int indiceSeleccionado) {
        DetalleVenta objp = null;
        
        if(this.listadoEmpleado != null) {
            objp = this.listadoEmpleado.get(indiceSeleccionado);
        }
        
        return objp;
    }

    
}