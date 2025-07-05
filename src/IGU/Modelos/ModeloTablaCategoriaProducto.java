
package IGU.Modelos;

import Entidades.CategoriaProducto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaCategoriaProducto extends AbstractTableModel {
  private ArrayList<CategoriaProducto> listadoCategoriaProducto = null;

    public ArrayList<CategoriaProducto> getListadoClientes() {
        return listadoCategoriaProducto;
    }

    public void setListadoCategoriaProducto(ArrayList<CategoriaProducto> listadoCategoriaProducto) {
        this.listadoCategoriaProducto = listadoCategoriaProducto;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
      int cantFilas = 0;
      if(this.listadoCategoriaProducto != null){
           cantFilas = this.listadoCategoriaProducto.size();
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
      
      if(this.listadoCategoriaProducto != null){
          objC =  this.listadoCategoriaProducto.get(rowIndex);
        switch (columnIndex) {
            case 0 : celda = objC.getNombrecat(); break;           
            case 1 : celda = objC.getDescripcion(); break;
 
            
            default:
                throw new AssertionError();
        } 
      }
      return celda;
    }
    
     public void addCategoriaProducto(CategoriaProducto cli) {
    if (this.listadoCategoriaProducto == null) {
        this.listadoCategoriaProducto = new ArrayList<>();
    }
    this.listadoCategoriaProducto.add(cli);
    fireTableDataChanged();  // Notifica a la tabla que el modelo cambió
}
     
     

      public CategoriaProducto getCategoriaProducto(int indiceSeleccionado) {
        CategoriaProducto objp = null;
        
        if(this.listadoCategoriaProducto != null) {
            objp = this.listadoCategoriaProducto.get(indiceSeleccionado);
        }
        
        return objp;
    }
}