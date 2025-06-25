
package IGU.Modelos;

import Entidades.Producto;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaGestionProducto extends AbstractTableModel{
    private ArrayList<Producto> listadoProducto = null;

    public ArrayList<Producto> getListadoProducto() {
        return listadoProducto;
    }

    public void setListadoProducto(ArrayList<Producto> listadoProducto) {
        this.listadoProducto = listadoProducto;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
         int cantFilas = 0;
        if(this.listadoProducto != null){
           cantFilas = this.listadoProducto.size();
        }  
        return cantFilas;
    }
    
    @Override
    public int getColumnCount() {
        return 6;    
    }
        public String getColumnName (int column){
        String nombreCol = "";
        
        switch (column) {
            case 0 : nombreCol = "Nombre"; break;           
            case 1 : nombreCol = "Categoria"; break;
            case 2 : nombreCol = "Descripcion"; break;
            case 3 : nombreCol = "Unidad medida"; break;
            case 4 : nombreCol = "PrecioU"; break;
            case 5 : nombreCol = "Stock"; break;
            
            default:
                throw new AssertionError();
        }  
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object celda = "";
        Producto objP = null;
      
        if(this.listadoProducto != null){
          objP =  this.listadoProducto.get(rowIndex);
        switch (columnIndex) {
            case 0 : celda = objP.getNombre(); break;
            case 1 : celda = (objP.getCategoriaProducto() != null) 
                        ? objP.getCategoriaProducto().getNombre()
                        : "Sin categoría"; break;
            case 2 : celda = (objP.getCategoriaProducto() != null) 
                        ? objP.getCategoriaProducto().getDescripcion()
                        : "Sin descripción"; break;
            case 3 : celda = objP.getUnidadMedida(); break;
            case 4 : celda = objP.getPrecioUnitario(); break;
            case 5 : celda = objP.getStock(); break;
            
            default:
                throw new AssertionError();
        } 
      }
      return celda;
    }
    
    
    
}
