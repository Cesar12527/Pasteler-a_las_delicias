
package IGU.Modelos;

import Entidades.MetodoPago;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaMetodoPago extends AbstractTableModel {
  private ArrayList<MetodoPago> listadoMetodoPago = null;

    public ArrayList<MetodoPago> getListadoClientes() {
        return listadoMetodoPago;
    }

    public void setLMetodoPago(ArrayList<MetodoPago> listadoMetodoPago) {
        this.listadoMetodoPago = listadoMetodoPago;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
      int cantFilas = 0;
      if(this.listadoMetodoPago != null){
           cantFilas = this.listadoMetodoPago.size();
      }  
      return cantFilas;
    }

    @Override
    public int getColumnCount() {
       return 1;
    }


    public String getColumnName(int column) {
        String nombreCol = "";
        
        switch (column) {
            case 0 : nombreCol = "Metodo de pago"; break;           
            default:
                throw new AssertionError();
        }  
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Object celda = "";
      MetodoPago objC = null;
      
      if(this.listadoMetodoPago != null){
          objC =  this.listadoMetodoPago.get(rowIndex);
        switch (columnIndex) {
            case 0 : celda = objC.getTipoPago(); break;           

 
            
            default:
                throw new AssertionError();
        } 
      }
      return celda;
    }
    
     public void addMetodoPago(MetodoPago cli) {
    if (this.listadoMetodoPago == null) {
        this.listadoMetodoPago = new ArrayList<>();
    }
    this.listadoMetodoPago.add(cli);
    fireTableDataChanged();  // Notifica a la tabla que el modelo cambió
}
     
     

      public MetodoPago getMetodoPago(int indiceSeleccionado) {
        MetodoPago objp = null;
        
        if(this.listadoMetodoPago != null) {
            objp = this.listadoMetodoPago.get(indiceSeleccionado);
        }
        
        return objp;
    }
}
