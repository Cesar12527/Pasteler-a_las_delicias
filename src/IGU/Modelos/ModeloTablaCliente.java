
package IGU.Modelos;

import Entidades.Cliente;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaCliente extends AbstractTableModel {
  private ArrayList<Cliente> listadoClientes = null;

    public ArrayList getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoClientes(ArrayList listadoClientes) {
        this.listadoClientes = listadoClientes;
    }

    @Override
    public int getRowCount() {
      int cantFilas = 0;
      if(this.listadoClientes != null){
           cantFilas = this.listadoClientes.size();
      }  
      return cantFilas;
    }

    @Override
    public int getColumnCount() {
       return 4;
    }

    @Override
    public String getColumnName(int column) {
        String nombreCol = "";
        
        switch (column) {
            case 0 : nombreCol = "Nombres"; break;           
            case 1 : nombreCol = "Apellidos"; break;
            case 2 : nombreCol = "Dni"; break;
            case 3 : nombreCol = "Telefono"; break;
            
            default:
                throw new AssertionError();
        }  
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Object celda = "";
      Cliente objC = null;
      
      if(this.listadoClientes != null){
          objC =  this.listadoClientes.get(rowIndex);
        switch (columnIndex) {
            case 0 : celda = objC.getNombre(); break;           
            case 1 : celda = objC.getApellidos(); break;
            case 2 : celda = objC.getDni(); break;
            case 3 : celda = objC.getTelefono(); break;
            
            default:
                throw new AssertionError();
        } 
      }
      return celda;
    }
      
}
