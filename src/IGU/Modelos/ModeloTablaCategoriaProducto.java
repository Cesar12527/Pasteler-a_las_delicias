
package IGU.Modelos;

import Entidades.CategoriaProducto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaCategoriaProducto extends AbstractTableModel {
  private ArrayList<CategoriaProducto> listadoClientes = null;

    public ArrayList<CategoriaProducto> getListadoClientes() {
        return listadoClientes;
    }

    public void setListadoCategoriaProducto(ArrayList<CategoriaProducto> listadoClientes) {
        this.listadoClientes = listadoClientes;
        fireTableDataChanged();
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
       return 2;
    }


    public String getColumnName(int column) {
        String nombreCol = "";
        
        switch (column) {
            case 0 : nombreCol = "Nombres"; break;           
            case 1 : nombreCol = "Descripción"; break;
            default:
                throw new AssertionError();
        }  
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
      Object celda = "";
      CategoriaProducto objC = null;
      
      if(this.listadoClientes != null){
          objC =  this.listadoClientes.get(rowIndex);
        switch (columnIndex) {
            case 0 : celda = objC.getNombre(); break;           
            case 1 : celda = objC.getDescripcion(); break;
 
            
            default:
                throw new AssertionError();
        } 
      }
      return celda;
    }
    
     public void addCategoriaProducto(CategoriaProducto cli) {
    if (this.listadoClientes == null) {
        this.listadoClientes = new ArrayList<>();
    }
    this.listadoClientes.add(cli);
    fireTableDataChanged();  // Notifica a la tabla que el modelo cambió
}
     
     

      public CategoriaProducto getCategoriaProducto(int indiceSeleccionado) {
        CategoriaProducto objp = null;
        
        if(this.listadoClientes != null) {
            objp = this.listadoClientes.get(indiceSeleccionado);
        }
        
        return objp;
    }
}
