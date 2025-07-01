
package IGU.Modelos;

import Entidades.Empleado;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class ModeloComboEmpleado extends AbstractListModel implements ComboBoxModel {
    private ArrayList<Empleado> listadoEmpleado;
    private Empleado seleccionado = null; 

    public ArrayList<Empleado> getListadoRol() {
        return listadoEmpleado;
    }

    public void setListadoRol(ArrayList<Empleado> listadoRol) {
        this.listadoEmpleado = listadoRol;
    }

    public Empleado getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Empleado seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if(this.listadoEmpleado != null && anItem != null) {
            for (Empleado tipoRol : this.listadoEmpleado) {
                if( tipoRol.toString().equals(anItem) ) {
                    this.seleccionado = tipoRol;
                    return;
                }
            }
        }
    }

    @Override
    public Object getSelectedItem() {
        Object elem = "";
        if(this.seleccionado != null) {
            elem = this.seleccionado;
        }
        return elem;
    }

    @Override
    public int getSize() {
        int cantElem = 0;
        
        if(this.listadoEmpleado != null) {        
            cantElem = this.listadoEmpleado.size();
        }
        return cantElem; 
    }

    @Override
    public Object getElementAt(int index) {
        Object elem = "";
        if(this.listadoEmpleado != null) { 
            elem = this.listadoEmpleado.get(index).toString();
        }
        return elem;
    }
    

}
