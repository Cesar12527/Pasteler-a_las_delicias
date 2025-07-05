/*
package IGU.Modelos;

import Entidades.Cliente;
import java.util.ArrayList;
import javax.swing.AbstractListModel;
import javax.swing.ComboBoxModel;


public class ModeloComboCliente extends AbstractListModel implements ComboBoxModel {
    private ArrayList<Cliente> listadoCliente;
    private Cliente seleccionado = null; 

    public ArrayList<Cliente> getListadoRol() {
        return listadoCliente;
    }

    public void setListadoRol(ArrayList<Cliente> listadoRol) {
        this.listadoCliente = listadoRol;
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
    }

    @Override
    public void setSelectedItem(Object anItem) {
        this.seleccionado = null;
        if(this.listadoCliente != null && anItem != null) {
            for (Cliente tipoRol : this.listadoCliente) {
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
        
        if(this.listadoCliente != null) {        
            cantElem = this.listadoCliente.size();
        }
        return cantElem; 
    }

    @Override
    public Object getElementAt(int index) {
        Object elem = "";
        if(this.listadoCliente != null) { 
            elem = this.listadoCliente.get(index).toString();
        }
        return elem;
    }
    
   

}*/
