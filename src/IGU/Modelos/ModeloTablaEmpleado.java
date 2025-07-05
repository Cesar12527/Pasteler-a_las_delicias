
package IGU.Modelos;

import Entidades.Empleado;
import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

public class ModeloTablaEmpleado extends AbstractTableModel{
    private ArrayList<Empleado> listadoEmpleado = null;

    public ArrayList<Empleado> getListadoProducto() {
        return listadoEmpleado;
    }

    public void setListadoProducto(ArrayList<Empleado> listadoEmpleado) {
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
        return 7;    
    }
        public String getColumnName (int column){
        String nombreCol = "";
        
        switch (column) {
            case 0 : nombreCol = "Nombre"; break;           
            case 1 : nombreCol = "Apellido"; break;
            case 2 : nombreCol = "DNI"; break;
            case 3 : nombreCol = "Telefono"; break;
            case 4 : nombreCol = "Correo"; break;
            case 5 : nombreCol = "Estado"; break;
            case 6 : nombreCol = "Rol"; break;
            
            default:
                throw new AssertionError();
        }  
        return nombreCol;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object celda = "";
        Empleado objP = null;
      
        if(this.listadoEmpleado != null){
          objP =  this.listadoEmpleado.get(rowIndex);
        switch (columnIndex) {
            case 0 : celda = objP.getNombreEmpleado(); break;
            case 1 : celda = objP.getApellidos(); break;
            case 2 : celda = objP.getDni(); break;
            case 3 : celda = objP.getTelefono(); break;
            case 4 : celda = objP.getCorreo(); break;
            case 5 : celda = objP.getEstado(); break;
            case 6 : celda = objP.getUsuario().getTiporol(); break;

            
            default:
                throw new AssertionError();
        } 
      }
      return celda;
    }
    


    
    public void addEmpleado(Empleado p) {
    if (this.listadoEmpleado == null) {
        this.listadoEmpleado = new ArrayList<>();
    }
    this.listadoEmpleado.add(p);
    fireTableDataChanged();  // Notifica a la tabla que el modelo cambió
}


    public Empleado getEmpleado(int indiceSeleccionado) {
        Empleado objp = null;
        
        if(this.listadoEmpleado != null) {
            objp = this.listadoEmpleado.get(indiceSeleccionado);
        }
        
        return objp;
    }

    
}