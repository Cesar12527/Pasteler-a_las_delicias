
package IGU.Modelos;

import Entidades.MetodoPago;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class ModeloComboTipoPago extends AbstractListModel implements ComboBoxModel {
    private ArrayList<MetodoPago> listadoTipoPago;
    private MetodoPago seleccionado = null; 

    public ArrayList<MetodoPago> getListadoRol() {
        return listadoTipoPago;
    }

    public void setListadoRol(ArrayList<MetodoPago> listadoRol) {
        this.listadoTipoPago = listadoRol;
    }

    public MetodoPago getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(MetodoPago seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if(this.listadoTipoPago != null && anItem != null) {
            for (MetodoPago tipoRol : this.listadoTipoPago) {
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
        
        if(this.listadoTipoPago != null) {        
            cantElem = this.listadoTipoPago.size();
        }
        return cantElem; 
    }

    @Override
    public Object getElementAt(int index) {
        Object elem = "";
        if(this.listadoTipoPago != null) { 
            elem = this.listadoTipoPago.get(index).toString();
        }
        return elem;
    }

}
